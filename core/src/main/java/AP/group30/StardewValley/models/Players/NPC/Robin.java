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

public class Robin extends NPC {
    private static Animation<TextureRegion> animation;
    private static int x;
    private static int y;
    public static float reactionTimer = 0.0f;
    public Robin() {
        super(NPCDetail.ROBIN);
        TextureRegion[] Region = new TextureRegion[4];
        Region[0] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Robin0));
        Region[1] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Robin1));
        Region[2] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Robin2));
        Region[3] = new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.Robin3));
        animation = new Animation<TextureRegion>(0.3f, Region);
        animation.setPlayMode(Animation.PlayMode.LOOP);
        x = 65 * 32;
        y = 57 * 32;
        this.getRectangle().setPosition(x, y);
    }

    @Override
    public String quest1() {
        if (isQuest1()) {
            return "This quest is completed.";
        }

        Player player = App.getCurrentGame().getCurrentPlayer();
        Item request = Item.findItemByName("wood", player.getBackPack().getItems());
        int rate = 1;
        if (player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(4)) == 2) {
            rate = 2;
        }

        if (request == null) {
            return "You don't have wood!";
        } else {
            if (request.getCount() < 80) {
                return "You need at least 80 wood!";
            } else if (request.getCount() == 80) {
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 80);
            }

            int count = 1000 * rate;
            player.setMoney(player.getMoney() + count);

            this.setQuest1(true);
            for (Player player1 : App.getCurrentGame().getPlayers()) {
                Integer a = 1;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(4)).remove(a);
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
        Item request = Item.findItemByName("iron bar", player.getBackPack().getItems());
        int rate = 1;
        if (player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(4)) == 2) {
            rate = 2;
        }

        if (request == null) {
            return "You don't have iron bar!";
        } else {
            if (request.getCount() < 10) {
                return "You need at least 10 iron bar!";
            } else if (request.getCount() == 10) {
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 10);
            }

            int count = 3 * rate;
            Item reward = new IndustrialProduct(count, IndustrialProductType.BEE_HOUSE);
            Item newItem = Item.findItemByName("bee house", player.getBackPack().getItems());
            if (newItem == null) {
                player.getBackPack().getItems().add(reward);
            } else {
                newItem.setCount(newItem.getCount() + count);
            }

            this.setQuest2(true);
            for (Player player1 : App.getCurrentGame().getPlayers()) {
                Integer a = 2;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(4)).remove(a);
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
        Item request = Item.findItemByName("wood", player.getBackPack().getItems());
        int rate = 1;
        if (player.getFriendshipsNPC().get(App.getCurrentGame().getNPCs().get(4)) == 2) {
            rate = 2;
        }

        if (request == null) {
            return "You don't have wood!";
        } else {
            if (request.getCount() < 1000) {
                return "You need at least 1000 wood!";
            } else if (request.getCount() == 1000) {
                player.getBackPack().getItems().remove(request);
            } else {
                request.setCount(request.getCount() - 1000);
            }

            int count = 25000 * rate;
            player.setMoney(player.getMoney() + count);

            this.setQuest3(true);
            for (Player player1 : App.getCurrentGame().getPlayers()) {
                Integer a = 3;
                player1.getActivatedQuestNPC().get(App.getCurrentGame().getNPCs().get(4)).remove(a);
            }

            return "You have successfully completed the quest!";
        }
    }


    @Override
    public String talk() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        NPC npc = App.getCurrentGame().getNPCs().get(4);
        int friendship = player.getFriendshipsNPC().get(npc) / 200;
        Weather weather = App.getCurrentGame().getCurrentWeather();

        if (friendship == 0) {
            switch (weather) {
                case SUNNY:
                    return "Perfect day for construction.";
                case RAIN:
                    return "Rain slows down my projects. Bummer.";
                case SNOW:
                    return "Snow means I have to work indoors all day.";
                case STORM:
                    return "Can’t work in this storm. Tools keep shorting out.";
            }
        } else if (friendship == 1) {
            switch (weather) {
                case SUNNY:
                    return "Sunny days put me in a good mood to build!";
                case RAIN:
                    return "I guess I can catch up on blueprints today.";
                case SNOW:
                    return "Winter’s a good time to get creative with interiors.";
                case STORM:
                    return "This storm’s wild. Be careful out there.";
            }
        } else if (friendship >= 2) {
            switch (weather) {
                case SUNNY:
                    return "You bring the sunshine with you, even on sunny days.";
                case RAIN:
                    return "Come help me in the workshop while the rain falls.";
                case SNOW:
                    return "Let’s drink cocoa and talk project ideas!";
                case STORM:
                    return "Let’s just ride this storm out together, alright?";
            }
        }

        return "";
    }

    @Override
    public void showDialog(SpriteBatch batch, BitmapFont font, Camera camera) {
        batch.draw(GameAssetManager.assetManager.get(GameAssetManager.chatBox), camera.position.x - Gdx.graphics.getWidth() / 3.8f,
            camera.position.y - Gdx.graphics.getHeight() / 2.2f,this.getRectangle().width * 60,this.getRectangle().height * 8f);
        font.draw(batch,"Robin: " + talk(), camera.position.x - Gdx.graphics.getWidth() / 4.2f, camera.position.y - Gdx.graphics.getHeight() / 4f);
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
        if (Robin.reactionTimer > 0) {
            batch.draw(reactionTexture, x, y + 70, 40 , 40);
        }
    }
}
