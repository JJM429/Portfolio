package org.uob.a2.commands;

import org.junit.jupiter.api.Test;
import org.uob.a2.gameobjects.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Look} command.
 */
class LookTest {

    /**
     * Tests the "look room" command to retrieve the room description and visible objects.
     */
    @Test
    void testLookRoom() {
        // Setup game state
        Room room = new Room("1", "Test Room", "A simple test room.", false);
        Item item = new Item("key", "Rusty Key", "A rusty old key.", false);
        Equipment equipment = new Equipment("sword", "Sword", "A sharp blade.", false, null);
        room.addItem(item);
        room.addEquipment(equipment);
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, new Player("Player"));

        // Execute look command
        Look lookCommand = new Look("room");
        String result = lookCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.contains("A simple test room.") &&
                             result.contains("rusty old key") &&
                             result.contains("A sharp blade");

        System.out.println("AUTOMARK::Look.testLookRoom: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected to retrieve room description and visible objects.");
    }

    /**
     * Tests the "look exits" command to retrieve visible exits.
     */
    @Test
    void testLookExits() {
        // Setup game state
        Room room = new Room("1", "Test Room", "A simple test room.", false);
        Exit exit = new Exit("north", "North Exit", "A path leading north.", "2", false);
        room.addExit(exit);
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, new Player("Player"));

        // Execute look command
        Look lookCommand = new Look("exits");
        String result = lookCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.contains("The available exits are:") &&
                             result.contains("A path leading north");

        System.out.println("AUTOMARK::Look.testLookExits: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected to retrieve visible exits.");
    }

    /**
     * Tests the "look features" command to retrieve visible features in the room.
     */
    @Test
    void testLookFeatures() {
        // Setup game state
        Room room = new Room("1", "Test Room", "A simple test room.", false);
        Feature feature = new Feature("painting", "Painting", "A beautiful landscape painting.", false);
        room.addFeature(feature);
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, new Player("Player"));

        // Execute look command
        Look lookCommand = new Look("features");
        String result = lookCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.contains("You also see:") &&
                             result.contains("painting");

        System.out.println("AUTOMARK::Look.testLookFeatures: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected to retrieve visible features in the room.");
    }

    /**
     * Tests the "look key" command to retrieve the description of a specific item.
     */
    @Test
    void testLookSpecificItem() {
        // Setup game state
        Room room = new Room("1", "Test Room", "A simple test room.", false);
        Item item = new Item("key", "key", "A rusty old key.", false);
        room.addItem(item);
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, new Player("Player"));

        // Execute look command
        Look lookCommand = new Look("key");
        String result = lookCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.contains("A rusty old key.");

        System.out.println("AUTOMARK::Look.testLookSpecificItem: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected to retrieve the description of the specific item.");
    }

    /**
     * Tests the "look hidden" command to ensure hidden objects are not visible.
     */
    @Test
    void testLookHiddenObject() {
        // Setup game state
        Room room = new Room("1", "Test Room", "A simple test room.", false);
        Item hiddenItem = new Item("hiddenKey", "Hidden Key", "A key that is hidden.", true);
        room.addItem(hiddenItem);
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, new Player("Player"));

        // Execute look command
        Look lookCommand = new Look("hiddenKey");
        String result = lookCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.isEmpty();

        System.out.println("AUTOMARK::Look.testLookHiddenObject: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected hidden objects to not be visible.");
    }
}
