package org.uob.a2.commands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code CommandErrorException} class.
 */
class CommandErrorExceptionTest {

    /**
     * Tests the constructor and the message retrieval.
     */
    @Test
    void testExceptionMessage() {
        CommandErrorException exception = new CommandErrorException("Invalid command");

        boolean result = "Invalid command".equals(exception.getMessage());
        System.out.println("AUTOMARK::CommandErrorException.testExceptionMessage: " + (result ? "PASS" : "FAIL"));

        assertTrue(result, "Expected message to match 'Invalid command'");
    }

    /**
     * Tests the {@code toString} method.
     */
    @Test
    void testToStringMethod() {
        CommandErrorException exception = new CommandErrorException("Invalid command");

        boolean result = "CommandError: Invalid command".equals(exception.toString());
        System.out.println("AUTOMARK::CommandErrorException.testToStringMethod: " + (result ? "PASS" : "FAIL"));

        assertTrue(result, "Expected toString output to match 'CommandError: Invalid command'");
    }
}
