package com.example.demo;

import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.stage.Stage;
import javafx.util.Duration;

public class TranslateTransitionExample extends Application {
    @Override
    public void start(Stage stage) {
        //Drawing a Circle
        Arc arc = new Arc();
        arc.setCenterX(100);
        arc.setCenterY(130);
        arc.setRadiusX(100);
        arc.setRadiusY(100);
        arc.setStartAngle(45);
        arc.setLength(270);

        //Setting the color of the arc
        arc.setFill(Color.PALEVIOLETRED);

        //Setting the stroke width of the arc
        arc.setStrokeWidth(2000);

        //Creating Translate Transition
        TranslateTransition translateTransition = new TranslateTransition();

        //Setting the duration of the transition
        translateTransition.setDuration(Duration.millis(5000));

        //Setting the node for the transition
        translateTransition.setNode(arc);

        //Setting the value of the transition along the x axis.
        translateTransition.setByX(300);

        //Setting the cycle count for the transition
        translateTransition.setCycleCount(50);

        //Setting auto reverse value to false
        translateTransition.setAutoReverse(false);

        //Playing the animation
        translateTransition.play();

        //Creating a Group object
        Group root = new Group(arc);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);

        //Setting title to the Stage
        stage.setTitle("Translate transition example");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}
