package org.uob.a2.commands;

import org.junit.jupiter.api.Test;
import org.uob.a2.gameobjects.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Status} command.
 */
class StatusTest {

    /**
     * Tests the status command for displaying the player's inventory.
     */
    @Test
    void testInventoryStatus() {
        // Setup game state
        Player player = new Player("Player");
        player.addItem(new Item("key", "Rusty Key", "A rusty old key.", false));
        player.addEquipment(new Equipment("sword", "Sword", "A sharp blade.", false, null));
        GameState gameState = new GameState(new Map(), player);

        // Execute status command
        Status statusCommand = new Status("inventory");
        String result = statusCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.contains("Rusty Key") && result.contains("Sword");

        System.out.println("AUTOMARK::Status.testInventoryStatus: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected inventory to display both Rusty Key and Sword.");
    }

    /**
     * Tests the status command for displaying details of a specific item.
     */
    @Test
    void testSpecificItemStatus() {
        // Setup game state
        Player player = new Player("Player");
        player.addItem(new Item("k1", "key", "A rusty old key.", false));
        GameState gameState = new GameState(new Map(), player);

        // Execute status command
        Status statusCommand = new Status("key");
        String result = statusCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.contains("A rusty old key.");

        System.out.println("AUTOMARK::Status.testSpecificItemStatus: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected specific item description for key.");
    }

    /**
     * Tests the status command for displaying details of a specific equipment.
     */
    @Test
    void testSpecificEquipmentStatus() {
        // Setup game state
        Player player = new Player("Player");
        player.addEquipment(new Equipment("s1", "sword", "A sharp blade.", false, null));
        GameState gameState = new GameState(new Map(), player);

        // Execute status command
        Status statusCommand = new Status("sword");
        String result = statusCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.contains("A sharp blade.");

        System.out.println("AUTOMARK::Status.testSpecificEquipmentStatus: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected specific equipment description for sword.");
    }

    /**
     * Tests the status command for displaying player status.
     */
    @Test
    void testPlayerStatus() {
        // Setup game state
        Player player = new Player("Player");
        GameState gameState = new GameState(new Map(), player);

        // Execute status command
        Status statusCommand = new Status("player");
        String result = statusCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.contains("Player");

        System.out.println("AUTOMARK::Status.testPlayerStatus: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected player status to include Player.");
    }

    /**
     * Tests the status command with an invalid topic.
     */
    @Test
    void testInvalidTopic() {
        // Setup game state
        Player player = new Player("Player");
        GameState gameState = new GameState(new Map(), player);

        // Execute status command
        Status statusCommand = new Status("nonexistent");
        String result = statusCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.isEmpty();

        System.out.println("AUTOMARK::Status.testInvalidTopic: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected no result for an invalid topic.");
    }
}
