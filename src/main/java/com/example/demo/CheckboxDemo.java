package com.example.demo;
// Demonstrate Check Boxes.

import javafx.application.*;
import javafx.scene.*;
import javafx.scene.image.Image;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.event.*;
import javafx.geometry.*;

public class CheckboxDemo extends Application {

    CheckBox cbSmartphone;
    CheckBox cbTablet;
    CheckBox cbNotebook;
    CheckBox cbDesktop;

    Label selected;

    public static void main(String[] args) {launch();}

    @Override
    public void start(Stage stage) {

        stage.setTitle("Демонстрация Check Boxes");

        // Use a vertical FlowPane for the root node.
        // In this case, vertical and horizontal gaps of 10.
        /**По умолчанию компоненты размещаются на панели FlowPane по горизонтали.
         Для создания панели с вертикальной компоновкой следует передать конструктору
         значение Orientation. VERTICAL в качестве первого аргумента.*/
        FlowPane rootNode = new FlowPane(Orientation.VERTICAL, 100, 10);
        rootNode.setAlignment(Pos.CENTER_LEFT);
        Scene scene = new Scene(rootNode, 350, 250);
        stage.setScene(scene);
        Label heading = new Label("What Computers Do You Own?");
        Label response = new Label("");
        Label indeterminatelabel = new Label("Неопределённое состояние - флажок не выбран");

        // Create a label that will report all selected check boxes.
        selected = new Label("");//initial state is null

        // Create the check boxes.
        cbSmartphone = new CheckBox("Smartphone");
        cbTablet = new CheckBox("Tablet");
        cbNotebook = new CheckBox("Notebook");
        cbDesktop = new CheckBox("Desktop");
/**чтобы активизировать неопределенное состояние для флажка*/
        cbSmartphone.setAllowIndeterminate(true);

        // Handle action events for the check boxes.
/*        cbSmartphone.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cbSmartphone.isSelected())
                    response.setText("Smartphone was just selected.");
                else
                    response.setText("Smartphone was just cleared.");

                showAll();
            }
        });*/
        cbSmartphone.setOnAction(e -> {
            if (cbSmartphone.isIndeterminate())
                indeterminatelabel.setText("Smartphone is indeterminate");
            else if(cbSmartphone.isSelected())
                response.setText("Smartphone was just selected.");
            else
                response.setText("Smartphone was just cleared.");

            showAll();
        });
/*        cbTablet.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cbTablet.isSelected())
                    response.setText("Tablet was just selected.");
                else
                    response.setText("Tablet was just cleared.");
                showAll();
            }
        });*/
        cbTablet.setOnAction(e -> {
            if(cbTablet.isSelected())
                response.setText("Tablet was just selected.");
            else
                response.setText("Tablet was just cleared.");
            showAll();
        });
/*        cbNotebook.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cbNotebook.isSelected())
                    response.setText("Notebook was just selected.");
                else
                    response.setText("Notebook was just cleared.");

                showAll();
            }
        });*/
        cbNotebook.setOnAction(e -> {
            if(cbNotebook.isSelected())
                response.setText("Notebook was just selected.");
            else
                response.setText("Notebook was just cleared.");
            showAll();
        });
/*        cbDesktop.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent ae) {
                if(cbDesktop.isSelected())
                    response.setText("Desktop was just selected.");
                else
                    response.setText("Desktop was just cleared.");

                showAll();
            }
        });*/
        cbDesktop.setOnAction(e -> {
            if(cbDesktop.isSelected())
                response.setText("Desktop was just selected.");
            else
                response.setText("Desktop was just cleared.");
            showAll();
        });
        Button button = new Button("Close Button");
        button.setOnAction(e -> stage.close());
        Image icon = new Image("duke.png");
        stage.getIcons().add(icon);
        // Add controls to the scene graph.
        rootNode.getChildren().addAll(heading, cbSmartphone, cbTablet,
                cbNotebook, cbDesktop, indeterminatelabel, response, selected, button);

        // Show the stage and its scene.
        stage.show();

        showAll();
    }

    // Update and show the selections.
    void showAll() {
        String computers = "";
        if(cbSmartphone.isSelected()) computers = "Smartphone ";
        if(cbTablet.isSelected()) computers += "Tablet ";
        if(cbNotebook.isSelected()) computers += "Notebook ";
        if(cbDesktop.isSelected()) computers += "Desktop";

        selected.setText("Computers selected: " + computers);
    }
}
