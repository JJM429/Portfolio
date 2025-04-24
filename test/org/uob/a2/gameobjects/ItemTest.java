package org.uob.a2.gameobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Item} class.
 */
class ItemTest {

    /**
     * Tests the creation of an {@code Item} object and its attributes.
     */
    @Test
    void testItemAttributes() {
        // Create an item
        Item item = new Item("item1", "Key", "A rusty old key.", false);

        // Validate attributes
        boolean testPassed =
            "item1".equals(item.getId()) &&
            "Key".equals(item.getName()) &&
            "A rusty old key.".equals(item.getDescription()) &&
            !item.getHidden();

        System.out.println("AUTOMARK::Item.testItemAttributes: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected all item attributes to match.");
    }

    /**
     * Tests the string representation of an {@code Item}.
     */
    @Test
    void testToStringMethod() {
        // Create an item
        Item item = new Item("item1", "Key", "A rusty old key.", false);

        // Validate toString output
        String expected = "GameObject {id='item1', name='Key', description='A rusty old key.', hidden=false}";
        boolean testPassed = expected.equals(item.toString());

        System.out.println("AUTOMARK::Item.testToStringMethod: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected toString output to match the expected format.");
    }

    /**
     * Tests setting and getting the hidden state of an {@code Item}.
     */
    @Test
    void testSetAndGetHidden() {
        // Create an item
        Item item = new Item("item1", "Key", "A rusty old key.", true);

        // Update and validate hidden state
        item.setHidden(false);
        boolean testPassed = !item.getHidden();

        System.out.println("AUTOMARK::Item.testSetAndGetHidden: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected hidden state to be updated to 'false'.");
    }

    /**
     * Tests setting and getting the name of an {@code Item}.
     */
    @Test
    void testSetNameAndGetName() {
        // Create an item
        Item item = new Item("item1", "Key", "A rusty old key.", false);

        // Update and validate the name
        item.setName("Golden Key");
        boolean testPassed = "Golden Key".equals(item.getName());

        System.out.println("AUTOMARK::Item.testSetNameAndGetName: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected updated name to match 'Golden Key'.");
    }

    /**
     * Tests setting and getting the description of an {@code Item}.
     */
    @Test
    void testSetAndGetDescription() {
        // Create an item
        Item item = new Item("item1", "Key", "A rusty old key.", false);

        // Update and validate the description
        item.setDescription("A shiny golden key.");
        boolean testPassed = "A shiny golden key.".equals(item.getDescription());

        System.out.println("AUTOMARK::Item.testSetAndGetDescription: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected updated description to match 'A shiny golden key.'");
    }
}
