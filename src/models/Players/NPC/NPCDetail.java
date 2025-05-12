package models.Players.NPC;

import models.App;
import models.Items.Item;
import models.Maps.Tile;

import java.util.ArrayList;
import java.util.List;

public enum NPCDetail {
    SEBASTIAN("Sebastian", 0, 0, 10, new ArrayList<>(List.of(
            "wool",
            "pumpkin pie",
            "pizza"
    ))),
    ABIGAIL("Abigail", 0, 1, 15, new ArrayList<>(List.of(
            "stone",
            "iron ore",
            "coffee"
    ))),
    HARVEY("Harvey", 0, 2, 5, new ArrayList<>(List.of(
            "coffee",
            "pickle",
            "wine"
    ))),
    LEAH("Leah", 0, 3, 20,new ArrayList<>(List.of(
            "salad",
            "grape",
            "wine"
    ))),
    ROBIN("Robin", 0, 4, 25, new ArrayList<>(List.of(
            "spaghetti",
            "wood",
            "iron bar"
    )));


    public final String name;
    public final Tile tile;
    private final int quest3Days;
    public final ArrayList<String> favoriteGiftsName = new ArrayList<>();

    NPCDetail(String name, int x , int y, int quest3Days, ArrayList<String> favoriteGifts) {
        this.name = name;
        this.tile = App.getMaps().get(0).getTiles()[x][y];
        this.quest3Days = quest3Days;
        this.favoriteGiftsName.addAll(favoriteGifts);
    }
}
