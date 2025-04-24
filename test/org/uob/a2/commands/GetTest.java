package org.uob.a2.commands;

import org.junit.jupiter.api.Test;
import org.uob.a2.gameobjects.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Get} command.
 */
class GetTest {

    /**
     * Tests getting an item that is present in the current room.
     */
    @Test
    void testGetItemFromRoom() {
        // Setup game state
        Player player = new Player("Player");
        Item item = new Item("key", "key", "An old rusty key.", false);
        Room room = new Room("1", "Test Room", "A test room.", false);
        room.addItem(item);
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, player);

        // Execute get command
        Get getCommand = new Get("key");
        String result = getCommand.execute(gameState);

        // Validate results
        boolean testPassed = player.hasItem("key") &&
                             !room.getItems().contains(item) &&
                             "You pick up: key".equals(result);

        System.out.println("AUTOMARK::Get.testGetItemFromRoom: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected successful retrieval of the item.");
    }

    /**
     * Tests getting equipment that is present in the current room.
     */
    @Test
    void testGetEquipmentFromRoom() {
        // Setup game state
        Player player = new Player("Player");
        Equipment equipment = new Equipment("sword", "sword", "A sharp blade.", false, null);
        Room room = new Room("1", "Test Room", "A test room.", false);
        room.addEquipment(equipment);
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, player);

        // Execute get command
        Get getCommand = new Get("sword");
        String result = getCommand.execute(gameState);

        // Validate results
        boolean testPassed = player.hasEquipment("sword") &&
                             !room.getEquipments().contains(equipment) &&
                             "You pick up: sword".equals(result);

        System.out.println("AUTOMARK::Get.testGetEquipmentFromRoom: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected successful retrieval of the equipment.");
    }

    /**
     * Tests attempting to get an item that the player already has.
     */
    @Test
    void testGetItemAlreadyInInventory() {
        // Setup game state
        Player player = new Player("Player");
        Item item = new Item("key", "key", "An old rusty key.", false);
        player.addItem(item);
        Room room = new Room("1", "Test Room", "A test room.", false);
        room.addItem(item);
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, player);

        // Execute get command
        Get getCommand = new Get("key");
        String result = getCommand.execute(gameState);

        // Validate results
        boolean testPassed = "You already have key".equals(result);

        System.out.println("AUTOMARK::Get.testGetItemAlreadyInInventory: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected message indicating the item is already in inventory.");
    }

    /**
     * Tests attempting to get an item or equipment that does not exist in the room.
     */
    @Test
    void testGetNonexistentItem() {
        // Setup game state
        Player player = new Player("Player");
        Room room = new Room("1", "Test Room", "A test room.", false);
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, player);

        // Execute get command
        Get getCommand = new Get("nonexistent");
        String result = getCommand.execute(gameState);

        // Validate results
        boolean testPassed = "No nonexistent to get.".equals(result);

        System.out.println("AUTOMARK::Get.testGetNonexistentItem: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected message indicating no such item exists.");
    }
}
