package org.uob.a2.gameobjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Equipment} class.
 */
class EquipmentTest {

    /**
     * Tests the creation of an {@code Equipment} object and its attributes.
     */
    @Test
    void testEquipmentAttributes() {
        // Create equipment
        UseInformation useInfo = new UseInformation(false, "open", "chest1", "item1", "You opened the chest!");
        Equipment equipment = new Equipment("sword", "Sword", "A sharp blade.", false, useInfo);

        // Validate attributes
        boolean testPassed =
            "sword".equals(equipment.getId()) &&
            "Sword".equals(equipment.getName()) &&
            "A sharp blade.".equals(equipment.getDescription()) &&
            !equipment.getHidden() &&
            useInfo.equals(equipment.getUseInformation());

        System.out.println("AUTOMARK::Equipment.testEquipmentAttributes: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected all equipment attributes to match.");
    }

    /**
     * Tests the usage of equipment on a valid target.
     */
    @Test
    void testUseOnValidTarget() {
        // Setup game state
        UseInformation useInfo = new UseInformation(false, "open", "chest1", "item1", "You opened the chest!");
        Equipment equipment = new Equipment("key", "Key", "A rusty key.", false, useInfo);
        Container target = new Container("chest1", "Treasure Chest", "A locked chest.", false);
        Item hiddenItem = new Item("item1", "Gold Coin", "A shiny gold coin.", true);

        Room room = new Room("1", "Room", "A room with a chest.", false);
        room.addFeature(target);
        room.addItem(hiddenItem);

        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");

        GameState gameState = new GameState(map, new Player("Player"));

        // Use equipment
        String result = equipment.use(target, gameState);

        // Validate results
        boolean testPassed = 
            !hiddenItem.getHidden() && 
            result.contains("You opened the chest!");

        System.out.println("AUTOMARK::Equipment.testUseOnValidTarget: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected hidden item to be revealed and success message returned.");
    }

}
