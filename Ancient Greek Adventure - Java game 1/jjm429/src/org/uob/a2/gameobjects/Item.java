package org.uob.a2.gameobjects;

/**
 * Represents an item in the game, which is a type of {@code GameObject}.
 *
 * <p>
 * Items can be collected, used, or interacted with by the player.
 * This class inherits common properties from {@code GameObject}.
 * </p>
 */
public class Item extends GameObject {

    public Item(String id, String name, String description, boolean hidden) {
        super(id, name, description, hidden);
    }

    /**
     * Returns a string representation of the item by calling the superclass's {@code toString} method.
     *
     * @return a string describing the item
     */
    @Override
    public String toString() {
        return super.toString();
    }
}
