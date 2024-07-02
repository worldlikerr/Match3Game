package work.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class TopicPanel extends Pane {
    public static final int TILE_SIZE = 40;
    private static TopicBoard topicBoard = new TopicBoard();
    public TopicPanel() {
        setPrefSize(GameBoard.COLS * TILE_SIZE, GameBoard.ROWS * TILE_SIZE);
        drawBoard();
        setOnMouseClicked(this::handleMouseClick);
    }

    //绘制棋盘与元素
    public void drawBoard() {
        this.getChildren().clear();
        Tile[][] board = topicBoard.getBoard();
        for (int row = 0; row < GameBoard.ROWS; row++) {
            for (int col = 0; col < GameBoard.COLS; col++) {
                ImageView imageView = board[row][col].getImageView();
                if (board[row][col].isMatched()){
                    Image image = new Image("file:" + "C:\\Users\\death\\IdeaProjects\\Match-3 Game\\src\\work\\gameResource\\image\\block\\tile_grey.png");
                    imageView=new ImageView(image);
                    imageView.setFitWidth(GamePanel.TILE_SIZE);
                    imageView.setFitHeight(GamePanel.TILE_SIZE);
                }
                if (imageView != null) {
                    imageView.setX(col * GamePanel.TILE_SIZE);
                    imageView.setY(row * GamePanel.TILE_SIZE);
                    this.getChildren().add(imageView);
                } else {
                    System.out.println(STR."ImageView is null for tile at row: \{row}, col: \{col}");
                }
            }
        }
    }
    private void handleMouseClick(MouseEvent event) {
        Tile[][] board = topicBoard.getBoard();
        int row = (int) (event.getY() / TILE_SIZE);
        int col = (int) (event.getX() / TILE_SIZE);

        // Implement tile click logic here
        System.out.println(STR."\{row} \{col}");
        if (topicBoard.chooseTile.size()==2){
            PointTile pointTile=new PointTile(board[row][col],row,col);
            topicBoard.chooseTile.add(pointTile);
            topicBoard.isIdentical();
            drawBoard();
        }
        else {
            PointTile pointTile=new PointTile(board[row][col],row,col);
            topicBoard.chooseTile.add(pointTile);
        }
    }
}
