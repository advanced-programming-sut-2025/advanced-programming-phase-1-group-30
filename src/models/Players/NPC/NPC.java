package models.Players.NPC;

import models.Items.Item;
import models.Maps.Tile;

import java.util.ArrayList;

public abstract class NPC {
    private String name;
    private Tile tile;
    private NPCDetail detail;
    private ArrayList<String> favoriteGifts = new ArrayList<>();
    private boolean quest1 = false;
    private boolean quest2 = false;
    private boolean quest3 = false;
    private int tillQuest3;

    public NPC(NPCDetail detail) {
        this.name = detail.name;
        this.tile = detail.tile;
        this.detail = detail;
        this.favoriteGifts.addAll(detail.favoriteGiftsName);
        this.tillQuest3 = detail.quest3Days;
    }

    public abstract void quest1();
    public abstract void quest2();
    public abstract void quest3();
    public abstract void talk();

    public String getName() {
        return name;
    }

    public Tile getTile() {
        return tile;
    }

    public NPCDetail getDetail() {
        return detail;
    }

    public ArrayList<String> getFavoriteGifts() {
        return favoriteGifts;
    }

    public boolean isQuest1() {
        return quest1;
    }

    public boolean isQuest2() {
        return quest2;
    }

    public boolean isQuest3() {
        return quest3;
    }

    public void setQuest1(boolean quest1) {
        this.quest1 = quest1;
    }

    public void setQuest2(boolean quest2) {
        this.quest2 = quest2;
    }

    public void setQuest3(boolean quest3) {
        this.quest3 = quest3;
    }

    public int getTillQuest3() {
        return tillQuest3;
    }

    public void setTillQuest3(int tillQuest3) {
        this.tillQuest3 = tillQuest3;
    }
}


