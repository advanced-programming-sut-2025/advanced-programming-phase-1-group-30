package Models.Tools;

import Models.Tool;

public class Hoe extends Tool {
    private HoeType type;

    public Hoe(int count, HoeType type) {
        super(count);
        this.type = type;
    }

    public HoeType getType() {
        return type;
    }

    public void setType(HoeType type) {
        this.type = type;
    }
}
