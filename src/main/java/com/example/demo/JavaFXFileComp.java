package com.example.demo;
// A JavaFX version of the file comparison program shown in
// Try This 16-1.

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.IOException;

public class JavaFXFileComp extends Application {

    TextField firstTextField;  // holds the first file name
    TextField secondTextField; // holds the second file name

    Button button; // button to compare the files

    Label firstLabel, secondLabel; // displays prompts
    Label result; // displays results and error messages

    public static void main(String[] args) {launch();}

    @Override
    public void start(Stage stage) {
        stage.setTitle("Compare Files");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 180, 180);
        stage.setScene(scene);
        firstTextField = new TextField("c:\\Users\\k.kovalenko\\1.txt");
        secondTextField = new TextField("c:\\Users\\k.kovalenko\\1.txt");
        firstTextField.setPrefColumnCount(12);
        secondTextField.setPrefColumnCount(12);
        firstTextField.setPromptText("Enter file name.");
        secondTextField.setPromptText("Enter file name.");
        button = new Button("Compare");
        firstLabel = new Label("First file: ");
        secondLabel = new Label("Second file: ");
        result = new Label("Result");
        firstTextField.setOnAction( e -> button.fire());
        secondTextField.setOnAction( e -> button.fire());

        // Handle the action event for the Compare button.
        button.setOnAction(ae -> {
            int i=0, j=0;
            if(firstTextField.getText().equals("")) {
                result.setText("First file name missing.");
                return;
            }
            if(secondTextField.getText().equals("")) {
                result.setText("Second file name missing.");
                return;
            }
            try (FileInputStream f1 = new FileInputStream(firstTextField.getText());
                 FileInputStream f2 = new FileInputStream(secondTextField.getText()))
            {
                do {
                    i = f1.read();
                    j = f2.read();
                    if(i != j) break;
                } while(i != -1 && j != -1);

                if(i != j)
                    result.setText("Files are not the same.");
                else
                    result.setText("Files compare equal.");

            } catch(IOException exc) {
                result.setText("File Error Encountered");
            }
        });

        rootNode.getChildren().addAll(firstLabel, firstTextField, secondLabel, secondTextField,
                button, result);

        stage.show();
    }
}
