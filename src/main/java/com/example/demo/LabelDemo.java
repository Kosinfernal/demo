package com.example.demo;
// Demontrate a JavaFX label.

import javafx.application.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;

public class LabelDemo extends Application {

    public static void main(String[] args) {

        // Start the JavaFX application by calling launch().
        launch(args);
    }

    // Override the start() method.
    public void start(Stage stage) {

        // Give the stage a title.
        stage.setTitle("Usage of JavaFX label.");

        // Use a FlowPane for the root node.
        //FlowPane rootNode = new FlowPane();
        //TilePane rootNode = new TilePane();
        //DialogPane rootNode = new DialogPane();
        //BorderPane rootNode = new BorderPane();
        //Pane rootNode = new Pane();
        //HBox rootNode = new HBox();
        VBox rootNode = new VBox();
        rootNode.setAlignment(Pos.BASELINE_CENTER);

        // Create a scene.
        Scene scene = new Scene(rootNode, 300, 200);

        // Set the scene on the stage.
        stage.setScene(scene);

        // Create a label.
        Label label = new Label("JavaFX is a powerful GUI");

        // Add the label to the scene graph.
        /**Созданную метку (или любой другой компонент) необходимо добавить к содержимому
         сцены, что означает ее добавление в граф сцены. Для этого следует
         прежде всего вызвать метод getchildren () для корневого узла графа сцены.*/
        rootNode.getChildren().add(label);//добавляет метку в список узлов


        Button button = new Button("Кнопка -");
        rootNode.getChildren().add(button);
        button.setOnAction(e -> label.setText("-"));

        Button button1 = new Button("Кнопка +");
        rootNode.getChildren().add(button1);
        button1.setOnAction(e -> label.setText("Джава сильна!"));

        Button button3 = new Button("Кнопка удаления лейбла");
        rootNode.getChildren().add(button3);
        button3.setOnAction(e -> rootNode.getChildren().remove(label));

        Button button4 = new Button("Кнопка добавления лейбла");
        rootNode.getChildren().add(button4);
        button4.setOnAction(e -> rootNode.getChildren().add(label));

        Button button2 = new Button("Кнопка close");
        rootNode.getChildren().add(button2);
        button2.setOnAction(e -> stage.close());

        // Show the stage and its scene.
        stage.show();
    }
}
