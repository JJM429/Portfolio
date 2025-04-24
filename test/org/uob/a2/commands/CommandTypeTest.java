package org.uob.a2.commands;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the {@code CommandType} enum to ensure all command types are correctly defined.
 */
class CommandTypeTest {

    /**
     * Tests the existence of all {@code CommandType} values.
     */
    @Test
    void testEnumValues() {
        // Retrieve all CommandType values
        CommandType[] values = CommandType.values();

        // Validate that all expected CommandType values are present
        boolean result = (values.length == 8) &&
                (CommandType.MOVE == CommandType.valueOf("MOVE")) &&
                (CommandType.USE == CommandType.valueOf("USE")) &&
                (CommandType.GET == CommandType.valueOf("GET")) &&
                (CommandType.DROP == CommandType.valueOf("DROP")) &&
                (CommandType.LOOK == CommandType.valueOf("LOOK")) &&
                (CommandType.STATUS == CommandType.valueOf("STATUS")) &&
                (CommandType.HELP == CommandType.valueOf("HELP")) &&
                (CommandType.QUIT == CommandType.valueOf("QUIT"));

        System.out.println("AUTOMARK::CommandType.testEnumValues: " + (result ? "PASS" : "FAIL"));

        assertTrue(result, "All enum values must be correctly defined.");
    }

    /**
     * Tests that {@code CommandType.valueOf()} throws an exception for invalid input.
     */
    @Test
    void testInvalidEnumValue() {
        boolean result = false;

        // Attempt to retrieve an invalid CommandType value
        try {
            CommandType.valueOf("INVALID");
        } catch (IllegalArgumentException e) {
            // Exception expected for invalid input
            result = true;
        }

        System.out.println("AUTOMARK::CommandType.testInvalidEnumValue: " + (result ? "PASS" : "FAIL"));

        assertTrue(result, "Expected exception for invalid enum value.");
    }
}
