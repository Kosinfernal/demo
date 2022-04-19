package com.example.demo;
// A JavaFX application skeleton.

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Skeleton extends Application {
    public static void main(String[] args) {
        System.out.println("Launching JavaFX application.");
        // Start the JavaFX application by calling launch().
        //launch(args);
        launch();
    }

    // Override the init() method.
    public void init() {
        System.out.println("Inside the init() method.");
    }

    // Override the start() method.
    public void start(Stage myStage) {

        System.out.println("Inside the start() method.");

        // Give the stage a title.
        myStage.setTitle("JavaFX Skeleton.");

        // Create a root node. In this case, a flow layout
        //используется плавающая компоновка
        /**Этот тип компоновки характеризуется тем, что элементы последовательно располагаются
         в строках с автоматическим переходом на следующую строку, если
         для размещения очередного элемента в текущей строке не хватает места.*/
        // is used, but several alternatives exist.
        FlowPane rootNode = new FlowPane();//Создание корневого узла

        // Create a scene.
        Scene myScene = new Scene(rootNode, 300, 200);//Создание сцены

        // Set the scene on the stage.
            myStage.setScene(myScene);//Установка сцены на платформе
        //myStage.setScene(new Scene(rootNode, 300, 200));

        // Show the stage and its scene.
        myStage.show();//Отображение сцены
    }

    // Override the stop() method.
    public void stop() {
        System.out.println("Inside the stop() method.");
    }
}
