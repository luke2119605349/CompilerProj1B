package com.example;

import java.util.*;

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
public class Scanner {

    //A constant array of reserved keywords. Identifiers that match any of these are reset to a KEYWORD token type
    final static String reservedWords[] = {"else", "if", "int", "return", "void", "while"};
    public static void main( String[] args ) {
        CMinusScanner2 sn = new CMinusScanner2("src/main/java/com/example/cminuscode.txt");
        ArrayList<Token> tokens = new ArrayList<Token>();

        while (sn.viewNextToken().getEnumType() != Token.TokenType.EOF_TOKEN) {
            Token toAdd = new Token(sn.viewNextToken().getEnumType(), sn.getNextToken().getData());
            tokens.add(toAdd);
        }

        System.out.println("\nTokens:");
        for (Token t : tokens) {
            if (t.getType() == "ID") {
                for (String w : reservedWords) {
                    if (w.equals(t.getData())) {
                        t.setType(Token.TokenType.KEYWORD);
                    }
                }
            }
            System.out.println(t.getType() + ", " + t.getData());
        }
    }
}