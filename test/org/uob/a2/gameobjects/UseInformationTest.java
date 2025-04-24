package org.uob.a2.gameobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code UseInformation} class.
 */
class UseInformationTest {

    /**
     * Tests the creation of a {@code UseInformation} object and its attributes.
     */
    @Test
    void testUseInformationAttributes() {
        // Create a UseInformation object
        UseInformation useInfo = new UseInformation(false, "open", "chest1", "key1", "You opened the chest!");

        // Validate attributes
        boolean testPassed =
            !useInfo.isUsed() &&
            "open".equals(useInfo.getAction()) &&
            "chest1".equals(useInfo.getTarget()) &&
            "key1".equals(useInfo.getResult()) &&
            "You opened the chest!".equals(useInfo.getMessage());

        System.out.println("AUTOMARK::UseInformation.testUseInformationAttributes: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected all UseInformation attributes to match.");
    }

    /**
     * Tests updating the attributes of a {@code UseInformation} object.
     */
    @Test
    void testUpdateAttributes() {
        // Create a UseInformation object
        UseInformation useInfo = new UseInformation(false, "open", "chest1", "key1", "You opened the chest!");

        // Update attributes
        useInfo.setUsed(true);
        useInfo.setAction("reveal");
        useInfo.setTarget("door1");
        useInfo.setResult("key2");
        useInfo.setMessage("You revealed a hidden door!");

        // Validate updated attributes
        boolean testPassed =
            useInfo.isUsed() &&
            "reveal".equals(useInfo.getAction()) &&
            "door1".equals(useInfo.getTarget()) &&
            "key2".equals(useInfo.getResult()) &&
            "You revealed a hidden door!".equals(useInfo.getMessage());

        System.out.println("AUTOMARK::UseInformation.testUpdateAttributes: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected updated UseInformation attributes to match.");
    }

    /**
     * Tests the string representation of a {@code UseInformation} object.
     */
    @Test
    void testToStringMethod() {
        // Create a UseInformation object
        UseInformation useInfo = new UseInformation(false, "open", "chest1", "key1", "You opened the chest!");

        // Validate toString output
        String expected = "UseInformation{isUsed=false, action='open', target='chest1', result='key1', message='You opened the chest!'}";
        boolean testPassed = expected.equals(useInfo.toString());

        System.out.println("AUTOMARK::UseInformation.testToStringMethod: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected UseInformation toString output to match the expected format.");
    }
}
