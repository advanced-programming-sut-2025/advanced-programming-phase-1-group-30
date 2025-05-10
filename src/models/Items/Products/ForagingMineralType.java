package models.Items.Products;

public enum ForagingMineralType {
    QUARTZ("quartz","A clear crystal commonly found in caves and mines.", 25,3),
    EARTH_CRYSTAL("earth crystal","A resinous substance found near the surface.", 50,3),
    FROZEN_TEAR("frozen tear","A crystal fabled to be the frozen tears of a yeti.", 75,3),
    FIRE_QUARTZ("fire quartz","A glowing red crystal commonly found near hot lava.", 100,3),
    EMERALD("emerald","A precious stone with a brilliant green color.", 250,3),
    AQUAMARINE("aquamarine","A shimmery blue-green gem.", 180,3),
    RUBY("ruby","A precious stone that is sought after for its rich color and beautiful luster.", 250,3),
    AMETHYST("amethyst","A purple variant of quartz.", 100,3),
    TOPAZ("topaz","Fairly common but still prized for its beauty.", 80,3),
    JADE("jade","A pale green ornamental stone.", 200,3),
    DIAMOND("diamond","A rare and valuable gem.", 750,3),
    PRISMATIC_SHARED("prismatic shared","A very rare and powerful substance with unknown origins.", 2_000,3),
    COPPER("copper ore","A common ore that can be smelted into bars.", 5,1),
    IRON("iron ore","A fairly common ore that can be smelted into bars.", 10,2),
    GOLD("gold ore","A precious ore that can be smelted into bars.", 25,3),
    IRIDIUM("iridium ore","An exotic ore with many curious properties. Can be smelted into bars.", 100,4),
    COAL("coal","A combustible rock that is useful for crafting and smelting.",15,0),
    Stone("stone","A common material with many uses in crafting and building.",5,0);

    private final String name;
    private final String description;
    private final int baseSellPrice;
    private final int mineralLevel;

    ForagingMineralType(String name, String description, int baseSellPrice, int mineralLevel) {
        this.name = name;
        this.description = description;
        this.baseSellPrice = baseSellPrice;
        this.mineralLevel = mineralLevel;
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
}
