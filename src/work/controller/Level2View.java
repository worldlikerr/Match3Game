package work.controller;

import javafx.event.ActionEvent;
import work.MainAPP;

public class Level2View {
    public void Back(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/LevelChooseView.fxml","选择界面");
    }
}
