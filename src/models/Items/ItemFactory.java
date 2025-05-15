package models.Items;

public interface ItemFactory<T extends ItemsInteface> {
    Item create(int count, T recipe);
}
