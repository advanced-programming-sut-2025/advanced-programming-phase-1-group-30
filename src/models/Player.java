package models;

import models.Invetory.BackPack;
import models.Invetory.ShippingBin;
import models.enums.Skills;

import java.util.ArrayList;
import java.util.HashMap;

public class Player {
    private final String username;
    private Map map;
    private int energy;
    private ShippingBin shippingBin;
    private BackPack backPack;
    private int money;
    private final HashMap<Player, Integer> friendships = new HashMap<>();
    private final ArrayList<Skills> skills = new ArrayList<>();

    private boolean isPassedOut = false;

    public Player(String username) {
        this.username = username;
        this.map = null;
        this.energy = 100;
        this.shippingBin = null;
        this.backPack = null;
        this.money = 0;
    }

    public String getUsername() {
        return username;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public int getEnergy() {
        return energy;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }

    public ShippingBin getShippingBin() {
        return shippingBin;
    }

    public void setShippingBin(ShippingBin shippingBin) {
        this.shippingBin = shippingBin;
    }

    public BackPack getBackPack() {
        return backPack;
    }

    public void setBackPack(BackPack backPack) {
        this.backPack = backPack;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public HashMap<Player, Integer> getFriendships() {
        return friendships;
    }
    public boolean isPassedOut() {
        return isPassedOut;
    }

    public void setPassedOut(boolean passedOut) {
        isPassedOut = passedOut;
    }
    
    public ArrayList<Skills> getSkills() {
        return skills;
    }
}
