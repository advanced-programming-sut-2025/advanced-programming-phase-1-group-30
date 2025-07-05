package AP.group30.StardewValley.models.Animals;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Buildings.RanchCosts;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.Products.AnimalProductType;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.GameMenu;

import java.util.Random;

public class Dinosaur extends Animal {
    Item dinosaurEgg;
    int daysPassed = 0;
    public Dinosaur(int price, String name, int friendship, boolean fedToday, boolean petToday, int x, int y) {
        super(price, name, friendship, fedToday, petToday, x, y, RanchCosts.DINOSAUR);
    }
    @Override
    public void produceProduct() {
        daysPassed++;
        if (daysPassed == 8) {
            Random random = new Random();
            double rand2 = random.nextDouble(1);
            double quality = (double) getFriendship() / 1000 * (0.5 + 0.5 * rand2);
            qualityAssign(quality);
            this.setProductReady(true);
            daysPassed = 0;
        }
    }
    private void qualityAssign(double quality) {
        this.dinosaurEgg = new Item(1, "dinosaur egg", AnimalProductType.DINASOUR_EGG.getPrice(), ItemTexture.WOOD.getTexture());
        if (quality >= 0 && quality < 0.5) {
            this.dinosaurEgg.setQuality("regular");
            this.dinosaurEgg.setCof(1);
        } else if (quality >= 0.5 && quality < 0.7) {
            this.dinosaurEgg.setQuality("silver");
            this.dinosaurEgg.setCof(1.25);
        } else if (quality >= 0.7 && quality < 0.9) {
            this.dinosaurEgg.setQuality("gold");
            this.dinosaurEgg.setCof(1.5);
        } else if (quality >= 0.9) {
            this.dinosaurEgg.setQuality("iridium");
            this.dinosaurEgg.setCof(2);
        }
    }
    @Override
    public void collectProduct() {
        Player player = App.getCurrentGame().getCurrentPlayer();

        if (!isProductReady()) {
            GameMenu.printResult("Product is not ready!");
        } else {
            Item newItem = this.dinosaurEgg;

            if (Item.findItemByName(dinosaurEgg.getName(), player.getBackPack().getItems()) != null) {
                Item.findItemByName(dinosaurEgg.getName(), player.getBackPack().getItems()).setCount(Item.findItemByName(dinosaurEgg.getName(), player.getBackPack().getItems()).getCount() + 1);
                GameMenu.printResult(newItem.getName() + " has been collected!");
                this.dinosaurEgg = null;
                this.setProductReady(false);
            } else {
                if(player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()){
                    GameMenu.printResult("You don't have enough space in your backpack!");
                } else{
                    player.getBackPack().addItem(newItem);
                    GameMenu.printResult("Dinosaur egg collected!");
                    this.dinosaurEgg = null;
                    this.setProductReady(false);
                }
            }
        }
    }
}
