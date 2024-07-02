package work;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import work.entity.GamePanel;
import work.entity.TopicPanel;

import java.io.IOException;

public class MainAPP extends Application {
    public static Stage mainStage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        mainStage=stage;
        Pane gamePane=FXMLLoader.load(getClass().getResource("view/MenuView.fxml"));
        Scene scene=new Scene(gamePane,600,400);
        stage.setTitle("主菜单");
        stage.setScene(scene);
        stage.show();
    }

    //场景跳转方法
    public static void setRoot(String address,String title) throws Exception{
        Pane root= FXMLLoader.load(MainAPP.class.getResource(address));
        Scene scene=new Scene(root,600,400);
        mainStage.setTitle(title);
        mainStage.setScene(scene);
        mainStage.show();
    }
    //重载
    public static void setRoot(String address) throws IOException {
        Pane pane=new GamePanel();
        Pane root= FXMLLoader.load(MainAPP.class.getResource(address));
        root.getChildren().add(pane);
        pane.setLayoutX(40);
        pane.setLayoutY(40);
        Scene scene=new Scene(root,600,400);
        mainStage.setScene(scene);
        mainStage.show();
    }
    public static void setTopicRoot(String address) throws IOException {
        Pane pane=new TopicPanel();
        Pane root= FXMLLoader.load(MainAPP.class.getResource(address));
        root.getChildren().add(pane);
        pane.setLayoutX(40);
        pane.setLayoutY(40);
        Scene scene=new Scene(root,600,400);
        mainStage.setScene(scene);
        mainStage.show();
    }

}
