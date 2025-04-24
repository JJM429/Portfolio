package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the status command, allowing the player to retrieve information
 * about their inventory, specific items, or their overall status.
 * 
 * <p>
 * The status command can display a list of items in the player's inventory, 
 * provide details about a specific item, or show the player's general status.
 * </p>
 */
public class Status extends Command {

    private String topic
            ;
    public Status(String topic) {
        this.topic = topic;
    }

    public String execute(GameState gameState) {
        String temp = "Items: \n";
        if (topic.toLowerCase().equals("inventory")) {
            for (Item item : gameState.player.getInventory()) {
                temp += item.getName() + "\n";
            }
            temp += "Equipment: \n";
            for (Equipment equipment : gameState.player.getEquipment()) {
                temp += equipment.getName() + "\n";
            }
            return temp;
        }
        else if (gameState.player.hasItem(topic)) {
            return gameState.player.getItem(topic).getDescription();
        }
        else if (gameState.player.hasEquipment(topic)) {
            return gameState.player.getEquipment(topic).getDescription();
        }
        else if (topic.toLowerCase().equals("player")) {
            return "Current player: " + gameState.player.name;
        } else if (topic.toLowerCase().equals("map")) {
            System.out.println("""
                    ---------------------------
                     |    GREECE             8 \\    9--->
                     \\                      ___/
                      |              _______/  
                      \\          __/
              <---10    \\        \\
                        |_____    \\__
            <---11            \\_____ \\  .
                       _~~__         \\-       ..
                      /    3\\__             .
                      |5  4    6\\               .  .
                       \\  0  1  | PELOPONNESE
                        |        2\\
                        \\_-   -~--~         '   
                            \\/                     ;  __
                                      ------_____---__/  \\
                                      |____   7  _____----|
                                        '----' CRETE       
                            --------              
                  UNDERWORLD   12
                    """);
            return "";
        } else if (topic.toLowerCase().equals("score")) {
            int score = 0;
            for (Item item : gameState.player.getInventory()) {
                if (item.getName().equals("hide") || item.getName().equals("envenomed-arrows") || item.getName().equals("captured-hind") || item.getName().equals("captured-boar") || item.getName().equals("drachma") || item.getName().equals("razor-feather") || item.getName().equals("captured-bull") || item.getName().equals("tethered-mares") || item.getName().equals("belt") || item.getName().equals("cattle-prod") || item.getName().equals("apples") || item.getName().equals("sleeping-hound")) {
                    score += 10;
                } //else if (
            }
            return "Current Score: " + String.valueOf(score);
        }
        /*else if (topic.toLowerCase().equals("exit")) {
            temp = "";
            for (Exit exit : gameState.map.getCurrentRoom().getExits()) {
                if (!exit.getHidden()) {
                    temp += exit.getName() + ": " + exit.getDescription() + "\n";
                }
            }
            if (temp != "") {
                return "The available exits are: " + temp;
            } else {
                return "You must face your challenge before you can exit.";
            }
        }*/
        else {
            System.out.println("You cannot check the status of "+ topic);
            return "";
        }
    }

    public String toString() {
        return "Status message";
    }
}
