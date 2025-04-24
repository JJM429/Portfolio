package org.uob.a2.utils;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.uob.a2.gameobjects.*;
import java.io.*;

/**
 * Tests the functionality of the {@code GameStateFileParser} class.
 */
class GameStateFileParserTest {

    /**
     * Tests parsing a valid game state file.
     */
    @Test
    void testParseValidFile() {
        // Setup: Create a temporary game state file
        String fileContent = """
                player:Hero
                map:room1
                room:room1,Living Room,A cozy living room.,false
                item:item1,Key,A rusty key.,false
                equipment:equip1,Sword,A sharp blade.,false,open,room1,hiddenTreasure,You opened the treasure!
                container:chest1,Old Chest,A dusty old chest.,true
                exit:exit1,North Exit,Leads to the northern room.,room2,false
                """;

        File tempFile = null;
        boolean testPassed = false;

        try {
            tempFile = File.createTempFile("testGameState", ".txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                writer.write(fileContent);
            }

            // Parse the file
            GameState gameState = GameStateFileParser.parse(tempFile.getAbsolutePath());

            // Validate parsed game state
            testPassed = "Hero".equals(gameState.getPlayer().getName()) &&
                         "Living Room".equals(gameState.getMap().getCurrentRoom().getName()) &&
                         gameState.getMap().getCurrentRoom().getItems().size() == 1 &&
                         "Key".equals(gameState.getMap().getCurrentRoom().getItem("item1").getName()) &&
                         gameState.getMap().getCurrentRoom().getFeatures().size() == 1 &&
                         "Old Chest".equals(gameState.getMap().getCurrentRoom().getFeature("chest1").getName()) &&
                         gameState.getMap().getCurrentRoom().getExits().size() == 1 &&
                         "North Exit".equals(gameState.getMap().getCurrentRoom().getExit("exit1").getName());

            System.out.println("AUTOMARK::GameStateFileParser.testParseValidFile: " + (testPassed ? "PASS" : "FAIL"));
            assertTrue(testPassed, "Expected all elements of the parsed game state to match.");
        } catch (IOException e) {
            fail("Test setup failed: Could not create temporary file.");
        } finally {
            if (tempFile != null) {
                tempFile.delete();
            }
        }
    }

    /**
     * Tests parsing an invalid game state file.
     */
    @Test
    void testParseInvalidFile() {
        // Setup: Create an invalid game state file
        String fileContent = """
                player:Hero
                map:room1
                invalidentry
                """;

        File tempFile = null;
        boolean testPassed = false;

        try {
            tempFile = File.createTempFile("testGameStateInvalid", ".txt");
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {
                writer.write(fileContent);
            }

            // Attempt to parse the file
            GameState gameState = GameStateFileParser.parse(tempFile.getAbsolutePath());

            // Validate that parsing did not produce a valid GameState
            testPassed = gameState.getPlayer() != null &&
                         gameState.getMap().getCurrentRoom() == null;

            System.out.println("AUTOMARK::GameStateFileParser.testParseInvalidFile: " + (testPassed ? "PASS" : "FAIL"));
            assertTrue(testPassed, "Expected invalid file to produce partial game state with null current room.");
        } catch (IOException e) {
            fail("Test setup failed: Could not create temporary file.");
        } finally {
            if (tempFile != null) {
                tempFile.delete();
            }
        }
    }
}
