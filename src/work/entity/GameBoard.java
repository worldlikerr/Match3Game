package work.entity;

import java.util.ArrayList;
import java.util.Random;
//游戏主体逻辑类
public class GameBoard {
    public static final int ROWS = 8;
    public static final int COLS = 8;
    private Tile[][] board = new Tile[ROWS][COLS];
    private Random random = new Random();
//    public GamePanel gamePanel=GamePanel.getInstance();
    //元素容器,储存选中元素
    public ArrayList<PointTile> chooseTile;

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
        chooseTile= new ArrayList<>();

        update();
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
        for (int c=col;c<COLS;c++){
            if (tile.getType()==board[row][c].getType()){
                countCol++;
                down++;
            }
            else
                break;
        }
        if (countCol>2){
            isMatch=true;
            for (int i=0;i<up;i++){
                board[row][col-i].setMatched(true);
            }
            for (int i=0;i<down;i++){
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
        for (int r=row;r<ROWS;r++){
            if (tile.getType()==board[r][col].getType()){
                countRow++;
                right++;
            }
            else
                break;
        }
        if (countRow>2){
            isMatch=true;
            for (int i=0;i<left;i++){
                board[row-i][col].setMatched(true);
            }
            for (int i=0;i<right;i++){
                board[row+i][col].setMatched(true);
            }
        }
        return isMatch;
    }

    //每列降下旧元素
    public void dropTiles() {
        //后续优化一下,看得我头痛
        for (int c=0;c<COLS;c++){
            for (int r=ROWS-1;r>=0;r--){
                if (board[r][c].isMatched()){
                    for (int i=r-1;i>=0;i--){
                        if (!board[i][c].isMatched()){
                            //使两者的对象不同
                            board[r][c]=new Tile(board[i][c].getType());
                            board[i][c].setMatched(true);
                        }
                    }
                }
            }
        }
    }

    //每列生成新元素
    public void addNewTiles() {
        for (int c=0;c<COLS;c++){
            for (int r=0;r<ROWS;r++){
                if (board[r][c].isMatched()){
                    Type randomType = Type.values()[random.nextInt(Type.values().length)];
                    board[r][c]=new Tile(randomType);
                }
                else
                    break;
            }
        }
    }

    //刷新二维元素表直到无可消除元素
    public void update(){
        checkMatches();
        System.out.println("checkMatches done");
        dropTiles();
        System.out.println("dropTiles done");
        addNewTiles();
        System.out.println("addNewTiles done");
//            gamePanel.drawBoard();

    }

    //交换两个元素
    public void exchange(){
        PointTile first= chooseTile.getFirst();
        PointTile second=chooseTile.getLast();
        //不相邻
        if (!isAdjacent(first.getRow(), first.getCol(), second.getRow(), second.getCol())){
            chooseTile.clear();
            System.out.println("两个元素不相邻");
            return;
        }
        //交换相同元素
        if (first.getTile().getType()==second.getTile().getType()){
            chooseTile.clear();
            System.out.println("不可交换相同元素");
            return;
        }

        //相邻
        if (isAdjacent(first.getRow(), first.getCol(), second.getRow(), second.getCol())){
            board[first.getRow()][first.getCol()]=new Tile(second.getTile().getType());
            board[second.getRow()][second.getCol()]=new Tile(first.getTile().getType());
            //交换后出现可消除元素
            //
            if (checkEveryTile(first.getRow(), first.getCol())||checkEveryTile(second.getRow(),second.getCol())){
                chooseTile.clear();
                update();
                System.out.println("交换成功");
            }
            //交换后无可消除元素
            else{
                board[first.getRow()][first.getCol()]=new Tile(first.getTile().getType());
                board[second.getRow()][second.getCol()]=new Tile(second.getTile().getType());
                chooseTile.clear();
                System.out.println("交换失败");
            }
        }
    }
    //判断是否相邻
    private boolean isAdjacent(int row1,int col1,int row2,int col2){
        //同行
        if (row1==row2&&Math.abs(col1-col2)==1)
            return true;
        //同列
        if (col1==col2&&Math.abs(row1-row2)==1)
            return true;
        return false;
    }

    public Tile[][] getBoard() {
        return board;
    }
}

