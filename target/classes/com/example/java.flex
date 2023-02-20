/*
 * Copyright (C) 1998-2018  Gerwin Klein <lsf@jflex.de>
 * SPDX-License-Identifier: GPL-2.0-only
 */

/* Java 1.2 language lexer specification */

/* Use together with unicode.flex for Unicode preprocesssing */
/* and java12.cup for a Java 1.2 parser                      */

/* Note that this lexer specification is not tuned for speed.
   It is in fact quite slow on integer and floating point literals,
   because the input is read twice and the methods used to parse
   the numbers are not very fast.
   For a production quality application (e.g. a Java compiler)
   this could be optimized */

package com.example;
%%

%public
%class CMinusScanner2

%unicode

%line
%column
%function	scanToken
%type		Token

%{
  private Token nextToken = new Token(Token.TokenType.NONE);

  public CMinusScanner2 (String file) {
    try {
		zzReader  = new java.io.FileReader (file);
		nextToken = scanToken();
    }
    catch (Exception e) {

    }
  }
  
  public Token getNextToken () {
    Token returnToken = nextToken;
    if (nextToken.getType() != "Token.TokenType.EOF_TOKEN")
		try {nextToken = scanToken();}
		catch (Exception e) {}
    return returnToken;
  }

  public Token viewNextToken () {
    return nextToken;
  }
%}

/* main character classes */
LineTerminator = \r|\n|\r\n
InputCharacter = [^\r\n]

WhiteSpace = {LineTerminator} | [ \t\f]

/* comments */
Comment = {TraditionalComment} | {EndOfLineComment} |
          {DocumentationComment}

TraditionalComment = "/*" [^*] ~"*/" | "/*" "*"+ "/"
EndOfLineComment = "//" {InputCharacter}* {LineTerminator}?
DocumentationComment = "/*" "*"+ [^/*] ~"*/"

/* identifier and number */
Identifier = [:letter:]+
Number = [0-9]+

/* error tokens */
Error = {OtherError} | {NumberError} | {LetterError} | {AnnoyingError}
OtherError = [@|#|$|%|\^|&|_|:|.|/|`|~|\\|\||?|'|\"]+
NumberError = [0-9]+[[:letter:]*[:letter:|[0-9]]*]*
LetterError = [:letter:]+[[0-9]*[:letter:|[0-9]]*]*
AnnoyingError = [[:letter:]+[[0-9]+[:letter:]+]+]|[[0-9]+[[:letter:]+[0-9]+]+]


/* string and character literals */
StringCharacter = [^\r\n\"\\]
SingleCharacter = [^\r\n\'\\]

%state STRING, CHARLITERAL

%%

<YYINITIAL> {

  /* keywords */
  "else"                         { return new Token(Token.TokenType.KEYWORD, "else"); }
  "int"                          { return new Token(Token.TokenType.KEYWORD, "int"); }
  "if"                           { return new Token(Token.TokenType.KEYWORD, "if"); }
  "return"                       { return new Token(Token.TokenType.KEYWORD, "return"); }
  "void"                         { return new Token(Token.TokenType.KEYWORD, "void"); }
  "while"                        { return new Token(Token.TokenType.KEYWORD, "while"); }

  /* separators */
  "("                            { return new Token(Token.TokenType.LPAREN); }
  ")"                            { return new Token(Token.TokenType.RPAREN); }
  "{"                            { return new Token(Token.TokenType.LBRAY); }
  "}"                            { return new Token(Token.TokenType.RBRAY); }
  "["                            { return new Token(Token.TokenType.LBRACK); }
  "]"                            { return new Token(Token.TokenType.RBRACK); }
  ";"                            { return new Token(Token.TokenType.SEMI); }
  ","                            { return new Token(Token.TokenType.COMMA); }

  /* operators */
  "="                            { return new Token(Token.TokenType.EQ); }
  ">"                            { return new Token(Token.TokenType.GT); }
  "<"                            { return new Token(Token.TokenType.LT); }
  "!"                            { return new Token(Token.TokenType.ERROR, "!"); }
  "=="                           { return new Token(Token.TokenType.EQEQ); }
  "<="                           { return new Token(Token.TokenType.LTE); }
  ">="                           { return new Token(Token.TokenType.GTE); }
  "!="                           { return new Token(Token.TokenType.NOTEQ); }
  "+"                            { return new Token(Token.TokenType.PLUS); }
  "-"                            { return new Token(Token.TokenType.MINUS); }
  "*"                            { return new Token(Token.TokenType.STAR); }
  "/"                            { return new Token(Token.TokenType.SLASH); }

  /* comments */
  {Comment}                      { /* ignore */ }

  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }

  /* identifier and number */
  {Identifier}                   { return new Token(Token.TokenType.ID, yytext()); }
  {Number}						 { return new Token(Token.TokenType.NUM, yytext()); }
  
  /* error(s) */
  {Error}						 { return new Token(Token.TokenType.ERROR, yytext()); }
}

<STRING> {
  /* error cases */
  \\.                            { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\""); }
  {LineTerminator}               { throw new RuntimeException("Unterminated string at end of line"); }
}

<CHARLITERAL> {
  /* error cases */
  \\.                            { throw new RuntimeException("Illegal escape sequence \""+yytext()+"\""); }
  {LineTerminator}               { throw new RuntimeException("Unterminated character literal at end of line"); }
}

/* error fallback */
[^]                              { throw new RuntimeException("Illegal character \""+yytext()+
                                                              "\" at line "+yyline+", column "+yycolumn); }
<<EOF>>                          { return new Token(Token.TokenType.EOF_TOKEN); }