package org.uob.a2.parser;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TokenTest {

    /**
     * Tests the {@code Token} constructor with both a type and value.
     */
    @Test
    void testTokenWithTypeAndValue() {
        // Create a token with type and value
        Token token = new Token(TokenType.MOVE, "north");

        // Validate type and value
        boolean testPassed = 
            (token.getTokenType() == TokenType.MOVE) &&
            ("north".equals(token.getValue()));

        System.out.println("AUTOMARK::Token.testTokenWithTypeAndValue: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected Token type to be MOVE and value to be 'north'.");
    }

    /**
     * Tests the {@code Token} constructor with only a type.
     */
    @Test
    void testTokenWithTypeOnly() {
        // Create a token with only type
        Token token = new Token(TokenType.QUIT);

        // Validate type and default value
        boolean testPassed = 
            (token.getTokenType() == TokenType.QUIT) &&
            (token.getValue() == null);

        System.out.println("AUTOMARK::Token.testTokenWithTypeOnly: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected Token type to be QUIT and value to be null.");
    }
}
