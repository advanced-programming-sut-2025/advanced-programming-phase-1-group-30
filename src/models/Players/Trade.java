package models.Players;

import models.Items.Item;

public class Trade {
    private Player getter;
    private Player giver;
    private Item offeredItem;
    private boolean getsMoney;
    private int money;
    private Item requestedItem;
    private String type;
    private String moneyOrItem;

    public Trade(Player giver, Player getter, Item tradedItem, boolean getsMoney, int money, Item gottenItem) {
        this.giver = giver;
        this.getter = getter;
        this.offeredItem = tradedItem;
        this.getsMoney = getsMoney;
        this.money = money;
        this.requestedItem = gottenItem;
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
    public Item getOfferedItem() {
        return offeredItem;
    }
    public void setOfferedItem(Item tradedItem) {
        this.offeredItem = tradedItem;
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
    public Item getRequestedItem() {
        return requestedItem;
    }
    public void setRequestedItem(Item gottenItem) {
        this.requestedItem = gottenItem;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMoneyOrItem() {
        return moneyOrItem;
    }

    public void setMoneyOrItem(String moneyOrItem) {
        this.moneyOrItem = moneyOrItem;
    }
}
