package work.controller;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.util.Duration;
import work.MainAPP;
import work.entity.StarsManager;

import java.util.concurrent.atomic.AtomicInteger;

public class Level1View {
    public Label timeRemain;

    public void Back(ActionEvent actionEvent) throws Exception {
        MainAPP.setRoot("view/LevelChooseView.fxml","关卡选择");
    }

    public void initialize() {
        AtomicInteger timeSeconds= new AtomicInteger(30);
        timeRemain.setText(STR."Time: \{timeSeconds}");

        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1), event -> {
            timeSeconds.getAndDecrement();
            timeRemain.setText(STR."Time: \{timeSeconds}");

            if (timeSeconds.get() ==0){
                StarsManager.getLevel();
                StarsManager.addPower();

                try {
                    MainAPP.setRoot("view/GameResultView.fxml","游戏结果");
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Timeline timeline = new Timeline(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
    }
}
