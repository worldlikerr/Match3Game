package work.entity;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

//面板类,用于绘制棋盘与格子,鼠标监听
public class GamePanel extends Pane {
    //绘制的宽度
    private static final int TILE_SIZE = 40;
    private static GameBoard gameBoard = new GameBoard();
    public static GamePanel instance;
    public static synchronized GamePanel getInstance(){
        if (instance==null)
            instance=new GamePanel();
        return instance;
    }

    public GamePanel() {
        setPrefSize(GameBoard.COLS * TILE_SIZE, GameBoard.ROWS * TILE_SIZE);
        drawBoard();
        setOnMouseClicked(this::handleMouseClick);
    }

    //绘制棋盘与元素
    public void drawBoard() {
        Tile[][] board = gameBoard.getBoard();
        for (int row = 0; row < GameBoard.ROWS; row++) {
            for (int col = 0; col < GameBoard.COLS; col++) {
                Rectangle rect = new Rectangle(col * TILE_SIZE, row * TILE_SIZE, TILE_SIZE, TILE_SIZE);
                rect.setFill(getColor(board[row][col].getType().getIndex()));
                getChildren().add(rect);
            }
        }
    }

    //鼠标监听
    private void handleMouseClick(MouseEvent event) {
        Tile[][] board = gameBoard.getBoard();
        int row = (int) (event.getY() / TILE_SIZE);
        int col = (int) (event.getX() / TILE_SIZE);

        // Implement tile click logic here
        System.out.println(STR."\{row} \{col}");

        if (gameBoard.chooseTile.isEmpty()){
            PointTile pointTile=new PointTile(board[row][col],row,col);
            gameBoard.chooseTile.add(pointTile);
            return;
        }
        if (gameBoard.chooseTile.size()==1){
            PointTile pointTile=new PointTile(board[row][col],row,col);
            gameBoard.chooseTile.add(pointTile);
            gameBoard.exchange();
//            System.out.println("1");
//            System.out.println(STR."\{gameBoard.chooseTile.getFirst().getTile().getType()}");
//            System.out.println(STR."\{gameBoard.chooseTile.getLast().getTile().getType()}");
            drawBoard();
        }
    }

    private static Color getColor(int type) {
        return switch (type) {
            case 1 -> Color.BLUE;
            case 2 -> Color.GREEN;
            case 3 -> Color.PINK;
            case 4 -> Color.PURPLE;
            case 5 -> Color.RED;
            default -> Color.YELLOW;
        };
    }
}

