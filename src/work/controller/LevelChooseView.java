package work.controller;

import javafx.event.ActionEvent;
import work.MainAPP;

import java.io.IOException;

public class LevelChooseView {
    public void Back(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/MenuView.fxml","主菜单");
    }

    public void ToLevel1(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/Level1View.fxml");
    }

    public void ToLevel2(ActionEvent actionEvent) throws IOException {
        MainAPP.setTopicRoot("view/Level2View.fxml");
    }
}
