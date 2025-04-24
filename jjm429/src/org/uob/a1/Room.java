package org.uob.a1;

public class Room {
    private String name;
    private String description;
    private char symbol;
    private Position position;

    //constructor for rooms
    public Room(String name, String description, char symbol, Position position)
    {
        this.name = name;
        this.description = description;
        this.symbol = symbol;
        this.position = position;
    }

    //getter methods
    public String getName()
    {
        return this.name;
    }

    public String getDescription()
    {
        return this.description;
    }

    public char getSymbol()
    {
        return this.symbol;
    }

    public Position getPosition()
    {
        return this.position;
    }
    
    
}