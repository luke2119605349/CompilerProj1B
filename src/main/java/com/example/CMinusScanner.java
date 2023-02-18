package com.example;

import java.io.*;
import com.example.Token.TokenType;

/*
 * This class performs scanining as the first phase of a compiler.
 * 
 * @authors: Luke Carpenter, Kobe Couvion
 * Created: February 2023
 * Copyright probably doesn't matter :)
 * 
 * Description: Every character of the input file is scanned and formed into a token. The token types are limited to
 * Identifiers (keywords and variable names), numbers, and a set of these special symbols:
 * ( ) [ ] { } = == != < <= > >= , ; / */ /* + - *    . It uses STATES that are defined in the enum below, and also
 * the Token class in Token.java.
 */
public class CMinusScanner {
    //States defined for tracking what each token type is about to be
    public enum State {
        START,
        LETTER,
        NUM,
        LT,
        GT,
        EQ,
        BANG,
        INSLASH,
        INCOMM,
        OUTCOMM,
        DONE
    }

    //A constant array of reserved keywords. Identifiers that match any of these are reset to a KEYWORD token type
    final static String reservedWords[] = {"else", "if", "int", "return", "void", "while"};

    //private vars
    private PushbackReader inFile;
    private Token nextToken;

    //Constructor
    public CMinusScanner (String file) {
        try {
            File cmcode = new File(file);
            System.out.println(cmcode.getAbsolutePath());
            inFile = new PushbackReader(new FileReader(cmcode));
        }
        catch (Exception e) {

        }
        nextToken = scanToken();
    }

    //Get and view token methods
    public Token getNextToken () {
        Token returnToken = nextToken;
        if (nextToken.getType() != "EOF_TOKEN")
            nextToken = scanToken();
        return returnToken;
    }

    public Token viewNextToken () {
        return nextToken;
    }
    
