package com.example.demo30;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public class HelloController {
    @FXML
    private TextField field;
    @FXML
    protected void buttonClicked(ActionEvent event) {
        String text = field.getText();
        String check = ((Button) event.getSource()).getText();
        if (check.equals("AC")) {
            field.clear();
            return;
        }
        if (check.equals("=")) {
            text = text + " " + check;
            Calculate c = new Calculate(text);
            Thread t = new Thread(c);
            t.start();
            try {
                t.join();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
            field.setText(c.getResult());
            return;
        }
        if(!isNumber(check)&&!check.equals(".")) {
            text = text + " " + check+" ";
        }
        else{
            text = text+check;
        }
        field.setText(text);
    }
    protected boolean isNumber(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}