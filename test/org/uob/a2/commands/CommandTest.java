package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the abstract {@code Command} class using a mock implementation.
 */
class CommandTest {

    /**
     * Tests the basic functionality of a concrete subclass of {@code Command}.
     */
    @Test
    void testCommandAttributes() {
        // Create a concrete implementation of Command
        Command mockCommand = new MockCommand(CommandType.GET, "key");

        // Validate attributes
        boolean result = (mockCommand.commandType == CommandType.GET) && ("key".equals(mockCommand.value));
        System.out.println("AUTOMARK::Command.testCommandAttributes: " + (result ? "PASS" : "FAIL"));

        assertTrue(result, "Expected attributes to match the values.");
    }

    /**
     * Tests the execution of the mock command.
     */
    @Test
    void testCommandExecution() {
        // Create a concrete implementation of Command
        Command mockCommand = new MockCommand(CommandType.MOVE, "north");

        // Execute the command and validate the result
        boolean result = "MockCommand executed with value: north".equals(mockCommand.execute(new GameState(new Map(), new Player("Player"))));
        System.out.println("AUTOMARK::Command.testCommandExecution: " + (result ? "PASS" : "FAIL"));

        assertTrue(result, "Expected mock command execution result to match.");
    }

    /**
     * A mock implementation of the {@code Command} class for testing purposes.
     */
    static class MockCommand extends Command {

        /**
         * Constructs a new {@code MockCommand} with the specified type and value.
         *
         * @param commandType the type of the command
         * @param value the associated value of the command
         */
        public MockCommand(CommandType commandType, String value) {
            this.commandType = commandType;
            this.value = value;
        }

        /**
         * Mock implementation of the {@code execute} method.
         *
         * @param gameState the current state of the game
         * @return a mock execution result
         */
        @Override
        public String execute(GameState gameState) {
            return "MockCommand executed with value: " + value;
        }
    }
}
