package work;

import work.entity.GameBoard;
import work.entity.Tile;

public class Test {
    public static void main(String[] args) {
        GameBoard gameBoard=new GameBoard();
        Tile[][] board =gameBoard.getBoard();
        System.out.println(board[1][1].getType());
    }
}
