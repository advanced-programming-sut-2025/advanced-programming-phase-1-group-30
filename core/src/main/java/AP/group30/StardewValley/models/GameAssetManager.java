package AP.group30.StardewValley.models;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

public class GameAssetManager {
    public static AssetManager assetManager = new AssetManager();
    public static final AssetDescriptor<Texture> background = new AssetDescriptor<>("menu assets/loading screen.png", Texture.class);
    public static final AssetDescriptor<Texture> blackBackground = new AssetDescriptor<>("menu assets/Black.png", Texture.class);

    public static final AssetDescriptor<Texture> inventoryScreen = new AssetDescriptor<>("Inventory/Inventory.png", Texture.class);
    public static final AssetDescriptor<Texture> inventoryItem = new AssetDescriptor<>("Inventory/Inventory_Item.png", Texture.class);

    public static final AssetDescriptor<Texture> skill = new AssetDescriptor<>("Skill/Skill.png", Texture.class);
    public static final AssetDescriptor<Texture> farmingIcon = new AssetDescriptor<>("Skill/Farming_Skill_Icon.png", Texture.class);
    public static final AssetDescriptor<Texture> fishingIcon = new AssetDescriptor<>("Skill/Fishing_Skill_Icon.png", Texture.class);
    public static final AssetDescriptor<Texture> foragingIcon = new AssetDescriptor<>("Skill/Foraging_Skill_Icon.png", Texture.class);
    public static final AssetDescriptor<Texture> miningIcon = new AssetDescriptor<>("Skill/Mining_Skill_Icon.png", Texture.class);
    public static final AssetDescriptor<Texture> playerInfo = new AssetDescriptor<>("Skill/playerInfo.png", Texture.class);
    public static final AssetDescriptor<Texture> tapperIcon = new AssetDescriptor<>("Skill/Tapper_Icon.png", Texture.class);

    public static final AssetDescriptor<Texture> energyBar = new AssetDescriptor<>("EnergyBar/energy_bar.png", Texture.class);
    public static final AssetDescriptor<Texture> nightBackground = new AssetDescriptor<>("menu assets/sebastianRideTiles.png", Texture.class);
    public static final AssetDescriptor<Skin> menuSkin = new AssetDescriptor<>("skin/pixthulhu-ui.json", Skin.class);
    public static final AssetDescriptor<Texture> grass = new AssetDescriptor<>("tile/grass.png", Texture.class);
    public static final AssetDescriptor<Texture> winterGrass = new AssetDescriptor<>("tile/winter_grass.png", Texture.class);
    public static final AssetDescriptor<Texture> dirt = new AssetDescriptor<>("tile/dirt.png", Texture.class);

    public static final AssetDescriptor<Texture> player00 = new AssetDescriptor<>("player/00.png", Texture.class);
    public static final AssetDescriptor<Texture> player01 = new AssetDescriptor<>("player/01.png", Texture.class);
    public static final AssetDescriptor<Texture> player02 = new AssetDescriptor<>("player/02.png", Texture.class);
    public static final AssetDescriptor<Texture> player03 = new AssetDescriptor<>("player/03.png", Texture.class);
    public static final AssetDescriptor<Texture> player10 = new AssetDescriptor<>("player/10.png", Texture.class);
    public static final AssetDescriptor<Texture> player11 = new AssetDescriptor<>("player/11.png", Texture.class);
    public static final AssetDescriptor<Texture> player12 = new AssetDescriptor<>("player/12.png", Texture.class);
    public static final AssetDescriptor<Texture> player13 = new AssetDescriptor<>("player/13.png", Texture.class);
    public static final AssetDescriptor<Texture> player20 = new AssetDescriptor<>("player/20.png", Texture.class);
    public static final AssetDescriptor<Texture> player21 = new AssetDescriptor<>("player/21.png", Texture.class);
    public static final AssetDescriptor<Texture> player22 = new AssetDescriptor<>("player/22.png", Texture.class);
    public static final AssetDescriptor<Texture> player23 = new AssetDescriptor<>("player/23.png", Texture.class);
    public static final AssetDescriptor<Texture> dirt2 = new AssetDescriptor<>("tile/dirt2.png", Texture.class);
    public static final AssetDescriptor<Texture> dirt3 = new AssetDescriptor<>("tile/dirt3.png", Texture.class);
    public static final AssetDescriptor<Texture> dirt4 = new AssetDescriptor<>("tile/dirt4.png", Texture.class);
    public static final AssetDescriptor<Texture> winterDirt2 = new AssetDescriptor<>("tile/winter_dirt2.png", Texture.class);
    public static final AssetDescriptor<Texture> winterDirt3 = new AssetDescriptor<>("tile/winter_dirt3.png", Texture.class);
    public static final AssetDescriptor<Texture> winterDirt = new AssetDescriptor<>("tile/winter_dirt.png", Texture.class);

