package models;

import java.util.ArrayList;

public class GreatMap {
    private ArrayList<Map> maps = new ArrayList<>();

    public GreatMap(ArrayList<Map> maps) {
        this.maps = maps;
    }

    public ArrayList<Map> getMaps() {
        return maps;
    }

    public void setMaps(ArrayList<Map> maps) {
        this.maps = maps;
    }
}
