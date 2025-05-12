package models.Items;

import models.Players.Player;

public class Gift extends Item {
    private boolean isRated = false;
    private Player sentPlayer;
    public Gift(int count, String name, Player sentPlayer) {
        super(count, name);
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

}
