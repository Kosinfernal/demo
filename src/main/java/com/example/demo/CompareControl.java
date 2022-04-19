package com.example.demo;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.FileInputStream;
import java.io.IOException;

public class CompareControl {
    @FXML
    Button compareButton, close;
    @FXML
    Label buttonLabel, textFieldOneLabel, textFieldTwoLabel, result, dateLabel;
    @FXML
    CheckBox checkBox;
    @FXML
    TextField textField1, textField2;
    @FXML
    DatePicker datePicker;

    @FXML
    protected void pressTheButton() {
        buttonLabel.setText("Кнопка была нажата");
        int i, j, count = 0;
        if (textField1.getText().equals("")) {
            textFieldOneLabel.setText("First file name missing.");
            return;
        }
        if (textField2.getText().equals("")) {
            textFieldTwoLabel.setText("Second file name missing.");
            return;
        }
        try (FileInputStream f1 = new FileInputStream(textField1.getText());
             FileInputStream f2 = new FileInputStream(textField2.getText())) {
            // Check the contents of each file.
            do {
                i = f1.read();
                j = f2.read();
                if (i != j) break;
                count++;
            } while (i != -1 && j != -1);

            if (i != j) {
                if (checkBox.isSelected())
                    result.setText("Файлы отличаются начиная с позиции " + count);
                else
                    result.setText("Файлы не одинаковы");
            } else
                result.setText("Файлы одинаковы.");
        } catch (IOException exc) {
            result.setText("File Error");
        }
    }

    @FXML
    protected void textFieldOneAction() {
        pressTheButton();
        textFieldOneLabel.setText("Enter в первом окне нажат. " +
                "Текст первого поля изменён на: \n'" + textField1.getText()+"'");
    }
    @FXML
    protected void textFieldTwoAction() {
        pressTheButton();
        textFieldTwoLabel.setText("Enter во втором окне нажат. " +
                "Текст второго поля изменён на: \n" + textField2.getText());
    }
    @FXML
    protected void chooseTheDate() {
        dateLabel.setText("Была выбрана дата: " + datePicker.getValue());
    }
    @FXML
    protected void close() {
        Platform.exit();
    }
}