    public static final AssetDescriptor<Texture> insideHouse = new AssetDescriptor<>("Building/InsideHut.png", Texture.class);

    public static final AssetDescriptor<Texture> river = new AssetDescriptor<>("tile/river.png", Texture.class);
    public static final AssetDescriptor<Texture> leftWall = new AssetDescriptor<>("tile/wall/leftWall.png", Texture.class);
    public static final AssetDescriptor<Texture> rightWall = new AssetDescriptor<>("tile/wall/rightWall.png", Texture.class);
    public static final AssetDescriptor<Texture> upWall = new AssetDescriptor<>("tile/wall/upWall.png", Texture.class);
    public static final AssetDescriptor<Texture> downWall = new AssetDescriptor<>("tile/wall/downWall.png", Texture.class);
    public static final AssetDescriptor<Texture> cornerWall1 = new AssetDescriptor<>("tile/wall/corner1Wall.png", Texture.class);
    public static final AssetDescriptor<Texture> cornerWall2 = new AssetDescriptor<>("tile/wall/corner2Wall.png", Texture.class);
    public static final AssetDescriptor<Texture> outdoorGrass1 = new AssetDescriptor<>("tile/wall/outdoorGrass1.png", Texture.class);
    public static final AssetDescriptor<Texture> outdoorGrass2 = new AssetDescriptor<>("tile/wall/outdoorGrass2.png", Texture.class);
    public static final AssetDescriptor<Texture> outdoorGrass3 = new AssetDescriptor<>("tile/wall/outdoorGrass3.png", Texture.class);
    public static final AssetDescriptor<Texture> outdoorGrass4 = new AssetDescriptor<>("tile/wall/outdoorGrass4.png", Texture.class);
    public static final AssetDescriptor<Texture> plantable = new AssetDescriptor<>("tile/plantable.png", Texture.class);
    public static final AssetDescriptor<Texture> wateredTile = new AssetDescriptor<>("tile/watered_tile.png", Texture.class);
    public static final AssetDescriptor<Texture> clock = new AssetDescriptor<>("Stardew_Valley_Images/Clock/Clock.png", Texture.class);

    public static final AssetDescriptor<Texture> axe = new AssetDescriptor<>("Tools/Axe/Axe.png", Texture.class);
    public static final AssetDescriptor<Texture> pickaxe = new AssetDescriptor<>("Tools/Pickaxe/Pickaxe.png", Texture.class);
    public static final AssetDescriptor<Texture> scythe = new AssetDescriptor<>("Tools/Scythe/Scythe.png", Texture.class);
    public static final AssetDescriptor<Texture> hoe = new AssetDescriptor<>("Tools/Hoe/Hoe.png", Texture.class);
    public static final AssetDescriptor<Texture> wateringCan = new AssetDescriptor<>("Tools/Watering_Can/Watering_Can.png", Texture.class);
    public static final AssetDescriptor<Texture> milkPail = new AssetDescriptor<>("Tools/Milk_Pail/Milk_Pail.png", Texture.class);
    public static final AssetDescriptor<Texture> trashCan = new AssetDescriptor<>("Tools/Trash_Can/Trash_Can_Copper.png", Texture.class);

