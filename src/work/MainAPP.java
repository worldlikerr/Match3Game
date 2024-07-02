package work;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
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

    //消息输出界面
    public static void toRemindScene(String text) {
        Stage primaryStage = new Stage();
        Pane root = new Pane();
        //设置输出信息
        Label label = new Label(text);
        label.setTranslateY(60);
        label.setTranslateX(50);
        label.setFont(Font.font(20));
        //添加输出信息
        root.getChildren().add(label);

        Scene scene = new Scene(root, 300, 150);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
