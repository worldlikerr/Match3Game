package work.entity;

public class PointTile {
    private Tile tile;
    private int row;
    private int col;

    public PointTile(Tile tile, int row, int col) {
        this.tile = tile;
        this.row = row;
        this.col = col;
    }

    public Tile getTile() {
        return tile;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }
}