    public static final AssetDescriptor<Texture> wood = new AssetDescriptor<>("item/resource/Wood.png", Texture.class);
    public static final AssetDescriptor<Texture> stone = new AssetDescriptor<>("item/resource/Stone.png", Texture.class);
    public static final AssetDescriptor<Texture> stones = new AssetDescriptor<>("item/resource/Stones.png", Texture.class);

    public static final AssetDescriptor<Texture> tree = new AssetDescriptor<>("tree/tree.png", Texture.class);
    public static final AssetDescriptor<Texture> apricot_tree = new AssetDescriptor<>("tree/Apricot.png", Texture.class);
    public static final AssetDescriptor<Texture> cherry_tree = new AssetDescriptor<>("tree/Cherry.png", Texture.class);
    public static final AssetDescriptor<Texture> banana_tree = new AssetDescriptor<>("tree/Banana.png", Texture.class);
    public static final AssetDescriptor<Texture> mango_tree = new AssetDescriptor<>("tree/Mango.png", Texture.class);
    public static final AssetDescriptor<Texture> orange_tree = new AssetDescriptor<>("tree/Orange.png", Texture.class);
    public static final AssetDescriptor<Texture> peach_tree = new AssetDescriptor<>("tree/Peach.png", Texture.class);
    public static final AssetDescriptor<Texture> apple_tree = new AssetDescriptor<>("tree/Apple.png", Texture.class);
    public static final AssetDescriptor<Texture> pomegranate_tree = new AssetDescriptor<>("tree/Pomegranate.png", Texture.class);
    public static final AssetDescriptor<Texture> oak_tree = new AssetDescriptor<>("tree/Oak.png", Texture.class);
    public static final AssetDescriptor<Texture> maple_tree = new AssetDescriptor<>("tree/Maple.png", Texture.class);
    public static final AssetDescriptor<Texture> pine_tree = new AssetDescriptor<>("tree/Pine.png", Texture.class);
    public static final AssetDescriptor<Texture> mahogany_tree = new AssetDescriptor<>("tree/Mahogany.png", Texture.class);
    public static final AssetDescriptor<Texture> mushroom_tree = new AssetDescriptor<>("tree/Mushroom.png", Texture.class);
    public static final AssetDescriptor<Texture> wild_tree = new AssetDescriptor<>("tree/Wild.png", Texture.class);
    public static final AssetDescriptor<Texture> mystic_tree = new AssetDescriptor<>("tree/Mystic.png", Texture.class);

    public static final AssetDescriptor<Texture> refrigerator = new AssetDescriptor<>("Inventory/Refrigerator.png", Texture.class);

