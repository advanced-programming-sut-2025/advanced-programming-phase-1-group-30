package AP.group30.StardewValley.models.Animals;

import AP.group30.StardewValley.models.Buildings.RanchCosts;

public class Pig extends Animal {
    public Pig(int price, String name, int friendship, boolean fedToday, boolean petToday, int x, int y) {
        super(price, name, friendship, fedToday, petToday, x, y, RanchCosts.PIG);
    }
//    @Override
//    public void produceProduct() {
//        Random random = new Random();
//
//        double x = (random.nextFloat(1) + 0.5);
//        double chance = (getFriendship() + (x * 150)) / 1500;
//    }
}
