package models.Players.NPC;

import models.App;
import models.Maps.Weather;
import models.Players.Player;
import views.GameMenu;

public class Harvey extends NPC {

    public Harvey() {
        super(NPCDetail.HARVEY);
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
        NPC npc = App.getCurrentGame().getNPCs().get(2);
        int friendship = player.getFriendshipsNPC().get(npc) / 200;
        Weather weather = App.getCurrentGame().getCurrentWeather();

        if (friendship == 0) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("Nice weather. Good for keeping people healthy.");
                    break;
                case RAIN:
                    GameMenu.printResult("Be careful out here in the wet—it’s flu season.");
                    break;
                case SNOW:
                    GameMenu.printResult("Wrap up warm, alright?");
                    break;
                case STORM:
                    GameMenu.printResult("Try not to go outside in this. Stay safe.");
                    break;
            }
        } else if (friendship == 1) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("A sunny day helps with morale. Mental health matters too.");
                    break;
                case RAIN:
                    GameMenu.printResult("Rain is relaxing... as long as you're not on call.");
                    break;
                case SNOW:
                    GameMenu.printResult("Snow slows everything down. It's oddly calming.");
                    break;
                case STORM:
                    GameMenu.printResult("My equipment might get fried today. Yikes.");
                    break;
            }
        } else if (friendship >= 2) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("Let's take a walk in the sun, just the two of us.");
                    break;
                case RAIN:
                    GameMenu.printResult("Want to listen to the rain from my clinic?");
                    break;
                case SNOW:
                    GameMenu.printResult("Snowed in with you? That doesn’t sound so bad.");
                    break;
                case STORM:
                    GameMenu.printResult("You came out in this weather just to see me? You're incredible.");
                    break;
            }
        }
    }

}
