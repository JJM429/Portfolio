package org.uob.a2.commands;

import org.uob.a2.gameobjects.GameState;

public class NoAction extends Command {

    public NoAction() {}

    @Override
    public String execute(GameState gameState) {
        return "Please enter a valid action.";
    }
}
