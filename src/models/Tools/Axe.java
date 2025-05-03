package models.Tools;

import models.Tool;

public class Axe extends Tool {
    private AxeType type;

    public Axe(int count, AxeType type) {
        super(count, type.getName());
        this.type = type;
    }

    public AxeType getType() {
        return type;
    }

    public void setType(AxeType type) {
        this.type = type;
    }
}
