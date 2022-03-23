package com.mycompany.animationlab;

import java.io.IOException;
import javafx.animation.FillTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.ParallelTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class PrimaryController {

    @FXML
    private Pane pane;
    @FXML
    private Rectangle Rect;
    @FXML
    private Button chnageToYellow;
    @FXML
    private Button changeWidth;
    @FXML
    private Button doBoth;
    @FXML
    private Button translateButton;
    @FXML
    private Button translateSequ;
    @FXML
    private Button rotateButton;

    @FXML
    private void chnageToYellowColor(ActionEvent event) {

        FillTransition ftY = new FillTransition(Duration.seconds(3), Rect);
        ftY.setToValue(Color.YELLOW);
        ftY.setCycleCount(2);
        ftY.setAutoReverse(true);

        ftY.play();

    }

    @FXML
    private void changeWithOfRect(ActionEvent event) {

        ScaleTransition sc = new ScaleTransition(Duration.seconds(1), Rect);
        sc.setToX(Rect.getLayoutX() * 2);

        sc.play();

    }

    @FXML
    private void parallelAnimations(ActionEvent event) {
        //this is a bad way to do this, but its to show a parallel animation working 

        FillTransition ftY = new FillTransition(Duration.seconds(3), Rect);
        ftY.setToValue(Color.YELLOW);

        ScaleTransition sc = new ScaleTransition(Duration.seconds(1), Rect);
        sc.setToX(Rect.getLayoutX() * 2);

        ParallelTransition pt = new ParallelTransition(ftY, sc);
        pt.play();

    }

    @FXML
    private void translateShape(ActionEvent event) {

        KeyValue kv1 = new KeyValue(Rect.translateXProperty(), 50);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(2), kv1);

        KeyValue kv2 = new KeyValue(Rect.translateYProperty(), 400);
        KeyFrame kf2 = new KeyFrame(Duration.seconds(3), kv2);

        Timeline t1 = new Timeline(kf1, kf2);

        t1.play();

    }

    @FXML
    private void translateShapeSequ(ActionEvent event) {

        KeyValue kv2 = new KeyValue(Rect.translateYProperty(), 400);
        KeyFrame kf2 = new KeyFrame(Duration.seconds(3), kv2);
        Timeline t1 = new Timeline(kf2);

        KeyValue kv1 = new KeyValue(Rect.translateXProperty(), 50);
        KeyFrame kf1 = new KeyFrame(Duration.seconds(2), kv1);
        Timeline t2 = new Timeline(kf1);

        SequentialTransition sq = new SequentialTransition(t1, t2);

        sq.play();

    }

  

}
