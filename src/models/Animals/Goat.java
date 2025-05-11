package models.Animals;

import models.App;
import models.Buildings.RanchCosts;
import models.Items.Item;
import models.Items.Tools.MilkPail;
import models.Players.Player;
import views.GameMenu;

import java.util.Random;

public class Goat extends Animal {
    Item goatMilk;
    Item bigGoatMilk;
    int daysPassed = 0;
    public Goat(int price, String name, int friendship, boolean fedToday, boolean petToday, int x, int y) {
        super(price, name, friendship, fedToday, petToday, x, y, RanchCosts.GOAT);
    }
    @Override
    public void produceProduct() {
        daysPassed++;
        if (daysPassed == 2) {
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
                    this.bigGoatMilk = new Item(1, "big goat milk");
                    if (quality >= 0 && quality < 0.5) {
                        this.bigGoatMilk.setQuality("regular");
                        this.bigGoatMilk.setCof(1);
                    } else if (quality >= 0.5 && quality < 0.7) {
                        this.bigGoatMilk.setQuality("silver");
                        this.bigGoatMilk.setCof(1.25);
                    } else if (quality >= 0.7 && quality < 0.9) {
                        this.bigGoatMilk.setQuality("gold");
                        this.bigGoatMilk.setCof(1.5);
                    } else if (quality >= 0.9) {
                        this.bigGoatMilk.setQuality("iridium");
                        this.bigGoatMilk.setCof(2);
                    }
                } else {
                    qualityAssign(quality);
                }
            }
            this.setProductReady(true);
            daysPassed = 0;
        }
    }

    private void qualityAssign(double quality) {
        this.goatMilk = new Item(1, "goat milk");
        if (quality >= 0 && quality < 0.5) {
            this.goatMilk.setQuality("regular");
            this.goatMilk.setCof(1);
        } else if (quality >= 0.5 && quality < 0.7) {
            this.goatMilk.setQuality("silver");
            this.goatMilk.setCof(1.25);
        } else if (quality >= 0.7 && quality < 0.9) {
            this.goatMilk.setQuality("gold");
            this.goatMilk.setCof(1.5);
        } else if (quality >= 0.9) {
            this.goatMilk.setQuality("iridium");
            this.goatMilk.setCof(2);
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
            Item newItem = this.goatMilk;
            if (this.goatMilk == null) {
                newItem = this.bigGoatMilk;
            }
            if(Item.findItemByName(bigGoatMilk.getName(), player.getBackPack().getItems()) != null){
                newItem.setCount(newItem.getCount() + 1);
            }else{
                if(player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()){
                    GameMenu.printResult("You don't have enough space in your backpack!");
                } else{
                    player.getBackPack().addItem(newItem);
                    if (newItem.getName().equals(this.goatMilk.getName())) {
                        GameMenu.printResult("Goat milk collected!");
                    } else if (newItem.getName().equals(this.bigGoatMilk.getName())) {
                        GameMenu.printResult("Big goat milk collected!");
                    }

                    this.goatMilk = null;
                    this.bigGoatMilk = null;
                }
            }
        }
    }
}
