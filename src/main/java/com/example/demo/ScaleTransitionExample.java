package com.example.demo;

import javafx.animation.ScaleTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ScaleTransitionExample extends Application {
    @Override
    public void start(Stage stage) {
        //Drawing a Circle
        Circle circle = new Circle();

        //Setting the position of the circle
        circle.setCenterX(300.0f);
        circle.setCenterY(135.0f);

        //Setting the radius of the circle
        circle.setRadius(50.0f);

        //Setting the color of the circle
        circle.setFill(Color.CORNFLOWERBLUE);

        //Setting the stroke width of the circle
        //Настройка ширины обводки круга
        circle.setStrokeWidth(20);

        //Creating scale Transition
        ScaleTransition scaleTransition = new ScaleTransition();
        ScaleTransition scaleTransition1 = new ScaleTransition();

        //Setting the duration for the transition
        //скорость
        scaleTransition.setDuration(Duration.millis(500));

        //Setting the node for the transition
        scaleTransition.setNode(circle);

        //Setting the dimensions for scaling
        scaleTransition.setByY(1.5);
        scaleTransition.setByX(1.5);

        //Setting the cycle count for the translation
        //скорость
        scaleTransition.setCycleCount(20);

        //Setting auto reverse value to true
        scaleTransition.setAutoReverse(true);
        Button button = new Button("start");
        button.setOnAction(event ->
        //Playing the animation
        scaleTransition.play());


        Button reverse = new Button("reverse");
        reverse.setLayoutX(400);
        reverse.setLayoutX(400);
        reverse.setOnAction(event -> {
            scaleTransition1.setDuration(Duration.millis(500));
            scaleTransition1.setNode(circle);
            scaleTransition1.setByY(-1.5);
            scaleTransition1.setByX(-1.5);
            scaleTransition1.setCycleCount(20);
            scaleTransition1.setAutoReverse(true);

            scaleTransition1.play();
        });

        Button button1 = new Button("stop");
        button1.setLayoutX(200);
        button1.setLayoutX(200);
        button1.setOnAction(event ->{
            //Playing the animation
            scaleTransition.stop();
            scaleTransition1.stop();
        });

        //Creating a Group object
        Group root = new Group(button, circle, button1, reverse);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);

        //Setting title to the Stage
        stage.setTitle("Scale transition example");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}