    public static final AssetDescriptor<Texture> friedEgg = new AssetDescriptor<>("item/FoodType/Fried_Egg.png", Texture.class);
    public static final AssetDescriptor<Texture> bakedFish = new AssetDescriptor<>("item/FoodType/Baked_Fish.png", Texture.class);
    public static final AssetDescriptor<Texture> salad = new AssetDescriptor<>("item/FoodType/Salad.png", Texture.class);
    public static final AssetDescriptor<Texture> omelet = new AssetDescriptor<>("item/FoodType/Omelet.png", Texture.class);
    public static final AssetDescriptor<Texture> pumpkinPie = new AssetDescriptor<>("item/FoodType/Pumpkin_Pie.png", Texture.class);
    public static final AssetDescriptor<Texture> spaghetti = new AssetDescriptor<>("item/FoodType/Spaghetti.png", Texture.class);
    public static final AssetDescriptor<Texture> pizza = new AssetDescriptor<>("item/FoodType/Pizza.png", Texture.class);
    public static final AssetDescriptor<Texture> tortilla = new AssetDescriptor<>("item/FoodType/Tortilla.png", Texture.class);
    public static final AssetDescriptor<Texture> makiRoll = new AssetDescriptor<>("item/FoodType/Maki_Roll.png", Texture.class);
    public static final AssetDescriptor<Texture> tripleShotEspresso = new AssetDescriptor<>("item/FoodType/Triple_Shot_Espresso.png", Texture.class);
    public static final AssetDescriptor<Texture> cookie = new AssetDescriptor<>("item/FoodType/Cookie.png", Texture.class);
    public static final AssetDescriptor<Texture> hashBrowns = new AssetDescriptor<>("item/FoodType/Hashbrowns.png", Texture.class);
    public static final AssetDescriptor<Texture> pancakes = new AssetDescriptor<>("item/FoodType/Pancakes.png", Texture.class);
    public static final AssetDescriptor<Texture> fruitSalad = new AssetDescriptor<>("item/FoodType/Fruit_Salad.png", Texture.class);
    public static final AssetDescriptor<Texture> redPlate = new AssetDescriptor<>("item/FoodType/Red_Plate.png", Texture.class);
    public static final AssetDescriptor<Texture> bread = new AssetDescriptor<>("item/FoodType/Bread.png", Texture.class);
    public static final AssetDescriptor<Texture> salmonDinner = new AssetDescriptor<>("item/FoodType/Salmon_Dinner.png", Texture.class);
    public static final AssetDescriptor<Texture> vegetableMedley = new AssetDescriptor<>("item/FoodType/Vegetable_Medley.png", Texture.class);
    public static final AssetDescriptor<Texture> farmersLunch = new AssetDescriptor<>("item/FoodType/Farmer's_Lunch.png", Texture.class);
    public static final AssetDescriptor<Texture> survivalBurger = new AssetDescriptor<>("item/FoodType/Survival_Burger.png", Texture.class);
    public static final AssetDescriptor<Texture> dishOTheSea = new AssetDescriptor<>("item/FoodType/Dish_O_The_Sea.png", Texture.class);
    public static final AssetDescriptor<Texture> seafoamPudding = new AssetDescriptor<>("item/FoodType/Seafoam_Pudding.png", Texture.class);
    public static final AssetDescriptor<Texture> minersTreat = new AssetDescriptor<>("item/FoodType/Miner's_Treat.png", Texture.class);

    // *** Buildings ***
    public static final AssetDescriptor<Texture> carpenter = new AssetDescriptor<>("buildings/Carpenter's_Shop.png", Texture.class);
    public static final AssetDescriptor<Texture> fishShop = new AssetDescriptor<>("buildings/Fish_Shop.png", Texture.class);
    public static final AssetDescriptor<Texture> jojamart = new AssetDescriptor<>("buildings/Jojamart.png", Texture.class);
    public static final AssetDescriptor<Texture> pierres = new AssetDescriptor<>("buildings/Pierres_shop.png", Texture.class);
    public static final AssetDescriptor<Texture> ranch = new AssetDescriptor<>("buildings/Ranch.png", Texture.class);
    public static final AssetDescriptor<Texture> saloon = new AssetDescriptor<>("buildings/Saloon.png", Texture.class);
    public static final AssetDescriptor<Texture> blacksmith = new AssetDescriptor<>("buildings/BlackSmith.png", Texture.class);
    public static final AssetDescriptor<Texture> house = new AssetDescriptor<>("buildings/Hut.png", Texture.class);
    public static final AssetDescriptor<Texture> ruinedGreenhouse = new AssetDescriptor<>("buildings/ruined_greenhouse.png", Texture.class);
    public static final AssetDescriptor<Texture> barn = new AssetDescriptor<>("buildings/Barn.png", Texture.class);
    public static final AssetDescriptor<Texture> bigBarn = new AssetDescriptor<>("buildings/Big_Barn.png", Texture.class);
    public static final AssetDescriptor<Texture> deluxeBarn = new AssetDescriptor<>("buildings/Deluxe_Barn.png", Texture.class);
    public static final AssetDescriptor<Texture> coop = new AssetDescriptor<>("buildings/Coop.png", Texture.class);
    public static final AssetDescriptor<Texture> bigCoop = new AssetDescriptor<>("buildings/Big_Coop.png", Texture.class);
    public static final AssetDescriptor<Texture> deluxeCoop = new AssetDescriptor<>("buildings/Deluxe_Coop.png", Texture.class);

