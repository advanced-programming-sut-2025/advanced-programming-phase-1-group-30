package AP.group30.StardewValley.models.Items;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public enum ItemTexture {
    WOOD(new Texture(Gdx.files.internal("/items/wood.png")));

    private final Texture TEXTURE;

    ItemTexture(Texture texture) {
        this.TEXTURE = texture;
    }

    public Texture getTexture() {
        return TEXTURE;
    }
}
