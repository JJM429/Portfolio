package org.uob.a2.gameobjects;

import java.util.ArrayList;

/**
 * Represents a generic game object that can be part of the game world.
 * 
 * <p>
 * Game objects have a name, description, unique identifier, and visibility state.
 * This abstract class serves as a base for more specific types of game objects.
 * </p>
 */
public abstract class GameObject {

    protected String description;
    protected boolean hidden;
    String id;
    protected String name;


    public GameObject(String id, String name, String description, boolean hidden) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.hidden = hidden;

    }
    public GameObject() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    public boolean getHidden() {
        return hidden;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
    /**
     * Returns a string representation of the game object, including its ID, name,
     * description, and visibility state.
     *
     * @return a string describing the game object
     */
    @Override
    public String toString() {
        return "GameObject {" +
               "id='" + id + '\'' +
               ", name='" + name + '\'' +
               ", description='" + description + '\'' +
               ", hidden=" + hidden +
               '}';
    }
}
