package org.uob.a1;
//add comments to all classes!!!
import java.util.Scanner; 

public class Game {
    
    public static void main(String[] args) {
        //create new objects to facilitate the game
        Map map1 = new Map(7,7); 
        Position posPlayer = new Position(0,0);
        Player Player1 = new Player(posPlayer, map1);
        Inventory Inventory = new Inventory();
        Score Score = new Score(0);


        //add the rooms to the map
        Position pos1 = new Position(2, 1);
        Room R1 = new Room("The Glade of Apollo", "A sunny, cheerful clearing in the dense forest, where rays of sunlight dance enchantingly around a central altar.", 'G', pos1);
        
        Position pos2 = new Position(4, 2);
        Room R2 = new Room("Temple of Hades", "You hear a bloodcurdling howl. Ahead lies a spine-chilling structure that seems to emanate an otherworldly aura. The Temple of Hades is nestled into a dark clearing, under the thick canopy of the enchanted forest.\nThe door of the temple is ajar.", 'T', pos2);

        Position pos3 = new Position(1, 3);
        Room R3 = new Room("The Garden of Artemis", "A magical and mysterious area of the forest, where the canopy is so impenetrable that the illusion of a permanent night is cast. A golden hind slumbers among the lilies.", 'A', pos3);
        
        Position pos4 = new Position(4, 0);
        Room R4 = new Room("The Spring of Aphrodite", "Underneath an old fig tree sits a small natural grotto, where water flows down a wall of rock and forms a pool amongst the moss. It is here that legend says Aphrodite would come to bathe.", 'S', pos4);

        Position pos5 = new Position(3, 4);
        Room R5 = new Room("Demeter's Great Cornucopia", "A striking and glorious centrepiece to a thriving meadow, the cornucopia symbolises abundance and nourishment.", 'D', pos5);
        
        Position pos6 = new Position(5, 4);
        Room R6 = new Room("Idol of Zeus Most High ", "As you scan the forest clearing, your eyes are drawn to a magnificent statue. This sculpture of the Thunderbringer in his full glory strikes you with a mixture of fear and sheer awe.", 'Z', pos6);

        Position pos7 = new Position(2, 5);
        Room R7 = new Room("Ares' Wasteland", "An unforgiving expanse that echoes with resonant fury. The barren terrain is scorched and marked with the scars of countless, long-forgotten wars. A solitary ironwood stands, as if still at attention.", 'W', pos7);
        
        Position pos8 = new Position(0, 6);
        Room R8 = new Room("Poseidon Falls", "A breathtaking cascade of azure that seems to thunder down from impossible heights. The falls feed a glistening plunge pool, launching a fine mist into the air, where a dazzling display of rainbows dance.", 'P', pos8); //
        
        Position pos9 = new Position(6, 0);
        Room R9 = new Room("Volcano of Hephaestus", "A formidable peak, shrouded in thick, sulphurous smoke. The crimson glow of molten rock hints at the proximity of the Anvil of the Cardinal Craftsman.", 'H', pos9);

        Position pos10 = new Position(6, 6); 
        Room R10 = new Room("Mount Olympus", "Mount Olympus towers over the mortal realm. Its slopes are lush and mystical, and its peaks are crowned with glorious temples, each emanating a divine glow.\nThe air hums and crackles with sacred power.", 'M', pos10);
        
        
        //place the player on the map
        map1.playerNewLocation(posPlayer);

        //narration for start of game
        System.out.println("\n\nYou find yourself on the outskirts of a dense forest. \nThe path forks ahead of you. \nMove E, S or SE.");
        
        //initialise action and item variables and narration
        String action = "";
        String item = "";
        String narration;

        //initialise isPlaying condition
        Boolean isPlaying = true;
        Boolean inRoom = false;
        Boolean isLooking;
        Boolean isPickingUp;
        Boolean roomLook;
        Boolean needsHelp;

        //initialise puzzle conditions
        Boolean puzzle1 = false;
        Boolean puzzle2 = false;
        Boolean puzzle3 = false;
        Boolean finalPuzzle = false;

        //initialise easter egg condition
        Boolean isGuilty = false;

        //initialise temporary variable
        int n = 0;
        
        // start game loop
        do {
            //block to take the user's action as an input
            System.out.println("-----------------\n-----------------\nChoose an action:");     
            Scanner inputDevice = new Scanner(System.in);
            action = inputDevice.nextLine();
            isLooking = false;
            isPickingUp = false;
            roomLook = false;
            needsHelp = false;

            //remove old player location from last iteration if player decides to move this turn
            try {
                if (action.toLowerCase().substring(0,5).equals("move ")) {
                    map1.playerRemoveOldLocation(posPlayer);
                }
            } catch (Exception e) {
            }

            //if loop for if 'look' or 'pick up' actions are chosen to extract the item

            try {
                if (action.toLowerCase().substring(0,4).equals("look")) {
                    isLooking = true;
                    if (action.toLowerCase().equals("look") && inRoom) {
                        roomLook = true;
                    } else if (action.toLowerCase().equals("look") && !inRoom) {
                        System.out.println("A labyrinthine sprawl of paths fan out in all directions. The shadows seem to bend, and the roots to twist, in a sinister way designed to confuse and disorient even the most competent and accomplished adventurers. Each branch begins to look familiar...\nNevertheless, the air carries the fresh, earthy scent of pine and damp wood, hinting at the presence of hidden glades and secret clearings.");
                    } else {
                        item = action.substring(5);
                    }
                    
                    // add more if statements and create classes for items.java and features.java
                }
                if (action.toLowerCase().substring(0,7).equals("pick up")) {
                    isPickingUp = true;
                    item = action.substring(8);
                }
                    
                //catch for if the action entered is less than length 4
            } catch (Exception e) {
            }
        

            // only execute switch case if action is not a look action or pick up action
            if(!isLooking && !isPickingUp) {
            //switch case for determining action
                switch (action.toLowerCase()) {
                    case "move e" : Player1.movePlayer(1,0); break;
                    case "move w" : Player1.movePlayer(-1,0); break;
                    case "move s" : Player1.movePlayer(0,1); break;
                    case "move n" : Player1.movePlayer(0,-1); break;
                    case "move ne" : Player1.movePlayer(1,-1); break;
                    case "move nw" : Player1.movePlayer(-1,-1); break;
                    case "move se" : Player1.movePlayer(1,1); break;
                    case "move sw" : Player1.movePlayer(-1,1); break;
                    case "inventory" : 
                        if (Inventory.displayInventory().equals(""))
                        {
                            System.out.println("You have no items in your inventory.");
                        } else {
                            System.out.println(Inventory.displayInventory());
                        }; 
                        break;
                    case "score" : System.out.println("Current Score: " + Score.getScore()); break;
                    case "map" : System.out.println(map1.display()); break; 
                    case "help" : needsHelp = true; System.out.println("You pray to Hermes, God of Travellers, for assistance in your adventure."); break;
                    case "drop" : System.out.println("Which item do you wish to drop?"); item = inputDevice.nextLine(); Inventory.removeItem(item); break;
                    case "quit" : isPlaying = false; System.out.println("You fall down to your knees, exhaustion possessing each limb individually. Under your breath you mutter something about a Sisyphean task.\nSo long adventurer, and may the gods be with you."); break; //set isPlaying to false to prevent any other code from executing after quit is called
                    default : System.out.println("You are confused.");
                }
            }
            //skips rest of this iteration of game loop if 'quit' is entered
            if (!isPlaying) {
                continue;
            }


            //add rooms to map after they have been discovered
            if (posPlayer.x == pos1.x && posPlayer.y == pos1.y) {
                inRoom = true;
                map1.placeRoom(pos1, R1.getSymbol());
                //look for Room 1
                if (roomLook) { 
                    System.out.println(R1.getName() + ": " + R1.getDescription());
                } else if (needsHelp) {
                    System.out.println("Try looking at the altar");
                    needsHelp = false;
                }
                
                //allow for 'look altar' command
                narration = (item.equals("altar") || item.equals("at altar")) ? "Beneath the altar lies a wooden bow, a quiver and a lyre.\n" : "";
                if (isLooking) {
                    System.out.print(narration);
                }
                //add methods to pick up bow and quiver and lyre
                if (isPickingUp && (item.equals("bow") || item.equals("quiver") || item.equals("lyre"))) {
                    Inventory.addItem(item);
                    continue;
                }
                
            } else if (posPlayer.x == pos2.x && posPlayer.y == pos2.y){
                inRoom = true;
                map1.placeRoom(pos2, R2.getSymbol());
                //look for Room 2
                if (roomLook) { 
                    System.out.println(R2.getName() + ": " + R2.getDescription());
                } else if (needsHelp) {
                    System.out.println("Try looking inside the temple");
                }
                //allow for 'look inside'
                narration = (item.equals("inside")) ? "Inside the temple is a blood-stained, ancient chest.\n" : "";
                if (isLooking) {
                    System.out.print(narration);
                }
                if (item.equals("chest")) {
                    System.out.println("In the chest you find a key.\nBefore you can pick it up, Cerberus, a fearsome guardian hound with three heads, snarls and charges towards you.");
                    System.out.println("You are faced with three choices: shoot an arrow, play a lullaby, or run.");
                    item = "";
                    //puzzle 1 involving the player choosing a course of action
                    if (!puzzle1) {
                        action = inputDevice.nextLine();
                        if (action.equals("shoot") || action.equals("shoot arrow")) {
                            if (Inventory.hasItem("bow") != -1 && Inventory.hasItem("quiver") != -1) {
                                System.out.println("The arrow bounces off the hound's thick hide and you are forced to retreat out of the temples southern exit.");
                            } else {
                                System.out.println("You attempt to retrieve your bow and quiver but cannot find them. You are forced to retreat out of the temples southern exit.");
                            }
                                Player1.movePlayer(0,1);
                                map1.playerNewLocation(posPlayer);
                        } else if (action.equals("play") || action.equals("play lullaby")) {
                            if (Inventory.hasItem("lyre") != -1) {
                                System.out.println("Cerberus' charge is stopped as the beast succumbs to somnolence.");
                                Score.solvePuzzle();
                                Inventory.addItem("key-of-darkness");
                                puzzle1 = true;
                                System.out.println("It might be useful later.");
                            } else { 
                                System.out.println("Without the help of Apollo's lyre your lullaby has no effect. You are forced to retreat out of the temples southern exit.");
                                Player1.movePlayer(0,1);
                                map1.playerNewLocation(posPlayer);
                            }
                        } else {
                            System.out.println("You are forced to retreat out of the temples southern exit.");
                            Player1.movePlayer(0,1);
                            map1.playerNewLocation(posPlayer);     
                        }
                    }
                }
                //check if in room 3
            } else if (posPlayer.x == pos3.x && posPlayer.y == pos3.y){
                inRoom = true;
                map1.placeRoom(pos3, R3.getSymbol());
                if (roomLook) { 
                    System.out.println(R3.getName() + ": " + R3.getDescription());
                }
                narration = (item.equals("lilies") || item.equals("golden hind")) ?  "A solitary moonbeam illuminates a small hunting knife that lies on the floor.\n" : "";
                if (isLooking) {
                    System.out.print(narration);
                }
                //allow for pick up knife
                if (isPickingUp && (item.equals("knife") || item.equals("hunting knife"))) {
                    Inventory.addItem("hunting-knife");
                    continue;

                }
                //room 4
            } else if (posPlayer.x == pos4.x && posPlayer.y == pos4.y){
                inRoom = true;
                map1.placeRoom(pos4, R4.getSymbol());

                if (roomLook) { 
                    System.out.println(R4.getName() + ": " + R4.getDescription());
                } else if (needsHelp) {
                    System.out.println("Try looking in the pool.");
                }
                //allow for 'look pool'
                narration = (item.equals("pool") || item.equals("in pool")) ? "Beneath the shimmering surface of the pool, you make out the shape of a strange vial.\n" : "";
                if (isLooking) {
                    System.out.print(narration);
                }
                if (isPickingUp && (item.equals("vial") || item.equals("strange vial"))) {
                    Inventory.addItem("strange-vial");
                    continue;
                }
            //room 5
            } else if (posPlayer.x == pos5.x && posPlayer.y == pos5.y){
                inRoom = true;
                map1.placeRoom(pos5, R5.getSymbol());

                if (roomLook) { 
                    System.out.println(R5.getName() + ": " + R5.getDescription());
                } else if (needsHelp) {
                    System.out.println("Try looking below the cornucopia");
                }
                //allow for 'look below'
                narration = (item.equals("below") || item.equals("below cornucopia") || item.equals("cornucopia")) ? "Under the Cornucopia lies a lucky charm and a horn o'plenty.\n" : "";
                if (isLooking) {
                    System.out.print(narration);
                }
                if (isPickingUp && (item.equals("lucky charm") || item.equals("charm"))) {
                    Inventory.addItem("lucky-charm");
                    continue;
                } else if (isPickingUp && (item.equals("horn") || item.equals("horn o'plenty"))) {
                    Inventory.addItem("horn-o'plenty");
                    continue;

                }
            //room 6
            } else if (posPlayer.x == pos6.x && posPlayer.y == pos6.y){
                inRoom = true;
                map1.placeRoom(pos6, R6.getSymbol());
                if (roomLook) { 
                    System.out.println(R6.getName() + ": " + R6.getDescription());
                    isLooking = false;
                } else if (needsHelp) {
                    System.out.println("Try looking at the statue.");
                }
                //allow for 'look eye'
                narration = (item.equals("statue") || item.equals("at statue")) ? "Upon closer inspection, the right eye of the statue appears to be slightly set back. It looks like some form of hidden switch. Unfortunately, it is beyond your reach.\n" : "";
                if (isLooking && !puzzle2) {
                    System.out.print(narration);                
                    if (Inventory.hasItem("bow") != -1 && Inventory.hasItem("quiver") != -1); {
                        while (!action.equals("shoot arrow")) {
                            action = inputDevice.nextLine();
                            if (action.equals("help")) { 
                                System.out.println("The Messenger God advises you to shoot an arrow at the eye.");
                            } else if (!action.equals("shoot arrow")) { 
                                System.out.println("That didn't seem to work, perhaps you should ask for Hermes' help by using the command 'help'.");
                            }
                        }
                        Score.solvePuzzle();
                        puzzle2 = true;
                        System.out.println("The arrow finds its mark. Simultaneously, a brilliant flash of lightning strikes the clearing, leaving a glowing sceptre resting upon the singed grass.");
                        //allow for pick up sceptre 
                    } 
                } else if (isPickingUp && puzzle2 && (item.equals("sceptre") || item.equals("glowing sceptre"))) {
                            Inventory.addItem("sceptre-of-the-golden-eagle");
                            continue;                
                } else if (needsHelp && (Inventory.hasItem("bow") == -1 || Inventory.hasItem("quiver") == -1)){ 
                    System.out.println("If only you had a bow and quiver.");
                }

            
            //room 7
            } else if (posPlayer.x == pos7.x && posPlayer.y == pos7.y){
                inRoom = true;
                map1.placeRoom(pos7, R7.getSymbol());
                if (roomLook) { 
                    System.out.println(R7.getName() + ": " + R7.getDescription());
                } else if (needsHelp) {
                    System.out.println("The ironwood looks interesting.");
                }
                //allow for 'look ironwood'
                narration = (item.equals("ironwood") || item.equals("at ironwood")) ? "An enormous broadsword is embedded in the trunk. You heave at it but cannot prise it free.\n" : "";
                if (isLooking) {
                    System.out.print(narration);
                }
                if (!puzzle3) {
                    if (isPickingUp && (item.equals("sword") || item.equals("broadsword"))) {
                        if (Inventory.hasItem("hunting-knife") != -1) {
                            System.out.println("You use your hunting knife to carve the sword free.");
                            Inventory.addItem("great-broadsword");
                            Score.solvePuzzle();
                            puzzle3 = true;
                            continue;
                        } else {
                            System.out.println("If only you had a knife to cut the sword free.");
                        }
                    }
                }                        

                
             //room 8
            } else if (posPlayer.x == pos8.x && posPlayer.y == pos8.y){
                inRoom = true;
                map1.placeRoom(pos8, R8.getSymbol());
                if (roomLook) { 
                    System.out.println(R8.getName() + ": " + R8.getDescription());
                } else if (needsHelp) {
                    System.out.println("Try looking at the plunge pool.");
                }
                //allow for 'look pool'
                narration = (item.equals("pool") || item.equals("plunge pool")) ? "The rainbows shimmer and finally part to reveal an object that seems to hover just below the surface. Upon closer inspection it appears to be a weathered and timeworn trident.\n" : "";
                if (isLooking) {
                    System.out.print(narration);
                }
                if (isPickingUp && item.equals("trident")) {
                    Inventory.addItem("weathered-trident");
                    continue;
                }

            //room 9
            } else if (posPlayer.x == pos9.x && posPlayer.y == pos9.y){
                inRoom = true;
                map1.placeRoom(pos9, R9.getSymbol());
                if (roomLook) { 
                    System.out.println(R9.getName() + ": " + R9.getDescription());
                } else if (needsHelp) {
                    System.out.println("Perhaps you should try looking at the anvil.");
                }
                //allow for 'look anvil'
                narration = (item.equals("anvil") || item.equals("at anvil")) ? "Resting upon the divine forge lie a hammer and tongs. This looks like a good place to restore a weathered and timeworn object.\n" : "";
                if (isLooking && !roomLook) {
                    System.out.print(narration);
                    if (Inventory.hasItem("weathered-trident") != -1) {
                        Inventory.removeItem("weathered-trident");
                        System.out.print("And place it on the anvil.\n");
                        System.out.println("You watch awestruck as the trident is restored to its former glory right before your eyes. The trident now shines with the godly aura of Poseidon.");
                        Inventory.addItem("restored-trident");
                        Score.solvePuzzle();

                    } else {
                        System.out.println("You are not yet worthy of this sacred workshop.");
                    }
                }


            //room 10    
            } else if (posPlayer.x == pos10.x && posPlayer.y == pos10.y) {
                inRoom = true;//amend to implement the look command
                map1.placeRoom(pos10, R10.getSymbol());
                //look for Room 10
                if (roomLook) {
                    if (Inventory.hasItem("lucky-charm") != -1 && Inventory.hasItem("horn-o'plenty") != -1 && Inventory.hasItem("sceptre-of-the-golden-eagle") != -1 && Inventory.hasItem("key-of-darkness") != -1 && Inventory.hasItem("great-broadsword") != -1) {
                        System.out.println(R10.getName() + ": " + R10.getDescription());                        
                        System.out.println("You feel you are nearing the end of your quest");
                    } else {
                        System.out.println("You have not gathered sufficient armaments to pass your final test.\nHermes advises you to continue searching the map.");
                    }

                } else if (needsHelp) {
                    System.out.println("Try looking closer.");
                }
                narration = (item.equals("closer")) ? "You see that a final challenge has been laid out for you. Legend has it any adventurer who can pass this last test will gain unprecedented glory and status. Legend also says there are no second chances." : "";
                //final Puzzle
                if (isLooking && !roomLook) {
                    System.out.println(narration);
                    System.out.println("First up, a ravenous hell hound obstructs your passage.\nChoose your first action: Draw sword, hold horn o'plenty or shoot arrow.");
                    action = inputDevice.nextLine();
                    if (action.equals("hold horn") || action.equals("hold horn o'plenty")) {
                        System.out.println("The hound is confused and distracted by the sudden banquet of delicious meats and rich fruits that rain from the sky, allowing you to continue on the path unimpeded.");
                        System.out.println("Your next challenge awaits. A cyclops, son of Poseidon, guards a magnificently adorned gateway. His heavy armour makes him look invulnerable, yet you know you must pass him to beat this challenge.\nChoose your next action: attack with sword, present trident or drink from vial.");
                        action = inputDevice.nextLine();
                        switch (action) {
                            case "attack with sword" : System.out.println("Your sword bounces off the cyclops' unbreakable armour and is wrenched from your hands. It spins a double somersault through the air, landing with a wet squelch and a scream in the cyclops solitary eye - his only weakness. It would appear that luck was on your side."); isGuilty = true; break;
                            case "present trident" : if (Inventory.hasItem("restored-trident") != -1) {
                                System.out.println("The cyclops bursts into tears at the magnificence of his father's symbol. He is incredulous at your kindness and bows reverently to let you pass."); break;
                            } else {
                                System.out.println("The cyclops is insulted by your actions. He swats you away with one enormous hand causing you to tumble back to the bottom of the slope. Eternal honour slips from your grip this time.");
                                action = "quit"; break;
                            }
                            case "drink from vial" : System.out.println("You drink from the vial. Instantly, you begin to transform into a swan. You are forced to retreat as you desperately attempt to reverse the spell."); action = "quit"; break;
                            default : action = "quit"; System.out.println("You take too long to react and the cyclops lands a violent blow. You must retreat and eternal honour slips from your grip this time."); break;
                                
                        }
                        if (action.equals("quit")) {
                            break;
                        }
                        System.out.println("You now approach the gateway. To one side sits a large, dark keyhole.");
                        action = inputDevice.nextLine();
                        if (action.equals("use key") || action.equals("open gateway")) {
                            System.out.println("The key fits perfectly and the gates swing open. Inside, your eyes feast on a majestic antechamber, adorned with gold on every wall and with breathtaking statues of the Olympian gods lining a central path.\nYou follow the path and it leads to a regal centrepiece. However, the nest is empty.");
                            action = inputDevice.nextLine();
                            if (action.equals("place scepter")) {
                                Score.solvePuzzle();
                                finalPuzzle = true;
                                System.out.println("As you place the scepter down, the eagle begins to grow larger. It lifts you up and flies you to the peaks of Mt. Olympus to take your honourable place among the Olympians. Congratulations adventurer.");
                                System.out.println("Your final score was: " + Score.getScore());
                                if (isGuilty) { 
                                    System.out.println("The cyclops blood still weighs heavy on your mind...");
                                }
                                action = "quit";
                                break;
                            } else { 
                                System.out.println("'You have no place here,' booms a loud voice, 'how dare you wield such a holy item as my sceptre?'. A bolt of lightning smites you from the heavens. Eternal honour slips from your grip this time.");
                                action = "quit";
                                break;
                            }
                        } else {
                            System.out.println("It appears you are merely another hero destined to fall short. Eternal honour slips from your grip this time.");
                            action = "quit";
                            break;
                        }        
                        
                    } else { 
                        System.out.println("The hound shadow travels through your attack and sends you reeling. You must retreat and eternal honour slips from your grip this time.");
                        action = "quit";
                        break;
                    }
                    
                }
        
            
            } else if (needsHelp && !inRoom) {
                //if player asks for help but is not in a room
                System.out.println("Using the speed of the Messenger God, move through more regions of the map to unlock more areas.");
            } else {
                // if not in room then add player location to the map. This is here so that the symbols of the rooms are not removed from the map by putting player locations over the top of them.
                inRoom = false;
                map1.playerNewLocation(posPlayer);
            }
            try {
                //checks if player has moved into a room and prints a message to let them know
                if (action.toLowerCase().substring(0,5).equals("move ") && inRoom) {
                    System.out.println("Something catches your eye.\nYou venture off the path into a different area.");
                    Score.visitRoom();
                    continue;
                    //else player is on the path so lets them know
                } else if (action.toLowerCase().substring(0,5).equals("move ")) {
                    System.out.println("You are on the path.");
                }
            }
                // catches exceptions from using .substring() if string is not long enough
            catch (Exception e) {
                continue;
            }
            //game continues until 'quit' is entered
        } while (!action.toLowerCase().equals("quit"));
    }
}