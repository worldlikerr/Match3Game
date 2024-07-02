package work.entity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

//元素类
public class Tile {
    private Type type;
    private boolean isMatched;
    private ImageView imageView;

    public Tile(Type type) {
        this.type = type;
        this.isMatched = false;
        this.imageView = createImageView(this.type);
    }

    public Type getType() {
        return type;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public ImageView getImageView() {
        return imageView;
    }

    private ImageView createImageView(Type type) {
        String imagePath = switch (type) {
            case Blue -> "C:\\Users\\death\\IdeaProjects\\Match-3 Game\\src\\work\\gameResource\\image\\block\\blue_body_squircle.png";
            case Red -> "C:\\Users\\death\\IdeaProjects\\Match-3 Game\\src\\work\\gameResource\\image\\block\\red_body_squircle.png";
            case Green -> "C:\\Users\\death\\IdeaProjects\\Match-3 Game\\src\\work\\gameResource\\image\\block\\green_body_squircle.png";
            case Yellow -> "C:\\Users\\death\\IdeaProjects\\Match-3 Game\\src\\work\\gameResource\\image\\block\\yellow_body_squircle.png";
            case Purple -> "C:\\Users\\death\\IdeaProjects\\Match-3 Game\\src\\work\\gameResource\\image\\block\\purple_body_squircle.png";
            case Pink -> "C:\\Users\\death\\IdeaProjects\\Match-3 Game\\src\\work\\gameResource\\image\\block\\pink_body_squircle.png";
            default -> "C:\\Users\\death\\IdeaProjects\\Match-3 Game\\src\\work\\gameResource\\image\\block\\blue_body_squircle.png";
        };

        Image image = new Image("file:" + imagePath); // 使用 "file:" 前缀加载本地文件
        if (image.isError()) {
            System.out.println("Error loading image: " + imagePath);
        }

        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(GamePanel.TILE_SIZE);
        imageView.setFitHeight(GamePanel.TILE_SIZE);
        return imageView;
    }
}

