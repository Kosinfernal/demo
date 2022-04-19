package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class demo extends Application {

    public static void main(String[] args) {launch();}

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(demo.class.
                getResource("demo.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image("duke.png");
        stage.getIcons().add(icon);
        stage.setTitle("Demo!");
        stage.setScene(scene);
        stage.show();
    }
}
