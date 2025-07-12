package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import com.badlogic.gdx.graphics.Texture;

public enum ForagingSeedType implements ItemsInteface {
    JAZZ_SEEDS("jazz seeds", Season.SPRING, CropType.BLUE_JAZZ, null, 0, ItemTexture.WOOD.getTexture()),
    CARROT_SEEDS("carrot seeds", Season.SPRING, CropType.CARROT, null, 0, ItemTexture.WOOD.getTexture()),
    CAULIFLOWER_SEEDS("cauliflower seeds", Season.SPRING, CropType.CAULIFLOWER, null, 0, ItemTexture.WOOD.getTexture()),
    COFFEE_BEAN("coffee bean", Season.SPRING, CropType.COFFEE_BEAN, null, 0, ItemTexture.WOOD.getTexture()),
    GARLIC_SEEDS("garlic seeds", Season.SPRING, CropType.GARLIC, null, 0, ItemTexture.WOOD.getTexture()),
    BEAN_STARTER("bean starter", Season.SPRING, CropType.GREEN_BEAN, null, 0, ItemTexture.WOOD.getTexture()),
    KALE_SEEDS("kale seeds", Season.SPRING, CropType.KALE, null, 0, ItemTexture.WOOD.getTexture()),
    PARSNIP_SEEDS("parsnip seeds", Season.SPRING, CropType.PARSNIP, null, 0, ItemTexture.WOOD.getTexture()),
    POTATO_SEEDS("potato seeds", Season.SPRING, CropType.POTATO, null, 0, ItemTexture.WOOD.getTexture()),
    RHUBARB_SEEDS("rhubarb seeds", Season.SPRING, CropType.RHUBARB, null, 0, ItemTexture.WOOD.getTexture()),
    STRAWBERRY_SEEDS("strawberry seeds", Season.SPRING, CropType.STRAWBERRY, null, 0, ItemTexture.WOOD.getTexture()),
    TULIP_BULB("tulip bulb", Season.SPRING, CropType.TULIP, null, 0, ItemTexture.WOOD.getTexture()),
    RICE_SHOOT("rice shoot", Season.SPRING, CropType.UNMILLED_RICE, null, 0, ItemTexture.WOOD.getTexture()),
    BLUEBERRY_SEEDS("blueberry seeds", Season.SUMMER, CropType.BLUEBERRY, null, 0, ItemTexture.WOOD.getTexture()),
    CORN_SEEDS("corn seeds", Season.SUMMER, CropType.CORN, null, 0, ItemTexture.WOOD.getTexture()),
    HOPS_STARTER("hops starter", Season.SUMMER, CropType.HOPS, null, 0, ItemTexture.WOOD.getTexture()),
    PEPPER_SEEDS("pepper seeds", Season.SUMMER, CropType.HOT_PEPPER, null, 0, ItemTexture.WOOD.getTexture()),
    MELON_SEEDS("melon seeds", Season.SUMMER, CropType.MELON, null, 0, ItemTexture.WOOD.getTexture()),
    POPPY_SEEDS("poppy seeds", Season.SUMMER, CropType.POPPY, null, 0, ItemTexture.WOOD.getTexture()),
    RADISH_SEEDS("radish seeds", Season.SUMMER, CropType.RADISH, null, 0, ItemTexture.WOOD.getTexture()),
    RED_CABBAGE_SEEDS("red cabbage seeds", Season.SUMMER, CropType.RED_CABBAGE, null, 0, ItemTexture.WOOD.getTexture()),
    STARFRUIT_SEEDS("starfruit seeds", Season.SUMMER, CropType.STARFRUIT, null, 0, ItemTexture.WOOD.getTexture()),
    SPANGLE_SEEDS("spangle seeds", Season.SUMMER, CropType.SUMMER_SPANGLE, null, 0, ItemTexture.WOOD.getTexture()),
    SUMMER_SQUASH_SEEDS("summer squash seeds", Season.SUMMER, CropType.SUMMER_SQUASH, null, 0, ItemTexture.WOOD.getTexture()),
    SUNFLOWER_SEEDS("sunflower seeds", Season.SUMMER, CropType.SUNFLOWER, null, 0, ItemTexture.WOOD.getTexture()),
    TOMATO_SEEDS("tomato seeds", Season.SUMMER, CropType.TOMATO, null, 0, ItemTexture.WOOD.getTexture()),
    WHEAT_SEEDS("wheat seeds", Season.SUMMER, CropType.WHEAT, null, 0, ItemTexture.WOOD.getTexture()),
    AMARANTH_SEEDS("amaranth seeds", Season.FALL, CropType.AMARANTH, null, 0, ItemTexture.WOOD.getTexture()),
    ARTICHOKE_SEEDS("artichoke seeds", Season.FALL, CropType.ARTICHOKE, null, 0, ItemTexture.WOOD.getTexture()),
    BEET_SEEDS("beet seeds", Season.FALL, CropType.BEET, null, 0, ItemTexture.WOOD.getTexture()),
    BOK_CHOY_SEEDS("bok choy seeds", Season.FALL, CropType.BOK_CHOY, null, 0, ItemTexture.WOOD.getTexture()),
    BROCCOLI_SEEDS("broccoli seeds", Season.FALL, CropType.BROCCOLI, null, 0, ItemTexture.WOOD.getTexture()),
    CRANBERRY_SEEDS("cranberry seeds", Season.FALL, CropType.CRANBERRIES, null, 0, ItemTexture.WOOD.getTexture()),
    EGGPLANT_SEEDS("eggplant seeds", Season.FALL, CropType.EGGPLANT, null, 0, ItemTexture.WOOD.getTexture()),
    FAIRY_SEEDS("fairy seeds", Season.FALL, CropType.FAIRY_ROSE, null, 0, ItemTexture.WOOD.getTexture()),
    GRAPE_STARTER("grape starter", Season.FALL, CropType.GRAPE, null, 0, ItemTexture.WOOD.getTexture()),
    PUMPKIN_SEEDS("pumpkin seeds", Season.FALL, CropType.PUMPKIN, null, 0, ItemTexture.WOOD.getTexture()),
    YAM_SEEDS("yam seeds", Season.FALL, CropType.YAM, null, 0, ItemTexture.WOOD.getTexture()),
    RARE_SEED("rare seed", Season.FALL, CropType.SWEET_GEM_BERRY, null, 0, ItemTexture.WOOD.getTexture()),
    POWDERMELON_SEEDS("powdermelon seeds", Season.WINTER, CropType.POWDERMELON, null, 0, ItemTexture.WOOD.getTexture()),
    ANCIENT_SEEDS("ancient seeds", Season.ALL, CropType.ANCIENT_FRUIT, null, 0, ItemTexture.WOOD.getTexture()),
    MIXED_SEEDS("mixed seeds", Season.ALL, CropType.ANCIENT_FRUIT, null, 0, ItemTexture.WOOD.getTexture()), // TODO

