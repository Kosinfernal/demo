package com.example.demo;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.PerspectiveCamera;
import javafx.scene.Scene;
import javafx.scene.shape.Box;
import javafx.scene.shape.DrawMode;
import javafx.stage.Stage;

public class BoxDrawMode extends Application {
    @Override
    public void start(Stage stage) {
        //Drawing a Box
        Box box1 = new Box();

        //Setting the properties of the Box
        box1.setWidth(100.0);
        box1.setHeight(100.0);
        box1.setDepth(100.0);

        //Setting the position of the box
        box1.setTranslateX(200);
        box1.setTranslateY(150);
        box1.setTranslateZ(0);

        //Setting the drawing mode of the box
        box1.setDrawMode(DrawMode.LINE);

        //Drawing a Box
        Box box2 = new Box();

        //Setting the properties of the Box
        box2.setWidth(100.0);
        box2.setHeight(100.0);
        box2.setDepth(100.0);

        //Setting the position of the box
        box2.setTranslateX(450); //450
        box2.setTranslateY(150);//150
        box2.setTranslateZ(300);

        //Setting the drawing mode of the box
        box2.setDrawMode(DrawMode.FILL);

        //Creating a Group object
        Group root = new Group(box1, box2);

        //Creating a scene object
        Scene scene = new Scene(root, 600, 300);

        //Setting camera
        PerspectiveCamera camera = new PerspectiveCamera(false);
        camera.setTranslateX(0);
        camera.setTranslateY(0);
        camera.setTranslateZ(0);
        scene.setCamera(camera);

        //Setting title to the Stage
        stage.setTitle("Drawing a Box");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }
    public static void main(String args[]){
        launch(args);
    }
}
