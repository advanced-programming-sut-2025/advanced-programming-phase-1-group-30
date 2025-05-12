package models.Animals;

import models.App;
import models.Buildings.RanchCosts;
import models.Items.Item;
import models.Items.Products.AnimalProductType;
import models.Items.Tools.MilkPail;
import models.Players.Player;
import views.GameMenu;

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
            Item newItem = this.milk;
            if (this.milk == null) {
                newItem = this.bigMilk;
            }
            if(Item.findItemByName(bigMilk.getName(), player.getBackPack().getItems()) != null){
                newItem.setCount(newItem.getCount() + 1);
            }else{
                if(player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()){
                    GameMenu.printResult("You don't have enough space in your backpack!");
                } else {
                    player.getBackPack().addItem(newItem);
                    if (newItem.getName().equals(this.milk.getName())) {
                        GameMenu.printResult("Milk collected!");
                    } else if (newItem.getName().equals(this.bigMilk.getName())) {
                        GameMenu.printResult("Big milk collected!");
                    }
                    this.milk = null;
                    this.bigMilk = null;
                }
            }
        }
    }
}
