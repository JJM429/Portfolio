package org.uob.a2.gameobjects;

public class Equipment extends GameObject implements Usable {

    protected UseInformation useInformation;

    public Equipment(String id, String name, String description, boolean hidden, UseInformation useInformation) {
        super(id, name, description, hidden);
        this.useInformation = useInformation;
    }

    public void setUseInformation(UseInformation useInformation) {
        this.useInformation = useInformation;
    }

    public UseInformation getUseInformation() {
        return useInformation;
    }

    public String use(GameObject target, GameState gameState) {
        if ((gameState.map.getCurrentRoom().getFeatureByName(target.getName()) != null) && !(gameState.map.getCurrentRoom().getItems().isEmpty())) {
            for (Item item : gameState.map.getCurrentRoom().getItems()) {
                gameState.map.getCurrentRoom().getItem(item.getId()).setHidden(false);
            }
            return "You opened the chest! " + target.getName();
        }
        return "Error. No target found!";
    }

   
    /**
     * Returns a string representation of this equipment, including the attributes inherited from {@code GameObject}
     * and the associated use information.
     *
     * @return a string describing the equipment
     */
    @Override
    public String toString() {
        return super.toString() + ", useInformation=" + useInformation;
    }
}
