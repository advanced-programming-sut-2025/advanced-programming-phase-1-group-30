package AP.group30.StardewValley.models.Items.Tools;

import AP.group30.StardewValley.models.Items.ItemTexture;
import com.badlogic.gdx.graphics.Texture;

public enum AxeType {
    NORMAL("normal axe", 5, ItemTexture.WOOD.getTexture()),
    COPPER("copper axe", 4, ItemTexture.WOOD.getTexture()),
    IRON("iron axe", 3, ItemTexture.WOOD.getTexture()),
    GOLD("gold axe", 2, ItemTexture.WOOD.getTexture()),
    IRIDIUM("iridium axe",1, ItemTexture.WOOD.getTexture());

    private final String name;
    private final int energyUsed;
    private final Texture texture;

    AxeType(String name, int energyUsed, Texture texture) {
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
