package org.uob.a1;

public class Player {
    private Position position;
    private Score score;
    private Map map;
    
    public Player(Position position, Map map)
    {
        this.position = position;
        this.map = map;
    }

    public void movePlayer(int x, int y) //method to facilitate the "move " commands
    {
        if ((position.x + x) < map.width && (position.x + x) >= 0 && (position.y + y) < map.height && (position.y + y) >= 0) {
            position.x += x;
            position.y += y;
        }
        else {
            System.out.println("You have reached the edge of the map, adventurer.");
        }
            
    }
        
}