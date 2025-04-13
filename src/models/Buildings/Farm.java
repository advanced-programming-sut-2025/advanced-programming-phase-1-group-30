package models.Buildings;

import java.util.ArrayList;

public class Farm {
    private Hut hut;
    private GreenHouse greenHouse;
    private ArrayList<Lake> lakes = new ArrayList<>();
    private Quarry quarry;
    private ArrayList<Barn> barns = new ArrayList<>();
    private ArrayList<Coop> Coops = new ArrayList<>();

    public Farm(Hut hut, GreenHouse greenHouse, ArrayList<Lake> lakes, Quarry quarry, ArrayList<Barn> barns,
            ArrayList<Coop> coops) {
        this.hut = hut;
        this.greenHouse = greenHouse;
        this.lakes = lakes;
        this.quarry = quarry;
        this.barns = barns;
        Coops = coops;
    }

    public Hut getHut() {
        return hut;
    }
    public void setHut(Hut hut) {
        this.hut = hut;
    }
    public GreenHouse getGreenHouse() {
        return greenHouse;
    }
    public void setGreenHouse(GreenHouse greenHouse) {
        this.greenHouse = greenHouse;
    }
    public ArrayList<Lake> getLakes() {
        return lakes;
    }
    public void setLakes(ArrayList<Lake> lakes) {
        this.lakes = lakes;
    }
    public Quarry getQuarry() {
        return quarry;
    }
    public void setQuarry(Quarry quarry) {
        this.quarry = quarry;
    }
    public ArrayList<Barn> getBarns() {
        return barns;
    }
    public void setBarns(ArrayList<Barn> barns) {
        this.barns = barns;
    }
    public ArrayList<Coop> getCoops() {
        return Coops;
    }
    public void setCoops(ArrayList<Coop> coops) {
        Coops = coops;
    }
}
