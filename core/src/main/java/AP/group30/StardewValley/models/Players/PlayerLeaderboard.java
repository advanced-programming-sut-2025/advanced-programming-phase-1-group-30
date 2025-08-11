package AP.group30.StardewValley.models.Players;

public class PlayerLeaderboard {
    private final String username;
    private int money;
    private int farming;
    private int foraging;
    private int fishing;
    private int mining;
    private int numberOfQuests;

    public PlayerLeaderboard(String username, int money, int farming, int foraging, int fishing, int mining, int numberOfQuests) {
        this.username = username;
        this.money = money;
        this.farming = farming;
        this.foraging = foraging;
        this.fishing = fishing;
        this.mining = mining;
        this.numberOfQuests = numberOfQuests;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getFarming() {
        return farming;
    }

    public void setFarming(int farming) {
        this.farming = farming;
    }

    public int getForaging() {
        return foraging;
    }

    public void setForaging(int foraging) {
        this.foraging = foraging;
    }

    public int getFishing() {
        return fishing;
    }

    public void setFishing(int fishing) {
        this.fishing = fishing;
    }

    public int getMining() {
        return mining;
    }

    public void setMining(int mining) {
        this.mining = mining;
    }

    public String getUsername() {
        return username;
    }

    public int getNumberOfQuests() {
        return numberOfQuests;
    }

    public void setNumberOfQuests(int numberOfQuests) {
        this.numberOfQuests = numberOfQuests;
    }
}
