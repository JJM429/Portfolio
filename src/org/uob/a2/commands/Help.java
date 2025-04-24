package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the help command, providing the player with instructions or information
 * about various topics related to the game.
 * 
 * <p>
 * The help command displays information on how to play the game, including details about 
 * available commands, their syntax, and their purpose.
 * </p>
 */
public class Help extends Command {

    private String topic;

    public Help(String topic) {
        super(CommandType.HELP);
        this.topic = topic;
    }

    public String execute(GameState gameState) {
        if (topic == null || topic.strip().equals("") || topic.equals("null") || topic.equals("help")) {
            return "Welcome to the game! Here is a list of some commands that you can use GET - MOVE - HELP - DROP - USE - COMBINE - LOOK - STATUS - QUIT\nTry 'help <command/topic>' if you would like more specific help.";
        } else if (topic.equals("move")) {
            return "MOVE Command: Use the 'move' command with 'move <direction>' to move in the direction of a valid exit.\ne.g. 'move east'";
        } else if (topic.equals("drop")) {
            return "DROP command: Use the 'drop <item/equipment name>' command to remove an item or piece of equipment from your inventory.";
        } else if (topic.equals("use")) {
            return "USE command: Use the 'use <item/equipment> on <feature/foe>' command to use game objects in your inventory.";
        } else if (topic.equals("quit")) {
            return "QUIT command: Use the 'quit' command to quit the game.";
        } else if (topic.equals("look")) {
            return "LOOK command: Use the 'look <room/exit/features>|<item name>|<equipment name>|<feature name>' command to get more information.";
        } else if (topic.equals("status")) {
            return "STATUS command: Use the 'status <inventory/player/item name/equipment name/map/score>:' command to show status of specific objects.";
        } else if (topic.equals("combine")) {
            return "COMBINE command: Use the 'combine <item1/equipment1> and <item2/equipment2>' command to combine two objects into a new object.";
        } else if (topic.equals("get")) {
            return "GET command: Use the 'get <item name/equipment name>' command to add objects to your inventory.";
        }
        else {
            return "No help available for the topic: " + topic;
        }
    }

    public String toString() {
        return "HELP on " + topic;
    }
}
