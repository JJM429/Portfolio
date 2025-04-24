package org.uob.a2.gameobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Player} class.
 */
class PlayerTest {

    /**
     * Tests the creation of a {@code Player} object and its attributes.
     */
    @Test
    void testPlayerAttributes() {
        // Create a player
        Player player = new Player("Hero");

        // Validate attributes
        boolean testPassed =
            "Hero".equals(player.getName()) &&
            player.getInventory().isEmpty() &&
            player.getEquipment().isEmpty();

        System.out.println("AUTOMARK::Player.testPlayerAttributes: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected Player attributes to match.");
    }

    /**
     * Tests adding and retrieving an item in the player's inventory.
     */
    @Test
    void testAddAndRetrieveItem() {
        // Create a player and an item
        Player player = new Player("Hero");
        Item item = new Item("item1", "Key", "A rusty key.", false);

        // Add item to inventory
        player.addItem(item);

        // Validate inventory
        boolean testPassed =
            player.getInventory().contains(item) &&
            "Key".equals(player.getItem("Key").getName());

        System.out.println("AUTOMARK::Player.testAddAndRetrieveItem: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected item to be added and retrievable from Player inventory.");
    }

    /**
     * Tests adding and retrieving equipment.
     */
    @Test
    void testAddAndRetrieveEquipment() {
        // Create a player and equipment
        Player player = new Player("Hero");
        Equipment equipment = new Equipment("equip1", "Sword", "A sharp blade.", false, null);

        // Add equipment to player
        player.addEquipment(equipment);

        // Validate equipment
        boolean testPassed =
            player.getEquipment().contains(equipment) &&
            "Sword".equals(player.getEquipment("Sword").getName());

        System.out.println("AUTOMARK::Player.testAddAndRetrieveEquipment: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected equipment to be added and retrievable from Player.");
    }

    /**
     * Tests the string representation of the {@code Player} class.
     */
    @Test
    void testToStringMethod() {
        // Create a player with inventory and equipment
        Player player = new Player("Hero");
        player.addItem(new Item("item1", "Key", "A rusty key.", false));
        player.addEquipment(new Equipment("equip1", "Sword", "A sharp blade.", false, null));

        // Validate toString output
        String result = player.toString();
        boolean testPassed =
            result.contains("Hero") &&
            result.contains("A rusty key.") &&
            result.contains("A sharp blade.");

        System.out.println("AUTOMARK::Player.testToStringMethod: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected Player toString output to contain all details.");
    }

    /**
     * Tests checking if the player has an item.
     */
    @Test
    void testHasItem() {
        // Create a player and add an item
        Player player = new Player("Hero");
        player.addItem(new Item("item1", "Key", "A rusty key.", false));

        // Validate item existence
        boolean testPassed = player.hasItem("Key");

        System.out.println("AUTOMARK::Player.testHasItem: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected Player to have the specified item.");
    }

    /**
     * Tests checking if the player has equipment.
     */
    @Test
    void testHasEquipment() {
        // Create a player and add equipment
        Player player = new Player("Hero");
        player.addEquipment(new Equipment("equip1", "Sword", "A sharp blade.", false, null));

        // Validate equipment existence
        boolean testPassed = player.hasEquipment("Sword");

        System.out.println("AUTOMARK::Player.testHasEquipment: " + (testPassed ? "PASS" : "FAIL"));
        assertTrue(testPassed, "Expected Player to have the specified equipment.");
    }
}