    Boolean maybeleave = false;
    //The majority of the work is in here: Scan through file and grab a token to return
    public Token scanToken() {
        Token currToken = new Token(Token.TokenType.NONE);
        try{

            //Initialization of variables
            int c = 0;
            State scanState = State.START;

            //Keep munching characters until end of token or EOF (specified inside)
            while (scanState != State.DONE) {
                c = inFile.read();
                System.out.print((char)c);

                //EOF check
                if (c == -1 && scanState == State.START) {
                    scanState = State.DONE;
                    if (maybeleave) {
                        currToken.setToken(TokenType.EOF_TOKEN, null);
                    }
                    maybeleave = true;
                    break;
                }
                
                //Follow the Finite Automata to ultimately correctly classify/record each token
                switch (scanState) {

                    //See what to do at the first character of a token
                    case START:

                        //Everything that could be several characters long is handled in a branch that has "if"
                        if (Character.isDigit((char)c)) {
                            scanState = State.NUM;
                            currToken.setToken(Token.TokenType.NUM,(char)c);
                        }
                        else if (Character.isLetter((char)c)) {
                            scanState = State.LETTER;
                            currToken.setToken(Token.TokenType.ID,(char)c);
                        }
                        else if (Character.isWhitespace((char)c)) {
                            
                            /*//Extra whitespaces are usually ignored unless right before the EOF
                            scanState = State.START;
                            int eofChk = inFile.read();
                            if (eofChk == -1) {
                                scanState = State.DONE;
                                currToken.setToken(TokenType.EOF_TOKEN, null);
                            }
                            else {
                                inFile.unread(eofChk);
                            }*/
                        }
                        else if (c == '/') {
                            scanState = State.INSLASH;
                            currToken.setToken(Token.TokenType.SLASH,null);
                        }
                        else if (c == '=') {
                            currToken.setToken(Token.TokenType.EQ,null);
                            scanState = State.EQ;
                        }
                        else if (c == '<') {
                            currToken.setToken(Token.TokenType.LT,null);
                            scanState = State.LT;
                        }
                        else if (c == '>') {
                            currToken.setToken(Token.TokenType.GT,null);
                            scanState = State.GT;
                        }
                        else if (c == '!') {
                            currToken.setToken(Token.TokenType.ERROR,"!");
                            scanState = State.BANG;
                        }

                        //This if for every token that is only 1 character long
                        else {
                            switch ((char)c) {
                                case '+':
                                    currToken.setToken(Token.TokenType.PLUS,null);
                                    break;
                                case '-':
                                    currToken.setToken(Token.TokenType.MINUS,null);
                                    break;
                                case '*':
                                    currToken.setToken(Token.TokenType.STAR,null);
                                    break;
                                case ';':
                                    currToken.setToken(Token.TokenType.SEMI,null);
                                    break;
                                case ',':
                                    currToken.setToken(Token.TokenType.COMMA,null);
                                    break;
                                case '(':
                                    currToken.setToken(Token.TokenType.LPAREN,null);
                                    break;
                                case ')':
                                    currToken.setToken(Token.TokenType.RPAREN,null);
                                    break;
                                case '[':
                                    currToken.setToken(Token.TokenType.LBRACK,null);
                                    break;
                                case ']':
                                    currToken.setToken(Token.TokenType.RBRACK,null);
                                    break;
                                case '{':
                                    currToken.setToken(Token.TokenType.LBRAY,null);
                                    break;
                                case '}':
                                    currToken.setToken(Token.TokenType.RBRAY,null);
                                    break;
                                default:
                                    currToken.setToken(Token.TokenType.ERROR,null);
                                    currToken.addData((char)c);
                                    break;
                            }

                            //We are finished
                            scanState = State.DONE;

                            /*//Annoying whitespace EOF check thing again (IT WORKS SO DON'T QUESTION IT! :DD)
                            int eofChk = inFile.read();
                            if (eofChk == -1) {
                                scanState = State.DONE;
                                currToken.setToken(TokenType.EOF_TOKEN, null);
                            }
                            else {
                                inFile.unread(eofChk);
                            }*/
                        }
                        break;

                    //If we are in a string of 1 or more letters
                    case LETTER:
                        if (Character.isLetter(c)) {
                            //keep TokenType as letter
                            currToken.addData((char)c);
                        }
                        else if (Character.isDigit(c)) {
                            //error
                            currToken.setType(Token.TokenType.ERROR);
                            currToken.addData((char)c);
                        }
                        else {
                            //back up 1 char: this covers the potential for symbols to be immediately next to letters (e.g., int i=0)
                            inFile.unread(c);
                            scanState = State.DONE;
                        }
                        break;

                    //If we are in a string of 1 or more numbers
                    case NUM:
                        if (Character.isLetter(c)) {
                            currToken.setType(Token.TokenType.ERROR);
                            currToken.addData((char)c);
                        }
                        else if (Character.isDigit(c)) {
                            //keep TokenType as digit and add to data
                            currToken.addData((char)c);
                        }
                        else {
                            inFile.unread(c);
                            scanState = State.DONE;
                        }
                        break;

                    //If we have a < symbol and are looking for an = for <=
                    case LT:
                        if (c == '=') {
                            currToken.setToken(Token.TokenType.LTE,null);
                        }
                        else {
                            currToken.setToken(Token.TokenType.LT, null);
                            inFile.unread(c);
                        }
                        scanState = State.DONE;
                        break;

                    //If we have a > symbol and are looking for an = for >=
                    case GT:
                        if (c == '=') {
                            currToken.setToken(Token.TokenType.GTE, null);
                        }
                        else {
                            currToken.setToken(Token.TokenType.GT,null);
                            inFile.unread(c);
                        }
                        scanState = State.DONE;
                        break;

                    //If we have a = symbol and are looking for another = for ==
                    case EQ:
                        if (c == '=') {
                            currToken.setToken(Token.TokenType.EQEQ, null);
                        }
                        else {
                            currToken.setToken(Token.TokenType.EQ, null);
                            inFile.unread(c);
                        }
                        scanState = State.DONE;
                        break;

                    //If we have !, look for = immediately after for != (otherwise the token is an ERROR)
                    case BANG:
                        if (c == '=') {
                            currToken.setToken(Token.TokenType.NOTEQ, null);
                        }
                        else {
                            currToken.setToken(Token.TokenType.ERROR, '!');
                            inFile.unread(c);
                        }
                        scanState = State.DONE;
                        break;

                    //If we have received a /, check for a * and enter INCOMM state
                    case INSLASH:
                        if (c == '*') {
                            currToken.setType(Token.TokenType.NONE);
                            scanState = State.INCOMM;
                        }
                        else {
                            currToken.setToken(Token.TokenType.SLASH, null);
                            inFile.unread(c);
                            scanState = State.DONE;
                        }
                        break;

                    //If we are in a comment, check for a * to begin the exit, otherwise throw away
                    case INCOMM:
                        if (c == '*') {
                            scanState = State.OUTCOMM;
                        }
                        break;

                    //If we are in a comment and have gotten a *, check for / to exit comment, otherwise return to comment
                    case OUTCOMM:
                        if (c == '/') {
                            scanState = State.START;
                        }
                        else if (c =='*') {}//stay here
                        else {
                            scanState = State.INCOMM;
                        }
                        break;

                    //This will and should never happen
                    default:
                        System.out.println("You broke the scanner :/");
                        scanState = State.DONE;
                        break;
                }
            }
        }
        
        catch(Exception e) {
            System.out.println("File failed to open, or something internally is a bug and we are failures :\\");
            e.printStackTrace();
        }

        //RETURN!!! :DDD
        return currToken;
    }
}
