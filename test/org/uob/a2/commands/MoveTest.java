package org.uob.a2.commands;

import org.junit.jupiter.api.Test;
import org.uob.a2.gameobjects.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Move} command.
 */
class MoveTest {

    /**
     * Tests moving to a valid exit in the specified direction.
     */
    @Test
    void testMoveValidDirection() {
        // Setup game state
        Room currentRoom = new Room("1", "Start Room", "This is the starting room.", false);
        Room nextRoom = new Room("2", "Next Room", "This is the next room.", false);
        Exit exit = new Exit("north", "north", "Leads to the next room.", "2", false);
        currentRoom.addExit(exit);
        Map map = new Map();
        map.addRoom(currentRoom);
        map.addRoom(nextRoom);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, new Player("Player"));

        // Execute move command
        Move moveCommand = new Move("north");
        String result = moveCommand.execute(gameState);

        // Validate results
        boolean testPassed = "Moving towards north\n".equals(result) &&
                             "2".equals(map.getCurrentRoom().getId());

        System.out.println("AUTOMARK::Move.testMoveValidDirection: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected successful move to a valid direction.");
    }

    /**
     * Tests attempting to move in an invalid direction.
     */
    @Test
    void testMoveInvalidDirection() {
        // Setup game state
        Room currentRoom = new Room("1", "Start Room", "This is the starting room.", false);
        Map map = new Map();
        map.addRoom(currentRoom);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, new Player("Player"));

        // Execute move command
        Move moveCommand = new Move("south");
        String result = moveCommand.execute(gameState);

        // Validate results
        boolean testPassed = "No exit found in that direction.".equals(result);

        System.out.println("AUTOMARK::Move.testMoveInvalidDirection: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected message indicating no exit found in the specified direction.");
    }

    /**
     * Tests attempting to move towards a hidden exit.
     */
    @Test
    void testMoveHiddenExit() {
        // Setup game state
        Room currentRoom = new Room("1", "Start Room", "This is the starting room.", false);
        Exit hiddenExit = new Exit("north", "Hidden Exit", "Leads to a secret room.", "2", true);
        currentRoom.addExit(hiddenExit);
        Map map = new Map();
        map.addRoom(currentRoom);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, new Player("Player"));

        // Execute move command
        Move moveCommand = new Move("north");
        String result = moveCommand.execute(gameState);

        // Validate results
        boolean testPassed = "No exit found in that direction.".equals(result);

        System.out.println("AUTOMARK::Move.testMoveHiddenExit: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected message indicating no exit found for a hidden exit.");
    }
}
