package org.uob.a2.commands;

/**
 * Represents the various types of commands that can be executed in the game.
 * 
 * <p>
 * Each command type corresponds to a specific player action or game functionality.
 * </p>
 */
public enum CommandType {
    /**
     * Represents a command to move the player to a different location.
     */
    MOVE,

    /**
     * Represents a command to use an item or interact with a game object.
     */
    USE,

    /**
     * Represents a command to pick up an item.
     */
    GET,

    /**
     * Represents a command to drop an item from the player's inventory.
     */
    DROP,

    /**
     * Represents a command to look around the current location or inspect an object.
     */
    LOOK,

    /**
     * Represents a command to check the player's current status.
     */
    STATUS,

    /**
     * Represents a command to display help information.
     */
    HELP,

    /**
     * Represents a command to quit the game.
     */
    QUIT,

}
