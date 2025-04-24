package org.uob.a2.parser;

import org.junit.jupiter.api.Test;
import org.uob.a2.commands.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ParserTest {

    /**
     * Tests parsing a valid MOVE command.
     */
    @Test
    void testParseMoveCommand() {
        Parser parser = new Parser();
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token(TokenType.MOVE));
        tokens.add(new Token(TokenType.VAR, "north"));

        boolean testPassed = false;

        try {
            Command command = parser.parse(tokens);
            testPassed = (command instanceof Move) &&
                         (command.commandType == CommandType.MOVE) &&
                         (((Move) command).toString().contains("north"));
        } catch (CommandErrorException e) {
            fail("Exception should not be thrown for valid MOVE command");
        }

        System.out.println("AUTOMARK::Parser.testParseMoveCommand: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected to parse MOVE command correctly.");
    }

    /**
     * Tests parsing a valid GET command.
     */
    @Test
    void testParseGetCommand() {
        Parser parser = new Parser();
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token(TokenType.GET));
        tokens.add(new Token(TokenType.VAR, "key"));

        boolean testPassed = false;

        try {
            Command command = parser.parse(tokens);
            testPassed = (command instanceof Get) &&
                         (command.commandType == CommandType.GET) &&
                         (((Get) command).toString().contains("key"));
        } catch (CommandErrorException e) {
            fail("Exception should not be thrown for valid GET command");
        }

        System.out.println("AUTOMARK::Parser.testParseGetCommand: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected to parse GET command correctly.");
    }

    /**
     * Tests parsing an invalid command (e.g., missing arguments).
     */
    @Test
    void testParseInvalidCommand() {
        Parser parser = new Parser();
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token(TokenType.GET)); // Missing variable token

        boolean testPassed = false;

        try {
            parser.parse(tokens);
            fail("Exception should have been thrown for invalid GET command");
        } catch (CommandErrorException e) {
            testPassed = true; // Correctly threw exception
        }

        System.out.println("AUTOMARK::Parser.testParseInvalidCommand: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected exception for invalid GET command.");
    }

    /**
     * Tests parsing a USE command with an item and a target.
     */
    @Test
    void testParseUseCommand() {
        Parser parser = new Parser();
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token(TokenType.USE));
        tokens.add(new Token(TokenType.VAR, "key"));
        tokens.add(new Token(TokenType.PREPOSITION, "on"));
        tokens.add(new Token(TokenType.VAR, "chest"));

        boolean testPassed = false;

        try {
            Command command = parser.parse(tokens);
            testPassed = (command instanceof Use) &&
                         (command.commandType == CommandType.USE) &&
                         (((Use) command).toString().contains("key on chest"));
        } catch (CommandErrorException e) {
            fail("Exception should not be thrown for valid USE command");
        }

        System.out.println("AUTOMARK::Parser.testParseUseCommand: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected to parse USE command correctly.");
    }

    /**
     * Tests parsing a HELP command without arguments.
     */
    @Test
    void testParseHelpCommand() {
        Parser parser = new Parser();
        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token(TokenType.HELP));
        tokens.add(new Token(TokenType.EOL)); // No additional arguments

        boolean testPassed = false;

        try {
            Command command = parser.parse(tokens);
            testPassed = (command instanceof Help) &&
                         (command.commandType == CommandType.HELP) &&
                         (((Help) command).toString().contains("null")); // Topic is null
        } catch (CommandErrorException e) {
            fail("Exception should not be thrown for valid HELP command");
        }

        System.out.println("AUTOMARK::Parser.testParseHelpCommand: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected to parse HELP command correctly.");
    }
}
