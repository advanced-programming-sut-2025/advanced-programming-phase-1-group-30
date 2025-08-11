package AP.group30.StardewValley.models.Players;

import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.GameObjects;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class RemotePlayer implements GameObjects {
    public Texture region;
    public final String id;
    public final String username;
    public float x, y;
    private Texture reactionTexture;
    private float reactionTime = 0f;
    private String chat = null;

    public RemotePlayer(String id, String username, float x, float y) {
        this.id = id; this.x = x; this.y = y; this.username = username;
        region = GameAssetManager.assetManager.get(GameAssetManager.player00);
    }

    @Override
    public int getRenderY() {
        return (int)y;
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.draw(region, x, y, region.getWidth() * 2f , region.getHeight() * 2f);
    }

    public void renderReaction(SpriteBatch batch) {
        if (chat != null) {
            batch.draw(reactionTexture, x, y + 70, chat.length() * 15 + 50, 60);
            BitmapFont font = GameAssetManager.assetManager.get(GameAssetManager.skin).getFont("font");
            font.draw(batch, chat, x + 25, y + 115);
        } else {
            batch.draw(reactionTexture, x, y + 70, 40 , 40);
        }
    }

    public void setReactionTexture(Texture reactionTexture) {
        this.reactionTexture = reactionTexture;
    }

    public void setReactionTime(float reactionTime) {
        this.reactionTime = reactionTime;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public float getReactionTime() {
        return reactionTime;
    }

    public void decreaseReactionTimer(float delta) {
        this.reactionTime -= delta;
    }
}
