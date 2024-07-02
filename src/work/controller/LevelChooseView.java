package work.controller;

import javafx.event.ActionEvent;
import work.MainAPP;
import work.entity.PowerManager;

import java.io.IOException;

public class LevelChooseView {
    public void Back(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/MenuView.fxml","主菜单");
    }

    public void ToLevel1(ActionEvent actionEvent) throws Exception {
        PowerManager powerManager=PowerManager.getInstance();
        if (powerManager.getPower()<5){
            MainAPP.toRemindScene("体力不足");
        }
        else {
            powerManager.reducePower(5);
            MainAPP.setRoot("view/Level1View.fxml");
        }
    }

    public void ToLevel2(ActionEvent actionEvent) throws IOException {
        PowerManager powerManager=PowerManager.getInstance();
        if (powerManager.getPower()<5){
            MainAPP.toRemindScene("体力不足");
        }
        else {
            powerManager.reducePower(5);
            MainAPP.setTopicRoot("view/Level2View.fxml");
        }
    }
}
