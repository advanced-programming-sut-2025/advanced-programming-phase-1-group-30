package controllers;

import java.util.ArrayList;
import java.util.Random;

import models.App;
import models.Items.Item;
import models.Maps.Map;
import views.GameMenu;

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

    public static void crowAttack() {
        Random random = new Random();
        
        int chance;
        if (App.getCurrentGame().getCurrentPlayer().getMap().hasScareCrow()) chance = 8;
        else chance = 4;

        int randomNumber = random.nextInt(chance);
        if (randomNumber == 0) {
            GameMenu.printResult("You are under attack by CROWS!");
            randomNumber = random.nextInt(3) + 1;

            ArrayList<Item> products = App.getCurrentGame().getCurrentPlayer().getProducts();
            for (int i = 0; i < randomNumber; i++) {
                GameMenu.printResult("You loose " + products.get(i).getCount() + " " + products.get(i).getName());
                products.remove(i);
            }
        }
    }
}
