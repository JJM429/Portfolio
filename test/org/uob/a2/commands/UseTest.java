package org.uob.a2.commands;

import org.junit.jupiter.api.Test;
import org.uob.a2.gameobjects.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests the functionality of the {@code Use} command.
 */
class UseTest {

    /**
     * Tests using equipment on a valid target.
     */
    @Test
    void testUseOnValidTarget() {
        // Setup game state
        Player player = new Player("Player");
        Equipment equipment = new Equipment(
                "key", "key", "A rusty key.", false,
                new UseInformation(false, "open", "c1", "chest2", "You unlock the chest.")
        );
        Container target = new Container("c1", "Old Chest", "An old wooden chest.", false);
        Room room = new Room("1", "Room", "A room with a chest.", false);
        room.addFeature(target);
        player.addEquipment(equipment);
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, player);

        // Execute use command
        Use useCommand = new Use("key", "Old Chest");
        String result = useCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.contains("You unlock the chest.") &&
                             equipment.getUseInformation().isUsed();

        System.out.println("AUTOMARK::Use.testUseOnValidTarget: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected successful use of equipment on a valid target.");
    }

    /**
     * Tests using equipment on an invalid target.
     */
    @Test
    void testUseOnInvalidTarget() {
        // Setup game state
        Player player = new Player("Player");
        Equipment equipment = new Equipment(
                "key", "key", "A rusty key.", false,
                new UseInformation(false, "open", "chest1", "chest2", "You unlock the chest.")
        );
        player.addEquipment(equipment);
        Room room = new Room("1", "Room", "A room with no chest.", false);
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, player);

        // Execute use command
        Use useCommand = new Use("key", "nonexistent");
        String result = useCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.contains("Invalid use target");

        System.out.println("AUTOMARK::Use.testUseOnInvalidTarget: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected message indicating invalid target.");
    }

    /**
     * Tests using equipment that has already been used.
     */
    @Test
    void testUseAlreadyUsedEquipment() {
        // Setup game state
        Player player = new Player("Player");
        Equipment equipment = new Equipment(
                "key", "key", "A rusty key.", false,
                new UseInformation(true, "open", "chest1", "chest2", "You unlock the chest.")
        );
        player.addEquipment(equipment);
        Room room = new Room("1", "Room", "A room with a chest.", false);
        room.addFeature(new Container("chest1", "Old Container", "An old wooden chest.", false));
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, player);

        // Execute use command
        Use useCommand = new Use("key", "Old Container");
        String result = useCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.contains("You have already used key");

        System.out.println("AUTOMARK::Use.testUseAlreadyUsedEquipment: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected message indicating equipment was already used.");
    }

    /**
     * Tests using equipment that the player does not possess.
     */
    @Test
    void testUseEquipmentNotOwned() {
        // Setup game state
        Player player = new Player("Player");
        Room room = new Room("1", "Room", "A room with a chest.", false);
        room.addFeature(new Container("chest1", "Old Container", "An old wooden chest.", false));
        Map map = new Map();
        map.addRoom(room);
        map.setCurrentRoom("1");
        GameState gameState = new GameState(map, player);

        // Execute use command
        Use useCommand = new Use("key", "chest1");
        String result = useCommand.execute(gameState);

        // Validate results
        boolean testPassed = result.contains("You do not have key");

        System.out.println("AUTOMARK::Use.testUseEquipmentNotOwned: " + (testPassed ? "PASS" : "FAIL"));

        assertTrue(testPassed, "Expected message indicating the player does not possess the equipment.");
    }
}
