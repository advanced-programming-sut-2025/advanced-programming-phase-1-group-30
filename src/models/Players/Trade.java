package models.Players;

public class Trade {
    private Player getter;
    private Player giver;
    private String offeredItem;
    private boolean getsMoney;
    private int money;
    private String requestedItem;
    private String type;
    private String moneyOrItem;
    private int offerAmount;
    private int requestAmount;
    private int id;

    public Trade(Player giver, Player getter, String offeredItem, int offerAmount, boolean getsMoney, int money, String requestedItem, int requestAmount, int id) {
        this.giver = giver;
        this.getter = getter;
        this.offeredItem = offeredItem;
        this.getsMoney = getsMoney;
        this.money = money;
        this.requestedItem = requestedItem;
        this.offerAmount = offerAmount;
        this.requestAmount = requestAmount;
        this.id = id;
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
    public String getOfferedItem() {
        return offeredItem;
    }
    public void setOfferedItem(String tradedItem) {
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
    public String getRequestedItem() {
        return requestedItem;
    }
    public void setRequestedItem(String gottenItem) {
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

    public int getOfferAmount() {
        return offerAmount;
    }

    public int getRequestAmount() {
        return requestAmount;
    }

    public int getId() {
        return id;
    }
}
