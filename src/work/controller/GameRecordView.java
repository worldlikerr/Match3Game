package work.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import work.MainAPP;
import work.entity.GameRecord;

import java.time.LocalTime;

public class GameRecordView {
    public TableColumn<GameRecord, Integer> points;
    public TableColumn<GameRecord, Integer> stars;
    public TableColumn<GameRecord, Integer> pass;
    public TableColumn<GameRecord, LocalTime> time;
    public TableView<GameRecord> tableView;

    @FXML
    public void initialize(){
        //初始化列
        points.setCellValueFactory(new PropertyValueFactory<>("points"));
        stars.setCellValueFactory(new PropertyValueFactory<>("stars"));
        pass.setCellValueFactory(new PropertyValueFactory<>("pass"));
        time.setCellValueFactory(new PropertyValueFactory<>("time"));

        //添加数值
        GameRecord gameRecord=new GameRecord();
        ObservableList<GameRecord> date= FXCollections.observableArrayList(GameRecord.gameRecords);

        //设置数据到TableView中
        tableView.setItems(date);
    }

    public void back(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/MenuView.fxml","主菜单");
    }
}
