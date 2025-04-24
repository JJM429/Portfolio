package org.uob.a1;

public class Inventory {
    private String item;
    private int numItems = 0;
    final int MAX_ITEMS = 10;
    private String[] inventory = new String[MAX_ITEMS];
    private String temp;
    private String display;
    
    public Inventory()
    {

    }

    

    public int hasItem(String item)
    {
        try {
            for (int i=0; i<MAX_ITEMS; i++) {
                if (inventory[i].equals(item)) {
                    return i;
                }
                else {
                    continue;
                } // probably don't need this else
            }
            return -1;
        }
        catch (Exception e) {
            return -1;
        }
            
    }

    public void addItem(String item)
    {
        if (numItems == MAX_ITEMS) {
            System.out.println("You have no more space in your inventory. You must drop an item, in order to pick up a new item.");
        }
        if (hasItem(item) == -1) {
            for (int i=0; i<MAX_ITEMS; i++){
                if(inventory[i] == null){/*note may need to use .equals()*/
                    inventory[i] = item;
                    System.out.println("You pick up the " + item);
                    numItems++;
                    break;
                }
            }
        } else {
            System.out.println("That item cannot be picked up");
        }

    }

    public void removeItem(String item)
    {
        for (int i=0; i<MAX_ITEMS; i++) {
            if (inventory[i].equals(item)) {
                inventory[i] = null;
                System.out.println("You drop the " + item);
                numItems--;
                break;
            }
        }
        for (int i=0; i<MAX_ITEMS; i++) {
            for (int j=(MAX_ITEMS-1); j>0; j--) {
                if (inventory[j] != null && inventory[j-1] == null) {
                    temp = inventory[j-1];
                    inventory[j-1] = inventory[j];
                    inventory[j] = temp;
                }
            }
        }
    }

    public String displayInventory()
    {
        display = "";
        for (int i=0; i<MAX_ITEMS; i++) {
            if (inventory[i] != null) {
                display += inventory[i] + " ";
            }
        }
        return display;
        
    }

   
}