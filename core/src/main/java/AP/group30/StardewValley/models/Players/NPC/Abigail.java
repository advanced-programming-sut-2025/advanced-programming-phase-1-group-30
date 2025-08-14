package AP.group30.StardewValley.models.Players.NPC;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProduct;
import AP.group30.StardewValley.models.Items.IndustrialProducts.IndustrialProductType;
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

public class Abigail extends NPC {
    private static Animation<TextureRegion> animation;
    private static int x;
    private static int y;
    public static float reactionTimer = 0.0f;

    public Abigail() {
        super(NPCDetail.ABIGAIL);
        TextureRegion[] Region = new TextureRegion[4];
        Region[0] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Abigail0));
        Region[1] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Abigail1));
        Region[2] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Abigail2));
        Region[3] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Abigail3));
        animation = new Animation<TextureRegion>(0.3f, Region);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        x = 72 * 32;
        y = 22 * 32;
        this.getRectangle().setPosition(x, y);
    }

    @Override
    public String quest1() {
        if (isQuest1()) {
            return "This quest is completed.";
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item request = Item.findItemByName("gold bar", player.getBackPack().getItems());
        int rate = 1;
        NPC npc = App.getCurrentGame().getNPCs().get(1);

        if (player.getFriendshipsNPC().get(npc) == 2) {
            rate = 2;
        }

        if (request == null) {
            return "You don't have gold bar!";
        } else {
            if (request.getCount() == 1) {
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 1);
            }

            player.getFriendshipsNPC().put(npc, player.getFriendshipsNPC().get(npc) + 200);

            if (player.getFriendshipsNPC().get(npc) >= 200 &&
                player.getFriendshipsNPC().get(npc) < 400 &&
                !npc.isQuest2()) {
                player.getActivatedQuestNPC().get(npc).add(2);
            }

            this.setQuest1(true);
            for (Player player1 : App.getCurrentGame().getPlayers()) {
                player1.getActivatedQuestNPC().get(npc).remove(1);
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
        Item request = Item.findItemByName("pumpkin", player.getBackPack().getItems());
        int rate = 1;

        if (player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(1)) == 2) {
            rate = 2;
        }

        if (request == null) {
            return "You don't have pumpkin!";
        } else {
            if (request.getCount() == 1) {
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 1);
            }

            int count = 500 * rate;
            player.setMoney(player.getMoney() + count);

            this.setQuest2(true);
            for (Player player1 : App.getCurrentGame().getPlayers()) {
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(1)).remove(2);
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
        Item request = Item.findItemByName("wheat", player.getBackPack().getItems());
        int rate = 1;

        if (player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(1)) == 2) {
            rate = 2;
        }

        if (request == null) {
            return "You don't have wheat!";
        } else {
            if (request.getCount() < 50) {
                return "You need at least 50 wheat!";
            } else if (request.getCount() == 50) {
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 50);
            }

            int count = 1 * rate;
            Item reward = new IndustrialProduct(count, IndustrialProductType.IRIDIUM_SPRINKLER);
            Item newItem = Item.findItemByName("iridium sprinkler", player.getBackPack().getItems());
            if (newItem == null) {
                player.getBackPack().getItems().add(reward);
            } else {
                newItem.setCount(newItem.getCount() + count);
            }

            this.setQuest3(true);
            for (Player player1 : App.getCurrentGame().getPlayers()) {
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(1)).remove(3);
            }

            return "You have successfully completed the quest!";
        }
    }


    @Override
    public String talk() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        NPC npc = App.getCurrentGame().getNPCs().get(1);
        int friendship = player.getFriendshipsNPC().get(npc) / 200;
        Weather weather = App.getCurrentGame().getCurrentWeather();

        if (friendship == 0) {
            switch (weather) {
                case SUNNY:
                    return "Sunshine again? Boring...";
                case RAIN:
                    return "Rainy days are perfect for dungeon crawling.";
                case SNOW:
                    return "Snowball fight later?";
                case STORM:
                    return "Whoa! That lightning was intense!";
            }
        } else if (friendship == 1) {
            switch (weather) {
                case SUNNY:
                    return "Sun’s out—maybe I’ll go to the graveyard later.";
                case RAIN:
                    return "Let’s stay inside and play games today.";
                case SNOW:
                    return "Snowflakes are cool up close. Like tiny crystals.";
                case STORM:
                    return "Feels like something epic is going to happen.";
            }
        } else if (friendship >= 2) {
            switch (weather) {
                case SUNNY:
                    return "I’d go anywhere with you... even in this blinding sun.";
                case RAIN:
                    return "I kinda love this weather. Let’s stay in and snack.";
                case SNOW:
                    return "Let’s make snow sculptures together!";
                case STORM:
                    return "This storm is wild... wanna watch it from the mountain?";
            }
        }

        return "";
    }

    @Override
    public void showDialog(SpriteBatch batch, BitmapFont font, Camera camera) {
        batch.draw(GameAssetManager.assetManager.get(GameAssetManager.chatBox), camera.position.x - Gdx.graphics.getWidth() / 3.8f,
            camera.position.y - Gdx.graphics.getHeight() / 2.2f,this.getRectangle().width * 60,this.getRectangle().height * 8f);
        font.draw(batch,"Abigail: " + talk(), camera.position.x - Gdx.graphics.getWidth() / 4.2f, camera.position.y - Gdx.graphics.getHeight() / 4f);
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
        if (Abigail.reactionTimer > 0) {
            batch.draw(reactionTexture, x, y + 70, 40 , 40);
        }
    }
}
