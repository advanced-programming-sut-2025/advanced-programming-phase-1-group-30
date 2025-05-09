package models.Items.Products;

import models.TimeAndDate.Season;

public enum ForgingSeedType {
    test("test", null, CropType.test);
    
    private final String name;
    private final Season season;
    private final CropType crop;

    private ForgingSeedType(String name, Season season, CropType crop) {
        this.name = name;
        this.season = season;
        this.crop = crop;
    }
    
    public String getName() {
        return name;
    }
    public Season getSeason() {
        return season;
    }
    public CropType getCrop() {
        return crop;
    }
}