    APRICOT_SAPLING("apricot sapling", Season.SPRING, CropType.APRICOT, FruitType.APRICOT, 1, ItemTexture.WOOD.getTexture()),
    CHERRY_SAPLING("cherry sapling", Season.SPRING, CropType.CHERRY, FruitType.CHERRY, 1, ItemTexture.WOOD.getTexture()),
    BANANA_SAPLING("banana sapling", Season.SUMMER, CropType.BANANA, FruitType.BANANA, 1, ItemTexture.WOOD.getTexture()),
    MANGO_SAPLING("mango sapling", Season.SUMMER, CropType.MANGO, FruitType.MANGO, 1, ItemTexture.WOOD.getTexture()),
    ORANGE_SAPLING("orange sapling", Season.SUMMER, CropType.ORANGE, FruitType.ORANGE, 1, ItemTexture.WOOD.getTexture()),
    PEACH_SAPLING("peach sapling", Season.SUMMER, CropType.PEACH, FruitType.PEACH, 1, ItemTexture.WOOD.getTexture()),
    APPLE_SAPLING("apple sapling", Season.FALL, CropType.APPLE, FruitType.APPLE, 1, ItemTexture.WOOD.getTexture()),
    POMEGRANATE_SAPLING("pomegranate sapling", Season.FALL, CropType.POMEGRANATE, FruitType.POMEGRANATE, 1, ItemTexture.WOOD.getTexture()),
    OAK_TREE("acorns", Season.ALL, CropType.OAK_RESIN, FruitType.OAK_RESIN,1, ItemTexture.WOOD.getTexture()),
    MAPLE_SEEDS("maple seeds", Season.ALL, CropType.MAPLE_SYRUP, FruitType.MAPLE_SYRUP, 1, ItemTexture.WOOD.getTexture()),
    PINE_CONES("pine cones", Season.ALL, CropType.PINE_TAR, FruitType.PINE_TAR, 1, ItemTexture.WOOD.getTexture()),
    MAHOGANY_SEEDS("mahogany seeds", Season.ALL, CropType.SAP, FruitType.SAP, 1, ItemTexture.WOOD.getTexture()),
    MUSHROOM_TREE_SEEDS("mushroom tree seeds", Season.ALL, CropType.COMMON_MUSHROOM, FruitType.COMMON_MUSHROOM, 1, ItemTexture.WOOD.getTexture()),
    MYSTIC_TREE_SEEDS("mystic tree seeds", Season.ALL, CropType.MAPLE_SYRUP, FruitType.MAPLE_SYRUP, 1, ItemTexture.WOOD.getTexture());

    private final String name;
    private final Season season;
    private final CropType crop;
    private final FruitType fruit;
    private final int treeOrCrop; // 0 for crop, 1 for tree
    private final Texture texture;


    private ForagingSeedType(String name, Season season, CropType crop, FruitType fruit, int treeOrCrop, Texture texture) {
        this.name = name;
        this.season = season;
        this.crop = crop;
        this.fruit = fruit;
        this.treeOrCrop = treeOrCrop;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }
    public Season getSeason() {
        return season;
    }
    public CropType getCrop() {
        return crop;
    }

    public FruitType getFruit() {
        return fruit;
    }

    public int getTreeOrCrop() {
        return treeOrCrop;
    }
    public Texture getTexture() {
        return texture;
    }
    public int getPrice() {
        return 20;
    }
}
