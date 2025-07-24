package AP.group30.StardewValley.models.Animals;

import AP.group30.StardewValley.models.App;
import AP.group30.StardewValley.models.Buildings.RanchCosts;
import AP.group30.StardewValley.models.GameAssetManager;
import AP.group30.StardewValley.models.Items.Item;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.Products.AnimalProductType;
import AP.group30.StardewValley.models.Items.Tools.Shear;
import AP.group30.StardewValley.models.Players.Player;
import AP.group30.StardewValley.views.GameMenu;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.Random;

public class Sheep extends Animal {
    Item wool;
    int daysPassed = 0;
    public Sheep(int price, String name, int friendship, boolean fedToday, boolean petToday, int x, int y) {
        super(price, name, friendship, fedToday, petToday, x, y, RanchCosts.SHEEP);
        initAnimations(GameAssetManager.getBack("sheep"), GameAssetManager.getFront("sheep"), GameAssetManager.getLeft("sheep"),
            GameAssetManager.getRight("sheep"), GameAssetManager.getEating("sheep"), new TextureRegion(GameAssetManager.assetManager.get(GameAssetManager.sheepFront1)));
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
        this.wool = new Item(1, "wool", AnimalProductType.WOOL.getPrice(), ItemTexture.WOOD.getTexture());
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
