package Models.Tools;

import Models.Tool;

public class Scythe extends Tool {
    private final int enegryUsed = 0;

    public Scythe(int count, int enegryUsed) {
        super(count);
    }

    public int getEnegryUsed() {
        return enegryUsed;
    }
}
