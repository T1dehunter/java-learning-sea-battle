package core;

public class Point {
    private int row;
    private int cell;

    public Point(int row, int cell) {
        this.row = row;
        this.cell = cell;
    }

    public int getRow() {
        return row;
    }

    public int getCell() {
        return cell;
    }
}