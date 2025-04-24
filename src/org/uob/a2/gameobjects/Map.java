package org.uob.a2.gameobjects;

import java.util.ArrayList;

/**
 * Represents the game map, which consists of a collection of rooms and the current room the player is in.
 * 
 * <p>
 * The map allows for navigation between rooms, adding new rooms, and managing the current room context.
 * </p>
 */
public class Map {

    ArrayList<Room> rooms = new ArrayList<Room>();
    Room currentRoom;
    String id;

    public Map() {

    }

    public Map(String id) {
        this.id = id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void addRoom(Room room) {
        rooms.add(room);
        setCurrentRoom(room.getId());
    }

    public Room getRoom(String id) {
        for (Room room : rooms) {
            if (room.getId().equals(id)) {
                return room;
            }
        }
        return null;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(String roomid) {
        for (Room room : rooms) {
            if (room.getId().equals(roomid)) {
                currentRoom = room;
                return;
            }
        }
        currentRoom = null;
    }
  
    /**
     * Returns a string representation of the map, including all rooms.
     *
     * @return a string describing the map and its rooms
     */
    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("Map:\n");
        for (Room r : this.rooms) {
            out.append(r.toString()).append("\n");
        }
        return out.toString();
    }
}

