package com.example.demo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.shape.Arc;

public class demoController {
    @FXML
    private Arc arc;
    private double x;
    private double y;

    public void up(ActionEvent e) {
        arc.setCenterY(y -= 10);
    }

    public void down(ActionEvent e) {
        arc.setCenterY(y += 10);
    }

    public void left(ActionEvent e) {
        arc.setCenterX(x -= 10);
    }

    public void right(ActionEvent e) {
        arc.setCenterX(x += 10);
    }

}
