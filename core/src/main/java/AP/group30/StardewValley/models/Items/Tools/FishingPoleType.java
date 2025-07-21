package AP.group30.StardewValley.models.Items.Tools;

import AP.group30.StardewValley.models.Items.ItemTexture;
import com.badlogic.gdx.graphics.Texture;

public enum FishingPoleType {
    TRAINING_POLE("Training Pole", 8, 0.1, ItemTexture.TRAINING_POLE.getTexture()),
    BAMBOO_POLE("Bamboo Pole", 8, 0.5, ItemTexture.BAMBOO_POLE.getTexture()),
    FIBERGLASS_POLE("Fiberglass Pole", 6, 0.9, ItemTexture.FIBERGLASS_POLE.getTexture()),
    IRIDIUM_POLE("Iridium Pole", 4, 1.2, ItemTexture.IRIDIUM_POLE.getTexture());

    private final String name;
    private final int energyUsed;
    private final double pole;
    private final Texture texture;

    private FishingPoleType(String name, int energyUsed, double pole, Texture texture) {
        this.name = name;
        this.energyUsed = energyUsed;
        this.pole = pole;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public int getEnergyUsed() {
        return energyUsed;
    }

    public double getPole() {
        return pole;
    }

    public Texture getTexture() {
        return texture;
    }
}
