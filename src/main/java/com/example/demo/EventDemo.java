package com.example.demo;
// Demonstrate JavaFX events and buttons.

import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class EventDemo extends Application {

    Label response, responsev1;

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage stage) {

        // Give the stage a title.
        stage.setTitle("Использование JavaFX кнопок и событий.");

        // Use a FlowPane for the root node. In this case,
        // vertical and horizontal gaps of 10.
        /**конструктору объекта типа FlowPane передаются два значения, устанавливающих
         величину горизонтального и вертикального зазоров, которые будут
         оставлены вокруг элементов при их размещении на сцене. Если не указать эти
         значения, то два соседних элемента (например, две кнопки) расположатся на
         сцене вплотную друг к другу.*/
        FlowPane rootNode = new FlowPane(10, 10);

        // Center the controls in the scene.
        rootNode.setAlignment(Pos.CENTER);

        // Create a scene.
        Scene scene = new Scene(rootNode, 300, 100);

        // Set the scene on the stage.
        stage.setScene(scene);

        // Create a label.
        response = new Label("Push the Button");
        responsev1 = new Label("Жмакай кнопу");

        // Create two push buttons.
        Button btnUp = new Button("Вверх");
        Button btnDown = new Button("Вниз");
        Button btnUpv1 = new Button("Вверх v1");
        Button btnDownv1 = new Button("Вниз v1");
        Button exit = new Button("exit");

        // Handle the action events for the Up button.
        /**кнопки реагируют на события типа ActionEvent.
         Чтобы зарегистрировать обработчик этих событий, следует вызвать метод
         setOnAction() для соответствующей кнопки. Интерфейс EventHandler реализуется
         с использованием анонимного внутреннего класса. (Вспомните, что в классе
         EventHandler определен только метод handle().) В теле метода handle()
         задается текст, который будет отображаться меткой response и тем самым иллюстрировать
         нажатие кнопки Вверх. Это делается посредством вызова метода
         setText() для метки.*/
        btnUp.setOnAction(new EventHandler<ActionEvent>() {
            @AnonymousInnerClass
            public void handle(ActionEvent ae) {
                response.setText("You pressed Up.");
            }
        });
        //the same
        btnUpv1.setOnAction(e -> responsev1.setText("Ты жмакнул вверх v1."));

        // Handle the action events for the Down button.
        btnDown.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                response.setText("You pressed Down.");
            }
        });
        //the same
        btnDownv1.setOnAction(e -> responsev1.setText("Ты жмакнул вниз v1."));

        //exit.setOnAction(e->stage.close());
        exit.setOnAction(e->Platform.exit());//second method of program shut down

        // Add the label and buttons to the scene graph.
        rootNode.getChildren().addAll(btnUp, btnDown, response,
                btnUpv1, btnDownv1, responsev1, exit);

        // Show the stage and its scene.
        stage.show();
    }
}
