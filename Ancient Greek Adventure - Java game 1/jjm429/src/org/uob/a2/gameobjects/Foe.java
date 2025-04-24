package org.uob.a2.gameobjects;

public class Foe extends GameObject {

    private String defeatInfo, weakness, fail, drops;
    private boolean isSlain;

    public Foe(String id, String name, String description, boolean hidden, String defeatInfo, boolean isSlain, String weakness, String fail, String drops) {
        super(id, name, description, hidden);
        this.defeatInfo = defeatInfo;
        this.isSlain = isSlain;
        this.weakness = weakness;
        this.fail = fail;
        this.drops = drops;
    }

    public String getDrops() {
        return drops;
    }

    public String getDefeatInfo() {
        return defeatInfo;
    }

    public String getWeakness() {
        return weakness;
    }

    public String getFail() {
        return fail;
    }

    public boolean getSlain() {
        return isSlain;
    }

    public void setSlain(Boolean isSlain) {
        this.isSlain = isSlain;
    }
}
