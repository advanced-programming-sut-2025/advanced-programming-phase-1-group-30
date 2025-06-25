package AP.group30.StardewValley.models.Players.NPC;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.Products.ForagingMineral;
import AP.group30.StardewValley.models.Items.Products.ForagingMineralType;
import AP.group30.StardewValley.models.Maps.Weather;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.GameMenu;

public class Sebastian extends NPC {

    public Sebastian() {
        super(NPCDetail.SEBASTIAN);
    }

    @Override
    public void quest1() {
        if(isQuest1()){
            GameMenu.printResult("This quest is completed.");
            return;
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item request = Item.findItemByName("iron ore",player.getBackPack().getItems());
        int rate = 1;
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(0)) == 2){
            rate = 2;
        }
        if(request == null) {
            GameMenu.printResult("You don't have iron ore!");
        } else {
            if(request.getCount() < 50){
                GameMenu.printResult("You need at least 50 iron ore!");
                return;
            } else if(request.getCount() == 50){
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 50);
            }
            int count = 2 * rate;
            Item reward = new ForagingMineral(count, ForagingMineralType.DIAMOND);
            Item newItem = Item.findItemByName("diamond",player.getBackPack().getItems());
            if(newItem == null) {
                player.getBackPack().getItems().add(reward);
            } else {
                newItem.setCount(newItem.getCount() + count);
            }

            GameMenu.printResult("Congratulations! You have successfully completed the quest!");
            this.setQuest1(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 1;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(0)).remove(a);
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
        Item request = Item.findItemByName("pumpkin pie",player.getBackPack().getItems());
        int rate = 1;
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(0)) == 2){
            rate = 2;
        }
        if(request == null) {
            GameMenu.printResult("You don't have pumpkin pie!");
        } else {
            if(request.getCount() == 1){
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 1);
            }
            int count = 5000 * rate;
            player.setMoney(player.getMoney() + count);
            GameMenu.printResult("Congratulations! You have successfully completed the quest!");
            this.setQuest2(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 2;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(0)).remove(a);
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
        Item request = Item.findItemByName("stone",player.getBackPack().getItems());
        int rate = 1;
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(0)) == 2){
            rate = 2;
        }
        if(request == null) {
            GameMenu.printResult("You don't have stone!");
        } else {
            if(request.getCount() < 150){
                GameMenu.printResult("You need at least 150 stone!");
                return;
            } else if(request.getCount() == 150){
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 150);
            }
            int count = 50 * rate;
            Item reward = new ForagingMineral(count, ForagingMineralType.QUARTZ);
            Item newItem = Item.findItemByName("quartz",player.getBackPack().getItems());
            if(newItem == null) {
                player.getBackPack().getItems().add(reward);
            } else {
                newItem.setCount(newItem.getCount() + count);
            }

            GameMenu.printResult("Congratulations! You have successfully completed the quest!");
            this.setQuest3(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 3;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(0)).remove(a);
            }
        }
    }

    @Override
    public void talk() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        NPC npc = App.getCurrentGame().getNPCs().get(0);
        int friendship = player.getFriendshipsNPC().get(npc) / 200;
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
