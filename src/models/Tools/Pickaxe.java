package models.Tools;

import models.Tool;

public class Pickaxe extends Tool{
    private PickaxeType type;

    public Pickaxe(int count, PickaxeType type) {
        super(count);
        this.type = type;
    }

    public PickaxeType getType() {
        return type;
    }

    public void setType(PickaxeType type) {
        this.type = type;
    }
}
