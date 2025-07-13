package AP.group30.StardewValley.models.Inventory;

public enum ShippingBinType {
    REGULAR(1.0),
    SILVER(1.25),
    GOLD(1.5),
    IRIDIUM(2.0);

    private final double priceMultiplier;

    ShippingBinType(double priceMultiplier) {
        this.priceMultiplier = priceMultiplier;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    public double calculateNewPrice(double basePrice, double coff) {
        return basePrice * priceMultiplier * coff;
    }
}
