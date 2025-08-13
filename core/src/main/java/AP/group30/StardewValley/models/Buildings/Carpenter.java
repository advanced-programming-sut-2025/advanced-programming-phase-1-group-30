package AP.group30.StardewValley.models.Buildings;


import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Maps.TileTypes;

public class Carpenter extends Building {
    public Carpenter(int height, int width, int startX, int startY) {
        super(height, width, startX, startY, 9, 20, TileTypes.CARPENTERS_SHOP, BuildingTexture.CARPENTER.getTexture());
    }

    public int getStartHour() {
        int startHour = 9;
        return startHour;
    }
    public int getEndHour() {
        int endHour = 20;
        return endHour;
    }
}