    // *** Fertilizers ***
    public static final AssetDescriptor<Texture> deluxeRetainingSoil = new AssetDescriptor<>("Stardew_Valley_Images/Fertilizer/Deluxe_Retaining_Soil.png", Texture.class);
    public static final AssetDescriptor<Texture> speedGro = new AssetDescriptor<>("Stardew_Valley_Images/Fertilizer/Speed-Gro.png", Texture.class);

    // *** Seeds And Crops ***
    public static final AssetDescriptor<Texture> carrotSeeds = new AssetDescriptor<>("Stardew_Valley_Images/Crops/Carrot_Seeds.png", Texture.class);
    public static final AssetDescriptor<Texture> carrot = new AssetDescriptor<>("Stardew_Valley_Images/Crops/Carrot.png", Texture.class);
    public static final AssetDescriptor<Texture> carrotStage1 = new AssetDescriptor<>("Stardew_Valley_Images/Crops/Carrot_Stage_1.png", Texture.class);
    public static final AssetDescriptor<Texture> carrotStage2 = new AssetDescriptor<>("Stardew_Valley_Images/Crops/Carrot_Stage_2.png", Texture.class);
    public static final AssetDescriptor<Texture> carrotStage3 = new AssetDescriptor<>("Stardew_Valley_Images/Crops/Carrot_Stage_3.png", Texture.class);
    public static final AssetDescriptor<Texture> carrotStage4 = new AssetDescriptor<>("Stardew_Valley_Images/Crops/Carrot_Stage_4.png", Texture.class);

    public static final AssetDescriptor<Texture> pumpkinSeeds = new AssetDescriptor<>("Stardew_Valley_Images/Crops/Pumpkin_Seeds.png", Texture.class);
    public static final AssetDescriptor<Texture> pumpkin = new AssetDescriptor<>("Stardew_Valley_Images/Crops/Pumpkin.png", Texture.class);
    public static final AssetDescriptor<Texture> pumpkinStage1 = new AssetDescriptor<>("Stardew_Valley_Images/Crops/Pumpkin_Stage_1.png", Texture.class);
    public static final AssetDescriptor<Texture> pumpkinStage2 = new AssetDescriptor<>("Stardew_Valley_Images/Crops/Pumpkin_Stage_2.png", Texture.class);
    public static final AssetDescriptor<Texture> pumpkinStage3 = new AssetDescriptor<>("Stardew_Valley_Images/Crops/Pumpkin_Stage_3.png", Texture.class);
    public static final AssetDescriptor<Texture> pumpkinStage4 = new AssetDescriptor<>("Stardew_Valley_Images/Crops/Pumpkin_Stage_4.png", Texture.class);
    public static final AssetDescriptor<Texture> pumpkinStage5 = new AssetDescriptor<>("Stardew_Valley_Images/Crops/Pumpkin_Stage_5.png", Texture.class);
    public static final AssetDescriptor<Texture> pumpkinStage6 = new AssetDescriptor<>("Stardew_Valley_Images/Crops/Pumpkin_Stage_6.png", Texture.class);
    public static final AssetDescriptor<Texture> giantPumpkin = new AssetDescriptor<>("Stardew_Valley_Images/Crops/Giant_Pumpkin.png", Texture.class);


