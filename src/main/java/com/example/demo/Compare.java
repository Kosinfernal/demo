package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Compare extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Compare.class.getResource("compare.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Compare files");
        stage.getIcons().add(new Image("duke.png"));
        stage.setScene(scene);
        stage.show();
    }
}
