package org.uob.a2.gameobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Exit} class.
 */
class ExitTest {

    /**
     * Tests the creation of an {@code Exit} object and its attributes.
     */
    @Test
    void testExitAttributes() {
        // Create an exit
        Exit exit = new Exit("exit1", "North Exit", "Leads to the northern room.", "room2", false);

        // Validate attributes
        boolean testPassed =
            "exit1".equals(exit.getId()) &&
            "North Exit".equals(exit.getName()) &&
            "Leads to the northern room.".equals(exit.getDescription()) &&
            "room2".equals(exit.getNextRoom()) &&
            !exit.getHidden();

        System.out.println("AUTOMARK::Exit.testExitAttributes: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected all Exit attributes to match.");
    }

    /**
     * Tests the string representation of an {@code Exit} object.
     */
    @Test
    void testToStringMethod() {
        // Create an exit
        Exit exit = new Exit("exit1", "North Exit", "Leads to the northern room.", "room2", false);

        // Validate toString output
        String expected = "GameObject {id='exit1', name='North Exit', description='Leads to the northern room.', hidden=false}, nextRoom=room2";
        boolean testPassed = expected.equals(exit.toString());

        System.out.println("AUTOMARK::Exit.testToStringMethod: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected toString output to match the expected format.");
    }

    /**
     * Tests setting and getting the hidden state of the exit.
     */
    @Test
    void testSetAndGetHidden() {
        // Create an exit
        Exit exit = new Exit("exit1", "North Exit", "Leads to the northern room.", "room2", true);

        // Update and validate the hidden state
        exit.setHidden(false);
        boolean testPassed = !exit.getHidden();

        System.out.println("AUTOMARK::Exit.testSetAndGetHidden: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected hidden state to be updated to 'false'.");
    }
}
