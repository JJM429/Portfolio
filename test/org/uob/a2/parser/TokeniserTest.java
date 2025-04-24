package org.uob.a2.parser;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class TokeniserTest {

    /**
     * Tests the tokenisation of a basic command string.
     */
    @Test
    void testTokeniseBasicCommand() {
        Tokeniser tokeniser = new Tokeniser();
        tokeniser.tokenise("move north");

        ArrayList<Token> tokens = tokeniser.getTokens();
        boolean testPassed = 
            (tokens.size() == 3) &&
            (tokens.get(0).getTokenType() == TokenType.MOVE) &&
            ("north".equals(tokens.get(1).getValue())) &&
            (tokens.get(2).getTokenType() == TokenType.EOL);

        System.out.println("AUTOMARK::Tokeniser.testTokeniseBasicCommand: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected to tokenise basic command correctly.");
    }

    /**
     * Tests the tokenisation of a string with extra whitespace.
     */
    @Test
    void testTokeniseWithExtraWhitespace() {
        Tokeniser tokeniser = new Tokeniser();
        tokeniser.tokenise(tokeniser.sanitise("   get    key   "));

        ArrayList<Token> tokens = tokeniser.getTokens();
        boolean testPassed = 
            (tokens.size() == 3) &&
            (tokens.get(0).getTokenType() == TokenType.GET) &&
            ("key".equals(tokens.get(1).getValue())) &&
            (tokens.get(2).getTokenType() == TokenType.EOL);

        System.out.println("AUTOMARK::Tokeniser.testTokeniseWithExtraWhitespace: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected to tokenise string with extra whitespace correctly.");
    }

    /**
     * Tests the sanitisation of input strings.
     */
    @Test
    void testSanitiseInput() {
        Tokeniser tokeniser = new Tokeniser();
        String result = tokeniser.sanitise("   MOVE North   ");

        boolean testPassed = "move north".equals(result);

        System.out.println("AUTOMARK::Tokeniser.testSanitiseInput: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected input string to be sanitised correctly.");
    }

    /**
     * Tests the tokenisation of an unknown command.
     */
    @Test
    void testTokeniseUnknownCommand() {
        Tokeniser tokeniser = new Tokeniser();
        tokeniser.tokenise("dance wildly");

        ArrayList<Token> tokens = tokeniser.getTokens();
        boolean testPassed = 
            (tokens.size() == 3) &&
            (tokens.get(0).getTokenType() == TokenType.VAR) &&
            ("wildly".equals(tokens.get(1).getValue())) &&
            (tokens.get(2).getTokenType() == TokenType.EOL);

        System.out.println("AUTOMARK::Tokeniser.testTokeniseUnknownCommand: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected to tokenise unknown command correctly.");
    }

    /**
     * Tests the tokenisation of the command "use key on chest".
     */
    @Test
    void testTokeniseUseCommand() {
        Tokeniser tokeniser = new Tokeniser();
        tokeniser.tokenise("use key on chest");

        ArrayList<Token> tokens = tokeniser.getTokens();
        boolean testPassed = 
            (tokens.size() == 5) &&
            (tokens.get(0).getTokenType() == TokenType.USE) &&
            ("key".equals(tokens.get(1).getValue())) &&
            (tokens.get(2).getTokenType() == TokenType.PREPOSITION && "on".equals(tokens.get(2).getValue())) &&
            ("chest".equals(tokens.get(3).getValue())) &&
            (tokens.get(4).getTokenType() == TokenType.EOL);

        System.out.println("AUTOMARK::Tokeniser.testTokeniseUseCommand: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected to tokenise 'use key on chest' command correctly.");
    }
}
