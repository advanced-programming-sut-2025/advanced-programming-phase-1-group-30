package models.Players.NPC;

import models.App;
import models.Items.Item;
import models.Maps.Tile;

import java.util.ArrayList;
import java.util.List;

public enum NPCDetail {
    SEBASTIAN("Sebastian", 0, 0, 10, new ArrayList<>(List.of(
            new Item(1, "wool"),
            new Item(1, "pumpkin pie"),
            new Item(1, "pizza")
    ))),
    ABIGAIL("Abigail", 0, 1, 15, new ArrayList<>(List.of(
            new Item(1, "stone"),
            new Item(1, "iron ore"),
            new Item(1, "coffee")
    ))),
    HARVEY("Harvey", 0, 2, 5, new ArrayList<>(List.of(
            new Item(1, "coffee"),
            new Item(1, "pickle"),
            new Item(1, "wine")
    ))),
    LEAH("Leah", 0, 3, 20,new ArrayList<>(List.of(
            new Item(1, "salad"),
            new Item(1, "grape"),
            new Item(1, "wine")
    ))),
    ROBIN("Robin", 0, 4, 25, new ArrayList<>(List.of(
            new Item(1, "spaghetti"),
            new Item(1, "wood"),
            new Item(1, "iron bar")
    )));


    public final String name;
    public final Tile tile;
    private final int quest3Days;
    public final ArrayList<Item> favoriteGifts = new ArrayList<>();

    NPCDetail(String name, int x , int y, int quest3Days, ArrayList<Item> favoriteGifts) {
        this.name = name;
        this.tile = App.getMaps().get(0).getTiles()[x][y];
        this.quest3Days = quest3Days;
        this.favoriteGifts.addAll(favoriteGifts);
    }
}
