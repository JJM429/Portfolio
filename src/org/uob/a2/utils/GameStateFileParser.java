package org.uob.a2.utils;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.HashMap;

import org.uob.a2.gameobjects.*;

/**
 * Utility class for parsing a game state from a file.
 * 
 * <p>
 * This class reads a structured text file to create a {@code GameState} object,
 * including the player, map, rooms, items, equipment, features, and exits.
 * </p>
 */
public class GameStateFileParser {

    public GameStateFileParser() {

    }

    public static GameState parse (String filename) {
        GameState gameState = new GameState();
        try {
            Path file = Paths.get(filename);
            InputStream input = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String s = reader.readLine();

            while (s != null) {
                if (s.substring(0,4).equals("map:")) {
                    gameState.map = new Map(s.substring(4));
                } else if (s.substring(0,4).equals("foe:")) {
                    String[] foeInfo = s.substring(4).split(",");
                    gameState.map.getCurrentRoom().addFoe(new Foe(foeInfo[0], foeInfo[1], foeInfo[2], Boolean.parseBoolean(foeInfo[3]), foeInfo[4], Boolean.parseBoolean(foeInfo[5]), foeInfo[6], foeInfo[7], foeInfo[8]));
                } else if (s.substring(0,5).equals("room:")) {
                    String[] roomInfo = s.substring(5).split(",");
                    gameState.map.addRoom(new Room(roomInfo[0], roomInfo[1], roomInfo[2], Boolean.parseBoolean(roomInfo[3])));
                    gameState.map.setCurrentRoom(roomInfo[0]);
                } else if (s.substring(0,5).equals("item:")) {
                    String[] itemInfo = s.substring(5).split(",");
                    gameState.map.getCurrentRoom().addItem(new Item(itemInfo[0], itemInfo[1], itemInfo[2], Boolean.parseBoolean(itemInfo[3])));
                } else if (s.substring(0,5).equals("exit:")) {
                    String[] exitInfo = s.substring(5).split(",");
                    gameState.map.getCurrentRoom().addExit(new Exit(exitInfo[0], exitInfo[1], exitInfo[2], exitInfo[3], Boolean.parseBoolean(exitInfo[4])));
                } else if (s.substring(0,7).equals("player:")) {
                    gameState.player = new Player(s.substring(7));
                } else if (s.substring(0,10).equals("equipment:")) {
                    String[] equipmentInfo = s.substring(10).split(",");
                    gameState.map.getCurrentRoom().addEquipment(new Equipment(equipmentInfo[0], equipmentInfo[1], equipmentInfo[2], Boolean.parseBoolean(equipmentInfo[3]), new UseInformation(false, equipmentInfo[4], equipmentInfo[5], equipmentInfo[6], equipmentInfo[7])));
                } else if (s.substring(0,10).equals("container:")) {
                    String[] containerInfo = s.substring(10).split(",");
                    gameState.map.getCurrentRoom().addFeature(new Container(containerInfo[0], containerInfo[1], containerInfo[2], Boolean.parseBoolean(containerInfo[3])));
                }
                s = reader.readLine();
            }

        }
        catch (Exception e) {
            System.out.println(e.getMessage() + "failed here");
        }
        return gameState;

    }
}
