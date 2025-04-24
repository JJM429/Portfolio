package org.uob.a2.commands;

import org.uob.a2.gameobjects.GameState;
import org.uob.a2.gameobjects.Item;

public class Combine extends Command {

    private String equipment1, equipment2;

    public Combine(String equipment1, String equipment2) {
        super(CommandType.USE);
        this.equipment1 = equipment1;
        this.equipment2 = equipment2;
    }

    public String execute(GameState gameState) {
        try {
            if ((gameState.player.hasEquipment(equipment1)) && (gameState.player.hasEquipment(equipment2)) && !(gameState.player.getEquipment(equipment1).getUseInformation().isUsed()) && !(gameState.player.getEquipment(equipment2).getUseInformation().isUsed())) {
                gameState.player.getEquipment(equipment1).getUseInformation().setUsed(true);
                gameState.player.getEquipment(equipment2).getUseInformation().setUsed(true);
                String temp = gameState.player.getEquipment(equipment1).getUseInformation().getResult();
                gameState.player.addItem(gameState.map.getCurrentRoom().getItem(temp));
                gameState.player.getEquipment().remove(gameState.player.getEquipment(equipment1));
                gameState.player.getEquipment().remove(gameState.player.getEquipment(equipment2));

                return "You combine the " + equipment1 + " and the " + equipment2 + " to form " + temp;
            }
            return "Failed to combine";
        } catch (Exception e) {
            return "Failed to combine";
        }
    }
}
