package org.uob.a2.gameobjects;

import java.util.ArrayList;

/**
 * Represents a room in the game, which is a type of {@code GameObject}.
 * 
 * <p>
 * Rooms can have items, equipment, features, and exits. They also manage navigation
 * and interactions within the game world.
 * </p>
 */
public class Room extends GameObject {

    ArrayList<Exit> exits = new ArrayList<Exit>();
    public ArrayList<Item> items = new ArrayList<Item>();
    ArrayList<Equipment> equipment = new ArrayList<Equipment>();
    ArrayList<Feature> features = new ArrayList<Feature>();
    ArrayList<Foe> foes = new ArrayList<Foe>();
    ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    public Room() {

    }

    public Room(String id, String name, String description, boolean hidden) {
        super(id, name, description, hidden);
    }

    public ArrayList<Foe> getFoes() {return foes;}

    public Foe getFoe(String name) {
        for (Foe foe : foes) {
            if (foe.getName().equals(name)) {
                return foe;
            }
        }
        return null;
    }

    public void addFoe(Foe foe) {
        foes.add(foe);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public ArrayList<Exit> getExits() {
        return exits;
    }

    public void addExit(Exit exit) {
        exits.add(exit);
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public ArrayList<Equipment> getVisibleEquipments() {
        ArrayList<Equipment> Visibles = new ArrayList<Equipment>();
        for (Equipment equipment : equipment) {
            if (!equipment.getHidden()) {
                Visibles.add(equipment);
            }
        }
        return Visibles;
    }

    public ArrayList<Item> getVisibleItems() {
        ArrayList<Item> Visibles = new ArrayList<Item>();
        for (Item item : items) {
            if (!item.getHidden()) {
                Visibles.add(item);
            }
        }
        return Visibles;
    }

    public Item getItem(String id) {
        for (Item item : items) {
            if (item.getId().equals(id)) {
                return item;
            }
        }
        return null;
    }

    public Item getItemByName(String name) {
        for (Item item : items) {
            if (item.getName().equals(name)) {
                return item;
            }
        }
        return null;
    }

    public Feature getFeatureByName(String name) {
        for (Feature feature : features) {
            if (feature.getName().equals(name)) {
                return feature;
            }
        }
        return null;
    }

    public ArrayList<Equipment> getEquipments() {
        return this.equipment;
    }

    public boolean hasEuquipment(String id) {
        for (Equipment equipment : equipment) {
            if (equipment.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public Equipment getEquipmentByName(String name) {
        for (Equipment equipment1 : this.equipment) {
            if (equipment1.getName().equals(name)) {
                return equipment1;
            }
        }
        return null;
    }

    public Equipment getEquipment(String id) {
        for (Equipment equipment : this.equipment) {
            if (equipment.getId().equals(id)) {
                return equipment;
            }
        }
        return null;
    }

    public Exit getExit(String id) {
        for (Exit exit : exits) {
            if (exit.getId().equals(id)) {
                return exit;
            }
        }
        return null;
    }

    public void addEquipment(Equipment equipment) {
        this.equipment.add(equipment);
    }

    public Feature getFeature(String id) {
        for (Feature feature : features) {
            if (feature.getId().equals(id)) {
                return feature;
            }
        }
        return null;
    }

    public void addItem(Item item) {
        items.add(item);// can adjust to ensure same item not added twice
    }

    public ArrayList<Feature> getFeatures() {
        return features;
    }

    public ArrayList<GameObject> getAll() {
        return gameObjects;
    }

    public void addFeature(Feature feature) {
        features.add(feature);
    }

    public  boolean hasItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equals(itemName)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasEquipment(String Name) {
        for (Equipment equipment1 : this.equipment) {
            if (equipment1.getName().equals(Name)) {
                return true;
            }
        }
        return false;
    }




    /**
     * Returns a string representation of the room, including its contents and description.
     *
     * @return a string describing the room
     */
    @Override
    public String toString() {
        String out = "[" + id + "] Room: " + name + "\nDescription: " + description + "\nIn the room there is: ";
        for (Item i : this.items) {
            out += i + "\n";
        }
        for (Equipment e : this.equipment) {
            out += e + "\n";
        }
        for (Feature f : this.features) {
            out += f + "\n";
        }
        for (Exit e : this.exits) {
            out += e + "\n";
        }
        return out + "\n";
    }
}
