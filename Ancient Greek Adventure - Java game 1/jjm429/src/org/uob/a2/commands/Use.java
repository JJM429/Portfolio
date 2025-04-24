package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the use command, allowing the player to use equipment on a specific target in the game.
 * 
 * <p>
 * The use command checks if the player has the specified equipment and whether it can interact with
 * the target. The target can be a feature, item, or the current room, depending on the game context.
 * </p>
 */
public class Use extends Command {

    private String equipmentName;
    private String target;

    public Use(String equipmentName, String target) {
        super(CommandType.USE);
        this.equipmentName = equipmentName;
        this.target = target;
    }

    public String execute(GameState gameState) {
        try {
            if (gameState.player.getEquipment(equipmentName).getUseInformation().isUsed()) {
                return "You have already used " + equipmentName;
            }
        } catch (Exception e) {
        }
        if ((gameState.player.hasEquipment(equipmentName)) && (gameState.map.getCurrentRoom().getFeatureByName(target) != null) && !(gameState.player.getEquipment(equipmentName).getUseInformation().isUsed())) {
            gameState.player.getEquipment(equipmentName).getUseInformation().setUsed(true);
            gameState.map.getCurrentRoom().getFeatureByName(target).setHidden(true);
            for (Equipment equipment : gameState.map.getCurrentRoom().getEquipments()) {
                equipment.setHidden(false);
            }
            for (Item item : gameState.map.getCurrentRoom().getItems()) {
                item.setHidden(false);
            }
            for (Exit exit : gameState.map.getCurrentRoom().getExits()) {
                exit.setHidden(false);
            }
            return gameState.player.getEquipment(equipmentName).getUseInformation().getMessage() + ". There are new objects available in the room.";
        } else if ((gameState.player.hasEquipment(equipmentName)) && gameState.map.getCurrentRoom().hasEquipment(target)) {
            return gameState.map.getCurrentRoom().getEquipment(target).getUseInformation().getMessage();//check if this causes errors elsewhere
        } else if (!gameState.player.hasEquipment(equipmentName) && !gameState.player.hasItem(equipmentName) && !equipmentName.equals("hands") && !equipmentName.equals("trickery")) {
            return "You do not have " + equipmentName;
        } else if (gameState.map.getCurrentRoom().getFoe(target) == null) {
            return "Invalid use target.";
        } else if (gameState.map.getCurrentRoom().getFoe(target).getSlain()) {
            return "You cannot attack " + target;
        } else if (gameState.player.hasEquipment(equipmentName) || gameState.player.hasItem(equipmentName) || equipmentName.equals("hands") || equipmentName.equals("trickery")) {
            if (gameState.map.getCurrentRoom().getFoe(target).getWeakness().equals(equipmentName)) {
                gameState.map.getCurrentRoom().getFoe(target).setSlain(true);
                try {
                    gameState.map.getCurrentRoom().getItem(gameState.map.getCurrentRoom().getFoe(target).getDrops()).setHidden(false);
                } catch (Exception e) {}
                try {
                    gameState.map.getCurrentRoom().getEquipment(gameState.map.getCurrentRoom().getFoe(target).getDrops()).setHidden(false);
                } catch (Exception e) {}
                for (Exit exit : gameState.map.getCurrentRoom().getExits()) {
                    exit.setHidden(false);
                }
                return "\n" + gameState.map.getCurrentRoom().getFoe(target).getDefeatInfo();
            } else {
                return "\n" + gameState.map.getCurrentRoom().getFoe(target).getFail();
            }
        }
        return "Invalid use target.";
    }

    public String toString() {
        return "You use " + equipmentName + " on " + target;
    }
}
