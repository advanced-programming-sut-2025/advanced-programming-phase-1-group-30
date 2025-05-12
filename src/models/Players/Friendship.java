package models.Players;

import java.util.ArrayList;

public class Friendship {
    private int level;
    private int xp;
    private final ArrayList<String> talkHistory = new ArrayList<>();
    private boolean talkedToday = false;
    private boolean sentGiftToday = false;

    public Friendship() {
        this.level = 0;
        this.xp = 0;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public void addXp(int amount, boolean getFlower, boolean getRing) {
        xp += amount;
        while (xp >= getRequiredXp() && level < 3) {
            xp -= getRequiredXp();
            if (level == 2 && getFlower) {
                level = 3;
            } else if (level == 3 && getRing) {
                level = 4;
            } else {
                level++;
            }
        }
        while (xp < 0 && level > 0) {
            level--;
            xp += getRequiredXp();
        }
        if (level == 0 && xp < 0) {
            xp = 0;
        }
    }


    private int getRequiredXp() {
        return (1 + level) * 100;
    }

    public ArrayList<String> getTalkHistory() {
        return talkHistory;
    }

    public boolean isTalkedToday() {
        return talkedToday;
    }

    public void setTalkedToday(boolean talkedToday) {
        this.talkedToday = talkedToday;
    }
    public boolean isSentGiftToday() {
        return sentGiftToday;
    }
    public void setSentGiftToday(boolean sentGiftToday) {
        this.sentGiftToday = sentGiftToday;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }
}

