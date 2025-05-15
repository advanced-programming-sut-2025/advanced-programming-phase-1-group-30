package models.Players.NPC;

import models.App;
import models.Items.IndustrialProducts.IndustrialProduct;
import models.Items.IndustrialProducts.IndustrialProductType;
import models.Items.Item;
import models.Maps.Weather;
import models.Players.Player;
import views.GameMenu;

public class Abigail extends NPC {

    public Abigail() {
        super(NPCDetail.ABIGAIL);
    }

    @Override
    public void quest1() {
        if(isQuest1()){
            GameMenu.printResult("This quest is completed.");
            return;
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item request = Item.findItemByName("gold bar",player.getBackPack().getItems());
        int rate = 1;
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(1)) == 2){
            rate = 2;
        }
        if(request == null) {
            GameMenu.printResult("You don't have gold bar!");
        } else {
            if(request.getCount() == 1){
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 1);
            }
            NPC npc = App.getCurrentGame().getNPCs().get(1);
            player.getFriendshipsNPC().put(npc,player.getFriendshipsNPC().get(npc) + 200);
            if(player.getFriendshipsNPC().get(npc) >= 200 && player.getFriendshipsNPC().get(npc) < 400
                    && !npc.isQuest2()){
                player.getActivatedQuestNPC().get(npc).add(2);
            }

            GameMenu.printResult("Congratulations! You have successfully completed the quest!");
            this.setQuest1(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 1;
                player1.getActivatedQuestNPC().get(npc).remove(a);
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
        Item request = Item.findItemByName("pumpkin",player.getBackPack().getItems());
        int rate = 1;
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(1)) == 2){
            rate = 2;
        }
        if(request == null) {
            GameMenu.printResult("You don't have pumpkin!");
        } else {
            if(request.getCount() == 1){
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 1);
            }
            int count = 500 * rate;
            player.setMoney(player.getMoney() + count);
            GameMenu.printResult("Congratulations! You have successfully completed the quest!");
            this.setQuest2(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 2;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(1)).remove(a);
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
        Item request = Item.findItemByName("wheat",player.getBackPack().getItems());
        int rate = 1;
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(1)) == 2){
            rate = 2;
        }
        if(request == null) {
            GameMenu.printResult("You don't have wheat!");
        } else {
            if(request.getCount() < 50){
                GameMenu.printResult("You need at least 50 wheat!");
                return;
            } else if(request.getCount() == 50){
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 50);
            }
            int count = 1 * rate;
            Item reward = new IndustrialProduct(count, IndustrialProductType.IRIDIUM_SPRINKLER);
            Item newItem = Item.findItemByName("iridium sprinkler",player.getBackPack().getItems());
            if(newItem == null) {
                player.getBackPack().getItems().add(reward);
            } else {
                newItem.setCount(newItem.getCount() + count);
            }

            GameMenu.printResult("Congratulations! You have successfully completed the quest!");
            this.setQuest3(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 3;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(1)).remove(a);
            }
        }
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
