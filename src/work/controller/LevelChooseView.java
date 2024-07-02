package work.controller;

import javafx.event.ActionEvent;
import work.MainAPP;

public class LevelChooseView {
    public void Back(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/MenuView.fxml","主菜单");
    }

    public void ToLevel1(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/Level1View.fxml","第一管");
    }
}
