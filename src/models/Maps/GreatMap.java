package models.Maps;

import models.Buildings.Blacksmith;
import models.Buildings.Carpenter;
import models.Buildings.Ranch;

import java.util.ArrayList;

public class GreatMap {
    private ArrayList<Map> maps = new ArrayList<>();
    private Ranch ranch;
    private Carpenter carpenter;
    private Blacksmith blacksmith;
    public GreatMap(ArrayList<Map> maps) {
        this.maps = maps;
        this.ranch = new Ranch(0, 0, 0, 0);
        this.carpenter = new Carpenter(0, 0, 0, 0);
        this.blacksmith = new Blacksmith(0, 0, 0, 0);
    }

    public ArrayList<Map> getMaps() {
        return maps;
    }

    public void setMaps(ArrayList<Map> maps) {
        this.maps = maps;
    }

    public Ranch getRanch() {
        return ranch;
    }

    public Carpenter getCarpenter() {
        return carpenter;
    }

    public Blacksmith getBlacksmith() {
        return blacksmith;
    }
}
