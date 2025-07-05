package AP.group30.StardewValley.models.Items.Products;

import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Items.ItemsInteface;
import AP.group30.StardewValley.models.TimeAndDate.Season;
import com.badlogic.gdx.graphics.Texture;

public enum ForagingTreeType implements ItemsInteface {
    ACORNS("acorns", Season.ALL, ItemTexture.WOOD.getTexture()),
    MAPLE_SEEDS("maple seeds", Season.ALL, ItemTexture.WOOD.getTexture()),
    PINE_CONES("pine cones", Season.ALL, ItemTexture.WOOD.getTexture()),
    MAHOGANY_SEEDS("mahogany seeds", Season.ALL, ItemTexture.WOOD.getTexture()),
    MUSHROOM_TREE_SEEDS("mushroom tree seeds", Season.ALL, ItemTexture.WOOD.getTexture());

    private final String name;
    private final Season season;
    private final Texture texture;

    private ForagingTreeType(String name, Season season, Texture texture) {
        this.name = name;
        this.season = season;
        this.texture = texture;
    }

    public String getName() {
        return name;
    }
    public Season getSeason() {
        return season;
    }
    public Texture getTexture() {
        return texture;
    }
}