    public static void queueAsset() {
        assetManager.load(background);
        assetManager.load(blackBackground);
        assetManager.load(inventoryScreen);
        assetManager.load(inventoryItem);
        assetManager.load(skill);
        assetManager.load(energyBar);
        assetManager.load(nightBackground);
        assetManager.load(grass);
        assetManager.load(dirt);

        assetManager.load(player00);
        assetManager.load(player01);
        assetManager.load(player02);
        assetManager.load(player03);
        assetManager.load(player10);
        assetManager.load(player11);
        assetManager.load(player12);
        assetManager.load(player13);
        assetManager.load(player20);
        assetManager.load(player21);
        assetManager.load(player22);
        assetManager.load(player23);

        assetManager.load(dirt2);
        assetManager.load(dirt3);
        assetManager.load(dirt4);
        assetManager.load(winterDirt);
        assetManager.load(winterDirt2);
        assetManager.load(winterDirt3);
        assetManager.load(plantable);
        assetManager.load(wateredTile);
        assetManager.load(house);
        assetManager.load(ruinedGreenhouse);
        assetManager.load(menuSkin);
        assetManager.load(river);
        assetManager.load(leftWall);
        assetManager.load(rightWall);
        assetManager.load(upWall);
        assetManager.load(downWall);
        assetManager.load(cornerWall1);
        assetManager.load(cornerWall2);
        assetManager.load(outdoorGrass1);
        assetManager.load(outdoorGrass2);
        assetManager.load(outdoorGrass3);
        assetManager.load(outdoorGrass4);
        assetManager.load(clock);
        assetManager.load(axe);
        assetManager.load(pickaxe);
        assetManager.load(scythe);
        assetManager.load(hoe);
        assetManager.load(wateringCan);
        assetManager.load(milkPail);
        assetManager.load(wood);
        assetManager.load(stones);
        assetManager.load(stone);
        assetManager.load(tree);
        assetManager.load(apricot_tree);
        assetManager.load(cherry_tree);
        assetManager.load(banana_tree);
        assetManager.load(mango_tree);
        assetManager.load(orange_tree);
        assetManager.load(peach_tree);
        assetManager.load(apple_tree);
        assetManager.load(pomegranate_tree);
        assetManager.load(oak_tree);
        assetManager.load(maple_tree);
        assetManager.load(pine_tree);
        assetManager.load(mahogany_tree);
        assetManager.load(mushroom_tree);
        assetManager.load(wild_tree);
        assetManager.load(mystic_tree);
        assetManager.load(pine_tree);
        assetManager.load(mahogany_tree);
        assetManager.load(mushroom_tree);
        assetManager.load(trashCan);
        assetManager.load(farmingIcon);
        assetManager.load(fishingIcon);
        assetManager.load(foragingIcon);
        assetManager.load(miningIcon);
        assetManager.load(playerInfo);
        assetManager.load(tapperIcon);

        assetManager.load(insideHouse);
        assetManager.load(refrigerator);

        assetManager.load(friedEgg);
        assetManager.load(bakedFish);
        assetManager.load(pumpkinPie);
        assetManager.load(spaghetti);
        assetManager.load(tortilla);
        assetManager.load(makiRoll);
        assetManager.load(tripleShotEspresso);
        assetManager.load(hashBrowns);
        assetManager.load(pancakes);
        assetManager.load(fruitSalad);
        assetManager.load(redPlate);
        assetManager.load(salmonDinner);
        assetManager.load(vegetableMedley);
        assetManager.load(farmersLunch);
        assetManager.load(survivalBurger);
        assetManager.load(dishOTheSea);
        assetManager.load(seafoamPudding);
        assetManager.load(minersTreat);
        assetManager.load(omelet);
        assetManager.load(pizza);
        assetManager.load(cookie);
        assetManager.load(bread);
        assetManager.load(salad);

        assetManager.load(carpenter);
        assetManager.load(blacksmith);
        assetManager.load(jojamart);
        assetManager.load(pierres);
        assetManager.load(ranch);
        assetManager.load(fishShop);
        assetManager.load(saloon);
        assetManager.load(barn);
        assetManager.load(bigBarn);
        assetManager.load(deluxeBarn);
        assetManager.load(coop);
        assetManager.load(bigCoop);
        assetManager.load(deluxeCoop);

        assetManager.load(deluxeRetainingSoil);
        assetManager.load(speedGro);

        assetManager.load(carrotSeeds);
        assetManager.load(carrot);
        assetManager.load(carrotStage1);
        assetManager.load(carrotStage2);
        assetManager.load(carrotStage3);
        assetManager.load(carrotStage4);

        assetManager.load(pumpkin);
        assetManager.load(pumpkinSeeds);
        assetManager.load(pumpkinStage1);
        assetManager.load(pumpkinStage2);
        assetManager.load(pumpkinStage3);
        assetManager.load(pumpkinStage4);
        assetManager.load(pumpkinStage5);
        assetManager.load(pumpkinStage6);
        assetManager.load(giantPumpkin);
    }
}
