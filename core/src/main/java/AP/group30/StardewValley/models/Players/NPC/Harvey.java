package AP.group30.StardewValley.models.Players.NPC;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Items.Foods.Food;
import AP.group30.StardewValley.models.Items.Foods.FoodType;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Maps.Weather;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.GameMenu;

public class Harvey extends NPC {

    public Harvey() {
        super(NPCDetail.HARVEY);
    }

    @Override
    public void quest1() {
        if(isQuest1()){
            GameMenu.printResult("This quest is completed.");
            return;
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item request = Item.findItemByName("grape",player.getBackPack().getItems());
        int rate = 1;
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(2)) == 2){
            rate = 2;
        }
        if(request == null) {
            GameMenu.printResult("You don't have grape!");
        } else {
            if(request.getCount() < 12){
                GameMenu.printResult("You need at least 12 grape!");
                return;
            } else if(request.getCount() == 12){
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 12);
            }
            int count = 750 * rate;
            player.setMoney(player.getMoney() + count);

            GameMenu.printResult("Congratulations! You have successfully completed the quest!");
            this.setQuest1(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 1;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(2)).remove(a);
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
        Item request = Item.findItemByName("salmon",player.getBackPack().getItems());
        int rate = 1;
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(2)) == 2){
            rate = 2;
        }
        if(request == null) {
            GameMenu.printResult("You don't have salmon!");
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
            this.setQuest2(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 2;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(2)).remove(a);
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
        Item request = Item.findItemByName("wine",player.getBackPack().getItems());
        int rate = 1;
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(2)) == 2){
            rate = 2;
        }
        if(request == null) {
            GameMenu.printResult("You don't have wine!");
        } else {
           if(request.getCount() == 1){
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 150);
            }
            int count = 5 * rate;
            Item reward = new Food(count, FoodType.SALAD);
            Item newItem = Item.findItemByName("salad",player.getBackPack().getItems());
            if(newItem == null) {
                player.getBackPack().getItems().add(reward);
            } else {
                newItem.setCount(newItem.getCount() + count);
            }

            GameMenu.printResult("Congratulations! You have successfully completed the quest!");
            this.setQuest3(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 3;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(2)).remove(a);
            }
        }
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
