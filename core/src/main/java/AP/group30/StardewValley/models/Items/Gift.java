package AP.group30.StardewValley.models.Items;

import AP.group30.StardewValley.models.Players.Player;

public class Gift extends Item {
    private int rate;
    private boolean isRated = false;
    private Player sentPlayer;
    public Gift(int count, String name, Player sentPlayer, int price) {
        super(count, name, price, ItemTexture.WOOD.getTexture());
        this.sentPlayer = sentPlayer;
    }
    public boolean isRated() {
        return isRated;
    }
    public void setRated(boolean isRated) {
        this.isRated = isRated;
    }
    public Player getSentPlayer() {
        return sentPlayer;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }
}
