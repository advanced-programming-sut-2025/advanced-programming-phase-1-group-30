package models.Players.NPC;

import models.App;
import models.Items.Item;
import models.Maps.Tile;
import models.Maps.Weather;
import models.Players.Player;
import views.GameMenu;

import java.util.ArrayList;

public abstract class NPC {
    private String name;
    private Tile tile;
    private NPCDetail detail;
    private ArrayList<Item> favoriteGifts = new ArrayList<>();
    private boolean quest1 = false;
    private boolean quest2 = false;
    private boolean quest3 = false;
    private int quest3Activation;

    public NPC(NPCDetail detail) {
        this.name = detail.name;
        this.tile = detail.tile;
        this.detail = detail;
        this.favoriteGifts.addAll(detail.favoriteGifts);
    }

    public abstract void quest1();
    public abstract void quest2();
    public abstract void quest3();
    public abstract void talk();
}


