package org.uob.a2.parser;

/**
 * Represents a token in the parsing process, consisting of a {@code TokenType} and an optional value.
 * 
 * <p>
 * Tokens are used to represent the smallest units of meaning in the command input,
 * such as keywords, or variables.
 * </p>
 */
public class Token {

    TokenType type;
    String value;

    public Token(TokenType type) {
        this.type = type;
    }/** not sure if this is correct*/

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }

    public TokenType getTokenType() {
        return type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String toString() {
        return type + " " + value;
    }/** not a method that is stated in package so check if needed*/
}
