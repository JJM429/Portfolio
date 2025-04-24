package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the quit command, allowing the player to exit the game.
 * 
 * <p>
 * The quit command signals the end of the game session and provides a summary of the player's
 * current status before termination.
 * </p>
 */
public class Quit extends Command {

    public Quit() {
        super(CommandType.QUIT);
    }

    public String execute(GameState gameState) {
        String temp = "";
        for (Item item : gameState.player.getInventory()) {
            temp += (item.getName() + ", ");
        }
        try {
            return "Game over: " + temp.substring(0, temp.length() - 2);
        }
        catch (Exception e) {
            return "Game over: ";
        }
    }
}
