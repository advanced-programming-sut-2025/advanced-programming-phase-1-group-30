package models.Invetory;

public class TrashCan extends Inventory {
    private TrashCanType type;

    public TrashCan(TrashCanType type) {
        this.type = type;
    }

    public TrashCanType getType() {
        return type;
    }

    public void setType(TrashCanType type) {
        this.type = type;
    }
}
