package work.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import work.MainAPP;
import work.entity.StarsManager;

public class GameResultView {
    public Label stars;
    public Label points;
    @FXML
    public void initialize(){
        stars.setText(STR."获取的星数:\{String.valueOf(StarsManager.level)}");
        points.setText(STR."获取的分数:\{String.valueOf(StarsManager.points)}");

        StarsManager.points=0;
        StarsManager.level=0;
    }

    public void Back(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/MenuView.fxml","主菜单");
    }
}
