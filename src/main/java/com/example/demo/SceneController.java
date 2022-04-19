package com.example.demo;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class SceneController {
    @FXML
    private Label welcomeText;

    @FXML
    private Button closebutton;

    @FXML
    protected void switch1() {
        welcomeText.setText("Добро пожаловать в Приложение JavaFX!");
    }

    @FXML
    protected void switch2() {
        welcomeText.setText("Затёр!");
    }

    @FXML
    protected void close (){
        Stage stage = (Stage) closebutton.getScene().getWindow();
        stage.close();
    }
}