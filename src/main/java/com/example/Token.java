package com.example;

/*
 * This class defines a Token for use in the Scanner.
 * 
 * @authors: Luke Carpenter and Kobe Couvion
 * Created: February 2023
 * Copyright probably is still unimportant :))
 *
 * Description: Each Token has a tokenType and tokenData field as private variables. They can
 * both be set to null if needed. The types a token can have are defined in the enum TokenType.
 * The symbols mentioned in Scanner.java are all accounted for, as well as an ERROR type and 
 * NONE type. There are 2 constructors: 1 that takes a type and 1 that takes both Type and Data.
 * Getters and setters are defined to set and access each of the private attributes either
 * individually or together. The addData() method appends the input character to the existing
 * value stored in the tokenData field.
 */
public class Token {

    //enum for all the token types, including ERROR, NONE, and KEYWORD
    public enum TokenType {
        ID,
        NUM,
        PLUS,
        MINUS,
        STAR,
        SLASH,
        LT,
        LTE,
        GT,
        GTE,
        EQ,
        EQEQ,
        NOTEQ,
        SEMI,
        COMMA,
        LPAREN,
        RPAREN,
        LBRACK,
        RBRACK,
        LBRAY,
        RBRAY,
        KEYWORD,
        ERROR,
        NONE,
        EOF_TOKEN
    }

    //Variables
    private TokenType tokenType;
    private Object tokenData;

    //Constructors
    public Token(TokenType type) {
        tokenType = type;
        tokenData = null;
    }
    public Token (TokenType flavor, Object data) {
        tokenType = flavor;
        tokenData = data;
    }

    //Setters
    public void setType(TokenType flavor) {
        this.tokenType = flavor;
    }
    public void setToken(TokenType flavor, Object data) {
        this.tokenType = flavor;
        this.tokenData = data;
    }
    public void setData(Object data) {
        this.tokenData = data;
    }

    //Getters
    public String getType() {
        return this.tokenType.name();
    }
    public TokenType getEnumType() {
        return this.tokenType;
    }
    public Object getData() {
        return this.tokenData;
    }

    //Add character to existing data
    public void addData(char data) {
        if (this.tokenData == null) this.tokenData = Character.toString(data);
        else {this.tokenData = this.tokenData.toString() + Character.toString(data);}
    }
}