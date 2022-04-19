package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override//служит для инициализации всех необходимых переменных
    public void init() throws Exception {}

    @Override //служит для конструирования и установки параметров сцены.
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.
                getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image("c:\\Users\\k.kovalenko\\Downloads\\II" +
                "\\demo\\src\\main\\resources\\com\\example\\demo\\2.png");
        stage.getIcons().add(icon);
        stage.setTitle("Привет!");
        stage.setScene(scene);
        stage.show();
    }
    @Override //служит для сборки мусора и освобождением ресурсов
    public void stop() throws Exception {}

    public static void main(String[] args) {launch();}
}