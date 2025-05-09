package controllers;

import java.util.ArrayList;

import models.Maps.Map;

public class MaintainerController {
    public static void loadMap(){
        Map map = new Map(1);
        map.printMap();
    }

    public static <T> String arrayListToString(String name, ArrayList<T> list) {
        StringBuilder sb = new StringBuilder();

        sb.append(name + ": ");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i < list.size() - 1) {
                sb.append("-");
            }
            else sb.append("\n");
        }

        return sb.toString();
    }
}
