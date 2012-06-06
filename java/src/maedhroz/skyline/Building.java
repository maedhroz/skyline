package maedhroz.skyline;

public final class Building {

    private final int left;
    private final int height;
    private final int right;

    public Building(int left, int height, int right) {
        this.left = left;
        this.height = height;
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public int getHeight() {
        return height;
    }

    public int getRight() {
        return right;
    }
}
