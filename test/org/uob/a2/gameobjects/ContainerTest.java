package org.uob.a2.gameobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Container} class.
 */
class ContainerTest {

    /**
     * Tests the creation of a {@code Container} object and its attributes.
     */
    @Test
    void testContainerAttributes() {
        // Create a Container
        Container container = new Container("chest1", "Treasure Chest", "A chest filled with treasures.", false);

        // Validate attributes
        boolean testPassed =
            "chest1".equals(container.getId()) &&
            "Treasure Chest".equals(container.getName()) &&
            "A chest filled with treasures.".equals(container.getDescription()) &&
            !container.getHidden();

        System.out.println("AUTOMARK::Container.testContainerAttributes: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected all container attributes to match.");
    }

    /**
     * Tests setting and getting the name of the container.
     */
    @Test
    void testSetAndGetName() {
        // Create a container
        Container container = new Container("chest1", "Old Chest", "A worn-out wooden chest.", true);

        // Update and validate the name
        container.setName("Ancient Chest");
        boolean testPassed = "Ancient Chest".equals(container.getName());

        System.out.println("AUTOMARK::Container.testSetAndGetName: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected updated name to match 'Ancient Chest'.");
    }

    /**
     * Tests setting and getting the hidden state of the container.
     */
    @Test
    void testSetAndGetHidden() {
        // Create a container
        Container container = new Container("chest1", "Treasure Container", "A chest filled with treasures.", true);

        // Update and validate the hidden state
        container.setHidden(false);
        boolean testPassed = !container.getHidden();

        System.out.println("AUTOMARK::Container.testSetAndGetHidden: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected hidden state to be updated to 'false'.");
    }
}
