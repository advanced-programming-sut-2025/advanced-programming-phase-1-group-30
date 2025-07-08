package AP.group30.StardewValley.models.Items.Tools;

import AP.group30.StardewValley.models.Items.ItemTexture;
import com.badlogic.gdx.graphics.Texture;

public enum HoeType {
    NORMAL("normal hoe", 5, ItemTexture.HOE.getTexture()),
    COPPER("copper hoe", 4, ItemTexture.HOE.getTexture()),
    IRON("iron hoe", 3, ItemTexture.HOE.getTexture()),
    GOLD("gold hoe", 2, ItemTexture.HOE.getTexture()),
    IRIDIUM("iridium hoe", 1, ItemTexture.HOE.getTexture());

    private final String name;
    private final int energyUsed;
    private final Texture texture;

    HoeType(String name, int energyUsed, Texture texture) {
        this.name = name;
        this.energyUsed = energyUsed;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public int getEnergyUsed() {
        return energyUsed;
    }

    public Texture getTexture() {
        return texture;
    }
}
