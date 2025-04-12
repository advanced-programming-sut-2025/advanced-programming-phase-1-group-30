package models.Buildings;

public enum BuildingsInfo {
    House(0, 0),
    GreenHouse(0, 0),
    Quarry(0, 0),
    Lake(0, 0),
    Barn(0, 0),
    Coop(0, 0),
    Blacksmith(0, 0),
    JojaMart(0, 0),
    GeneralStore(0, 0),
    CarpenterShop(0, 0),
    FishShop(0, 0),
    Ranch(0, 0),
    StardropSaloon(0, 0);
    private final int startTime;
    private final int endTime;

    BuildingsInfo(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
