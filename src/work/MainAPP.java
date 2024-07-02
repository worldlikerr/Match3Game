package work;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainAPP extends Application {
    public static Stage mainStage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        mainStage=stage;
//        Pane gamePane=new GamePanel();
        Pane gamePane=FXMLLoader.load(getClass().getResource("view/MenuView.fxml"));
        Scene scene=new Scene(gamePane,600,400);
        stage.setTitle("主菜单");
        stage.setScene(scene);
        stage.show();
    }

    public static void setRoot(String address,String title) throws Exception{
        Pane root= FXMLLoader.load(MainAPP.class.getResource(address));
        Scene scene=new Scene(root,600,400);
        mainStage.setTitle(title);
        mainStage.setScene(scene);
        mainStage.show();
    }

}
