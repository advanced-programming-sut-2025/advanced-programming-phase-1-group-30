package AP.group30.StardewValley.models.Players.NPC;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Foods.Food;
import AP.group30.StardewValley.models.Items.Foods.FoodType;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Maps.Weather;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.GameMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Harvey extends NPC {
    private static Animation<TextureRegion> animation;
    private static int x;
    private static int y;
    public static float reactionTimer = 0.0f;

    public Harvey() {
        super(NPCDetail.HARVEY);
        TextureRegion[] Region = new TextureRegion[4];
        Region[0] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Harvey0));
        Region[1] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Harvey1));
        Region[2] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Harvey2));
        Region[3] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Harvey3));
        animation = new Animation<TextureRegion>(0.3f, Region);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        x = 43 * 32;
        y = 52 * 32;
        this.getRectangle().setPosition(x, y);
    }

    @Override
    public String quest1() {
        if (isQuest1()) {
            return "This quest is completed.";
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item request = Item.findItemByName("grape", player.getBackPack().getItems());
        int rate = 1;
        if (player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(2)) == 2) {
            rate = 2;
        }

        if (request == null) {
            return "You don't have grape!";
        } else {
            if (request.getCount() < 12) {
                return "You need at least 12 grape!";
            } else if (request.getCount() == 12) {
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 12);
            }

            int count = 750 * rate;
            player.setMoney(player.getMoney() + count);

            this.setQuest1(true);
            for (Player player1 : App.getCurrentGame().getPlayers()) {
                Integer a = 1;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(2)).remove(a);
            }
            return "You have successfully completed the quest!";
        }
    }

    @Override
    public String quest2() {
        if (isQuest2()) {
            return "This quest is completed.";
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item request = Item.findItemByName("salmon", player.getBackPack().getItems());
        int rate = 1;
        if (player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(2)) == 2) {
            rate = 2;
        }

        if (request == null) {
            return "You don't have salmon!";
        } else {
            if (request.getCount() == 1) {
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 1);
            }

            NPC npc = App.getCurrentGame().getNPCs().get(1);
            player.getFriendshipsNPC().put(npc, player.getFriendshipsNPC().get(npc) + 200);

            if (player.getFriendshipsNPC().get(npc) >= 200 &&
                player.getFriendshipsNPC().get(npc) < 400 &&
                !npc.isQuest2()) {
                player.getActivatedQuestNPC().get(npc).add(2);
            }

            this.setQuest2(true);
            for (Player player1 : App.getCurrentGame().getPlayers()) {
                Integer a = 2;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(2)).remove(a);
            }
            return "You have successfully completed the quest!";
        }
    }

    @Override
    public String quest3() {
        if (isQuest3()) {
            return "This quest is completed.";
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item request = Item.findItemByName("wine", player.getBackPack().getItems());
        int rate = 1;
        if (player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(2)) == 2) {
            rate = 2;
        }

        if (request == null) {
            return "You don't have wine!";
        } else {
            if (request.getCount() == 1) {
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 1);
            }

            int count = 5 * rate;
            Item reward = new Food(count, FoodType.SALAD);
            Item newItem = Item.findItemByName("salad", player.getBackPack().getItems());
            if (newItem == null) {
                player.getBackPack().getItems().add(reward);
            } else {
                newItem.setCount(newItem.getCount() + count);
            }

            this.setQuest3(true);
            for (Player player1 : App.getCurrentGame().getPlayers()) {
                Integer a = 3;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(2)).remove(a);
            }
            return "You have successfully completed the quest!";
        }
    }


    @Override
    public String talk() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        NPC npc = App.getCurrentGame().getNPCs().get(2);
        int friendship = player.getFriendshipsNPC().get(npc) / 200;
        Weather weather = App.getCurrentGame().getCurrentWeather();

        if (friendship == 0) {
            switch (weather) {
                case SUNNY:
                    return "Nice weather. Good for keeping people healthy.";
                case RAIN:
                    return "Be careful out here in the wet—it’s flu season.";
                case SNOW:
                    return "Wrap up warm, alright?";
                case STORM:
                    return "Try not to go outside in this. Stay safe.";
            }
        } else if (friendship == 1) {
            switch (weather) {
                case SUNNY:
                    return "A sunny day helps with morale. Mental health matters too.";
                case RAIN:
                    return "Rain is relaxing... as long as you're not on call.";
                case SNOW:
                    return "Snow slows everything down. It's oddly calming.";
                case STORM:
                    return "My equipment might get fried today. Yikes.";
            }
        } else if (friendship >= 2) {
            switch (weather) {
                case SUNNY:
                    return "Let's take a walk in the sun, just the two of us.";
                case RAIN:
                    return "Want to listen to the rain from my clinic?";
                case SNOW:
                    return "Snowed in with you? That doesn’t sound so bad.";
                case STORM:
                    return "You came out in this weather just to see me? You're incredible.";
            }
        }

        return "";
    }

    @Override
    public void showDialog(SpriteBatch batch, BitmapFont font, Camera camera) {
        batch.draw(GameAssetManager.assetManager.get(GameAssetManager.chatBox), camera.position.x - Gdx.graphics.getWidth() / 3.8f,
            camera.position.y - Gdx.graphics.getHeight() / 2.2f,this.getRectangle().width * 60,this.getRectangle().height * 8f);
        font.draw(batch,"Harvey: " + talk(), camera.position.x - Gdx.graphics.getWidth() / 4.2f, camera.position.y - Gdx.graphics.getHeight() / 4f);
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
        if (Harvey.reactionTimer > 0) {
            batch.draw(reactionTexture, x, y + 70, 40 , 40);
        }
    }
}
