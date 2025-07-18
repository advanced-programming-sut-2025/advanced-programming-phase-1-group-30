package AP.group30.StardewValley.models.Animals;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Buildings.RanchCosts;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.Products.AnimalProductType;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.GameMenu;
import java.util.Random;

public class Chicken extends Animal {
    Item egg;
    Item bigEgg;

    public Chicken(int price, String name, int friendship, boolean fedToday, boolean petToday, int x, int y) {
        super(price, name, friendship, fedToday, petToday, x, y, RanchCosts.CHICKEN);
    }
    @Override
    public void produceProduct() {
        Random random = new Random();
        double rand = random.nextDouble(100);
        double rand2 = random.nextDouble(1);
        double x = (random.nextFloat(1) + 0.5);
        double chance = (getFriendship() + (x * 150)) / 15;
        double quality = (double) getFriendship() / 1000 * (0.5 + 0.5 * rand2);
        if (getFriendship() < 100) {
            qualityAssign(quality);
        } else {
            if (rand < chance) {
                this.bigEgg = new Item(1, "big egg", AnimalProductType.BIG_EGG.getPrice(), ItemTexture.WOOD.getTexture());
                if (quality >= 0 && quality < 0.5) {
                    this.bigEgg.setQuality("regular");
                    this.bigEgg.setCof(1);
                } else if (quality >= 0.5 && quality < 0.7) {
                    this.bigEgg.setQuality("silver");
                    this.bigEgg.setCof(1.25);
                } else if (quality >= 0.7 && quality < 0.9) {
                    this.bigEgg.setQuality("gold");
                    this.bigEgg.setCof(1.5);
                } else if (quality >= 0.9) {
                    this.bigEgg.setQuality("iridium");
                    this.bigEgg.setCof(2);
                }
            } else {
                qualityAssign(quality);
            }
        }
        this.setProductReady(true);
    }

    private void qualityAssign(double quality) {
        this.egg = new Item(1, "egg", AnimalProductType.EGG.getPrice(), ItemTexture.WOOD.getTexture());
        if (quality >= 0 && quality < 0.5) {
            this.egg.setQuality("regular");
            this.egg.setCof(1);
        } else if (quality >= 0.5 && quality < 0.7) {
            this.egg.setQuality("silver");
            this.egg.setCof(1.25);
        } else if (quality >= 0.7 && quality < 0.9) {
            this.egg.setQuality("gold");
            this.egg.setCof(1.5);
        } else if (quality >= 0.9) {
            this.egg.setQuality("iridium");
            this.egg.setCof(2);
        }
    }
    @Override
    public void collectProduct() {
        if (!isProductReady()) {
            GameMenu.printResult("Product is not ready!");
        } else {
            Player player = App.getCurrentGame().getCurrentPlayer();
            Item newItem;
            if (this.egg == null) {
                newItem = this.bigEgg;
                if(Item.findItemByName(bigEgg.getName(), player.getBackPack().getItems()) != null){
                    Item.findItemByName(bigEgg.getName(), player.getBackPack().getItems()).setCount(Item.findItemByName(bigEgg.getName(), player.getBackPack().getItems()).getCount() + 1);
                    GameMenu.printResult(newItem.getName() + " collected!");
                    this.egg = null;
                    this.bigEgg = null;
                    this.setProductReady(false);
                }else{
                    if(player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()){
                        GameMenu.printResult("You don't have enough space in your backpack!");
                    } else{
                        player.getBackPack().addItem(newItem);
                        GameMenu.printResult(newItem.getName() + " collected!");
                        this.egg = null;
                        this.bigEgg = null;
                        this.setProductReady(false);
                    }
                }
            } else {
                newItem = this.egg;
                if (Item.findItemByName(egg.getName(), player.getBackPack().getItems()) != null) {
                    Item.findItemByName(egg.getName(), player.getBackPack().getItems()).setCount(Item.findItemByName(egg.getName(), player.getBackPack().getItems()).getCount() + 1);
                    GameMenu.printResult(newItem.getName() + " collected!");
                    this.egg = null;
                    this.bigEgg = null;
                    this.setProductReady(false);

                } else {
                    if (player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()) {
                        GameMenu.printResult("You don't have enough space in your backpack!");
                    } else {
                        player.getBackPack().addItem(newItem);
                        GameMenu.printResult(newItem.getName() + " collected!");
                        this.egg = null;
                        this.bigEgg = null;
                        this.setProductReady(false);
                    }
                }
            }
        }
    }
}
