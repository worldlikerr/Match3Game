package work.entity;

import java.util.Random;

public class GameBoard {
    private static final int ROWS = 8;
    private static final int COLS = 8;
    private Tile[][] board = new Tile[ROWS][COLS];
    private Random random = new Random();

    public GameBoard() {
        initializeBoard();
    }

    private void initializeBoard() {
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Type randomType = Type.values()[random.nextInt(Type.values().length)];
                board[row][col] = new Tile(randomType);
            }
        }
    }

    public void checkMatches() {
        // Implement match checking logic
    }

    public void removeMatches() {
        // Implement match removal logic
    }

    public void dropTiles() {
        // Implement tile dropping logic
    }

    public void addNewTiles() {
        // Implement new tile addition logic
    }

    public Tile[][] getBoard() {
        return board;
    }
}

