package models;

public class Trade {
    private Player giver;
    private Player getter;
    private Item tradedItem;
    private boolean getsMoney;
    private int money;
    private Item gottenItem;

    public Trade(Player giver, Player getter, Item tradedItem, boolean getsMoney, int money, Item gottenItem) {
        this.giver = giver;
        this.getter = getter;
        this.tradedItem = tradedItem;
        this.getsMoney = getsMoney;
        this.money = money;
        this.gottenItem = gottenItem;
    }
    
    public Player getGiver() {
        return giver;
    }

    public void setGiver(Player giver) {
        this.giver = giver;
    }
    public Player getGetter() {
        return getter;
    }
    public void setGetter(Player getter) {
        this.getter = getter;
    }
    public Item getTradedItem() {
        return tradedItem;
    }
    public void setTradedItem(Item tradedItem) {
        this.tradedItem = tradedItem;
    }
    public boolean isGetsMoney() {
        return getsMoney;
    }
    public void setGetsMoney(boolean getsMoney) {
        this.getsMoney = getsMoney;
    }
    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money = money;
    }
    public Item getGottenItem() {
        return gottenItem;
    }
    public void setGottenItem(Item gottenItem) {
        this.gottenItem = gottenItem;
    }
}
