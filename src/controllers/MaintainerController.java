package controllers;

import models.Map;

public class MaintainerController {
    public static void loadMap(){
        Map map = new Map(1);
        map.printMap();
    }
}
