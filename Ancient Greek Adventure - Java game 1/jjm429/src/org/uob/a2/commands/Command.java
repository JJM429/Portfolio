package org.uob.a2.commands;

import org.uob.a2.gameobjects.*;

/**
 * Represents an abstract command that can be executed within the game.
 * 
 * <p>
 * Subclasses should define specific types of commands and their behavior by 
 * implementing the {@link #execute(GameState)} method.
 * </p>
 */
public abstract class Command {

    public CommandType commandType;
    public String value;

    public Command() {}

    public Command(CommandType commandType, String value) {
        this.commandType = commandType;
        this.value = value;
    }

    public Command(CommandType commandType) {
        this.commandType = commandType;
    }/** not sure if this is needed for now*/

    public abstract String execute(GameState gameState);



}
