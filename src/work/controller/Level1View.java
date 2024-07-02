package work.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import work.MainAPP;

public class Level1View {
    public Label timeRemain;

    public void Back(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/LevelChooseView.fxml","关卡选择");
    }
}
