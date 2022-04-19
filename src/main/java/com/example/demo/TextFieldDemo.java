package com.example.demo;
// Demonstrate a text field.

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class TextFieldDemo extends Application {

    public static void main(String[] args) {launch();}

    @Override
    public void start(Stage stage) {

        stage.setTitle("Demonstrate a TextField");
        FlowPane rootNode = new FlowPane(10, 10);
        rootNode.setAlignment(Pos.CENTER);
        Scene scene = new Scene(rootNode, 500, 400);
        stage.setScene(scene);

        // Create a label that will report the state of the
        // selected check box.
        Label response = new Label("Enter Name: ");

        // Create a button that gets the text.
        Button btnGetText = new Button("Get Name 1");
        Button btn = new Button("Взять имя 2");

        // Create a text fields.
        TextField textField = new TextField();
        TextField textField1 = new TextField("field with predetermined text");
        textField1.setAlignment(Pos.BASELINE_CENTER);
        textField1.setPrefWidth(500);

        // Set the prompt.
        textField.setPromptText("prompt text");

        // Set preferred column count.
        //настройка ширины текстового поля
        textField.setPrefColumnCount(25);

        // Use a lambda expression to handle action events for the
        // text field. Action events are generated when ENTER is
        // pressed while the text field has input focus. In this case,
        // the text in the field is obtained and displayed.
        textField.setOnAction(e -> response.setText("Enter pressed. Name is: " +
                textField.getText()));
        textField1.setOnAction(e -> response.setText("Enter нажат. " +
                "Текст второй кнопки изменён на: " + textField1.getText()));

        // Use a lambda expression to get text from the text field
        // when the button is pressed.
        btnGetText.setOnAction(e ->
                response.setText("Button pressed. Name is: " +
                        textField.getText()));
        btn.setOnAction(e ->
                response.setText("Кнопка нажата. Второй текст: " +
                        textField1.getText()));

        // Use a separator to better organize the layout.
        Separator separator = new Separator();
        separator.setPrefWidth(1800);
        Separator separator0 = new Separator();
        separator0.setPrefWidth(1800);
        Separator separator1 = new Separator();
        separator1.setPrefWidth(1800);
        Separator separator2 = new Separator();
        separator2.setPrefWidth(1800);

        TextArea area = new TextArea("Многострочный \nввод");
                area.setPromptText("Multiple nstring ntext");
                area.setPrefSize(150,100);

        PasswordField passwordField = new PasswordField();
        Label lb = new Label("this is password field");


        Button button = new Button("Close");
        //button.setOnAction(e -> stage.close());
        button.setOnAction(e -> Platform.exit());
        stage.getIcons().add(new Image("duke.png"));
        rootNode.getChildren().addAll(textField, textField1, btnGetText, btn,
                separator, response, separator0, area, separator1, passwordField,
                lb, separator2, button);

        Glow glow = new Glow(0.3);
        rootNode.setEffect(glow);
//        Reflection reflection = new Reflection(5,6,7,8);
//        rootNode.setEffect(reflection);
//        BoxBlur boxBlur = new BoxBlur(100,200,300);

        stage.show();
    }
}
