package AP.group30.StardewValley.models.Players.NPC;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Game;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Foods.FoodType;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProduct;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProductType;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.models.Maps.Weather;
import AP.group30.StardewValley.models.Players.Direction;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.GameMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import static AP.group30.StardewValley.models.GameAssetManager.reaction;

public class Leah extends NPC {
    private static Animation<TextureRegion> animation;
    private static int x;
    private static int y;
    public static float reactionTimer = 0.0f;
    public Leah() {
        super(NPCDetail.LEAH);
        TextureRegion[] Region = new TextureRegion[4];
        Region[0] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Leah0));
        Region[1] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Leah1));
        Region[2] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Leah2));
        Region[3] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Leah3));
        animation = new Animation<TextureRegion>(0.3f, Region);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        x = 20 * 32;
        y = 40 * 32;
        this.getRectangle().setPosition(x, y);
    }

    @Override
    public String quest1() {
        if(isQuest1()){
            return "This quest is completed";
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item request = Item.findItemByName("wood",player.getBackPack().getItems());
        int rate = 1;
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(3)) == 2){
            rate = 2;
        }
        if(request == null) {
            return "You don't have wood!";
        } else {
            if(request.getCount() < 10){
                return "You need at least 10 wood!";
            } else if(request.getCount() == 10){
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 10);
            }
            int count = 500 * rate;
            player.setMoney(player.getMoney() + count);


            this.setQuest1(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 1;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(3)).remove(a);
            }
            return "You have successfully completed the quest!";
        }
    }

    @Override
    public String quest2() {
        if(isQuest2()){
            return "This quest is completed";
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item request = Item.findItemByName("salmon",player.getBackPack().getItems());
        int rate = 1;
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(3)) == 2){
            rate = 2;
        }
        if(request == null) {
            return "You don't have salmon!";
        } else {
            if(request.getCount() == 1){
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 1);
            }
            if(!player.getRecipes().contains(FoodType.SALMON_DINNER)){
                player.getRecipes().add(FoodType.SALMON_DINNER);
            }

            this.setQuest2(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 2;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(3)).remove(a);
            }
            return "You have successfully completed the quest!";
        }
    }

    @Override
    public String quest3() {
        if(isQuest3()){
            return "This quest is completed";
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item request = Item.findItemByName("wood",player.getBackPack().getItems());
        int rate = 1;
        if(player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(3)) == 2){
            rate = 2;
        }
        if(request == null) {
            return "You don't have wood!";
        } else {
            if(request.getCount() < 200){
                return "You need at least 200 wood!";
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

            this.setQuest3(true);
            for(Player player1 :App.getCurrentGame().getPlayers()){
                Integer a = 3;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(3)).remove(a);
            }
            return "You have successfully completed the quest!";
        }
    }

    @Override
    public String talk() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        NPC npc = App.getCurrentGame().getNPCs().get(3);
        int friendship = player.getFriendshipsNPC().get(npc) / 200;
        Weather weather = App.getCurrentGame().getCurrentWeather();

        if (friendship == 0) {
            switch (weather) {
                case SUNNY:
                    return "Sunlight’s great for painting... but it gets hot.";
                case RAIN:
                    return "Rainy days are for tea and thinking.";
                case SNOW:
                    return "Snow gives everything a kind of purity, don’t you think?";
                case STORM:
                    return "Storms are wild... nature’s way of reminding us who’s in charge.";
            }
        } else if (friendship == 1) {
            switch (weather) {
                case SUNNY:
                    return "This light is perfect for a landscape sketch.";
                case RAIN:
                    return "I like the sound of rain on the cabin roof.";
                case SNOW:
                    return "Snow always inspires me to sculpt something new.";
                case STORM:
                    return "Lightning... chaotic, but beautiful.";
            }
        } else if (friendship >= 2) {
            switch (weather) {
                case SUNNY:
                    return "I saved a sunny spot by the river for us.";
                case RAIN:
                    return "Want to stay in and paint with me while it rains?";
                case SNOW:
                    return "Let’s make art in the snow—our own little world.";
                case STORM:
                    return "Storms make me want to hold onto someone special. Lucky me.";
            }
        }
        return "";
    }

    @Override
    public void showDialog(SpriteBatch batch, BitmapFont font, Camera camera) {
        batch.draw(GameAssetManager.assetManager.get(GameAssetManager.chatBox), camera.position.x - Gdx.graphics.getWidth() / 3.8f,
            camera.position.y - Gdx.graphics.getHeight() / 2.2f,this.getRectangle().width * 60,this.getRectangle().height * 8f);
        font.draw(batch,"Leah: " + talk(), camera.position.x - Gdx.graphics.getWidth() / 4.2f, camera.position.y - Gdx.graphics.getHeight() / 4f);
        if(dialogueTimer <= 0){
            dialogueTimer = 3f;
        }
    }

    @Override
    public void showQuest() {

    }


    public static void render(SpriteBatch batch, float stateTime) {
        TextureRegion currentFrame;
        currentFrame = animation.getKeyFrame(stateTime);
        TextureRegion playerRegion = currentFrame;
        batch.draw(currentFrame, x, y, playerRegion.getRegionWidth() * 2f , playerRegion.getRegionHeight() * 2f);
        batch.draw(GameAssetManager.assetManager.get(GameAssetManager.chatNPC), x + 18, y + 50, 35 , 24);
        if (Leah.reactionTimer > 0) {
            batch.draw(reactionTexture, x, y + 70, 40 , 40);
        }
    }
}
