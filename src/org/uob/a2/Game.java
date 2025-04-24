package org.uob.a2;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
import java.nio.file.StandardOpenOption.*;

import org.uob.a2.commands.*;
import org.uob.a2.gameobjects.*;
import org.uob.a2.parser.*;
import org.uob.a2.utils.*;

/**
 * Main class for the game application. Handles game setup, input parsing, and game execution.
 * 
 * <p>
 * This class initializes the game state, reads user input, processes commands, and maintains the game loop.
 * </p>
 */
public class Game {
    public static void setup() {
        //intro art
        System.out.println("""

                              "$$.   e$$*$$c
                               "$$..$$P" '$$r
                                "$$$$"    "$$.           .d
                    z.          .$$$"      "$$.        .dP"
                    ^*e        e$$"         "$$.     .e$"
                      *b.    .$$P"           "$$.   z$"
                       "$c  e$$"              "$$.z$*"
                        ^*e$$P"                "$$$"
                          *$$                   "$$r
                          '$$F                 .$$P
                           $$$                z$$"
                           4$$               d$$b.
                           .$$%            .$$*"*$$e.
                        e$$$*"            z$$"    "*$$e.
                       4$$"              d$P"        "*$$e.
                       $P              .d$$$c           "*$$e..
                      d$"             z$$" *$b.            "*$L
                     4$"             e$P"   "*$c            ^$$
                     $"            .d$"       "$$.           ^$r
                    dP            z$$"         ^*$e.          "b
                   4$            e$P             "$$           "
                                J$F               $$
                                $$               .$F
                               4$"               $P"
                               $"               dP    
                                   """);
        //Welcome messages and getting player name
        System.out.println("\nWelcome to The Twelve Tasks of Hercules! \n----------------------------------------\nTake up the mantle of Hercules, the greatest hero of legend, and embark upon a journey that will echo through the ages. \nSummoned by the will of the gods and the decree of King Eurystheus, you face twelve trials spun, woven and severed by the very fates themselves.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nAnnounce thyself, noble adventurer, and prepare to etch legends into the scrolls of eternity. The trials ahead shall shape a tale resounding through the ages, immortalised in the annals of time.");
        String input = scanner.nextLine();
        System.out.println("Step forth in glory, " + input + ". \nThe gates of destiny stand open before you.");
        Path file = Paths.get("C:\\Users\\james\\IdeaProjects\\Assignment 2 new version\\src\\org\\uob\\a2\\Setup.txt");
        //Path file = Paths.get("/jupyter/work/Assignment 2/jjm429/src/org/uob/a2/Setup.txt");
        //Creating Setup.txt so that the gamestate can be parsed from it
        try {
            OutputStream out = new BufferedOutputStream(Files.newOutputStream(file, StandardOpenOption.APPEND));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write("\nplayer:" + input);//can change to append to end of file and write rest of information directly to file
            writer.flush();
            writer.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


    public static Command getCommands() {
        Scanner scanner = new Scanner(System.in);
        Tokeniser tokeniser = new Tokeniser();
        ArrayList<Token> tokens = tokeniser.getTokens();
        Parser parser = new Parser();
        Command command = new Look("placeholder");
        try {
            tokens.clear();
            System.out.println("-----------------\nChoose an action:");
            String action = scanner.nextLine();
            tokeniser.tokenise(tokeniser.sanitise(action));
            tokens = tokeniser.getTokens();
            command = parser.parse(tokens);
            return command;

        } catch (CommandErrorException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public static void executeCommands(Command command, GameState gameState) {
        try {
            String result = command.execute(gameState);
            System.out.println(result);
        } catch (NullPointerException e) {
            System.out.println("Please enter an action.");
        }
    }

    public static void enterRoom(GameState gameState) {
        //initialise strings for printing in bold
        String openBold = "\033[1m";
        String closeBold = "\033[0m";
        System.out.println(openBold + "\nTask " + gameState.map.getCurrentRoom().getId() + ": " + gameState.map.getCurrentRoom().getName() + closeBold);
        System.out.println(gameState.map.getCurrentRoom().getDescription());

        if (gameState.map.getCurrentRoom().getVisibleItems().size() > 0 || gameState.map.getCurrentRoom().getVisibleEquipments().size() > 0) {
            System.out.println("\nNew armaments available for this labour:");
            for (Item item : gameState.map.getCurrentRoom().getItems()) {
                if (!item.getHidden()) {
                    System.out.println(" - " + item.getName());
                }
            }
            for (Equipment equipment : gameState.map.getCurrentRoom().getEquipments()) {
                if (!equipment.getHidden()) {
                    System.out.println(" - " + equipment.getName());
                }
            }
            for (Feature feature : gameState.map.getCurrentRoom().getFeatures()) {
                if (!feature.getHidden()) {
                    System.out.println(" - " + feature.getName());
                }
            }
        } else {
            System.out.println("\nNo new armaments available for this labour.");
        }
    }

    public static void checkWin(GameState gameState) {
        if (gameState.player.hasItem("hide") && gameState.player.hasItem("envenomed-arrows") && gameState.player.hasItem("captured-hind") && gameState.player.hasItem("captured-boar") && gameState.player.hasItem("drachma") && gameState.player.hasItem("razor-feather") && gameState.player.hasItem("captured-bull") && gameState.player.hasItem("tethered-mares") && gameState.player.hasItem("belt") && gameState.player.hasItem("cattle-prod") && gameState.player.hasItem("apples") && gameState.player.hasItem("sleeping-hound")) {
            System.out.println("\nCongratulations " + gameState.player.getName() + ", you have conquered the unconquerable! Your twelve labours stand as a testament to your unmatched courage, dedication and perseverance.\nMay your name be celebrated in legend for eternity.");
            Command finalScore = new Status("score");
            System.out.println("Your final score was: " + finalScore.execute(gameState).substring(15));
            System.exit(0);
        }
    }

    public static void game() {
        //parse gamestate from file
        GameState gameState = GameStateFileParser.parse("C:\\Users\\james\\IdeaProjects\\Assignment 2 new version\\src\\org\\uob\\a2\\Setup.txt");
        //GameState gameState = GameStateFileParser.parse("/jupyter/work/Assignment 2/jjm429/src/org/uob/a2/Setup.txt");
        enterRoom(gameState);
        Command currentCommand;
        Room currentRoom = gameState.map.getRoom("0");
        do {
            currentCommand = getCommands();
            executeCommands(currentCommand, gameState);
            try {
                if (currentCommand.commandType == CommandType.MOVE && !(currentRoom.equals(gameState.map.getCurrentRoom()))) {
                    checkWin(gameState);
                    enterRoom(gameState);
                    currentRoom = gameState.map.getCurrentRoom();
                }
            } catch (NullPointerException n) {
                currentRoom = gameState.map.getCurrentRoom();
                System.out.println("Caught null error.");
                currentCommand = new NoAction();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } while (currentCommand.commandType != CommandType.QUIT);

    }


    public static void main(String[] args) {
        setup();
        game();
    }

}
