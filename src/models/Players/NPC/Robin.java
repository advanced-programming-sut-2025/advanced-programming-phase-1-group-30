package models.Players.NPC;

import models.App;
import models.Items.IndustrialProducts.IndustrialProduct;
import models.Items.IndustrialProducts.IndustrialProductType;
import models.Items.Item;
import models.Maps.Weather;
import models.Players.Player;
import views.GameMenu;

public class Robin extends NPC {

    public Robin() {
        super(NPCDetail.ROBIN);
    }

    @Override
    public void quest1() {
        if(isQuest1()){
            GameMenu.printResult("This quest is completed.");
            return;
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item request = Item.findItemByName("wood",player.getBackPack().getItems());
        int rate = 1;
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(4)) == 2){
            rate = 2;
        }
        if(request == null) {
            GameMenu.printResult("You don't have wood!");
        } else {
            if(request.getCount() < 80){
                GameMenu.printResult("You need at least 80 wood!");
                return;
            } else if(request.getCount() == 80){
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 80);
            }
            int count = 1000 * rate;
            player.setMoney(player.getMoney() + count);

            GameMenu.printResult("Congratulations! You have successfully completed the quest!");
            this.setQuest1(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 1;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(4)).remove(a);
            }
        }
    }

    @Override
    public void quest2() {
        if(isQuest2()){
            GameMenu.printResult("This quest is completed.");
            return;
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item request = Item.findItemByName("iron bar",player.getBackPack().getItems());
        int rate = 1;
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(4)) == 2){
            rate = 2;
        }
        if(request == null) {
            GameMenu.printResult("You don't have iron bar!");
        } else {
            if(request.getCount() < 10){
                GameMenu.printResult("You need at least 10 iron bar!");
                return;
            } else if(request.getCount() == 10){
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 10);
            }

            int count = 3 * rate;
            Item reward = new IndustrialProduct(count, IndustrialProductType.BEE_HOUSE);
            Item newItem = Item.findItemByName("bee house",player.getBackPack().getItems());
            if(newItem == null) {
                player.getBackPack().getItems().add(reward);
            } else {
                newItem.setCount(newItem.getCount() + count);
            }


            GameMenu.printResult("Congratulations! You have successfully completed the quest!");
            this.setQuest2(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 2;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(4)).remove(a);
            }
        }
    }

    @Override
    public void quest3() {
        if(isQuest3()){
            GameMenu.printResult("This quest is completed.");
            return;
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item request = Item.findItemByName("wood",player.getBackPack().getItems());
        int rate = 1;
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(4)) == 2){
            rate = 2;
        }
        if(request == null) {
            GameMenu.printResult("You don't have wood!");
        } else {
            if(request.getCount() < 1000){
                GameMenu.printResult("You need at least 1000 wood!");
                return;
            } else if(request.getCount() == 1000){
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 1000);
            }
            int count = 25000 * rate;
            player.setMoney(player.getMoney() + count);

            GameMenu.printResult("Congratulations! You have successfully completed the quest!");
            this.setQuest3(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 3;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(4)).remove(a);
            }
        }
    }

    @Override
    public void talk() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        NPC npc = App.getCurrentGame().getNPCs().get(4);
        int friendship = player.getFriendshipsNPC().get(npc) / 200;
        Weather weather = App.getCurrentGame().getCurrentWeather();

        if (friendship == 0) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("Perfect day for construction.");
                    break;
                case RAIN:
                    GameMenu.printResult("Rain slows down my projects. Bummer.");
                    break;
                case SNOW:
                    GameMenu.printResult("Snow means I have to work indoors all day.");
                    break;
                case STORM:
                    GameMenu.printResult("Can’t work in this storm. Tools keep shorting out.");
                    break;
            }
        } else if (friendship == 1) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("Sunny days put me in a good mood to build!");
                    break;
                case RAIN:
                    GameMenu.printResult("I guess I can catch up on blueprints today.");
                    break;
                case SNOW:
                    GameMenu.printResult("Winter’s a good time to get creative with interiors.");
                    break;
                case STORM:
                    GameMenu.printResult("This storm’s wild. Be careful out there.");
                    break;
            }
        } else if (friendship >= 2) {
            switch (weather) {
                case SUNNY:
                    GameMenu.printResult("You bring the sunshine with you, even on sunny days.");
                    break;
                case RAIN:
                    GameMenu.printResult("Come help me in the workshop while the rain falls.");
                    break;
                case SNOW:
                    GameMenu.printResult("Let’s drink cocoa and talk project ideas!");
                    break;
                case STORM:
                    GameMenu.printResult("Let’s just ride this storm out together, alright?");
                    break;
            }
        }
    }

}
