package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the drop command, allowing the player to drop an item from their inventory into the current room.
 * 
 * <p>
 * This command checks if the player possesses the specified item and, if so, removes it from their inventory
 * and adds it to the current room. If the player does not have the item, an error message is returned.
 * </p>
 */
public class Drop extends Command {

    private String item;

    public Drop(String item) {
        this.item = item;
    }

    public String execute(GameState gameState) {
        if (!gameState.player.hasItem(item) && !gameState.player.hasEquipment(item)) {
            return "You cannot drop " + item;
        }
        else if (gameState.player.hasItem(item)) {
            gameState.map.getCurrentRoom().addItem(gameState.player.getItem(item));
            gameState.player.getInventory().remove(gameState.player.getItem(item));
            return "You drop: " + item;
        }
        else {
            gameState.map.getCurrentRoom().addEquipment(gameState.player.getEquipment(item));
            gameState.player.getEquipment().remove(gameState.player.getEquipment(item));
            return "You drop: " + item;
        }
    }

    public String toString() {
        return "You have dropped: " + item;
    }

   
}
