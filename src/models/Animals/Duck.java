package models.Animals;

import models.App;
import models.Buildings.RanchCosts;
import models.Items.Item;
import models.Items.Products.AnimalProductType;
import models.Players.Player;
import views.GameMenu;

import java.util.Random;

public class Duck extends Animal {
    Item duckEgg;
    Item duckFeather;
    int daysPassed = 0;
    public Duck(int price, String name, int friendship, boolean fedToday, boolean petToday, int x, int y) {
        super(price, name, friendship, fedToday, petToday, x, y, RanchCosts.DUCK);
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
                    this.duckFeather = new Item(1, "duck feather", AnimalProductType.DUCK_FEATHER.getPrice());
                    if (quality >= 0 && quality < 0.5) {
                        this.duckFeather.setQuality("regular");
                        this.duckFeather.setCof(1);
                    } else if (quality >= 0.5 && quality < 0.7) {
                        this.duckFeather.setQuality("silver");
                        this.duckFeather.setCof(1.25);
                    } else if (quality >= 0.7 && quality < 0.9) {
                        this.duckFeather.setQuality("gold");
                        this.duckFeather.setCof(1.5);
                    } else if (quality >= 0.9) {
                        this.duckFeather.setQuality("iridium");
                        this.duckFeather.setCof(2);
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
        this.duckEgg = new Item(1, "duck egg", AnimalProductType.DUCK_EGG.getPrice());
        if (quality >= 0 && quality < 0.5) {
            this.duckEgg.setQuality("regular");
            this.duckEgg.setCof(1);
        } else if (quality >= 0.5 && quality < 0.7) {
            this.duckEgg.setQuality("silver");
            this.duckEgg.setCof(1.25);
        } else if (quality >= 0.7 && quality < 0.9) {
            this.duckEgg.setQuality("gold");
            this.duckEgg.setCof(1.5);
        } else if (quality >= 0.9) {
            this.duckEgg.setQuality("iridium");
            this.duckEgg.setCof(2);
        }
    }
    @Override
    public void collectProduct() {
        if (!isProductReady()) {
            GameMenu.printResult("Product is not ready!");
        } else {
            Player player = App.getCurrentGame().getCurrentPlayer();
            Item newItem;
            if (this.duckEgg == null) {
                newItem = this.duckFeather;
                if(Item.findItemByName(duckFeather.getName(), player.getBackPack().getItems()) != null) {
                    Item.findItemByName(duckFeather.getName(), player.getBackPack().getItems()).setCount(Item.findItemByName(duckEgg.getName(), player.getBackPack().getItems()).getCount() + 1);
                    GameMenu.printResult(newItem.getName() + " has been collected!");
                    this.duckFeather = null;
                    this.duckEgg = null;
                    this.setProductReady(false);
                } else {
                    if (player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()) {
                        GameMenu.printResult("You don't have enough space in your backpack!");
                    } else {
                        player.getBackPack().addItem(newItem);
                        GameMenu.printResult(newItem.getName() + " has been collected!");
                        this.duckEgg = null;
                        this.duckFeather = null;
                        this.setProductReady(false);
                    }
                }
            }else{
                newItem = this.duckEgg;
                if(Item.findItemByName(duckEgg.getName(), player.getBackPack().getItems()) != null) {
                    Item.findItemByName(duckEgg.getName(), player.getBackPack().getItems()).setCount(Item.findItemByName(duckEgg.getName(), player.getBackPack().getItems()).getCount() + 1);
                    GameMenu.printResult(newItem.getName() + " has been collected!");
                    this.duckFeather = null;
                    this.duckEgg = null;
                    this.setProductReady(false);
                } else {
                    if (player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()) {
                        GameMenu.printResult("You don't have enough space in your backpack!");
                    } else {
                        player.getBackPack().addItem(newItem);
                        GameMenu.printResult(newItem.getName() + " has been collected!");
                        this.duckEgg = null;
                        this.duckFeather = null;
                        this.setProductReady(false);
                    }
                }
            }
        }
    }
}
