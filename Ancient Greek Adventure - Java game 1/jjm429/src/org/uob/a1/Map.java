package org.uob.a1;

public class Map {
    public int width;
    public int height;
    private Position pos;
    private char symbol;
    private char[][] mapArray;
    private String map;
    final private char EMPTY = '.';

    //constructor for Map objects
    public Map(int width, int height)
    {
        this.width = width;
        this.height = height;
        //create map array to facilitate display method 
        this.mapArray = new char[width][height];
    }

    //method to add a new room
    public void placeRoom(Position pos, char symbol)
    {
        mapArray[pos.x][pos.y] = symbol;

    }


    //method to add new location of player on map.
    public void playerNewLocation(Position pos)
    {
        if (mapArray[pos.x][pos.y] == '\u0000') {
            mapArray[pos.x][pos.y] = '1';
        }
    }

    //method to remove the player's old location
    public void playerRemoveOldLocation(Position pos)
    {
        if (mapArray[pos.x][pos.y] == '1') {
            mapArray[pos.x][pos.y] = '\u0000';
        }
    }

    //method to display the current map
    public String display()
    {
        this.map = "";
        for (int j=0; j<height; j++)
        {
            for (int i=0; i<width; i++)
            {
                if (this.mapArray[i][j] == '\u0000') 
                {
                    this.map += EMPTY;
                } else {
                    this.map += this.mapArray[i][j];
                }
            }
            this.map += "\n";
        }
        return this.map;
    }
    
}