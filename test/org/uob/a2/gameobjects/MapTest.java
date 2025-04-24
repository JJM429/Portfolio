package org.uob.a2.gameobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Map} class.
 */
class MapTest {

    /**
     * Tests the addition of rooms to the map.
     */
    @Test
    void testAddRoom() {
        // Create map and rooms
        Map map = new Map();
        Room room1 = new Room("1", "Room 1", "First room.", false);
        Room room2 = new Room("2", "Room 2", "Second room.", false);

        // Add rooms to map
        map.addRoom(room1);
        map.addRoom(room2);

        // Validate rooms are added
        boolean testPassed =
            map.toString().contains("Room 1") &&
            map.toString().contains("Room 2");

        System.out.println("AUTOMARK::Map.testAddRoom: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected both rooms to be added to the map.");
    }

    /**
     * Tests setting the current room based on a valid room ID.
     */
    @Test
    void testSetCurrentRoomValidId() {
        // Create map and rooms
        Map map = new Map();
        Room room1 = new Room("1", "Room 1", "First room.", false);
        Room room2 = new Room("2", "Room 2", "Second room.", false);
        map.addRoom(room1);
        map.addRoom(room2);

        // Set current room
        map.setCurrentRoom("2");

        // Validate current room
        boolean testPassed = "Room 2".equals(map.getCurrentRoom().getName());

        System.out.println("AUTOMARK::Map.testSetCurrentRoomValidId: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected current room to be set to 'Room 2'.");
    }

    /**
     * Tests setting the current room with an invalid room ID.
     */
    @Test
    void testSetCurrentRoomInvalidId() {
        // Create map and rooms
        Map map = new Map();
        Room room1 = new Room("1", "Room 1", "First room.", false);
        map.addRoom(room1);

        // Attempt to set current room with invalid ID
        map.setCurrentRoom("invalid");

        // Validate current room is not set
        boolean testPassed = map.getCurrentRoom() == null;

        System.out.println("AUTOMARK::Map.testSetCurrentRoomInvalidId: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected current room to remain unset with invalid ID.");
    }

    /**
     * Tests the string representation of the map.
     */
    @Test
    void testToStringMethod() {
        // Create map and rooms
        Map map = new Map();
        Room room1 = new Room("1", "Room 1", "First room.", false);
        map.addRoom(room1);

        // Validate string representation
        String result = map.toString();
        boolean testPassed =
            result.contains("Map:") &&
            result.contains("Room 1");

        System.out.println("AUTOMARK::Map.testToStringMethod: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected map string representation to contain 'Map:' and 'Room 1'.");
    }
}
