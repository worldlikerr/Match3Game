package work.controller;

import javafx.event.ActionEvent;
import work.MainAPP;

public class MenuView {
    public void ToLevelChooseView(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/LevelChooseView.fxml","关卡选择");
    }
}
