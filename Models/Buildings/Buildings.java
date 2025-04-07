package Models.Buildings;

public class Buildings {
    private int lenght;
    private int width;
    private int startX;
    private int startY;

    public Buildings(int lenght, int width, int startX, int startY) {
        this.lenght = lenght;
        this.width = width;
        this.startX = startX;
        this.startY = startY;
    }

    public int getLenght() {
        return lenght;
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
