package models.Players.NPC;

import models.Buildings.BuildingsInfo;
import models.Maps.Tile;

import java.util.ArrayList;
import java.util.Objects;

public abstract class NPC {
    protected String name;
    protected Tile tile;
    protected int friendshipLevel = 0;
    protected int friendshipPoint = 0;
    protected ArrayList<Quest> quests= new ArrayList<>();
    protected Job job;
    protected ArrayList<Objects> favoriteGifts = new ArrayList<>();
    protected ArrayList<String> dialogues = new ArrayList<>();
    protected ArrayList<Tile> neighborTiles = new ArrayList<>();
    protected BuildingsInfo store;
}
