package AP.group30.StardewValley.models.Animals;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Buildings.RanchCosts;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.Products.AnimalProductType;
import AP.group30.StardewValley.models.Items.Tools.MilkPail;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.GameMenu;

import java.util.Random;

public class Cow extends Animal {
    Item milk;
    Item bigMilk;
    public Cow(int price, String name, int friendship, boolean fedToday, boolean petToday, int x, int y) {
        super(price, name, friendship, fedToday, petToday, x, y, RanchCosts.COW);
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
                this.bigMilk = new Item(1, "big milk", AnimalProductType.BIG_MILK.getPrice());
                if (quality >= 0 && quality < 0.5) {
                    this.bigMilk.setQuality("regular");
                    this.bigMilk.setCof(1);
                } else if (quality >= 0.5 && quality < 0.7) {
                    this.bigMilk.setQuality("silver");
                    this.bigMilk.setCof(1.25);
                } else if (quality >= 0.7 && quality < 0.9) {
                    this.bigMilk.setQuality("gold");
                    this.bigMilk.setCof(1.5);
                } else if (quality >= 0.9) {
                    this.bigMilk.setQuality("iridium");
                    this.bigMilk.setCof(2);
                }
            } else {
                qualityAssign(quality);
            }
        }
        this.setProductReady(true);
    }

    private void qualityAssign(double quality) {
        this.milk = new Item(1, "milk", AnimalProductType.MILK.getPrice());
        if (quality >= 0 && quality < 0.5) {
            this.milk.setQuality("regular");
            this.milk.setCof(1);
        } else if (quality >= 0.5 && quality < 0.7) {
            this.milk.setQuality("silver");
            this.milk.setCof(1.25);
        } else if (quality >= 0.7 && quality < 0.9) {
            this.milk.setQuality("gold");
            this.milk.setCof(1.5);
        } else if (quality >= 0.9) {
            this.milk.setQuality("iridium");
            this.milk.setCof(2);
        }
    }

    @Override
    public void collectProduct() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (!(player.getWield() instanceof MilkPail)) {
            GameMenu.printResult("You have to use Milk Pail!");
            return;
        }
        if (!isProductReady()) {
            GameMenu.printResult("Product is not ready!");
        } else {
            Item newItem;
            if (this.milk == null) {
                newItem = this.bigMilk;
                if(Item.findItemByName(bigMilk.getName(), player.getBackPack().getItems()) != null){
                    Item.findItemByName(bigMilk.getName(), player.getBackPack().getItems()).setCount(Item.findItemByName(bigMilk.getName(), player.getBackPack().getItems()).getCount() + 1);
                    setFriendship(Math.min(getFriendship() + 5, 1000));
                    GameMenu.printResult(newItem.getName() + " has been collected!");
                    this.milk = null;
                    this.bigMilk = null;
                    this.setProductReady(false);
                }else{
                    if(player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()){
                        GameMenu.printResult("You don't have enough space in your backpack!");
                    } else {
                        player.getBackPack().addItem(newItem);
                        setFriendship(Math.min(getFriendship() + 5, 1000));
                        GameMenu.printResult(newItem.getName() + " has been collected!");
                        this.milk = null;
                        this.bigMilk = null;
                        this.setProductReady(false);
                    }
                }
            } else {
                newItem = this.milk;
                if (Item.findItemByName(milk.getName(), player.getBackPack().getItems()) != null) {
                    Item.findItemByName(milk.getName(), player.getBackPack().getItems()).setCount(Item.findItemByName(milk.getName(), player.getBackPack().getItems()).getCount() + 1);
                    setFriendship(Math.min(getFriendship() + 5, 1000));
                    GameMenu.printResult(newItem.getName() + " has been collected!");
                    this.milk = null;
                    this.bigMilk = null;
                    this.setProductReady(false);
                } else {
                    if (player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()) {
                        GameMenu.printResult("You don't have enough space in your backpack!");
                    } else {
                        player.getBackPack().addItem(newItem);
                        setFriendship(Math.min(getFriendship() + 5, 1000));
                        GameMenu.printResult(newItem.getName() + " has been collected!");
                        this.milk = null;
                        this.bigMilk = null;
                        this.setProductReady(false);
                    }
                }
            }
        }
    }
}
