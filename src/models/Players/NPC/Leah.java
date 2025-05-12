package models.Players.NPC;

import models.App;
import models.Maps.Weather;
import models.Players.Player;
import views.GameMenu;

public class Leah extends NPC {

    public Leah() {
        super(NPCDetail.LEAH);
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
        NPC npc = App.getCurrentGame().getNPCs().get(3);
        int friendship = player.getFriendshipsNPC().get(npc) / 200;
        Weather weather = App.getCurrentGame().getCurrentWeather();

        if (friendship == 0) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("Sunlight’s great for painting... but it gets hot.");
                    break;
                case RAIN:
                    GameMenu.printResult("Rainy days are for tea and thinking.");
                    break;
                case SNOW:
                    GameMenu.printResult("Snow gives everything a kind of purity, don’t you think?");
                    break;
                case STORM:
                    GameMenu.printResult("Storms are wild... nature’s way of reminding us who’s in charge.");
                    break;
            }
        } else if (friendship == 1) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("This light is perfect for a landscape sketch.");
                    break;
                case RAIN:
                    GameMenu.printResult("I like the sound of rain on the cabin roof.");
                    break;
                case SNOW:
                    GameMenu.printResult("Snow always inspires me to sculpt something new.");
                    break;
                case STORM:
                    GameMenu.printResult("Lightning... chaotic, but beautiful.");
                    break;
            }
        } else if (friendship >= 2) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("I saved a sunny spot by the river for us.");
                    break;
                case RAIN:
                    GameMenu.printResult("Want to stay in and paint with me while it rains?");
                    break;
                case SNOW:
                    GameMenu.printResult("Let’s make art in the snow—our own little world.");
                    break;
                case STORM:
                    GameMenu.printResult("Storms make me want to hold onto someone special. Lucky me.");
                    break;
            }
        }
    }

}
