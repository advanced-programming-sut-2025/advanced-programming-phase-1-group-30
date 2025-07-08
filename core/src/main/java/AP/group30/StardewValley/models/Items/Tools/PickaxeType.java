package AP.group30.StardewValley.models.Items.Tools;

import AP.group30.StardewValley.models.Items.ItemTexture;
import com.badlogic.gdx.graphics.Texture;

public enum PickaxeType {
    NORMAL("normal pickaxe",5,0, ItemTexture.PICKAXE.getTexture()),
    COPPER("copper pickaxe", 4,1, ItemTexture.PICKAXE.getTexture()),
    IRON("iron pickaxe", 3,2, ItemTexture.PICKAXE.getTexture()),
    GOLD("gold pickaxe", 2,3, ItemTexture.PICKAXE.getTexture()),
    IRIDIUM("iridium pickaxe", 1,4, ItemTexture.PICKAXE.getTexture());

    private final String name;
    private final int energyUsed;
    private final int level;
    private final Texture texture;

     PickaxeType(String name, int energyUsed, int level, Texture texture) {
        this.name = name;
        this.energyUsed = energyUsed;
        this.level = level;
         this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public int getEnergyUsed() {
        return energyUsed;
    }

    public int getLevel() {
         return level;
    }

    public Texture getTexture() {
        return texture;
    }
}
