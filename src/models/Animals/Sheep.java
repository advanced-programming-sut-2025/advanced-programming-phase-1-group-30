package models.Animals;

import models.App;
import models.Buildings.RanchCosts;
import models.Items.Item;
import models.Items.Products.AnimalProductType;
import models.Items.Tools.Shear;
import models.Players.Player;
import views.GameMenu;

import java.util.Random;

public class Sheep extends Animal {
    Item wool;
    int daysPassed = 0;
    public Sheep(int price, String name, int friendship, boolean fedToday, boolean petToday, int x, int y) {
        super(price, name, friendship, fedToday, petToday, x, y, RanchCosts.SHEEP);
    }
    @Override
    public void produceProduct() {
        daysPassed++;
        if (daysPassed == 3) {
            Random random = new Random();
            double rand2 = random.nextDouble(1);
            double quality = (double) getFriendship() / 1000 * (0.5 + 0.5 * rand2);
            qualityAssign(quality);
            this.setProductReady(true);
            daysPassed = 0;
        }
    }
    private void qualityAssign(double quality) {
        this.wool = new Item(1, "wool", AnimalProductType.WOOL.getPrice());
        if (quality >= 0 && quality < 0.5) {
            this.wool.setQuality("regular");
            this.wool.setCof(1);
        } else if (quality >= 0.5 && quality < 0.7) {
            this.wool.setQuality("silver");
            this.wool.setCof(1.25);
        } else if (quality >= 0.7 && quality < 0.9) {
            this.wool.setQuality("gold");
            this.wool.setCof(1.5);
        } else if (quality >= 0.9) {
            this.wool.setQuality("iridium");
            this.wool.setCof(2);
        }
    }
    @Override
    public void collectProduct() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (!(player.getWield() instanceof Shear)) {
            GameMenu.printResult("You have to use Shear!");
            return;
        }
        if (!isProductReady()) {
            GameMenu.printResult("Product is not ready!");
        } else {
            Item newItem = this.wool;
            if (Item.findItemByName(wool.getName(), player.getBackPack().getItems()) != null) {
                Item.findItemByName(wool.getName(), player.getBackPack().getItems()).setCount(Item.findItemByName(wool.getName(), player.getBackPack().getItems()).getCount() + 1);
                GameMenu.printResult(newItem.getName() + " has been collected!");
                this.wool = null;
                this.setProductReady(false);
            } else {
                if(player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()){
                    GameMenu.printResult("You don't have enough space in your backpack!");
                } else{
                    player.getBackPack().addItem(newItem);
                    setFriendship(Math.max(getFriendship() + 5, 1000));
                    GameMenu.printResult("Wool collected!");
                    this.wool = null;
                    this.setProductReady(false);
                }
            }
        }
    }
}
