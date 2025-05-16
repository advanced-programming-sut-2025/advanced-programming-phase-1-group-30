package models.Maps;

import java.util.ArrayList;

public class GreatMap {
    private ArrayList<Map> maps = new ArrayList<>();
    private Map cityMap;

    public ArrayList<Map> getMaps() {
        return maps;
    }

    public void setMaps(ArrayList<Map> maps) {
        this.maps = maps;
    }

    public void setCityMap(Map cityMap) {
        this.cityMap = cityMap;
    }
}
