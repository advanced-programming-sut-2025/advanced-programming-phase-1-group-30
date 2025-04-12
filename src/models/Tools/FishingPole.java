package models.Tools;

import models.Tool;

public class FishingPole extends Tool {
    private FishingPoleType type;

    public FishingPole(int count, FishingPoleType type) {
        super(count);
        this.type = type;
    }

    public FishingPoleType getType() {
        return type;
    }

    public void setType(FishingPoleType type) {
        this.type = type;
    }
}
