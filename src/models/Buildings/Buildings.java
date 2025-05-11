package models.Buildings;

public class Buildings {
    private int height;
    private int width;
    private int startX;
    private int startY;

    public Buildings(int height, int width, int startX, int startY) {
        this.height = height;
        this.width = width;
        this.startX = startX;
        this.startY = startY;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }
}
