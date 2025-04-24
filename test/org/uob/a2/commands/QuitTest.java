package org.uob.a2.commands;

import org.junit.jupiter.api.Test;
import org.uob.a2.gameobjects.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Quit} command.
 */
class QuitTest {

    /**
     * Tests the execution of the quit command, ensuring it returns the expected game-over message
     * along with the player's status.
     */
    @Test
    void testQuitCommand() {
        // Setup game state
        Player player = new Player("Player");
        player.addItem(new Item("key", "Rusty Key", "An old rusty key.", false));
        Map map = new Map();
        map.addRoom(new Room("1", "Test Room", "A simple test room.", false));
        GameState gameState = new GameState(map, player);

        // Execute quit command
        Quit quitCommand = new Quit();
        String result = quitCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.contains("Game over:") &&
                             result.contains("Rusty Key");//changed to capitals to prevent test from incorrectly failing

        System.out.println("AUTOMARK::Quit.testQuitCommand: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected game-over message and player inventory status.");
    }

    /**
     * Tests the quit command to ensure it handles an empty player inventory correctly.
     */
    @Test
    void testQuitWithEmptyInventory() {
        // Setup game state
        Player player = new Player("Player");
        Map map = new Map();
        map.addRoom(new Room("1", "Test Room", "A simple test room.", false));
        GameState gameState = new GameState(map, player);

        // Execute quit command
        Quit quitCommand = new Quit();
        String result = quitCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.contains("Game over:") &&
                             !result.contains("Rusty Key");

        System.out.println("AUTOMARK::Quit.testQuitWithEmptyInventory: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected game-over message with no inventory items.");
    }
}
