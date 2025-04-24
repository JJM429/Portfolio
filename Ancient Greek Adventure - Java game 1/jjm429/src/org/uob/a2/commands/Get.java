package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the get command, allowing the player to pick up an item from the current room and add it to their inventory.
 * 
 * <p>
 * This command checks if the specified item is present in the current room. If the item exists and the player
 * does not already have it, the item is added to the player's inventory and removed from the room. Otherwise,
 * an appropriate message is returned.
 * </p>
 */
public class Get extends Command {

    private String item;

    public Get(String item) {
        super(CommandType.GET);
        this.item = item;
   }

   public String execute(GameState gameState) {
        if (gameState.player.hasItem(item) || gameState.player.hasEquipment(item)) {
            return "You already have " + item;//unfinished for equipment
        }
        else if ((gameState.map.getCurrentRoom().getItemByName(item) == null) && (gameState.map.getCurrentRoom().getEquipmentByName(item) == null)) {
            return "No " + item + " to get.";
        }
        else {
            try {
                if (gameState.map.getCurrentRoom().getItemByName(item).getHidden()) {
                    return "No " + item + " to get.";
                }
            } catch (Exception e) {}
            try {
                if (gameState.map.getCurrentRoom().getEquipmentByName(item).getHidden()) {
                    return "No " + item + " to get.";
                }
            } catch (Exception e) {}
            try {
                if (gameState.map.getCurrentRoom().getItemByName(item).getName().equals(item)) {
                    gameState.player.addItem(gameState.map.getCurrentRoom().getItemByName(item));
                    gameState.map.getCurrentRoom().items.remove(gameState.map.getCurrentRoom().getItemByName(item));
                    return "You pick up: " + item;
                }
            } catch (Exception e) {}
            try {
                if (gameState.map.getCurrentRoom().getEquipmentByName(item).getName().equals(item)){
                    gameState.player.addEquipment(gameState.map.getCurrentRoom().getEquipmentByName(item));
                    gameState.map.getCurrentRoom().getEquipments().remove(gameState.map.getCurrentRoom().getEquipmentByName(item));
                    return "You pick up: " + item;
                }
            } catch (Exception f) {}
        }
       System.out.println("You do not have any equipment to get.");
       return "Error";
   }

   public String toString() {
        return item;
   }
}
