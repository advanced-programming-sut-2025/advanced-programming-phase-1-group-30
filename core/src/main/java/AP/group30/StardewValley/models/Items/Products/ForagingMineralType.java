package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import com.badlogic.gdx.graphics.Texture;

public enum ForagingMineralType implements ItemsInteface {
    QUARTZ("quartz","A clear crystal commonly found in caves and mines.", 25,3, ItemTexture.WOOD.getTexture()),
    EARTH_CRYSTAL("earth crystal","A resinous substance found near the surface.", 50,3, ItemTexture.WOOD.getTexture()),
    FROZEN_TEAR("frozen tear","A crystal fabled to be the frozen tears of a yeti.", 75,3, ItemTexture.WOOD.getTexture()),
    FIRE_QUARTZ("fire quartz","A glowing red crystal commonly found near hot lava.", 100,3, ItemTexture.WOOD.getTexture()),
    EMERALD("emerald","A precious stone with a brilliant green color.", 250,3, ItemTexture.WOOD.getTexture()),
    AQUAMARINE("aquamarine","A shimmery blue-green gem.", 180,3, ItemTexture.WOOD.getTexture()),
    RUBY("ruby","A precious stone that is sought after for its rich color and beautiful luster.", 250,3, ItemTexture.WOOD.getTexture()),
    AMETHYST("amethyst","A purple variant of quartz.", 100,3, ItemTexture.WOOD.getTexture()),
    TOPAZ("topaz","Fairly common but still prized for its beauty.", 80,3, ItemTexture.WOOD.getTexture()),
    JADE("jade","A pale green ornamental stone.", 200,3, ItemTexture.WOOD.getTexture()),
    DIAMOND("diamond","A rare and valuable gem.", 750,3, ItemTexture.WOOD.getTexture()),
    PRISMATIC_SHARED("prismatic shared","A very rare and powerful substance with unknown origins.", 2_000,3, ItemTexture.WOOD.getTexture()),
    COPPER("copper ore","A common ore that can be smelted into bars.", 5,1, ItemTexture.WOOD.getTexture()),
    IRON("iron ore","A fairly common ore that can be smelted into bars.", 10,2, ItemTexture.WOOD.getTexture()),
    GOLD("gold ore","A precious ore that can be smelted into bars.", 25,3, ItemTexture.WOOD.getTexture()),
    IRIDIUM("iridium ore","An exotic ore with many curious properties. Can be smelted into bars.", 100,4, ItemTexture.WOOD.getTexture()),
    COAL("coal","A combustible rock that is useful for crafting and smelting.",15,0, ItemTexture.WOOD.getTexture()),
    STONE("stone","A common material with many uses in crafting and building.",5,0, ItemTexture.WOOD.getTexture());


    private final String name;
    private final String description;
    private final int baseSellPrice;
    private final int mineralLevel;
    private final Texture texture;

    ForagingMineralType(String name, String description, int baseSellPrice, int mineralLevel, Texture texture) {
        this.name = name;
        this.description = description;
        this.baseSellPrice = baseSellPrice;
        this.mineralLevel = mineralLevel;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getBaseSellPrice() {
        return baseSellPrice;
    }

    public int getMineralLevel() {
        return mineralLevel;
    }

    public Texture getTexture() {
        return texture;
    }
}
