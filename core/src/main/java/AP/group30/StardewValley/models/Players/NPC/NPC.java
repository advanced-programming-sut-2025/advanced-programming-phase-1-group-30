package AP.group30.StardewValley.models.Players.NPC;

import AP.group30.StardewValley.models.Maps.Tile;
import com.badlogic.gdx.Gdx;

import java.awt.*;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public abstract class NPC {
    private String name;
    private Tile tile;
    private NPCDetail detailNPC;
    private ArrayList<String> favoriteGifts = new ArrayList<>();
    private boolean quest1 = false;
    private boolean quest2 = false;
    private boolean quest3 = false;
    private int tillQuest3;
    private Rectangle rectangle = new Rectangle();
    protected float dialogueTimer = 0.0f;

    public NPC(NPCDetail detail) {
        name = detail.name;
        tile = detail.tile;
        detailNPC = detail;
        favoriteGifts.addAll(detail.favoriteGiftsName);
        tillQuest3 = detail.quest3Days;
        rectangle.setSize(16, 32);
    }

    public abstract String quest1();
    public abstract String quest2();
    public abstract String quest3();
    public abstract String talk();
    public abstract void showDialog(SpriteBatch batch, BitmapFont font, Camera camera);
    public abstract void showQuest();

    public String getName() {
        return name;
    }

    public Tile getTile() {
        return tile;
    }

    public NPCDetail getDetail() {
        return detailNPC;
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

    public Rectangle getRectangle() {
        return rectangle;
    }

    public float getDialogueTimer() {
        return dialogueTimer;
    }

    public void decreaseDialogueTimer(float delta) {
        this.dialogueTimer -= delta;
    }
}


