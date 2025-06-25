package AP.group30.StardewValley.models.Items;

public interface ItemFactory<T extends ItemsInteface> {
    Item create(int count, T recipe);
}
