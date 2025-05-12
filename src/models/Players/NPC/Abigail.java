package models.Players.NPC;

import models.App;
import models.Maps.Weather;
import models.Players.Player;
import views.GameMenu;

public class Abigail extends NPC {

    public Abigail() {
        super(NPCDetail.ABIGAIL);
    }

    @Override
    public void quest1() {

    }

    @Override
    public void quest2() {

    }

    @Override
    public void quest3() {

    }

    @Override
    public void talk() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        NPC npc = App.getCurrentGame().getNPCs().get(1);
        int friendship = player.getFriendshipsNPC().get(npc) / 200;
        Weather weather = App.getCurrentGame().getCurrentWeather();

        if (friendship == 0) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("Sunshine again? Boring...");
                    break;
                case RAIN:
                    GameMenu.printResult("Rainy days are perfect for dungeon crawling.");
                    break;
                case SNOW:
                    GameMenu.printResult("Snowball fight later?");
                    break;
                case STORM:
                    GameMenu.printResult("Whoa! That lightning was intense!");
                    break;
            }
        } else if (friendship == 1) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("Sun’s out—maybe I’ll go to the graveyard later.");
                    break;
                case RAIN:
                    GameMenu.printResult("Let’s stay inside and play games today.");
                    break;
                case SNOW:
                    GameMenu.printResult("Snowflakes are cool up close. Like tiny crystals.");
                    break;
                case STORM:
                    GameMenu.printResult("Feels like something epic is going to happen.");
                    break;
            }
        } else if (friendship >= 2) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("I’d go anywhere with you... even in this blinding sun.");
                    break;
                case RAIN:
                    GameMenu.printResult("I kinda love this weather. Let’s stay in and snack.");
                    break;
                case SNOW:
                    GameMenu.printResult("Let’s make snow sculptures together!");
                    break;
                case STORM:
                    GameMenu.printResult("This storm is wild... wanna watch it from the mountain?");
                    break;
            }
        }
    }
}
