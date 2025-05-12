package models.Players.NPC;

import models.App;
import models.Maps.Weather;
import models.Players.Player;
import views.GameMenu;

public class Sebastian extends NPC {

    public Sebastian() {
        super(NPCDetail.SEBASTIAN);
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
        NPC abigail = App.getCurrentGame().getNPCs().get(0);
        int friendship = player.getFriendshipsNPC().get(abigail) / 200;
        Weather weather = App.getCurrentGame().getCurrentWeather();

        if (friendship == 0) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("Ugh... too bright out here. I miss my room already.");
                    break;
                case RAIN:
                    GameMenu.printResult("This weather suits me just fine.");
                    break;
                case SNOW:
                    GameMenu.printResult("Snow’s okay... as long as I don’t have to shovel it.");
                    break;
                case STORM:
                    GameMenu.printResult("Storms make the world feel alive. I like that.");
                    break;
            }
        } else if (friendship == 1) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("It's kind of bright... but I’ll survive.");
                    break;
                case RAIN:
                    GameMenu.printResult("Rain fits my mood today.");
                    break;
                case SNOW:
                    GameMenu.printResult("Snow is calming... kinda nice.");
                    break;
                case STORM:
                    GameMenu.printResult("Stormy skies are oddly comforting.");
                    break;
            }
        } else if (friendship == 2) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("I guess a sunny day isn’t the worst thing.");
                    break;
                case RAIN:
                    GameMenu.printResult("Kinda peaceful, right?");
                    break;
                case SNOW:
                    GameMenu.printResult("Snow reminds me of home... quiet and cold.");
                    break;
                case STORM:
                    GameMenu.printResult("Sometimes I think the storm gets how I feel inside.");
                    break;
            }
        } else if (friendship == 3) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("I don’t mind the sun when you're around.");
                    break;
                case RAIN:
                    GameMenu.printResult("You ever just stand in the rain and think?");
                    break;
                case SNOW:
                    GameMenu.printResult("Want to walk in the snow together?");
                    break;
                case STORM:
                    GameMenu.printResult("If lightning hits us, at least we’ll be together. Kidding... mostly.");
                    break;
            }
        }
    }

}
