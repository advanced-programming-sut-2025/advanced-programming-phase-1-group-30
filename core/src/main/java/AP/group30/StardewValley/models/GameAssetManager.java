package AP.group30.StardewValley.models;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

import javax.swing.plaf.PanelUI;

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
    public static final AssetDescriptor<Skin> menuSkin = new AssetDescriptor<>("skin/LibGdx-Skin/NzSkin.json", Skin.class);
    public static final AssetDescriptor<Skin> skin = new AssetDescriptor<>("skin/pixthulhu-ui.json", Skin.class);
    public static final AssetDescriptor<Texture> grass = new AssetDescriptor<>("tile/grass.png", Texture.class);
    public static final AssetDescriptor<Texture> winterGrass = new AssetDescriptor<>("tile/winter_grass.png", Texture.class);
    public static final AssetDescriptor<Texture> dirt = new AssetDescriptor<>("tile/dirt.png", Texture.class);
    public static final AssetDescriptor<Texture> rain = new AssetDescriptor<>("lightning pictures/rain_drops-01.png", Texture.class);
    public static final AssetDescriptor<Texture> snow = new AssetDescriptor<>("lightning pictures/Rain-PNG-File.png", Texture.class);

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
    public static final AssetDescriptor<Texture> lightning1 = new AssetDescriptor<>("lightning pictures/lightning0.png", Texture.class);
    public static final AssetDescriptor<Texture> lightning2 = new AssetDescriptor<>("lightning pictures/lightning1.png", Texture.class);
    public static final AssetDescriptor<Texture> lightning3 = new AssetDescriptor<>("lightning pictures/lightning2.png", Texture.class);
    public static final AssetDescriptor<Texture> lightning4 = new AssetDescriptor<>("lightning pictures/lightning3.png", Texture.class);
    public static final AssetDescriptor<Texture> lightning5 = new AssetDescriptor<>("lightning pictures/lightning4.png", Texture.class);
    public static final AssetDescriptor<Texture> lightning6 = new AssetDescriptor<>("lightning pictures/lightning5.png", Texture.class);
    public static final AssetDescriptor<Texture> lightning7 = new AssetDescriptor<>("lightning pictures/lightning6.png", Texture.class);
    public static final AssetDescriptor<Texture> lightning8 = new AssetDescriptor<>("lightning pictures/lightning7.png", Texture.class);


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
    public static final AssetDescriptor<Texture> trainingRod = new AssetDescriptor<>("Tools/Fishing_Pole/Training_Rod.png", Texture.class);
    public static final AssetDescriptor<Texture> iridiumRod = new AssetDescriptor<>("Tools/Fishing_Pole/Iridium_Rod.png", Texture.class);
    public static final AssetDescriptor<Texture> fiberglassRod = new AssetDescriptor<>("Tools/Fishing_Pole/Fiberglass_Rod.png", Texture.class);
    public static final AssetDescriptor<Texture> bambooPole = new AssetDescriptor<>("Tools/Fishing_Pole/Bamboo_Pole.png", Texture.class);

    public static final AssetDescriptor<Texture> wood = new AssetDescriptor<>("item/resource/Wood.png", Texture.class);
    public static final AssetDescriptor<Texture> stone = new AssetDescriptor<>("Stardew_Valley_Images/Rock/Stone_Index760.png", Texture.class);
    public static final AssetDescriptor<Texture> stones = new AssetDescriptor<>("item/resource/Stones.png", Texture.class);
    public static final AssetDescriptor<Texture> stone1 = new AssetDescriptor<>("Stardew_Valley_Images/Rock/Farm_Boulder.png", Texture.class);
    public static final AssetDescriptor<Texture> stone2 = new AssetDescriptor<>("Stardew_Valley_Images/Rock/Quarry_Boulder.png", Texture.class);
    public static final AssetDescriptor<Texture> quartz = new AssetDescriptor<>("Stardew_Valley_Images/Mineral/Quartz.png", Texture.class);
    public static final AssetDescriptor<Texture> earth_crystal = new AssetDescriptor<>("Stardew_Valley_Images/Mineral/Earth_Crystal.png", Texture.class);
    public static final AssetDescriptor<Texture> frozen_tear = new AssetDescriptor<>("Stardew_Valley_Images/Mineral/Frozen_Tear.png", Texture.class);
    public static final AssetDescriptor<Texture> fire_quartz = new AssetDescriptor<>("Stardew_Valley_Images/Mineral/Fire_Quartz.png", Texture.class);
    public static final AssetDescriptor<Texture> emerald = new AssetDescriptor<>("Stardew_Valley_Images/Gem/Emerald.png", Texture.class);
    public static final AssetDescriptor<Texture> aquamarine = new AssetDescriptor<>("Stardew_Valley_Images/Gem/Aquamarine.png", Texture.class);
    public static final AssetDescriptor<Texture> ruby = new AssetDescriptor<>("Stardew_Valley_Images/Gem/Ruby.png", Texture.class);
    public static final AssetDescriptor<Texture> amethyst = new AssetDescriptor<>("Stardew_Valley_Images/Gem/Amethyst.png", Texture.class);
    public static final AssetDescriptor<Texture> topaz = new AssetDescriptor<>("Stardew_Valley_Images/Gem/Topaz.png", Texture.class);
    public static final AssetDescriptor<Texture> jade = new AssetDescriptor<>("Stardew_Valley_Images/Gem/Jade.png", Texture.class);
    public static final AssetDescriptor<Texture> diamond = new AssetDescriptor<>("Stardew_Valley_Images/Gem/Diamond.png", Texture.class);
    public static final AssetDescriptor<Texture> prismatic_shard = new AssetDescriptor<>("Stardew_Valley_Images/Gem/Prismatic_Shard.png", Texture.class);
    public static final AssetDescriptor<Texture> copper = new AssetDescriptor<>("Stardew_Valley_Images/Resource/Copper_Ore.png", Texture.class);
    public static final AssetDescriptor<Texture> iron = new AssetDescriptor<>("Stardew_Valley_Images/Resource/Iron_Ore.png", Texture.class);
    public static final AssetDescriptor<Texture> gold = new AssetDescriptor<>("Stardew_Valley_Images/Resource/Gold_Ore.png", Texture.class);
    public static final AssetDescriptor<Texture> iridium = new AssetDescriptor<>("Stardew_Valley_Images/Resource/Iridium_Ore.png", Texture.class);




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
    public static final AssetDescriptor<Texture> tree00 = new AssetDescriptor<>("tree/tree0.png", Texture.class);
    public static final AssetDescriptor<Texture> tree01 = new AssetDescriptor<>("tree/tree1.png", Texture.class);
    public static final AssetDescriptor<Texture> tree02 = new AssetDescriptor<>("tree/tree2.png", Texture.class);
    public static final AssetDescriptor<Texture> tree03 = new AssetDescriptor<>("tree/tree3.png", Texture.class);
    public static final AssetDescriptor<Texture> tree10 = new AssetDescriptor<>("tree/tree(2)0.png", Texture.class);
    public static final AssetDescriptor<Texture> tree11 = new AssetDescriptor<>("tree/tree(2)1.png", Texture.class);
    public static final AssetDescriptor<Texture> tree12 = new AssetDescriptor<>("tree/tree(2)2.png", Texture.class);
    public static final AssetDescriptor<Texture> tree13 = new AssetDescriptor<>("tree/tree(2)3.png", Texture.class);
    public static final AssetDescriptor<Texture> tree20 = new AssetDescriptor<>("tree/tree(3)0.png", Texture.class);
    public static final AssetDescriptor<Texture> tree21 = new AssetDescriptor<>("tree/tree(3)1.png", Texture.class);
    public static final AssetDescriptor<Texture> tree22 = new AssetDescriptor<>("tree/tree(3)2.png", Texture.class);
    public static final AssetDescriptor<Texture> tree23 = new AssetDescriptor<>("tree/tree(3)3.png", Texture.class);

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
    public static final AssetDescriptor<Texture> hay = new AssetDescriptor<>("item/FoodType/Hay.png", Texture.class);

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
    public static final AssetDescriptor<Texture> coopInterior = new AssetDescriptor<>("buildings/Coop_Interior.png", Texture.class);
    public static final AssetDescriptor<Texture> barnInterior = new AssetDescriptor<>("buildings/Barn_Interior.png", Texture.class);

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



    public static final AssetDescriptor<Texture> crafting = new AssetDescriptor<>("Inventory/Crafting.png", Texture.class);
    public static final AssetDescriptor<Texture> cherry_bomb = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Cherry_Bomb.png", Texture.class);
    public static final AssetDescriptor<Texture> bomb = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Bomb.png", Texture.class);
    public static final AssetDescriptor<Texture> mega_bomb = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Mega_Bomb.png", Texture.class);
    public static final AssetDescriptor<Texture> sprinkler = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Sprinkler.png", Texture.class);
    public static final AssetDescriptor<Texture> quality_sprinkler = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Quality_Sprinkler.png", Texture.class);
    public static final AssetDescriptor<Texture> iridium_sprinkler = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Iridium_Sprinkler.png", Texture.class);
    public static final AssetDescriptor<Texture> charcoal_kiln = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Charcoal_Kiln.png", Texture.class);
    public static final AssetDescriptor<Texture> furnace = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Furnace.png", Texture.class);
    public static final AssetDescriptor<Texture> scarecrow = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Scarecrow.png", Texture.class);
    public static final AssetDescriptor<Texture> deluxe_scarecrow = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Deluxe_Scarecrow.png", Texture.class);
    public static final AssetDescriptor<Texture> bee_house = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Bee_House.png", Texture.class);
    public static final AssetDescriptor<Texture> cheese_press = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Cheese_Press.png", Texture.class);
    public static final AssetDescriptor<Texture> keg = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Keg.png", Texture.class);
    public static final AssetDescriptor<Texture> loom = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Loom.png", Texture.class);
    public static final AssetDescriptor<Texture> mayonnaise_machine = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Mayonnaise_Machine.png", Texture.class);
    public static final AssetDescriptor<Texture> oil_maker = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Oil_Maker.png", Texture.class);
    public static final AssetDescriptor<Texture> preserves_jar = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Preserves_Jar.png", Texture.class);
    public static final AssetDescriptor<Texture> dehydrator = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Dehydrator.png", Texture.class);
    public static final AssetDescriptor<Texture> grass_starter = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Grass_Starter.png", Texture.class);
    public static final AssetDescriptor<Texture> fish_smoker = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Fish_Smoker.png", Texture.class);
    public static final AssetDescriptor<Texture> mystic_tree_seed = new AssetDescriptor<>("Stardew_Valley_Images/Crafting/Mystic_Tree_Seed.png", Texture.class);


    public static final AssetDescriptor<Texture> Abigail0 = new AssetDescriptor<>("NPC/Abi0.png", Texture.class);
    public static final AssetDescriptor<Texture> Abigail1 = new AssetDescriptor<>("NPC/Abi1.png", Texture.class);
    public static final AssetDescriptor<Texture> Abigail2 = new AssetDescriptor<>("NPC/Abi2.png", Texture.class);
    public static final AssetDescriptor<Texture> Abigail3 = new AssetDescriptor<>("NPC/Abi3.png", Texture.class);
    public static final AssetDescriptor<Texture> Harvey0 = new AssetDescriptor<>("NPC/Harvey0.png", Texture.class);
    public static final AssetDescriptor<Texture> Harvey1 = new AssetDescriptor<>("NPC/Harvey1.png", Texture.class);
    public static final AssetDescriptor<Texture> Harvey2 = new AssetDescriptor<>("NPC/Harvey2.png", Texture.class);
    public static final AssetDescriptor<Texture> Harvey3 = new AssetDescriptor<>("NPC/Harvey3.png", Texture.class);
    public static final AssetDescriptor<Texture> Leah0 = new AssetDescriptor<>("NPC/Leah0.png", Texture.class);
    public static final AssetDescriptor<Texture> Leah1 = new AssetDescriptor<>("NPC/Leah1.png", Texture.class);
    public static final AssetDescriptor<Texture> Leah2 = new AssetDescriptor<>("NPC/Leah2.png", Texture.class);
    public static final AssetDescriptor<Texture> Leah3 = new AssetDescriptor<>("NPC/Leah3.png", Texture.class);
    public static final AssetDescriptor<Texture> Robin0 = new AssetDescriptor<>("NPC/Robin0.png", Texture.class);
    public static final AssetDescriptor<Texture> Robin1 = new AssetDescriptor<>("NPC/Robin1.png", Texture.class);
    public static final AssetDescriptor<Texture> Robin2 = new AssetDescriptor<>("NPC/Robin2.png", Texture.class);
    public static final AssetDescriptor<Texture> Robin3 = new AssetDescriptor<>("NPC/Robin3.png", Texture.class);
    public static final AssetDescriptor<Texture> Sebastian0 = new AssetDescriptor<>("NPC/Seb0.png", Texture.class);
    public static final AssetDescriptor<Texture> Sebastian1 = new AssetDescriptor<>("NPC/Seb1.png", Texture.class);
    public static final AssetDescriptor<Texture> Sebastian2 = new AssetDescriptor<>("NPC/Seb2.png", Texture.class);
    public static final AssetDescriptor<Texture> Sebastian3 = new AssetDescriptor<>("NPC/Seb3.png", Texture.class);
    public static final AssetDescriptor<Texture> chatBox = new AssetDescriptor<>("Stardew_Valley_Images/Chat/chat.jpg", Texture.class);
    public static final AssetDescriptor<Texture> gift = new AssetDescriptor<>("Stardew_Valley_Images/Sprites/gift Log.png", Texture.class);
    public static final AssetDescriptor<Texture> heart = new AssetDescriptor<>("Stardew_Valley_Images/Heart/HeartIconLarge.png", Texture.class);
    public static final AssetDescriptor<Texture> questCompleted = new AssetDescriptor<>("Stardew_Valley_Images/Achievement/Achievement_Danger_In_The_Deep.jpg", Texture.class);
    public static final AssetDescriptor<Texture> questTodo = new AssetDescriptor<>("Stardew_Valley_Images/Achievement/Achievement_A_Big_Help.jpg", Texture.class);
    public static final AssetDescriptor<Texture> questUnavailable = new AssetDescriptor<>("Stardew_Valley_Images/Achievement/Achievement_Treasure_Trove.jpg", Texture.class);


    public static final AssetDescriptor<Texture> honey = new AssetDescriptor<>("item/ArtisanGoods/Honey.png", Texture.class);
    public static final AssetDescriptor<Texture> cheese = new AssetDescriptor<>("item/ArtisanGoods/Cheese.png", Texture.class);
    public static final AssetDescriptor<Texture> goatCheese = new AssetDescriptor<>("item/ArtisanGoods/Goat_Cheese.png", Texture.class);
    public static final AssetDescriptor<Texture> beer = new AssetDescriptor<>("item/ArtisanGoods/Beer.png", Texture.class);
    public static final AssetDescriptor<Texture> vinegar = new AssetDescriptor<>("item/ArtisanGoods/Vinegar.png", Texture.class);
    public static final AssetDescriptor<Texture> coffee = new AssetDescriptor<>("item/ArtisanGoods/Coffee.png", Texture.class);
    public static final AssetDescriptor<Texture> juice = new AssetDescriptor<>("item/ArtisanGoods/Juice.png", Texture.class);
    public static final AssetDescriptor<Texture> mead = new AssetDescriptor<>("item/ArtisanGoods/Mead.png", Texture.class);
    public static final AssetDescriptor<Texture> paleAle = new AssetDescriptor<>("item/ArtisanGoods/Pale_Ale.png", Texture.class);
    public static final AssetDescriptor<Texture> wine = new AssetDescriptor<>("item/ArtisanGoods/Wine.png", Texture.class);
    public static final AssetDescriptor<Texture> driedMushrooms = new AssetDescriptor<>("item/ArtisanGoods/Dried_Mushrooms.png", Texture.class);
    public static final AssetDescriptor<Texture> driedFruit = new AssetDescriptor<>("item/ArtisanGoods/Dried_Fruit.png", Texture.class);
    public static final AssetDescriptor<Texture> raisins = new AssetDescriptor<>("item/ArtisanGoods/Raisins.png", Texture.class);
    public static final AssetDescriptor<Texture> coal = new AssetDescriptor<>("item/ArtisanGoods/Coal.png", Texture.class);
    public static final AssetDescriptor<Texture> cloth = new AssetDescriptor<>("item/ArtisanGoods/Cloth.png", Texture.class);
    public static final AssetDescriptor<Texture> mayonnaise = new AssetDescriptor<>("item/ArtisanGoods/Mayonnaise.png", Texture.class);
    public static final AssetDescriptor<Texture> duckMayonnaise = new AssetDescriptor<>("item/ArtisanGoods/Duck_Mayonnaise.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurMayonnaise = new AssetDescriptor<>("item/ArtisanGoods/Dinosaur_Mayonnaise.png", Texture.class);
    public static final AssetDescriptor<Texture> truffleOil = new AssetDescriptor<>("item/ArtisanGoods/Truffle_Oil.png", Texture.class);
    public static final AssetDescriptor<Texture> oil = new AssetDescriptor<>("item/ArtisanGoods/Oil.png", Texture.class);
    public static final AssetDescriptor<Texture> pickles = new AssetDescriptor<>("item/ArtisanGoods/Pickles.png", Texture.class);
    public static final AssetDescriptor<Texture> jelly = new AssetDescriptor<>("item/ArtisanGoods/Jelly.png", Texture.class);
    public static final AssetDescriptor<Texture> smokedFish = new AssetDescriptor<>("item/ArtisanGoods/Smoked_Fish.png", Texture.class);
    public static final AssetDescriptor<Texture> metalBar = new AssetDescriptor<>("item/ArtisanGoods/Metal_Bar.png", Texture.class);

    public static final AssetDescriptor<Texture> builtGreenhouse = new AssetDescriptor<>("Stardew_Valley_Images/Greenhouse/GreenhouseBuilt.png", Texture.class);
    public static final AssetDescriptor<Texture> greenhouseInterior = new AssetDescriptor<>("Stardew_Valley_Images/Greenhouse/greenhouse.png",Texture.class);

    public static final AssetDescriptor<Texture> cowFront1 = new AssetDescriptor<>("output_squares/Cow0.png", Texture.class);
    public static final AssetDescriptor<Texture> cowFront2 = new AssetDescriptor<>("output_squares/Cow1.png", Texture.class);
    public static final AssetDescriptor<Texture> cowFront3 = new AssetDescriptor<>("output_squares/Cow2.png", Texture.class);
    public static final AssetDescriptor<Texture> cowFront4 = new AssetDescriptor<>("output_squares/Cow3.png", Texture.class);
    public static final AssetDescriptor<Texture> cowRight1 = new AssetDescriptor<>("output_squares/Cow4.png", Texture.class);
    public static final AssetDescriptor<Texture> cowRight2 = new AssetDescriptor<>("output_squares/Cow5.png", Texture.class);
    public static final AssetDescriptor<Texture> cowRight3 = new AssetDescriptor<>("output_squares/Cow6.png", Texture.class);
    public static final AssetDescriptor<Texture> cowRight4 = new AssetDescriptor<>("output_squares/Cow7.png", Texture.class);
    public static final AssetDescriptor<Texture> cowBack1 = new AssetDescriptor<>("output_squares/Cow8.png", Texture.class);
    public static final AssetDescriptor<Texture> cowBack2 = new AssetDescriptor<>("output_squares/Cow9.png", Texture.class);
    public static final AssetDescriptor<Texture> cowBack3 = new AssetDescriptor<>("output_squares/Cow10.png", Texture.class);
    public static final AssetDescriptor<Texture> cowBack4 = new AssetDescriptor<>("output_squares/Cow11.png", Texture.class);
    public static final AssetDescriptor<Texture> cowEating1 = new AssetDescriptor<>("output_squares/Cow16.png", Texture.class);
    public static final AssetDescriptor<Texture> cowEating2 = new AssetDescriptor<>("output_squares/Cow17.png", Texture.class);
    public static final AssetDescriptor<Texture> cowEating3 = new AssetDescriptor<>("output_squares/Cow18.png", Texture.class);
    public static final AssetDescriptor<Texture> cowEating4 = new AssetDescriptor<>("output_squares/Cow19.png", Texture.class);

    public static final AssetDescriptor<Texture> pigFront1 = new AssetDescriptor<>("output_squares/Pig0.png", Texture.class);
    public static final AssetDescriptor<Texture> pigFront2 = new AssetDescriptor<>("output_squares/Pig1.png", Texture.class);
    public static final AssetDescriptor<Texture> pigFront3 = new AssetDescriptor<>("output_squares/Pig2.png", Texture.class);
    public static final AssetDescriptor<Texture> pigFront4 = new AssetDescriptor<>("output_squares/Pig3.png", Texture.class);
    public static final AssetDescriptor<Texture> pigRight1 = new AssetDescriptor<>("output_squares/Pig4.png", Texture.class);
    public static final AssetDescriptor<Texture> pigRight2 = new AssetDescriptor<>("output_squares/Pig5.png", Texture.class);
    public static final AssetDescriptor<Texture> pigRight3 = new AssetDescriptor<>("output_squares/Pig6.png", Texture.class);
    public static final AssetDescriptor<Texture> pigRight4 = new AssetDescriptor<>("output_squares/Pig7.png", Texture.class);
    public static final AssetDescriptor<Texture> pigBack1 = new AssetDescriptor<>("output_squares/Pig8.png", Texture.class);
    public static final AssetDescriptor<Texture> pigBack2 = new AssetDescriptor<>("output_squares/Pig9.png", Texture.class);
    public static final AssetDescriptor<Texture> pigBack3 = new AssetDescriptor<>("output_squares/Pig10.png", Texture.class);
    public static final AssetDescriptor<Texture> pigBack4 = new AssetDescriptor<>("output_squares/Pig11.png", Texture.class);
    public static final AssetDescriptor<Texture> pigEating1 = new AssetDescriptor<>("output_squares/Pig16.png", Texture.class);
    public static final AssetDescriptor<Texture> pigEating2 = new AssetDescriptor<>("output_squares/Pig17.png", Texture.class);
    public static final AssetDescriptor<Texture> pigEating3 = new AssetDescriptor<>("output_squares/Pig18.png", Texture.class);
    public static final AssetDescriptor<Texture> pigEating4 = new AssetDescriptor<>("output_squares/Pig19.png", Texture.class);

    public static final AssetDescriptor<Texture> goatFront1 = new AssetDescriptor<>("output_squares/Goat0.png", Texture.class);
    public static final AssetDescriptor<Texture> goatFront2 = new AssetDescriptor<>("output_squares/Goat1.png", Texture.class);
    public static final AssetDescriptor<Texture> goatFront3 = new AssetDescriptor<>("output_squares/Goat2.png", Texture.class);
    public static final AssetDescriptor<Texture> goatFront4 = new AssetDescriptor<>("output_squares/Goat3.png", Texture.class);
    public static final AssetDescriptor<Texture> goatRight1 = new AssetDescriptor<>("output_squares/Goat4.png", Texture.class);
    public static final AssetDescriptor<Texture> goatRight2 = new AssetDescriptor<>("output_squares/Goat5.png", Texture.class);
    public static final AssetDescriptor<Texture> goatRight3 = new AssetDescriptor<>("output_squares/Goat6.png", Texture.class);
    public static final AssetDescriptor<Texture> goatRight4 = new AssetDescriptor<>("output_squares/Goat7.png", Texture.class);
    public static final AssetDescriptor<Texture> goatBack1 = new AssetDescriptor<>("output_squares/Goat8.png", Texture.class);
    public static final AssetDescriptor<Texture> goatBack2 = new AssetDescriptor<>("output_squares/Goat9.png", Texture.class);
    public static final AssetDescriptor<Texture> goatBack3 = new AssetDescriptor<>("output_squares/Goat10.png", Texture.class);
    public static final AssetDescriptor<Texture> goatBack4 = new AssetDescriptor<>("output_squares/Goat11.png", Texture.class);
    public static final AssetDescriptor<Texture> goatEating1 = new AssetDescriptor<>("output_squares/Goat16.png", Texture.class);
    public static final AssetDescriptor<Texture> goatEating2 = new AssetDescriptor<>("output_squares/Goat17.png", Texture.class);
    public static final AssetDescriptor<Texture> goatEating3 = new AssetDescriptor<>("output_squares/Goat18.png", Texture.class);
    public static final AssetDescriptor<Texture> goatEating4 = new AssetDescriptor<>("output_squares/Goat19.png", Texture.class);

    public static final AssetDescriptor<Texture> sheepFront1 = new AssetDescriptor<>("output_squares/Sheep0.png", Texture.class);
    public static final AssetDescriptor<Texture> sheepFront2 = new AssetDescriptor<>("output_squares/Sheep1.png", Texture.class);
    public static final AssetDescriptor<Texture> sheepFront3 = new AssetDescriptor<>("output_squares/Sheep2.png", Texture.class);
    public static final AssetDescriptor<Texture> sheepFront4 = new AssetDescriptor<>("output_squares/Sheep3.png", Texture.class);
    public static final AssetDescriptor<Texture> sheepRight1 = new AssetDescriptor<>("output_squares/Sheep4.png", Texture.class);
    public static final AssetDescriptor<Texture> sheepRight2 = new AssetDescriptor<>("output_squares/Sheep5.png", Texture.class);
    public static final AssetDescriptor<Texture> sheepRight3 = new AssetDescriptor<>("output_squares/Sheep6.png", Texture.class);
    public static final AssetDescriptor<Texture> sheepRight4 = new AssetDescriptor<>("output_squares/Sheep7.png", Texture.class);
    public static final AssetDescriptor<Texture> sheepBack1 = new AssetDescriptor<>("output_squares/Sheep8.png", Texture.class);
    public static final AssetDescriptor<Texture> sheepBack2 = new AssetDescriptor<>("output_squares/Sheep9.png", Texture.class);
    public static final AssetDescriptor<Texture> sheepBack3 = new AssetDescriptor<>("output_squares/Sheep10.png", Texture.class);
    public static final AssetDescriptor<Texture> sheepBack4 = new AssetDescriptor<>("output_squares/Sheep11.png", Texture.class);
    public static final AssetDescriptor<Texture> sheepEating1 = new AssetDescriptor<>("output_squares/Sheep16.png", Texture.class);
    public static final AssetDescriptor<Texture> sheepEating2 = new AssetDescriptor<>("output_squares/Sheep17.png", Texture.class);
    public static final AssetDescriptor<Texture> sheepEating3 = new AssetDescriptor<>("output_squares/Sheep18.png", Texture.class);
    public static final AssetDescriptor<Texture> sheepEating4 = new AssetDescriptor<>("output_squares/Sheep19.png", Texture.class);

    public static final AssetDescriptor<Texture> shearedSheepFront1 = new AssetDescriptor<>("output_squares/ShearedSheep0.png", Texture.class);
    public static final AssetDescriptor<Texture> shearedSheepFront2 = new AssetDescriptor<>("output_squares/ShearedSheep1.png", Texture.class);
    public static final AssetDescriptor<Texture> shearedSheepFront3 = new AssetDescriptor<>("output_squares/ShearedSheep2.png", Texture.class);
    public static final AssetDescriptor<Texture> shearedSheepFront4 = new AssetDescriptor<>("output_squares/ShearedSheep3.png", Texture.class);
    public static final AssetDescriptor<Texture> shearedSheepRight1 = new AssetDescriptor<>("output_squares/ShearedSheep4.png", Texture.class);
    public static final AssetDescriptor<Texture> shearedSheepRight2 = new AssetDescriptor<>("output_squares/ShearedSheep5.png", Texture.class);
    public static final AssetDescriptor<Texture> shearedSheepRight3 = new AssetDescriptor<>("output_squares/ShearedSheep6.png", Texture.class);
    public static final AssetDescriptor<Texture> shearedSheepRight4 = new AssetDescriptor<>("output_squares/ShearedSheep7.png", Texture.class);
    public static final AssetDescriptor<Texture> shearedSheepBack1 = new AssetDescriptor<>("output_squares/ShearedSheep8.png", Texture.class);
    public static final AssetDescriptor<Texture> shearedSheepBack2 = new AssetDescriptor<>("output_squares/ShearedSheep9.png", Texture.class);
    public static final AssetDescriptor<Texture> shearedSheepBack3 = new AssetDescriptor<>("output_squares/ShearedSheep10.png", Texture.class);
    public static final AssetDescriptor<Texture> shearedSheepBack4 = new AssetDescriptor<>("output_squares/ShearedSheep11.png", Texture.class);
    public static final AssetDescriptor<Texture> shearedSheepEating1 = new AssetDescriptor<>("output_squares/ShearedSheep16.png", Texture.class);
    public static final AssetDescriptor<Texture> shearedSheepEating2 = new AssetDescriptor<>("output_squares/ShearedSheep17.png", Texture.class);
    public static final AssetDescriptor<Texture> shearedSheepEating3 = new AssetDescriptor<>("output_squares/ShearedSheep18.png", Texture.class);
    public static final AssetDescriptor<Texture> shearedSheepEating4 = new AssetDescriptor<>("output_squares/ShearedSheep19.png", Texture.class);

    public static final AssetDescriptor<Texture> chickenFront1 = new AssetDescriptor<>("output_squares/Chicken0.png", Texture.class);
    public static final AssetDescriptor<Texture> chickenFront2 = new AssetDescriptor<>("output_squares/Chicken1.png", Texture.class);
    public static final AssetDescriptor<Texture> chickenFront3 = new AssetDescriptor<>("output_squares/Chicken2.png", Texture.class);
    public static final AssetDescriptor<Texture> chickenFront4 = new AssetDescriptor<>("output_squares/Chicken3.png", Texture.class);
    public static final AssetDescriptor<Texture> chickenRight1 = new AssetDescriptor<>("output_squares/Chicken4.png", Texture.class);
    public static final AssetDescriptor<Texture> chickenRight2 = new AssetDescriptor<>("output_squares/Chicken5.png", Texture.class);
    public static final AssetDescriptor<Texture> chickenRight3 = new AssetDescriptor<>("output_squares/Chicken6.png", Texture.class);
    public static final AssetDescriptor<Texture> chickenRight4 = new AssetDescriptor<>("output_squares/Chicken7.png", Texture.class);
    public static final AssetDescriptor<Texture> chickenBack1 = new AssetDescriptor<>("output_squares/Chicken8.png", Texture.class);
    public static final AssetDescriptor<Texture> chickenBack2 = new AssetDescriptor<>("output_squares/Chicken9.png", Texture.class);
    public static final AssetDescriptor<Texture> chickenBack3 = new AssetDescriptor<>("output_squares/Chicken10.png", Texture.class);
    public static final AssetDescriptor<Texture> chickenBack4 = new AssetDescriptor<>("output_squares/Chicken11.png", Texture.class);
    public static final AssetDescriptor<Texture> chickenEating1 = new AssetDescriptor<>("output_squares/Chicken24.png", Texture.class);
    public static final AssetDescriptor<Texture> chickenEating2 = new AssetDescriptor<>("output_squares/Chicken25.png", Texture.class);
    public static final AssetDescriptor<Texture> chickenEating3 = new AssetDescriptor<>("output_squares/Chicken26.png", Texture.class);
    public static final AssetDescriptor<Texture> chickenEating4 = new AssetDescriptor<>("output_squares/Chicken27.png", Texture.class);

    public static final AssetDescriptor<Texture> duckFront1 = new AssetDescriptor<>("output_squares/Duck0.png", Texture.class);
    public static final AssetDescriptor<Texture> duckFront2 = new AssetDescriptor<>("output_squares/Duck1.png", Texture.class);
    public static final AssetDescriptor<Texture> duckFront3 = new AssetDescriptor<>("output_squares/Duck2.png", Texture.class);
    public static final AssetDescriptor<Texture> duckFront4 = new AssetDescriptor<>("output_squares/Duck3.png", Texture.class);
    public static final AssetDescriptor<Texture> duckRight1 = new AssetDescriptor<>("output_squares/Duck4.png", Texture.class);
    public static final AssetDescriptor<Texture> duckRight2 = new AssetDescriptor<>("output_squares/Duck5.png", Texture.class);
    public static final AssetDescriptor<Texture> duckRight3 = new AssetDescriptor<>("output_squares/Duck6.png", Texture.class);
    public static final AssetDescriptor<Texture> duckRight4 = new AssetDescriptor<>("output_squares/Duck7.png", Texture.class);
    public static final AssetDescriptor<Texture> duckBack1 = new AssetDescriptor<>("output_squares/Duck8.png", Texture.class);
    public static final AssetDescriptor<Texture> duckBack2 = new AssetDescriptor<>("output_squares/Duck9.png", Texture.class);
    public static final AssetDescriptor<Texture> duckBack3 = new AssetDescriptor<>("output_squares/Duck10.png", Texture.class);
    public static final AssetDescriptor<Texture> duckBack4 = new AssetDescriptor<>("output_squares/Duck11.png", Texture.class);
    public static final AssetDescriptor<Texture> duckEating1 = new AssetDescriptor<>("output_squares/Duck24.png", Texture.class);
    public static final AssetDescriptor<Texture> duckEating2 = new AssetDescriptor<>("output_squares/Duck25.png", Texture.class);
    public static final AssetDescriptor<Texture> duckEating3 = new AssetDescriptor<>("output_squares/Duck26.png", Texture.class);
    public static final AssetDescriptor<Texture> duckEating4 = new AssetDescriptor<>("output_squares/Duck27.png", Texture.class);

    public static final AssetDescriptor<Texture> dinosaurFront1 = new AssetDescriptor<>("output_squares/Dinosaur0.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurFront2 = new AssetDescriptor<>("output_squares/Dinosaur1.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurFront3 = new AssetDescriptor<>("output_squares/Dinosaur2.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurFront4 = new AssetDescriptor<>("output_squares/Dinosaur3.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurRight1 = new AssetDescriptor<>("output_squares/Dinosaur4.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurRight2 = new AssetDescriptor<>("output_squares/Dinosaur5.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurRight3 = new AssetDescriptor<>("output_squares/Dinosaur6.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurRight4 = new AssetDescriptor<>("output_squares/Dinosaur7.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurBack1 = new AssetDescriptor<>("output_squares/Dinosaur8.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurBack2 = new AssetDescriptor<>("output_squares/Dinosaur9.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurBack3 = new AssetDescriptor<>("output_squares/Dinosaur10.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurBack4 = new AssetDescriptor<>("output_squares/Dinosaur11.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurEating1 = new AssetDescriptor<>("output_squares/Dinosaur24.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurEating2 = new AssetDescriptor<>("output_squares/Dinosaur25.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurEating3 = new AssetDescriptor<>("output_squares/Dinosaur26.png", Texture.class);
    public static final AssetDescriptor<Texture> dinosaurEating4 = new AssetDescriptor<>("output_squares/Dinosaur27.png", Texture.class);

    public static final AssetDescriptor<Texture> rabbitFront1 = new AssetDescriptor<>("output_squares/Rabbit0.png", Texture.class);
    public static final AssetDescriptor<Texture> rabbitFront2 = new AssetDescriptor<>("output_squares/Rabbit1.png", Texture.class);
    public static final AssetDescriptor<Texture> rabbitFront3 = new AssetDescriptor<>("output_squares/Rabbit2.png", Texture.class);
    public static final AssetDescriptor<Texture> rabbitFront4 = new AssetDescriptor<>("output_squares/Rabbit3.png", Texture.class);
    public static final AssetDescriptor<Texture> rabbitRight1 = new AssetDescriptor<>("output_squares/Rabbit4.png", Texture.class);
    public static final AssetDescriptor<Texture> rabbitRight2 = new AssetDescriptor<>("output_squares/Rabbit5.png", Texture.class);
    public static final AssetDescriptor<Texture> rabbitRight3 = new AssetDescriptor<>("output_squares/Rabbit6.png", Texture.class);
    public static final AssetDescriptor<Texture> rabbitRight4 = new AssetDescriptor<>("output_squares/Rabbit7.png", Texture.class);
    public static final AssetDescriptor<Texture> rabbitBack1 = new AssetDescriptor<>("output_squares/Rabbit8.png", Texture.class);
    public static final AssetDescriptor<Texture> rabbitBack2 = new AssetDescriptor<>("output_squares/Rabbit9.png", Texture.class);
    public static final AssetDescriptor<Texture> rabbitBack3 = new AssetDescriptor<>("output_squares/Rabbit10.png", Texture.class);
    public static final AssetDescriptor<Texture> rabbitBack4 = new AssetDescriptor<>("output_squares/Rabbit11.png", Texture.class);
    public static final AssetDescriptor<Texture> rabbitEating1 = new AssetDescriptor<>("output_squares/Rabbit24.png", Texture.class);
    public static final AssetDescriptor<Texture> rabbitEating2 = new AssetDescriptor<>("output_squares/Rabbit25.png", Texture.class);
    public static final AssetDescriptor<Texture> rabbitEating3 = new AssetDescriptor<>("output_squares/Rabbit26.png", Texture.class);
    public static final AssetDescriptor<Texture> rabbitEating4 = new AssetDescriptor<>("output_squares/Rabbit27.png", Texture.class);

    public static final AssetDescriptor<Texture> angler = new AssetDescriptor<>("Fish/Angler.png", Texture.class);
    public static final AssetDescriptor<Texture> blueDiscus = new AssetDescriptor<>("Fish/Blue_Discus.png", Texture.class);
    public static final AssetDescriptor<Texture> crimsonfish = new AssetDescriptor<>("Fish/Crimsonfish.png", Texture.class);
    public static final AssetDescriptor<Texture> dorado = new AssetDescriptor<>("Fish/Dorado.png", Texture.class);
    public static final AssetDescriptor<Texture> flounder = new AssetDescriptor<>("Fish/Flounder.png", Texture.class);
    public static final AssetDescriptor<Texture> ghostfish = new AssetDescriptor<>("Fish/Ghostfish.png", Texture.class);
    public static final AssetDescriptor<Texture> glacierfish = new AssetDescriptor<>("Fish/Glacierfish.png", Texture.class);
    public static final AssetDescriptor<Texture> herring = new AssetDescriptor<>("Fish/Herring.png", Texture.class);
    public static final AssetDescriptor<Texture> legend = new AssetDescriptor<>("Fish/Legend.png", Texture.class);
    public static final AssetDescriptor<Texture> lionfish = new AssetDescriptor<>("Fish/Lionfish.png", Texture.class);
    public static final AssetDescriptor<Texture> midnightCarp = new AssetDescriptor<>("Fish/Midnight_Carp.png", Texture.class);
    public static final AssetDescriptor<Texture> perch = new AssetDescriptor<>("Fish/Perch.png", Texture.class);
    public static final AssetDescriptor<Texture> rainbowTrout = new AssetDescriptor<>("Fish/Rainbow_Trout.png", Texture.class);
    public static final AssetDescriptor<Texture> salmon = new AssetDescriptor<>("Fish/Salmon.png", Texture.class);
    public static final AssetDescriptor<Texture> sardine = new AssetDescriptor<>("Fish/Sardine.png", Texture.class);
    public static final AssetDescriptor<Texture> shad = new AssetDescriptor<>("Fish/Shad.png", Texture.class);
    public static final AssetDescriptor<Texture> squid = new AssetDescriptor<>("Fish/Squid.png", Texture.class);
    public static final AssetDescriptor<Texture> sunfish = new AssetDescriptor<>("Fish/Sunfish.png", Texture.class);
    public static final AssetDescriptor<Texture> tilapia = new AssetDescriptor<>("Fish/Tilapia.png", Texture.class);
    public static final AssetDescriptor<Texture> tuna = new AssetDescriptor<>("Fish/Tuna.png", Texture.class);

    public static final AssetDescriptor<Texture> spring = new AssetDescriptor<>("Stardew_Valley_Images/Clock/spring.png", Texture.class);
    public static final AssetDescriptor<Texture> summer = new AssetDescriptor<>("Stardew_Valley_Images/Clock/summer.png", Texture.class);
    public static final AssetDescriptor<Texture> fall = new AssetDescriptor<>("Stardew_Valley_Images/Clock/fall.png", Texture.class);
    public static final AssetDescriptor<Texture> winter = new AssetDescriptor<>("Stardew_Valley_Images/Clock/winter.png", Texture.class);
    public static final AssetDescriptor<Texture> sunny = new AssetDescriptor<>("Stardew_Valley_Images/Clock/sunny.png", Texture.class);
    public static final AssetDescriptor<Texture> rainy = new AssetDescriptor<>("Stardew_Valley_Images/Clock/rainy.png", Texture.class);
    public static final AssetDescriptor<Texture> stormy = new AssetDescriptor<>("Stardew_Valley_Images/Clock/stormy.png", Texture.class);
    public static final AssetDescriptor<Texture> snowy = new AssetDescriptor<>("Stardew_Valley_Images/Clock/snowy.png", Texture.class);

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
        assetManager.load(skin);

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
        assetManager.load(trainingRod);
        assetManager.load(bambooPole);
        assetManager.load(iridiumRod);
        assetManager.load(fiberglassRod);
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

        assetManager.load(tree00);
        assetManager.load(tree01);
        assetManager.load(tree02);
        assetManager.load(tree03);
        assetManager.load(tree10);
        assetManager.load(tree11);
        assetManager.load(tree12);
        assetManager.load(tree13);
        assetManager.load(tree20);
        assetManager.load(tree21);
        assetManager.load(tree22);
        assetManager.load(tree23);

        assetManager.load(lightning1);
        assetManager.load(lightning2);
        assetManager.load(lightning3);
        assetManager.load(lightning4);
        assetManager.load(lightning5);
        assetManager.load(lightning6);
        assetManager.load(lightning7);
        assetManager.load(lightning8);
        assetManager.load(snow);
        assetManager.load(rain);

        assetManager.load(insideHouse);
        assetManager.load(refrigerator);
        assetManager.load(barnInterior);
        assetManager.load(coopInterior);

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
        assetManager.load(hay);

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

        assetManager.load(crafting);
        assetManager.load(cherry_bomb);
        assetManager.load(bomb);
        assetManager.load(mega_bomb);
        assetManager.load(sprinkler);
        assetManager.load(quality_sprinkler);
        assetManager.load(iridium_sprinkler);
        assetManager.load(charcoal_kiln);
        assetManager.load(furnace);
        assetManager.load(scarecrow);
        assetManager.load(deluxe_scarecrow);
        assetManager.load(bee_house);
        assetManager.load(cheese_press);
        assetManager.load(keg);
        assetManager.load(loom);
        assetManager.load(mayonnaise_machine);
        assetManager.load(oil_maker);
        assetManager.load(preserves_jar);
        assetManager.load(dehydrator);
        assetManager.load(grass_starter);
        assetManager.load(fish_smoker);
        assetManager.load(mystic_tree_seed);

        assetManager.load(Abigail0);
        assetManager.load(Abigail1);
        assetManager.load(Abigail2);
        assetManager.load(Abigail3);
        assetManager.load(Harvey0);
        assetManager.load(Harvey1);
        assetManager.load(Harvey2);
        assetManager.load(Harvey3);
        assetManager.load(Leah0);
        assetManager.load(Leah1);
        assetManager.load(Leah2);
        assetManager.load(Leah3);
        assetManager.load(Robin0);
        assetManager.load(Robin1);
        assetManager.load(Robin2);
        assetManager.load(Robin3);
        assetManager.load(Sebastian0);
        assetManager.load(Sebastian1);
        assetManager.load(Sebastian2);
        assetManager.load(Sebastian3);
        assetManager.load(chatBox);
        assetManager.load(gift);
        assetManager.load(heart);
        assetManager.load(questCompleted);
        assetManager.load(questUnavailable);
        assetManager.load(questTodo);

        assetManager.load(honey);
        assetManager.load(cheese);
        assetManager.load(goatCheese);
        assetManager.load(beer);
        assetManager.load(vinegar);
        assetManager.load(coffee);
        assetManager.load(juice);
        assetManager.load(paleAle);
        assetManager.load(driedMushrooms);
        assetManager.load(driedFruit);
        assetManager.load(raisins);
        assetManager.load(coal);
        assetManager.load(cloth);
        assetManager.load(mayonnaise);
        assetManager.load(duckMayonnaise);
        assetManager.load(dinosaurMayonnaise);
        assetManager.load(truffleOil);
        assetManager.load(oil);
        assetManager.load(pickles);
        assetManager.load(jelly);
        assetManager.load(smokedFish);
        assetManager.load(metalBar);
        assetManager.load(mead);
        assetManager.load(wine);
        assetManager.load(stone1);
        assetManager.load(stone2);

        assetManager.load(quartz);
        assetManager.load(earth_crystal);
        assetManager.load(frozen_tear);
        assetManager.load(fire_quartz);
        assetManager.load(emerald);
        assetManager.load(aquamarine);
        assetManager.load(ruby);
        assetManager.load(amethyst);
        assetManager.load(topaz);
        assetManager.load(jade);
        assetManager.load(diamond);
        assetManager.load(prismatic_shard);
        assetManager.load(copper);
        assetManager.load(iron);
        assetManager.load(gold);
        assetManager.load(iridium);
        assetManager.load(builtGreenhouse);
        assetManager.load(greenhouseInterior);

        assetManager.load(cowFront1);
        assetManager.load(cowFront2);
        assetManager.load(cowFront3);
        assetManager.load(cowFront4);
        assetManager.load(cowBack1);
        assetManager.load(cowBack2);
        assetManager.load(cowBack3);
        assetManager.load(cowBack4);
        assetManager.load(cowRight1);
        assetManager.load(cowRight2);
        assetManager.load(cowRight3);
        assetManager.load(cowRight4);
        assetManager.load(cowEating1);
        assetManager.load(cowEating2);
        assetManager.load(cowEating3);
        assetManager.load(cowEating4);

        assetManager.load(sheepFront1);
        assetManager.load(sheepFront2);
        assetManager.load(sheepFront3);
        assetManager.load(sheepFront4);
        assetManager.load(sheepBack1);
        assetManager.load(sheepBack2);
        assetManager.load(sheepBack3);
        assetManager.load(sheepBack4);
        assetManager.load(sheepRight1);
        assetManager.load(sheepRight2);
        assetManager.load(sheepRight3);
        assetManager.load(sheepRight4);
        assetManager.load(sheepEating1);
        assetManager.load(sheepEating2);
        assetManager.load(sheepEating3);
        assetManager.load(sheepEating4);

        assetManager.load(goatFront1);
        assetManager.load(goatFront2);
        assetManager.load(goatFront3);
        assetManager.load(goatFront4);
        assetManager.load(goatBack1);
        assetManager.load(goatBack2);
        assetManager.load(goatBack3);
        assetManager.load(goatBack4);
        assetManager.load(goatRight1);
        assetManager.load(goatRight2);
        assetManager.load(goatRight3);
        assetManager.load(goatRight4);
        assetManager.load(goatEating1);
        assetManager.load(goatEating2);
        assetManager.load(goatEating3);
        assetManager.load(goatEating4);

        assetManager.load(pigFront1);
        assetManager.load(pigFront2);
        assetManager.load(pigFront3);
        assetManager.load(pigFront4);
        assetManager.load(pigBack1);
        assetManager.load(pigBack2);
        assetManager.load(pigBack3);
        assetManager.load(pigBack4);
        assetManager.load(pigRight1);
        assetManager.load(pigRight2);
        assetManager.load(pigRight3);
        assetManager.load(pigRight4);
        assetManager.load(pigEating1);
        assetManager.load(pigEating2);
        assetManager.load(pigEating3);
        assetManager.load(pigEating4);

        assetManager.load(chickenFront1);
        assetManager.load(chickenFront2);
        assetManager.load(chickenFront3);
        assetManager.load(chickenFront4);
        assetManager.load(chickenBack1);
        assetManager.load(chickenBack2);
        assetManager.load(chickenBack3);
        assetManager.load(chickenBack4);
        assetManager.load(chickenRight1);
        assetManager.load(chickenRight2);
        assetManager.load(chickenRight3);
        assetManager.load(chickenRight4);
        assetManager.load(chickenEating1);
        assetManager.load(chickenEating2);
        assetManager.load(chickenEating3);
        assetManager.load(chickenEating4);

        assetManager.load(duckFront1);
        assetManager.load(duckFront2);
        assetManager.load(duckFront3);
        assetManager.load(duckFront4);
        assetManager.load(duckBack1);
        assetManager.load(duckBack2);
        assetManager.load(duckBack3);
        assetManager.load(duckBack4);
        assetManager.load(duckRight1);
        assetManager.load(duckRight2);
        assetManager.load(duckRight3);
        assetManager.load(duckRight4);
        assetManager.load(duckEating1);
        assetManager.load(duckEating2);
        assetManager.load(duckEating3);
        assetManager.load(duckEating4);

        assetManager.load(dinosaurFront1);
        assetManager.load(dinosaurFront2);
        assetManager.load(dinosaurFront3);
        assetManager.load(dinosaurFront4);
        assetManager.load(dinosaurBack1);
        assetManager.load(dinosaurBack2);
        assetManager.load(dinosaurBack3);
        assetManager.load(dinosaurBack4);
        assetManager.load(dinosaurRight1);
        assetManager.load(dinosaurRight2);
        assetManager.load(dinosaurRight3);
        assetManager.load(dinosaurRight4);
        assetManager.load(dinosaurEating1);
        assetManager.load(dinosaurEating2);
        assetManager.load(dinosaurEating3);
        assetManager.load(dinosaurEating4);

        assetManager.load(rabbitFront1);
        assetManager.load(rabbitFront2);
        assetManager.load(rabbitFront3);
        assetManager.load(rabbitFront4);
        assetManager.load(rabbitBack1);
        assetManager.load(rabbitBack2);
        assetManager.load(rabbitBack3);
        assetManager.load(rabbitBack4);
        assetManager.load(rabbitRight1);
        assetManager.load(rabbitRight2);
        assetManager.load(rabbitRight3);
        assetManager.load(rabbitRight4);
        assetManager.load(rabbitEating1);
        assetManager.load(rabbitEating2);
        assetManager.load(rabbitEating3);
        assetManager.load(rabbitEating4);

        assetManager.load(angler);
        assetManager.load(blueDiscus);
        assetManager.load(crimsonfish);
        assetManager.load(flounder);
        assetManager.load(ghostfish);
        assetManager.load(glacierfish);
        assetManager.load(herring);
        assetManager.load(legend);
        assetManager.load(lionfish);
        assetManager.load(midnightCarp);
        assetManager.load(perch);
        assetManager.load(rainbowTrout);
        assetManager.load(salmon);
        assetManager.load(sardine);
        assetManager.load(shad);
        assetManager.load(squid);
        assetManager.load(sunfish);
        assetManager.load(tilapia);
        assetManager.load(tuna);
        assetManager.load(dorado);

        assetManager.load(spring);
        assetManager.load(summer);
        assetManager.load(fall);
        assetManager.load(winter);
        assetManager.load(sunny);
        assetManager.load(rainy);
        assetManager.load(stormy);
        assetManager.load(snowy);

    }

    public static TextureRegion[] getFront(String animal) {
        TextureRegion[] front = null;
        switch (animal) {
            case "cow": front = new TextureRegion[] {
                new TextureRegion(assetManager.get(cowFront1)),
                new TextureRegion(assetManager.get(cowFront2)),
                new TextureRegion(assetManager.get(cowFront3)),
                new TextureRegion(assetManager.get(cowFront4))
            }; break;
            case "sheep": front = new TextureRegion[] {
                new TextureRegion(assetManager.get(sheepFront1)),
                new TextureRegion(assetManager.get(sheepFront2)),
                new TextureRegion(assetManager.get(sheepFront3)),
                new TextureRegion(assetManager.get(sheepFront4))
            }; break;
            case "goat": front = new TextureRegion[] {
                new TextureRegion(assetManager.get(goatFront1)),
                new TextureRegion(assetManager.get(goatFront2)),
                new TextureRegion(assetManager.get(goatFront3)),
                new TextureRegion(assetManager.get(goatFront4))
            }; break;
            case "pig": front = new TextureRegion[] {
                new TextureRegion(assetManager.get(pigFront1)),
                new TextureRegion(assetManager.get(pigFront2)),
                new TextureRegion(assetManager.get(pigFront3)),
                new TextureRegion(assetManager.get(pigFront4))
            }; break;
            case "chicken": front = new TextureRegion[] {
                new TextureRegion(assetManager.get(chickenFront1)),
                new TextureRegion(assetManager.get(chickenFront2)),
                new TextureRegion(assetManager.get(chickenFront3)),
                new TextureRegion(assetManager.get(chickenFront4))
            }; break;
            case "duck": front = new TextureRegion[] {
                new TextureRegion(assetManager.get(duckFront1)),
                new TextureRegion(assetManager.get(duckFront2)),
                new TextureRegion(assetManager.get(duckFront3)),
                new TextureRegion(assetManager.get(duckFront4))
            }; break;
            case "dinosaur": front = new TextureRegion[] {
                new TextureRegion(assetManager.get(dinosaurFront1)),
                new TextureRegion(assetManager.get(dinosaurFront2)),
                new TextureRegion(assetManager.get(dinosaurFront3)),
                new TextureRegion(assetManager.get(dinosaurFront4))
            }; break;
            case "rabbit": front = new TextureRegion[] {
                new TextureRegion(assetManager.get(rabbitFront1)),
                new TextureRegion(assetManager.get(rabbitFront2)),
                new TextureRegion(assetManager.get(rabbitFront3)),
                new TextureRegion(assetManager.get(rabbitFront4))
            }; break;
            case "lightning": front = new TextureRegion[] {
                new TextureRegion(assetManager.get(lightning1)),
                new TextureRegion(assetManager.get(lightning2)),
                new TextureRegion(assetManager.get(lightning3)),
                new TextureRegion(assetManager.get(lightning4)),
                new TextureRegion(assetManager.get(lightning5)),
                new TextureRegion(assetManager.get(lightning6)),
                new TextureRegion(assetManager.get(lightning7)),
                new TextureRegion(assetManager.get(lightning8)),
            }; break;
        }
        return front;
    }

    public static TextureRegion[] getBack(String animal) {
        TextureRegion[] back = null;
        switch (animal) {
            case "pig": back = new TextureRegion[] {
                new TextureRegion(assetManager.get(pigBack1)),
                new TextureRegion(assetManager.get(pigBack2)),
                new TextureRegion(assetManager.get(pigBack3)),
                new TextureRegion(assetManager.get(pigBack4))
            }; break;
            case "goat": back = new TextureRegion[] {
                new TextureRegion(assetManager.get(goatBack1)),
                new TextureRegion(assetManager.get(goatBack2)),
                new TextureRegion(assetManager.get(goatBack3)),
                new TextureRegion(assetManager.get(goatBack4))
            }; break;
            case "sheep": back = new TextureRegion[] {
                new TextureRegion(assetManager.get(sheepBack1)),
                new TextureRegion(assetManager.get(sheepBack2)),
                new TextureRegion(assetManager.get(sheepBack3)),
                new TextureRegion(assetManager.get(sheepBack4))
            }; break;
            case "cow": back = new TextureRegion[] {
                new TextureRegion(assetManager.get(cowBack1)),
                new TextureRegion(assetManager.get(cowBack2)),
                new TextureRegion(assetManager.get(cowBack3)),
                new TextureRegion(assetManager.get(cowBack4))
            }; break;
            case "chicken": back = new TextureRegion[] {
                new TextureRegion(assetManager.get(chickenBack1)),
                new TextureRegion(assetManager.get(chickenBack2)),
                new TextureRegion(assetManager.get(chickenBack3)),
                new TextureRegion(assetManager.get(chickenBack4))
            }; break;
            case "duck": back = new TextureRegion[] {
                new TextureRegion(assetManager.get(duckBack1)),
                new TextureRegion(assetManager.get(duckBack2)),
                new TextureRegion(assetManager.get(duckBack3)),
                new TextureRegion(assetManager.get(duckBack4))
            }; break;
            case "dinosaur": back = new TextureRegion[] {
                new TextureRegion(assetManager.get(dinosaurBack1)),
                new TextureRegion(assetManager.get(dinosaurBack2)),
                new TextureRegion(assetManager.get(dinosaurBack3)),
                new TextureRegion(assetManager.get(dinosaurBack4))
            }; break;
            case "rabbit": back = new TextureRegion[] {
                new TextureRegion(assetManager.get(rabbitBack1)),
                new TextureRegion(assetManager.get(rabbitBack2)),
                new TextureRegion(assetManager.get(rabbitBack3)),
                new TextureRegion(assetManager.get(rabbitBack4))
            }; break;
        }
        return back;
    }

    public static TextureRegion[] getRight(String animal) {
        TextureRegion[] right = null;
        switch (animal) {
            case "cow": right = new TextureRegion[] {
                new TextureRegion(assetManager.get(cowRight1)),
                new TextureRegion(assetManager.get(cowRight2)),
                new TextureRegion(assetManager.get(cowRight3)),
                new TextureRegion(assetManager.get(cowRight4))
            }; break;
            case "goat": right = new TextureRegion[] {
                new TextureRegion(assetManager.get(goatRight1)),
                new TextureRegion(assetManager.get(goatRight2)),
                new TextureRegion(assetManager.get(goatRight3)),
                new TextureRegion(assetManager.get(goatRight4))
            }; break;
            case "pig": right = new TextureRegion[] {
                new TextureRegion(assetManager.get(pigRight1)),
                new TextureRegion(assetManager.get(pigRight2)),
                new TextureRegion(assetManager.get(pigRight3)),
                new TextureRegion(assetManager.get(pigRight4))
            }; break;
            case "sheep": right = new TextureRegion[] {
                new TextureRegion(assetManager.get(sheepRight1)),
                new TextureRegion(assetManager.get(sheepRight2)),
                new TextureRegion(assetManager.get(sheepRight3)),
                new TextureRegion(assetManager.get(sheepRight4))
            }; break;
            case "chicken": right = new TextureRegion[] {
                new TextureRegion(assetManager.get(chickenRight1)),
                new TextureRegion(assetManager.get(chickenRight2)),
                new TextureRegion(assetManager.get(chickenRight3)),
                new TextureRegion(assetManager.get(chickenRight4))
            }; break;
            case "duck": right = new TextureRegion[] {
                new TextureRegion(assetManager.get(duckRight1)),
                new TextureRegion(assetManager.get(duckRight2)),
                new TextureRegion(assetManager.get(duckRight3)),
                new TextureRegion(assetManager.get(duckRight4))
            }; break;
            case "dinosaur": right = new TextureRegion[] {
                new TextureRegion(assetManager.get(dinosaurRight1)),
                new TextureRegion(assetManager.get(dinosaurRight2)),
                new TextureRegion(assetManager.get(dinosaurRight3)),
                new TextureRegion(assetManager.get(dinosaurRight4))
            }; break;
            case "rabbit": right = new TextureRegion[] {
                new TextureRegion(assetManager.get(rabbitRight1)),
                new TextureRegion(assetManager.get(rabbitRight2)),
                new TextureRegion(assetManager.get(rabbitRight3)),
                new TextureRegion(assetManager.get(rabbitRight4))
            }; break;
        }
        return right;
    }

    public static TextureRegion[] getLeft(String animal) {
        TextureRegion[] left = null;
        switch (animal) {
            case "cow"-> {
                TextureRegion left1 = new TextureRegion(assetManager.get(cowRight1));
                left1.flip(true, false);
                TextureRegion left2 = new TextureRegion(assetManager.get(cowRight2));
                left2.flip(true, false);
                TextureRegion left3 = new TextureRegion(assetManager.get(cowRight3));
                left3.flip(true, false);
                TextureRegion left4 = new TextureRegion(assetManager.get(cowRight4));
                left4.flip(true, false);
                left = new TextureRegion[]{
                    left1, left2, left3, left4
                };
                break;
            }
            case "sheep" -> {
                TextureRegion left1 = new TextureRegion(assetManager.get(sheepRight1));
                left1.flip(true, false);
                TextureRegion left2 = new TextureRegion(assetManager.get(sheepRight2));
                left2.flip(true, false);
                TextureRegion left3 = new TextureRegion(assetManager.get(sheepRight3));
                left3.flip(true, false);
                TextureRegion left4 = new TextureRegion(assetManager.get(sheepRight4));
                left4.flip(true, false);
                left = new TextureRegion[]{
                    left1, left2, left3, left4
                };
            }
            case "pig" -> {
                TextureRegion left1 = new TextureRegion(assetManager.get(pigRight1));
                left1.flip(true, false);
                TextureRegion left2 = new TextureRegion(assetManager.get(pigRight2));
                left2.flip(true, false);
                TextureRegion left3 = new TextureRegion(assetManager.get(pigRight3));
                left3.flip(true, false);
                TextureRegion left4 = new TextureRegion(assetManager.get(pigRight4));
                left4.flip(true, false);
                left = new TextureRegion[]{
                    left1, left2, left3, left4
                };
                break;
            }
            case "goat" -> {
                TextureRegion left1 = new TextureRegion(assetManager.get(goatRight1));
                left1.flip(true, false);
                TextureRegion left2 = new TextureRegion(assetManager.get(goatRight2));
                left2.flip(true, false);
                TextureRegion left3 = new TextureRegion(assetManager.get(goatRight3));
                left3.flip(true, false);
                TextureRegion left4 = new TextureRegion(assetManager.get(goatRight4));
                left4.flip(true, false);
                left = new TextureRegion[]{
                    left1, left2, left3, left4
                };
            }
            case "chicken" -> {
                TextureRegion left1 = new TextureRegion(assetManager.get(chickenRight1));
                left1.flip(true, false);
                TextureRegion left2 = new TextureRegion(assetManager.get(chickenRight2));
                left2.flip(true, false);
                TextureRegion left3 = new TextureRegion(assetManager.get(chickenRight3));
                left3.flip(true, false);
                TextureRegion left4 = new TextureRegion(assetManager.get(chickenRight4));
                left4.flip(true, false);
                left = new TextureRegion[]{
                    left1, left2, left3, left4
                };
            }
            case "duck" -> {
                TextureRegion left1 = new TextureRegion(assetManager.get(duckRight1));
                left1.flip(true, false);
                TextureRegion left2 = new TextureRegion(assetManager.get(duckRight2));
                left2.flip(true, false);
                TextureRegion left3 = new TextureRegion(assetManager.get(duckRight3));
                left3.flip(true, false);
                TextureRegion left4 = new TextureRegion(assetManager.get(duckRight4));
                left4.flip(true, false);
                left = new TextureRegion[]{
                    left1, left2, left3, left4
                };
            }
            case "dinosaur" -> {
                TextureRegion left1 = new TextureRegion(assetManager.get(dinosaurRight1));
                left1.flip(true, false);
                TextureRegion left2 = new TextureRegion(assetManager.get(dinosaurRight2));
                left2.flip(true, false);
                TextureRegion left3 = new TextureRegion(assetManager.get(dinosaurRight3));
                left3.flip(true, false);
                TextureRegion left4 = new TextureRegion(assetManager.get(dinosaurRight4));
                left4.flip(true, false);
                left = new TextureRegion[]{
                    left1, left2, left3, left4
                };
            }
            case "rabbit" -> {
                TextureRegion left1 = new TextureRegion(assetManager.get(rabbitRight1));
                left1.flip(true, false);
                TextureRegion left2 = new TextureRegion(assetManager.get(rabbitRight2));
                left2.flip(true, false);
                TextureRegion left3 = new TextureRegion(assetManager.get(rabbitRight3));
                left3.flip(true, false);
                TextureRegion left4 = new TextureRegion(assetManager.get(rabbitRight4));
                left4.flip(true, false);
                left = new TextureRegion[]{
                    left1, left2, left3, left4
                };
            }
        }
        return left;
    }

    public static TextureRegion[] getEating(String animal) {
        TextureRegion[] eating = null;
        switch (animal) {
            case "cow": eating = new TextureRegion[] {
                new TextureRegion(assetManager.get(cowEating1)),
                new TextureRegion(assetManager.get(cowEating2)),
                new TextureRegion(assetManager.get(cowEating3)),
                new TextureRegion(assetManager.get(cowEating4))
            }; break;
            case "goat": eating = new TextureRegion[] {
                new TextureRegion(assetManager.get(goatEating1)),
                new TextureRegion(assetManager.get(goatEating2)),
                new TextureRegion(assetManager.get(goatEating3)),
                new TextureRegion(assetManager.get(goatEating4))
            }; break;
            case "pig": eating = new TextureRegion[] {
                new TextureRegion(assetManager.get(pigEating1)),
                new TextureRegion(assetManager.get(pigEating2)),
                new TextureRegion(assetManager.get(pigEating3)),
                new TextureRegion(assetManager.get(pigEating4))
            }; break;
            case "sheep": eating = new TextureRegion[] {
                new TextureRegion(assetManager.get(sheepEating1)),
                new TextureRegion(assetManager.get(sheepEating2)),
                new TextureRegion(assetManager.get(sheepEating3)),
                new TextureRegion(assetManager.get(sheepEating4))
            }; break;
            case "chicken": eating = new TextureRegion[] {
                new TextureRegion(assetManager.get(chickenEating1)),
                new TextureRegion(assetManager.get(chickenEating2)),
                new TextureRegion(assetManager.get(chickenEating3)),
                new TextureRegion(assetManager.get(chickenEating4))
            }; break;
            case "duck": eating = new TextureRegion[] {
                new TextureRegion(assetManager.get(duckEating1)),
                new TextureRegion(assetManager.get(duckEating2)),
                new TextureRegion(assetManager.get(duckEating3)),
                new TextureRegion(assetManager.get(duckEating4))
            }; break;
            case "dinosaur": eating = new TextureRegion[] {
                new TextureRegion(assetManager.get(dinosaurEating1)),
                new TextureRegion(assetManager.get(dinosaurEating2)),
                new TextureRegion(assetManager.get(dinosaurEating3)),
                new TextureRegion(assetManager.get(dinosaurEating4))
            }; break;
            case "rabbit": eating = new TextureRegion[] {
                new TextureRegion(assetManager.get(rabbitEating1)),
                new TextureRegion(assetManager.get(rabbitEating2)),
                new TextureRegion(assetManager.get(rabbitEating3)),
                new TextureRegion(assetManager.get(rabbitEating4))
            }; break;
        }
        return eating;
    }
}
