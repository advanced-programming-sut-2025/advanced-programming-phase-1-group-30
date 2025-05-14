package models.Animals;

import models.App;
import models.Buildings.RanchCosts;
import models.Items.Item;
import models.Items.Products.AnimalProductType;
import models.Players.Player;
import views.GameMenu;

import java.util.Random;

public class Rabbit extends Animal {
    Item rabbitWool;
    Item rabbitFoot;
    int daysPassed = 0;
    public Rabbit(int price, String name, int friendship, boolean fedToday, boolean petToday, int x, int y) {
        super(price, name, friendship, fedToday, petToday, x, y, RanchCosts.RABBIT);
    }
    @Override
    public void produceProduct() {
        daysPassed++;
        if (daysPassed == 4) {
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
                    this.rabbitFoot = new Item(1, "rabbit foot", AnimalProductType.RABBIT_LEG.getPrice());
                    if (quality >= 0 && quality < 0.5) {
                        this.rabbitFoot.setQuality("regular");
                        this.rabbitFoot.setCof(1);
                    } else if (quality >= 0.5 && quality < 0.7) {
                        this.rabbitFoot.setQuality("silver");
                        this.rabbitFoot.setCof(1.25);
                    } else if (quality >= 0.7 && quality < 0.9) {
                        this.rabbitFoot.setQuality("gold");
                        this.rabbitFoot.setCof(1.5);
                    } else if (quality >= 0.9) {
                        this.rabbitFoot.setQuality("iridium");
                        this.rabbitFoot.setCof(2);
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
        this.rabbitWool = new Item(1, "rabbit wool", AnimalProductType.RABBIT_WOOL.getPrice());
        if (quality >= 0 && quality < 0.5) {
            this.rabbitWool.setQuality("regular");
            this.rabbitWool.setCof(1);
        } else if (quality >= 0.5 && quality < 0.7) {
            this.rabbitWool.setQuality("silver");
            this.rabbitWool.setCof(1.25);
        } else if (quality >= 0.7 && quality < 0.9) {
            this.rabbitWool.setQuality("gold");
            this.rabbitWool.setCof(1.5);
        } else if (quality >= 0.9) {
            this.rabbitWool.setQuality("iridium");
            this.rabbitWool.setCof(2);
        }
    }

    @Override
    public void collectProduct() {
        Player player = App.getCurrentGame().getCurrentPlayer();
        if (!isProductReady()) {
            GameMenu.printResult("Product is not ready!");
        } else {
            Item newItem;
            if (this.rabbitWool == null) {
                newItem = this.rabbitFoot;
                if(Item.findItemByName(rabbitFoot.getName(), player.getBackPack().getItems()) != null){
                    Item.findItemByName(rabbitFoot.getName(), player.getBackPack().getItems()).setCount(Item.findItemByName(rabbitFoot.getName(), player.getBackPack().getItems()).getCount() + 1);
                    GameMenu.printResult(newItem.getName() + " has been collected!");
                    this.rabbitWool = null;
                    this.rabbitFoot = null;
                    this.setProductReady(false);
                }else{
                    if(player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()){
                        GameMenu.printResult("You don't have enough space in your backpack!");
                    } else {
                        player.getBackPack().addItem(newItem);
                        setFriendship(Math.max(getFriendship() + 5, 1000));
                        GameMenu.printResult(newItem.getName() + " has been collected!");
                        this.rabbitWool = null;
                        this.rabbitFoot = null;
                        this.setProductReady(false);
                    }
                }
            } else {
                newItem = this.rabbitWool;
                if (Item.findItemByName(rabbitWool.getName(), player.getBackPack().getItems()) != null) {
                    Item.findItemByName(rabbitWool.getName(), player.getBackPack().getItems()).setCount(Item.findItemByName(rabbitWool.getName(), player.getBackPack().getItems()).getCount() + 1);
                    GameMenu.printResult(newItem.getName() + " has been collected!");
                    this.rabbitWool = null;
                    this.rabbitFoot = null;
                    this.setProductReady(false);
                } else {
                    if (player.getBackPack().getItems().size() == player.getBackPack().getType().getCapacity()) {
                        GameMenu.printResult("You don't have enough space in your backpack!");
                    } else {
                        player.getBackPack().addItem(newItem);
                        setFriendship(Math.max(getFriendship() + 5, 1000));
                        GameMenu.printResult(newItem.getName() + " has been collected!");
                        this.rabbitWool = null;
                        this.rabbitFoot = null;
                        this.setProductReady(false);
                    }
                }
            }
        }
    }
}
