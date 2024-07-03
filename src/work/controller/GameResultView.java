package work.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import work.MainAPP;
import work.entity.GameRecord;
import work.entity.StarsManager;

import java.time.LocalDate;

public class GameResultView {
    public Label stars;
    public Label points;
    public Label powerReturn;

    @FXML
    public void initialize(){
        stars.setText(STR."获取的星数:\{String.valueOf(StarsManager.level)}");
        points.setText(STR."获取的分数:\{String.valueOf(StarsManager.points)}");
        powerReturn.setText(STR."获得的体力:\{String.valueOf(StarsManager.addPower())}");

        //记录游戏结果
        GameRecord gameRecord=new GameRecord(StarsManager.points,StarsManager.level,StarsManager.pass, LocalDate.now());
        GameRecord.gameRecords.add(gameRecord);

        //数据复原
        StarsManager.points=0;
        StarsManager.level=0;
        StarsManager.pass=0;
    }

    public void Back(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/MenuView.fxml","主菜单");
    }
}
