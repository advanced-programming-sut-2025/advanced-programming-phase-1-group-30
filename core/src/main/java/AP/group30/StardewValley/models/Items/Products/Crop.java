package AP.group30.StardewValley.models.Items.Products;
import AP.group30.StardewValley.models.GameObjects;
import AP.group30.StardewValley.models.Items.ItemTexture;
import AP.group30.StardewValley.models.Maps.Map;
import AP.group30.StardewValley.views.StartMenus.RegisterMenu;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.ArrayList;

public class Crop extends Product implements GameObjects {
    private final CropType type;
    private ArrayList<Integer> stages;
    int currentStage = 0;
    private int daysPassed = 0;
    private boolean notNeedWaterAnymore = false;
    private boolean wateredToday = false;
    private int daysNotWatered = 0;
    private int regrowthTime = 0;
    int x, y;
    java.util.Map<Integer, Texture> stageTextureMap = new java.util.HashMap<>();

    public Crop(int count, CropType type) {
        super(count, type.getName(), type.getPrice(), type.getTexture());
        this.type = type;
        stages = type.getStages();
        for (int i = 0; i < stages.size(); i++) {
            stageTextureMap.put(i, type.getStageTextures().get(i));
        }
    }

    public CropType getType() {
        return type;
    }

    public ArrayList<Integer> getStages() {
        return stages;
    }
    public int getCurrentStage() {
        return currentStage;
    }
    public void setCurrentStage(int currentStage) {
        this.currentStage = currentStage;
    }

    public int getDaysPassed() {
        return daysPassed;
    }

    public void setDaysPassed(int daysPassed) {
        this.daysPassed = daysPassed;
    }

    public boolean isNotNeedWaterAnymore() {
        return notNeedWaterAnymore;
    }

    public void setNotNeedWaterAnymore(boolean notNeedWaterAnymore) {
        this.notNeedWaterAnymore = notNeedWaterAnymore;
    }

    public boolean isWateredToday() {
        return wateredToday;
    }

    public void setWateredToday(boolean wateredToday) {
        this.wateredToday = wateredToday;
    }

    public int getDaysNotWatered() {
        return daysNotWatered;
    }

    public void setDaysNotWatered(int daysNotWatered) {
        this.daysNotWatered = daysNotWatered;
    }

    public int getRegrowthTime() {
        return regrowthTime;
    }

    public void setRegrowthTime(int regrowthTime) {
        this.regrowthTime = regrowthTime;
    }

    @Override
    public int getRenderY() {
        return y * 32;
    }
    @Override
    public void render(SpriteBatch batch) {
        if(RegisterMenu.gameScreen.getGreenhouseScreen().isVisible()){
            batch.draw(stageTextureMap.get(currentStage) , Gdx.graphics.getWidth() / 2.5f + x * 32,
                Gdx.graphics.getHeight() / 3.93f + y * 32, 32, 32);
        } else {
            batch.draw(stageTextureMap.get(currentStage), x * 32, y * 32, 32, 32);
        }
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
