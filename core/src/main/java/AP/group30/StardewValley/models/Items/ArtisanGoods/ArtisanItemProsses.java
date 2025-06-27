package AP.group30.StardewValley.models.Items.ArtisanGoods;

public class ArtisanItemProsses {
    private ArtisanGood artisanGood;
    private int remainingTime;

    public ArtisanItemProsses(ArtisanGood artisanGood) {
        this.artisanGood = artisanGood;
        this.remainingTime = artisanGood.getType().getProcessingTime();
    }

    public ArtisanGood getArtisanGood() {
        return artisanGood;
    }

    public int getRemainingTime() {
        return remainingTime;
    }

    public void changeRemainingTime(int amount) {
        this.remainingTime = Math.max(0, remainingTime - amount);
    }
}
