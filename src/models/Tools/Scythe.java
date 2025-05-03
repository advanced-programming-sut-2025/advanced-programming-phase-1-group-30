package models.Tools;

import models.Tool;

public class Scythe extends Tool {
    private final int enegryUsed = 0;

    public Scythe(int count, int enegryUsed) {
        super(count, "Scythe");
    }

    public int getEnegryUsed() {
        return enegryUsed;
    }
}
