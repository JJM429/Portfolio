package org.uob.a2.gameobjects;

/**
 * Represents the current state of the game, including the map and the player.
 * 
 * <p>
 * The game state contains all necessary information about the game's progress, such as
 * the player's status and the state of the game map.
 * </p>
 */
public class GameState {

    public Map map;
    public Player player;

    public GameState(Map map, Player player) {
        this.map = map;
        this.player = player;
    }

    public GameState() {

    }

    public Map getMap() {
        return this.map;
    }

    public Player getPlayer() {
        return this.player;
    }
   
    /**
     * Returns a string representation of the game state, including the map and player details.
     *
     * @return a string describing the game state
     */
    @Override
    public String toString() {
        return "GameState {" +
               "map=" + (map != null ? map.toString() : "null") + ", " +
               "player=" + (player != null ? player.toString() : "null") +
               '}';
    }
}
