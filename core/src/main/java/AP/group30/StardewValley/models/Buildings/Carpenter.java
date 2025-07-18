package AP.group30.StardewValley.models.Buildings;


import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;

public class Carpenter extends Building {
    public Carpenter(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 20, TileTypes.CARPENTERS_SHOP, BuildingTexture.CARPENTER.getTexture());
    }
    private final int startHour = 9;
    private final int endHour = 20;

    public int getStartHour() {
        return startHour;
    }
    public int getEndHour() {
        return endHour;
    }
}
