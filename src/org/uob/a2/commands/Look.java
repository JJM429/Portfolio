package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the look command, allowing the player to examine various elements of the game world.
 * 
 * <p>
 * The look command can provide details about the current room, its exits, features, or specific items and equipment.
 * Hidden objects are not included in the output unless explicitly revealed.
 * </p>
 */
public class Look extends Command {

    private String target;

    public Look(String target) {
        super(CommandType.LOOK);
        this.target = target;
    }

    public String execute(GameState gameState) {
        if (target.toLowerCase().equals("room")) {
            String temp = "\nIn the room you see:";
            for (Item item : gameState.map.getCurrentRoom().getItems()) {
                if (!item.getHidden()) {
                    temp += "\n" + item.getName() + " - " + item.getDescription();
                }
            }
            for (Equipment equipment : gameState.map.getCurrentRoom().getEquipments()) {
                if (!equipment.getHidden()) {
                    temp += "\n" + equipment.getName() + " - " + equipment.getDescription();
                }
            }
            for (Feature feature : gameState.map.getCurrentRoom().getFeatures()) {
                if (!feature.getHidden()) {
                    temp += "\n" + feature.getName() + " - " + feature.getDescription();
                }
            }
            return gameState.map.getCurrentRoom().getDescription() + temp;
        }
        else if (target.toLowerCase().equals("exits") || target.toLowerCase().equals("exit")) {
            String temp = "";
            for (Exit exit : gameState.map.getCurrentRoom().getExits()) {
                temp += "\n - " + exit.getName() + ": " + exit.getDescription();
            }
            if (temp == "") {
                return "You must face your challenge before you can exit.";
            } else {
                return "The available exits are: " + temp;
            }
        }
        else if (target.toLowerCase().equals("features")) {
            String temp = "";
            for (Feature feature : gameState.map.getCurrentRoom().getFeatures()) {
                if (!feature.getHidden()) {
                    temp += "\n - " + feature.getId();/**could also do feature.getName().toLowerCase()*/
                }
            }
            if (temp != "") {
                return "You also see: " + temp;
            } else {
                return "This room doesn't seem to have any extra features.";
            }
        }
        else if (gameState.map.getCurrentRoom().getItems().contains(gameState.map.getCurrentRoom().getItemByName(target)) && !gameState.map.getCurrentRoom().getItemByName(target).getHidden()) {
            return gameState.map.getCurrentRoom().getItemByName(target).getDescription();
        }
        else if (gameState.map.getCurrentRoom().getEquipments().contains(gameState.map.getCurrentRoom().getEquipmentByName(target)) && !gameState.map.getCurrentRoom().getEquipmentByName(target).getHidden()) {
            return gameState.map.getCurrentRoom().getEquipmentByName(target).getDescription();
        } else if (gameState.map.getCurrentRoom().getFeatures().contains(gameState.map.getCurrentRoom().getFeatureByName(target)) && !gameState.map.getCurrentRoom().getFeatureByName(target).getHidden()) {
            return gameState.map.getCurrentRoom().getFeatureByName(target).getDescription();
        }
        else {
            System.out.println("Couldn't find: " + target);
            return "";
        }
    }

    public String toString() {
        return "Look message...";
    }
}
