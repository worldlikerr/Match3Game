package work.entity;

import java.util.ArrayList;
import java.util.Random;
//游戏主体逻辑类
public class GameBoard {
    public static final int ROWS = 8;
    public static final int COLS = 8;
    private Tile[][] board = new Tile[ROWS][COLS];
    private Random random = new Random();
    //元素容器,储存选中元素
    public ArrayList<Tile> chooseTile;

    //初始化格子内元素
    public GameBoard() {
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
        chooseTile=new ArrayList<Tile>();
    }

    //检测所有元素是否可消除并标记
    public boolean checkMatches() {
        //检测交换元素后出现可消除的元素
        boolean isMatch=false;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                isMatch=checkEveryTile(row,col);
            }
        }
        return isMatch;
    }
    private boolean checkEveryTile(int row,int col){
        Tile tile=board[row][col];
        boolean isMatch=false;
        //列
        int up=0,down=0,countCol=0;
        for (int c=col;c>=0;c--){
            if (tile.getType()==board[row][c].getType()){
                countCol++;
                up++;
            }
            else
                break;
        }
        for (int c=col;c<=COLS;c++){
            if (tile.getType()==board[row][c].getType()){
                countCol++;
                down++;
            }
            else
                break;
        }
        if (countCol>2){
            isMatch=true;
            for (int i=0;i<=up;i++){
                board[row][col-i].setMatched(true);
            }
            for (int i=0;i<=up;i++){
                board[row][col+i].setMatched(true);
            }
        }
        //行
        int left=0,right=0,countRow=0;
        for (int r=row;r>=0;r--){
            if (tile.getType()==board[r][col].getType()){
                countRow++;
                left++;
            }
            else
                break;
        }
        for (int r=row;r<=ROWS;r++){
            if (tile.getType()==board[r][col].getType()){
                countRow++;
                right++;
            }
            else
                break;
        }
        if (countRow>2){
            isMatch=true;
            for (int i=0;i<=left;i--){
                board[row-i][col].setMatched(true);
            }
            for (int i=0;i<=right;i++){
                board[row+i][col].setMatched(true);
            }
        }
        return isMatch;
    }

    //每列降下旧元素
    public void dropTiles() {

    }

    //每列生成新元素
    public void addNewTiles() {
        // Implement new tile addition logic
    }

    //刷新二维元素表直到无可消除元素
    public void update(){
        while (checkMatches()){
            dropTiles();
            addNewTiles();
        }
    }
    public Tile[][] getBoard() {
        return board;
    }

}

