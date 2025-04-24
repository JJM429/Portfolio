package org.uob.a2.gameobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code GameState} class.
 */
class GameStateTest {

    /**
     * Tests the construction of a {@code GameState} object and its attributes.
     */
    @Test
    void testGameStateConstruction() {
        // Setup a map and player
        Map map = new Map();
        Player player = new Player("Player");

        // Create GameState
        GameState gameState = new GameState(map, player);

        // Validate attributes
        boolean testPassed =
            map.equals(gameState.getMap()) &&
            player.equals(gameState.getPlayer());

        System.out.println("AUTOMARK::GameState.testGameStateConstruction: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected map and player attributes of GameState to match.");
    }

    /**
     * Tests the default constructor of the {@code GameState} class.
     */
    @Test
    void testDefaultConstructor() {
        // Create default GameState
        GameState gameState = new GameState();

        // Validate attributes
        boolean testPassed =
            gameState.getMap() == null &&
            gameState.getPlayer() == null;

        System.out.println("AUTOMARK::GameState.testDefaultConstructor: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected default GameState attributes to be null.");
    }

    /**
     * Tests the string representation of the {@code GameState} class.
     */
    @Test
    void testToStringMethod() {
        // Setup a map and player
        Map map = new Map();
        map.addRoom(new Room("1", "Room", "A test room.", false));
        Player player = new Player("Player");

        // Create GameState
        GameState gameState = new GameState(map, player);

        // Validate toString output
        String result = gameState.toString();
        boolean testPassed =
            result.contains("map=") &&
            result.contains("player=");

        System.out.println("AUTOMARK::GameState.testToStringMethod: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected toString output to contain map and player details.");
    }
}
