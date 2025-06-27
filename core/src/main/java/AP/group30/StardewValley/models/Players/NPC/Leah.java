package AP.group30.StardewValley.models.Players.NPC;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Items.Foods.FoodType;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProduct;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProductType;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Maps.Weather;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.GameMenu;

public class Leah extends NPC {

    public Leah() {
        super(NPCDetail.LEAH);
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
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(3)) == 2){
            rate = 2;
        }
        if(request == null) {
            GameMenu.printResult("You don't have wood!");
        } else {
            if(request.getCount() < 10){
                GameMenu.printResult("You need at least 10 wood!");
                return;
            } else if(request.getCount() == 10){
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 10);
            }
            int count = 500 * rate;
            player.setMoney(player.getMoney() + count);

            GameMenu.printResult("Congratulations! You have successfully completed the quest!");
            this.setQuest1(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 1;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(3)).remove(a);
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
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(3)) == 2){
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
            if(!player.getRecipes().contains(FoodType.SALMON_DINNER)){
                player.getRecipes().add(FoodType.SALMON_DINNER);
            }

            GameMenu.printResult("Congratulations! You have successfully completed the quest!");
            this.setQuest2(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 2;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(3)).remove(a);
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
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(3)) == 2){
            rate = 2;
        }
        if(request == null) {
            GameMenu.printResult("You don't have wood!");
        } else {
            if(request.getCount() < 200){
                GameMenu.printResult("You need at least 200 wood!");
                return;
            } else if(request.getCount() == 200){
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 200);
            }
            int count = 3 * rate;
            Item reward = new IndustrialProduct(count, IndustrialProductType.DELUXE_SCARECROW);
            Item newItem = Item.findItemByName("deluxe scarecrow",player.getBackPack().getItems());
            if(newItem == null) {
                player.getBackPack().getItems().add(reward);
            } else {
                newItem.setCount(newItem.getCount() + count);
            }

            GameMenu.printResult("Congratulations! You have successfully completed the quest!");
            this.setQuest3(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 3;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(3)).remove(a);
            }
        }
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
