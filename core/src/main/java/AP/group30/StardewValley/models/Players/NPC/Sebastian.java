package AP.group30.StardewValley.models.Players.NPC;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.Products.ForagingMineral;
import AP.group30.StardewValley.models.Items.Products.ForagingMineralType;
import AP.group30.StardewValley.models.Maps.Weather;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.GameMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class Sebastian extends NPC {
    private static Animation<TextureRegion> animation;
    private static int x;
    private static int y;
    public static float reactionTimer = 0.0f;

    public Sebastian() {
        super(NPCDetail.SEBASTIAN);
        TextureRegion[] Region = new TextureRegion[4];
        Region[0] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Sebastian0));
        Region[1] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Sebastian1));
        Region[2] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Sebastian2));
        Region[3] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Sebastian3));
        animation = new Animation<TextureRegion>(0.3f, Region);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        x = 18 * 32;
        y = 16 * 32;
        this.getRectangle().setPosition(x, y);
    }

    @Override
    public String quest1() {
        if (isQuest1()) {
            return "This quest is completed.";
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item request = Item.findItemByName("iron ore", player.getBackPack().getItems());
        int rate = 1;
        if (player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(0)) == 2) {
            rate = 2;
        }

        if (request == null) {
            return "You don't have iron ore!";
        } else {
            if (request.getCount() < 50) {
                return "You need at least 50 iron ore!";
            } else if (request.getCount() == 50) {
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 50);
            }

            int count = 2 * rate;
            Item reward = new ForagingMineral(count, ForagingMineralType.DIAMOND);
            Item newItem = Item.findItemByName("diamond", player.getBackPack().getItems());
            if (newItem == null) {
                player.getBackPack().getItems().add(reward);
            } else {
                newItem.setCount(newItem.getCount() + count);
            }

            this.setQuest1(true);
            for (Player player1 : App.getCurrentGame().getPlayers()) {
                Integer a = 1;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(0)).remove(a);
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
        Item request = Item.findItemByName("pumpkin pie", player.getBackPack().getItems());
        int rate = 1;
        if (player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(0)) == 2) {
            rate = 2;
        }

        if (request == null) {
            return "You don't have pumpkin pie!";
        } else {
            if (request.getCount() == 1) {
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 1);
            }

            int count = 5000 * rate;
            player.setMoney(player.getMoney() + count);

            this.setQuest2(true);
            for (Player player1 : App.getCurrentGame().getPlayers()) {
                Integer a = 2;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(0)).remove(a);
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
        Item request = Item.findItemByName("stone", player.getBackPack().getItems());
        int rate = 1;
        if (player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(0)) == 2) {
            rate = 2;
        }

        if (request == null) {
            return "You don't have stone!";
        } else {
            if (request.getCount() < 150) {
                return "You need at least 150 stone!";
            } else if (request.getCount() == 150) {
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 150);
            }

            int count = 50 * rate;
            Item reward = new ForagingMineral(count, ForagingMineralType.QUARTZ);
            Item newItem = Item.findItemByName("quartz", player.getBackPack().getItems());
            if (newItem == null) {
                player.getBackPack().getItems().add(reward);
            } else {
                newItem.setCount(newItem.getCount() + count);
            }

            this.setQuest3(true);
            for (Player player1 : App.getCurrentGame().getPlayers()) {
                Integer a = 3;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(0)).remove(a);
            }

            return "You have successfully completed the quest!";
        }
    }


    @Override
    public String talk() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        NPC npc = App.getCurrentGame().getNPCs().get(0);
        int friendship = player.getFriendshipsNPC().get(npc) / 200;
        Weather weather = App.getCurrentGame().getCurrentWeather();

        if (friendship == 0) {
            switch (weather) {
                case SUNNY:
                    return "Ugh... too bright out here. I miss my room already.";
                case RAIN:
                    return "This weather suits me just fine.";
                case SNOW:
                    return "Snow’s okay... as long as I don’t have to shovel it.";
                case STORM:
                    return "Storms make the world feel alive. I like that.";
            }
        } else if (friendship == 1) {
            switch (weather) {
                case SUNNY:
                    return "It's kind of bright... but I’ll survive.";
                case RAIN:
                    return "Rain fits my mood today.";
                case SNOW:
                    return "Snow is calming... kinda nice.";
                case STORM:
                    return "Stormy skies are oddly comforting.";
            }
        } else if (friendship == 2) {
            switch (weather) {
                case SUNNY:
                    return "I guess a sunny day isn’t the worst thing.";
                case RAIN:
                    return "Kinda peaceful, right?";
                case SNOW:
                    return "Snow reminds me of home... quiet and cold.";
                case STORM:
                    return "Sometimes I think the storm gets how I feel inside.";
            }
        } else if (friendship == 3) {
            switch (weather) {
                case SUNNY:
                    return "I don’t mind the sun when you're around.";
                case RAIN:
                    return "You ever just stand in the rain and think?";
                case SNOW:
                    return "Want to walk in the snow together?";
                case STORM:
                    return "If lightning hits us, at least we’ll be together. Kidding... mostly.";
            }
        }
        return "";
    }

    @Override
    public void showDialog(SpriteBatch batch, BitmapFont font, Camera camera) {
        batch.draw(GameAssetManager.assetManager.get(GameAssetManager.chatBox), camera.position.x - Gdx.graphics.getWidth() / 3.8f,
            camera.position.y - Gdx.graphics.getHeight() / 2.2f,this.getRectangle().width * 60,this.getRectangle().height * 8f);
        font.draw(batch,"Sebastian: " + talk(), camera.position.x - Gdx.graphics.getWidth() / 4.2f, camera.position.y - Gdx.graphics.getHeight() / 4f);
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
        if (Sebastian.reactionTimer > 0) {
            batch.draw(reactionTexture, x, y + 70, 40 , 40);
        }
    }
}
