package AP.group30.StardewValley.models.Items.Tools;

import AP.group30.StardewValley.models.Items.ItemTexture;
import com.badlogic.gdx.graphics.Texture;

public enum BasketType {
    NORMAL("normal watering can",0,40, ItemTexture.WATERING_CAN.getTexture()),
    COPPER("copper watering can",1,55, ItemTexture.WATERING_CAN.getTexture()),
    IRON("iron watering can",2,70, ItemTexture.WATERING_CAN.getTexture()),
    GOLD("gold watering can",3,85, ItemTexture.WATERING_CAN.getTexture()),
    IRIDIUM("iridium watering can",4,100, ItemTexture.WATERING_CAN.getTexture());

    private final String name;
    private final int energyUsed;
    private final int capacity;
    private final Texture texture;

    BasketType(String name, int energyUsed, int capacity, Texture texture) {
        this.name = name;
        this.energyUsed = energyUsed;
        this.capacity = capacity;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getEnergyUsed() {
        return energyUsed;
    }

    public Texture getTexture() {
        return texture;
    }
}
