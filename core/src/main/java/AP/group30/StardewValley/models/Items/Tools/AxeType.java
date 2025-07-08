package AP.group30.StardewValley.models.Items.Tools;

import AP.group30.StardewValley.models.Items.ItemTexture;
import com.badlogic.gdx.graphics.Texture;

public enum AxeType {
    NORMAL("normal axe", 5, ItemTexture.AXE.getTexture()),
    COPPER("copper axe", 4, ItemTexture.AXE.getTexture()),
    IRON("iron axe", 3, ItemTexture.AXE.getTexture()),
    GOLD("gold axe", 2, ItemTexture.AXE.getTexture()),
    IRIDIUM("iridium axe",1, ItemTexture.AXE.getTexture());

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
