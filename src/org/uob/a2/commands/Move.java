package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents the move command, allowing the player to navigate to a different room in the game world.
 * 
 * <p>
 * The move command checks if the specified direction corresponds to an available exit in the current room.
 * If a matching exit is found, the player's location is updated to the connected room.
 * </p>
 */
public class Move extends Command {

    private String direction;

    public Move(String direction) {
        super(CommandType.MOVE);
        this.direction = direction;
    }

    public String execute(GameState gameState) {
        for (Exit exit : gameState.map.getCurrentRoom().getExits()) {
            if (direction.equals(exit.getName()) && !exit.getHidden()) {
                gameState.map.setCurrentRoom(exit.getNextRoom());
                return "Moving towards " + direction +"\n";
            }
        }
        return "No exit found in that direction.";
    }

    public String toString() {
        return "You move " + direction;
    }
}
