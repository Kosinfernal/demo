package com.example.demo;
// Demonstrate rotation, scaling, reflection, and bluring.
/**Модифицируйте программу EffectsAndTransformsDemo таким образом,
 чтобы размытие применялось также к кнопке Повернуть. Задайте для ширины
 и высоты области размытия значение 5, а для счетчика итераций —
 значение 2 .*/

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.effect.BoxBlur;
import javafx.scene.effect.Reflection;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.transform.Rotate;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;
import javafx.stage.Stage;

public class EffectsAndTransformsDemo extends Application {
    double angle = 0.0;
    double scaleFactor = 0.4;
    double blurVal = 1.0;
    double blurVal1 = 1.0;

    // Create initial effects and transforms.
    //создаются экземпляры класса
    Reflection reflection = new Reflection();
    BoxBlur blur = new BoxBlur();
    BoxBlur blur1 = new BoxBlur();
    Rotate rotate = new Rotate();
    Scale scale = new Scale();
    //Creating the translation transformation
    Translate translate = new Translate();

    // Create push buttons.
    Button btnRotate = new Button("Rotate");
    Button btnBlur = new Button("Blur off");
    Button btnScale = new Button("Scale");
    Button close = new Button("close");
    Button btn = new Button("translate");

    Label label = new Label("Reflection Adds Visual Sparkle");

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage) {
        stage.setTitle("Effects and Transforms Demo");
        FlowPane rootNode = new FlowPane(20, 20);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 300, 220);
        stage.setScene(scene);

        // Add rotation to the transform list for the Rotate button.
        btnRotate.getTransforms().add(rotate);

        // Add scaling to the transform list for the Scale button.
        btnScale.getTransforms().add(scale);

        // Set the reflection effect on the reflection label.
        //непрозрачность
        reflection.setTopOpacity(0.7);
        reflection.setBottomOpacity(0.3);
        label.setEffect(reflection);

        // Handle the action events for the Rotate button.
        btnRotate.setOnAction(ae -> {
            angle += 45.0;

            rotate.setAngle(angle);
            rotate.setPivotX(btnRotate.getWidth()/2);
            rotate.setPivotY(btnRotate.getHeight()/2);

            if(blurVal1 == 2.0) {//счётчик итераций
                blurVal1 = 0.0;
                btnRotate.setEffect(null);
            } else {
                blurVal1++;
                btnRotate.setEffect(blur1);
            }
            blur1.setWidth(5);//ширина области размытия
            blur1.setHeight(5);//высота области размытия
        });

        // Handle the action events for the Scale button.
        btnScale.setOnAction(ae -> {
            scaleFactor += 0.3;
            if(scaleFactor > 3.0) scaleFactor = 0.4;

            scale.setX(scaleFactor);
            scale.setY(scaleFactor);
        });

        // Handle the action events for the Blur button.
        btnBlur.setOnAction(ae -> {
            if(blurVal == 10.0) {
                blurVal = 1.0;
                btnBlur.setEffect(null);
                btnBlur.setText("Blur off");
            } else {
                blurVal+=3;
                btnBlur.setEffect(blur);
                btnBlur.setText("Blur on");
            }
            blur.setWidth(blurVal);//ширина области размытия
            blur.setHeight(blurVal);//высота области размытия
        });

        //Setting the X,Y,Z coordinates to apply the translation
        translate.setX(-9);//сместить горизонтально пикселей
        translate.setY(50);//сместить вертикально пикселей
        //translate.setZ(100);

        btn.setLayoutY(287.0);
        btn.setLayoutY(273.0);

        btn.setOnAction(e-> btn.getTransforms().addAll(translate));

        Separator separator = new Separator();
        separator.setPrefWidth(2000);
        Separator separator1 = new Separator();
        separator1.setPrefWidth(2000);
        stage.getIcons().add(new Image("duke.png"));
        close.setOnAction(e -> stage.close());
        rootNode.getChildren().addAll(btn, separator, btnRotate, btnScale, btnBlur, label,
                separator1, close);
        stage.show();
    }
}