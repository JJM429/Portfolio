package org.uob.a2.commands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Help} command.
 */
class HelpTest {

    /**
     * Tests the execution of the general help command (no topic specified).
     */
    @Test
    void testGeneralHelp() {
        Help helpCommand = new Help(null);
        String result = helpCommand.execute(null); // GameState is not used for Help commands

        // Validate results
        boolean testPassed = result.contains("Welcome to the game!") &&
                             result.contains("- MOVE") &&
                             result.contains("- HELP");

        System.out.println("AUTOMARK::Help.testGeneralHelp: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected the general help command to display correct information.");
    }

    /**
     * Tests the execution of the help command with a valid topic.
     */
    @Test
    void testSpecificHelpValidTopic() {
        Help helpCommand = new Help("move");
        String result = helpCommand.execute(null);

        // Validate results
        boolean testPassed = result.contains("MOVE Command:") &&
                             result.contains("Use the 'move' command") &&
                             result.contains("direction");

        System.out.println("AUTOMARK::Help.testSpecificHelpValidTopic: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected the help command to display correct information for a valid topic.");
    }

    /**
     * Tests the execution of the help command with an invalid topic.
     */
    @Test
    void testSpecificHelpInvalidTopic() {
        Help helpCommand = new Help("unknown");
        String result = helpCommand.execute(null);

        // Validate results
        boolean testPassed = result.contains("No help available for the topic: unknown");

        System.out.println("AUTOMARK::Help.testSpecificHelpInvalidTopic: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected the help command to display an error message for an invalid topic.");
    }

    /**
     * Tests the string representation of the help command.
     */
    @Test
    void testToStringMethod() {
        Help helpCommand = new Help("look");
        String result = helpCommand.toString();

        // Validate results
        boolean testPassed = result.contains("HELP") && result.contains("look");

        System.out.println("AUTOMARK::Help.testToStringMethod: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected the toString method to include HELP and the specified topic.");
    }
}
