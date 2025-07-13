package AP.group30.StardewValley.models.Items;

import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Products.ForagingSeedType;
import AP.group30.StardewValley.models.Items.Products.FruitType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.Texture;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public enum ItemTexture {

    WOOD(GameAssetManager.assetManager.get(GameAssetManager.wood)),
    STONE(GameAssetManager.assetManager.get(GameAssetManager.stones)),

    APRICOT_TREE(GameAssetManager.assetManager.get(GameAssetManager.apricot_tree)),
    CHERRY_TREE(GameAssetManager.assetManager.get(GameAssetManager.cherry_tree)),
    BANANA_TREE(GameAssetManager.assetManager.get(GameAssetManager.banana_tree)),
    MANGO_TREE(GameAssetManager.assetManager.get(GameAssetManager.mango_tree)),
    ORANGE_TREE(GameAssetManager.assetManager.get(GameAssetManager.orange_tree)),
    PEACH_TREE(GameAssetManager.assetManager.get(GameAssetManager.peach_tree)),
    APPLE_TREE(GameAssetManager.assetManager.get(GameAssetManager.apple_tree)),
    POMEGRANATE_TREE(GameAssetManager.assetManager.get(GameAssetManager.pomegranate_tree)),
    OAK_TREE(GameAssetManager.assetManager.get(GameAssetManager.oak_tree)),
    MAPLE_TREE(GameAssetManager.assetManager.get(GameAssetManager.maple_tree)),
    PINE_TREE(GameAssetManager.assetManager.get(GameAssetManager.pine_tree)),
    MAHOGANY_TREE(GameAssetManager.assetManager.get(GameAssetManager.mahogany_tree)),
    MUSHROOM_TREE(GameAssetManager.assetManager.get(GameAssetManager.mushroom_tree)),
    TREE(GameAssetManager.assetManager.get(GameAssetManager.tree)),
    WILD_TREE(GameAssetManager.assetManager.get(GameAssetManager.wild_tree)),
    MYSTIC_TREE(GameAssetManager.assetManager.get(GameAssetManager.mystic_tree)),
    AXE(GameAssetManager.assetManager.get(GameAssetManager.axe)),
    PICKAXE(GameAssetManager.assetManager.get(GameAssetManager.pickaxe)),
    SCYTHE(GameAssetManager.assetManager.get(GameAssetManager.scythe)),
    HOE(GameAssetManager.assetManager.get(GameAssetManager.hoe)),
    WATERING_CAN(GameAssetManager.assetManager.get(GameAssetManager.wateringCan)),
    MILK_PAIL(GameAssetManager.assetManager.get(GameAssetManager.milkPail)),
    TRASH_CAN(GameAssetManager.assetManager.get(GameAssetManager.trashCan)),

    FARMING_ICON(GameAssetManager.assetManager.get(GameAssetManager.farmingIcon)),
    FISHING_ICON(GameAssetManager.assetManager.get(GameAssetManager.fishingIcon)),
    FORAGING_ICON(GameAssetManager.assetManager.get(GameAssetManager.foragingIcon)),
    MINING_ICON(GameAssetManager.assetManager.get(GameAssetManager.miningIcon)),

    TAPPER_ICON(GameAssetManager.assetManager.get(GameAssetManager.tapperIcon)),

    FRIED_EGG(GameAssetManager.assetManager.get(GameAssetManager.friedEgg)),
    BAKED_FISH(GameAssetManager.assetManager.get(GameAssetManager.bakedFish)),
    SALAD(GameAssetManager.assetManager.get(GameAssetManager.salad)),
    OMELET(GameAssetManager.assetManager.get(GameAssetManager.omelet)),
    PUMPKIN_PIE(GameAssetManager.assetManager.get(GameAssetManager.pumpkinPie)),
    SPAGHETTI(GameAssetManager.assetManager.get(GameAssetManager.spaghetti)),
    PIZZA(GameAssetManager.assetManager.get(GameAssetManager.pizza)),
    TORTILLA(GameAssetManager.assetManager.get(GameAssetManager.tortilla)),
    MAKI_ROLL(GameAssetManager.assetManager.get(GameAssetManager.makiRoll)),
    TRIPLE_SHOT_ESPRESSO(GameAssetManager.assetManager.get(GameAssetManager.tripleShotEspresso)),
    COOKIE(GameAssetManager.assetManager.get(GameAssetManager.cookie)),
    HASH_BROWNS(GameAssetManager.assetManager.get(GameAssetManager.hashBrowns)),
    PANCAKES(GameAssetManager.assetManager.get(GameAssetManager.pancakes)),
    FRUIT_SALAD(GameAssetManager.assetManager.get(GameAssetManager.fruitSalad)),
    RED_PLATE(GameAssetManager.assetManager.get(GameAssetManager.redPlate)),
    BREAD(GameAssetManager.assetManager.get(GameAssetManager.bread)),
    SALMON_DINNER(GameAssetManager.assetManager.get(GameAssetManager.salmonDinner)),
    VEGETABLE_MEDLEY(GameAssetManager.assetManager.get(GameAssetManager.vegetableMedley)),
    FARMERS_LUNCH(GameAssetManager.assetManager.get(GameAssetManager.farmersLunch)),
    SURVIVAL_BURGER(GameAssetManager.assetManager.get(GameAssetManager.survivalBurger)),
    DISH_O_THE_SEA(GameAssetManager.assetManager.get(GameAssetManager.dishOTheSea)),
    SEAFOAM_PUDDING(GameAssetManager.assetManager.get(GameAssetManager.seafoamPudding)),
    MINERS_TREAT(GameAssetManager.assetManager.get(GameAssetManager.minersTreat)),

    // *** Buildings ***
    CARPENTER(GameAssetManager.assetManager.get(GameAssetManager.carpenter)),
    RANCH(GameAssetManager.assetManager.get(GameAssetManager.ranch)),
    SALOON(GameAssetManager.assetManager.get(GameAssetManager.saloon)),
    BLACKSMITH(GameAssetManager.assetManager.get(GameAssetManager.blacksmith)),
    PIERRES(GameAssetManager.assetManager.get(GameAssetManager.pierres)),
    JOJA(GameAssetManager.assetManager.get(GameAssetManager.jojamart)),
    FISH_SHOP(GameAssetManager.assetManager.get(GameAssetManager.fishShop)),

    // *** Crops and Seeds ***
    CARROT(GameAssetManager.assetManager.get(GameAssetManager.carrot)),
    CARROT_SEEDS(GameAssetManager.assetManager.get(GameAssetManager.carrotSeeds)),
    CARROT_STAGE_1(GameAssetManager.assetManager.get(GameAssetManager.carrotStage1)),
    CARROT_STAGE_2(GameAssetManager.assetManager.get(GameAssetManager.carrotStage2)),
    CARROT_STAGE_3(GameAssetManager.assetManager.get(GameAssetManager.carrotStage3)),
    CARROT_STAGE_4(GameAssetManager.assetManager.get(GameAssetManager.carrotStage4));

    private final Texture TEXTURE;

    ItemTexture(Texture texture) {
        this.TEXTURE = texture;
    }

    public Texture getTexture() {
        return TEXTURE;
    }
}
