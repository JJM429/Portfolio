package org.uob.a2.gameobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code GameObject} abstract class and its basic properties.
 */
class GameObjectTest {

    /**
     * Tests the creation of a {@code GameObject} through a concrete subclass and validates its attributes.
     */
    @Test
    void testGameObjectAttributes() {
        // Create a concrete implementation of GameObject
        GameObject gameObject = new GameObject("object1", "Lamp", "A bright lamp.", false) {};

        // Validate attributes
        boolean testPassed =
            "object1".equals(gameObject.getId()) &&
            "Lamp".equals(gameObject.getName()) &&
            "A bright lamp.".equals(gameObject.getDescription()) &&
            !gameObject.getHidden();

        System.out.println("AUTOMARK::GameObject.testGameObjectAttributes: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected all GameObject attributes to match.");
    }

    /**
     * Tests the string representation of a {@code GameObject}.
     */
    @Test
    void testToStringMethod() {
        // Create a concrete implementation of GameObject
        GameObject gameObject = new GameObject("object1", "Lamp", "A bright lamp.", false) {};

        // Validate toString output
        String expected = "GameObject {id='object1', name='Lamp', description='A bright lamp.', hidden=false}";
        boolean testPassed = expected.equals(gameObject.toString());

        System.out.println("AUTOMARK::GameObject.testToStringMethod: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected toString output to match the expected format.");
    }

    /**
     * Tests setting and getting the name of a {@code GameObject}.
     */
    @Test
    void testSetNameAndGetName() {
        // Create a concrete implementation of GameObject
        GameObject gameObject = new GameObject("object1", "Lamp", "A bright lamp.", false) {};
        gameObject.setName("Desk Lamp");

        // Validate updated name
        boolean testPassed = "Desk Lamp".equals(gameObject.getName());

        System.out.println("AUTOMARK::GameObject.testSetNameAndGetName: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected updated name to match 'Desk Lamp'.");
    }

    /**
     * Tests setting and getting the visibility state of a {@code GameObject}.
     */
    @Test
    void testSetAndGetHidden() {
        // Create a concrete implementation of GameObject
        GameObject gameObject = new GameObject("object1", "Lamp", "A bright lamp.", true) {};
        gameObject.setHidden(false);

        // Validate hidden state
        boolean testPassed = !gameObject.getHidden();

        System.out.println("AUTOMARK::GameObject.testSetAndGetHidden: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected hidden state to be updated to 'false'.");
    }

    /**
     * Tests setting and getting the description of a {@code GameObject}.
     */
    @Test
    void testSetAndGetDescription() {
        // Create a concrete implementation of GameObject
        GameObject gameObject = new GameObject("object1", "Lamp", "A bright lamp.", false) {};
        gameObject.setDescription("A dim lamp.");

        // Validate updated description
        boolean testPassed = "A dim lamp.".equals(gameObject.getDescription());

        System.out.println("AUTOMARK::GameObject.testSetAndGetDescription: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected updated description to match 'A dim lamp.'");
    }
}
