package org.uob.a2.gameobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Room} class.
 */
class RoomTest {

    /**
     * Tests the creation of a {@code Room} object and its attributes.
     */
    @Test
    void testRoomAttributes() {
        // Create a room
        Room room = new Room("room1", "Living Room", "A cozy living room.", false);

        // Validate attributes
        boolean testPassed =
            "room1".equals(room.getId()) &&
            "Living Room".equals(room.getName()) &&
            "A cozy living room.".equals(room.getDescription()) &&
            !room.getHidden();

        System.out.println("AUTOMARK::Room.testRoomAttributes: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected all room attributes to match.");
    }

    /**
     * Tests adding and retrieving items in the room.
     */
    @Test
    void testAddAndRetrieveItems() {
        // Create a room and items
        Room room = new Room("room1", "Living Room", "A cozy living room.", false);
        Item item1 = new Item("item1", "Key", "A rusty key.", false);
        Item item2 = new Item("item2", "Book", "A dusty old book.", false);

        // Add items to room
        room.addItem(item1);
        room.addItem(item2);

        // Validate items
        boolean testPassed =
            room.getItems().contains(item1) &&
            room.getItems().contains(item2) &&
            "Key".equals(room.getItemByName("Key").getName());

        System.out.println("AUTOMARK::Room.testAddAndRetrieveItems: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected items to be added and retrievable from the room.");
    }

    /**
     * Tests adding and retrieving features in the room.
     */
    @Test
    void testAddAndRetrieveFeatures() {
        // Create a room and features
        Room room = new Room("room1", "Living Room", "A cozy living room.", false);
        Feature feature = new Feature("feature1", "Painting", "A beautiful painting.", false);

        // Add feature to room
        room.addFeature(feature);

        // Validate features
        boolean testPassed = room.getFeatures().contains(feature);

        System.out.println("AUTOMARK::Room.testAddAndRetrieveFeatures: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected feature to be added and retrievable from the room.");
    }

    /**
     * Tests adding and retrieving exits in the room.
     */
    @Test
    void testAddAndRetrieveExits() {
        // Create a room and exits
        Room room = new Room("room1", "Living Room", "A cozy living room.", false);
        Exit exit = new Exit("exit1", "North Exit", "Leads to the north.", "room2", false);

        // Add exit to room
        room.addExit(exit);

        // Validate exits
        boolean testPassed =
            room.getExits().contains(exit) &&
            "North Exit".equals(room.getExit("exit1").getName());

        System.out.println("AUTOMARK::Room.testAddAndRetrieveExits: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected exit to be added and retrievable from the room.");
    }

    /**
     * Tests the string representation of the {@code Room} class.
     */
    @Test
    void testToStringMethod() {
        // Create a room with contents
        Room room = new Room("room1", "Living Room", "A cozy living room.", false);
        room.addItem(new Item("item1", "Key", "A rusty key.", false));
        room.addEquipment(new Equipment("equip1", "Sword", "A sharp blade.", false, null));
        room.addFeature(new Feature("feature1", "Painting", "A beautiful painting.", false));
        room.addExit(new Exit("exit1", "North Exit", "Leads to the north.", "room2", false));

        // Validate toString output
        String result = room.toString();
        boolean testPassed =
            result.contains("Living Room") &&
            result.contains("A rusty key.") &&
            result.contains("A sharp blade.") &&
            result.contains("A beautiful painting.");

        System.out.println("AUTOMARK::Room.testToStringMethod: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected room string representation to include all details.");
    }
}
