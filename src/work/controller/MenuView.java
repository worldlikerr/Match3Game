package work.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import work.MainAPP;
import work.entity.PowerManager;

public class MenuView {
    public Label remainPower;

    @FXML
    public void initialize(){
        PowerManager powerManager=PowerManager.getInstance();
        remainPower.setText(STR."剩余体力:\{powerManager.getPower()}");
    }

    public void ToLevelChooseView(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/LevelChooseView.fxml","关卡选择");
    }

    public void toGameRecordView(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/GameRecordView.fxml","游戏记录");
    }
}
