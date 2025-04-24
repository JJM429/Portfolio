package org.uob.a2.commands;

import org.junit.jupiter.api.Test;
import org.uob.a2.gameobjects.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Drop} command.
 */
class DropTest {

    /**
     * Tests dropping an item that exists in the player's inventory.
     */
    @Test
    void testDropItemFromInventory() {
        // Setup game state
        Player player = new Player("Player");
        Item item = new Item("k1", "key", "An old rusty key.", false);
        player.addItem(item);
        Room room = new Room("1", "Test Room", "A test room.", false);
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, player);

        // Execute drop command
        Drop dropCommand = new Drop("key");
        String result = dropCommand.execute(gameState);

        // Validate results
        boolean testPassed = !player.hasItem("key") &&
                             gameState.getMap().getCurrentRoom().hasItem("key") &&
                             "You drop: key".equals(result);

        System.out.println("AUTOMARK::Drop.testDropItemFromInventory: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected successful drop of the item from inventory.");
    }

    /**
     * Tests dropping an equipment item that exists in the player's inventory.
     */
    @Test
    void testDropEquipmentFromInventory() {
        // Setup game state
        Player player = new Player("Player");
        Equipment equipment = new Equipment("s1", "sword", "A sharp blade.", false, null);
        player.addEquipment(equipment);
        Room room = new Room("1", "Test Room", "A test room.", false);
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, player);

        // Execute drop command
        Drop dropCommand = new Drop("sword");
        String result = dropCommand.execute(gameState);

        // Validate results
        boolean testPassed = !player.hasEquipment("sword") &&
                             room.hasEquipment("sword") &&
                             "You drop: sword".equals(result);

        System.out.println("AUTOMARK::Drop.testDropEquipmentFromInventory: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected successful drop of equipment from inventory.");
    }

    /**
     * Tests attempting to drop an item that the player does not possess.
     */
    @Test
    void testDropNonexistentItem() {
        // Setup game state
        Player player = new Player("Player");
        Room room = new Room("1", "Test Room", "A test room.", false);
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, player);

        // Execute drop command
        Drop dropCommand = new Drop("nonexistent");
        String result = dropCommand.execute(gameState);

        // Validate results
        boolean testPassed = "You cannot drop nonexistent".equals(result);

        System.out.println("AUTOMARK::Drop.testDropNonexistentItem: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected message indicating the item cannot be dropped.");
    }
}
