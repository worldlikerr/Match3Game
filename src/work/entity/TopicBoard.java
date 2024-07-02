package work.entity;

import java.util.ArrayList;
import java.util.Random;

public class TopicBoard {
    public static final int ROWS = 8;
    public static final int COLS = 8;
    private Tile[][] board = new Tile[ROWS][COLS];
    private Random random = new Random();
    //    public GamePanel gamePanel=GamePanel.getInstance();
    //元素容器,储存选中元素
    public ArrayList<PointTile> chooseTile;

    //初始化格子内元素
    public TopicBoard() {
        initializeBoard();
    }

    private void initializeBoard() {
        //初始化棋盘元素
        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                Type randomType = Type.values()[random.nextInt(Type.values().length)];
                board[row][col] = new Tile(randomType);
            }
        }
        //初始化选中容器
        chooseTile= new ArrayList<>();

    }
    //判断三个元素是否相同
    public void isIdentical(){
        PointTile tile1=chooseTile.get(0);
        PointTile tile2=chooseTile.get(1);
        PointTile tile3=chooseTile.get(2);

        if (tile1.getTile().getType()==tile2.getTile().getType()&&tile1.getTile().getType()==tile3.getTile().getType()){
            board[tile1.getRow()][tile1.getCol()].setMatched(true);
            board[tile2.getRow()][tile2.getCol()].setMatched(true);
            board[tile3.getRow()][tile3.getCol()].setMatched(true);
        }
        else{
            System.out.println("所选元素不匹配");
        }
        chooseTile.clear();
    }

    public Tile[][] getBoard() {
        return board;
    }
}
