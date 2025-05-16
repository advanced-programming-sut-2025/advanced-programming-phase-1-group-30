package models.Items;

import models.Players.Player;

public class Gift extends Item {
    private int rate;
    private boolean isRated = false;
    private Player sentPlayer;
    public Gift(int count, String name, Player sentPlayer, int price) {
        super(count, name, price);
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
