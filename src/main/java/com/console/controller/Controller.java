package com.console.controller;

import com.console.application.model.DataOutput;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class Controller {

    @FXML
    Button button_execute;

    @FXML
    Button button_clear;

    @FXML
    Button button_console;

    @FXML
    TextArea txt_area;

    @FXML
    TextField txt_field;

    public Controller(){
    }

    @FXML
    void initialize(){
        txt_area.textProperty().addListener((ChangeListener<Object>) (observable, oldValue, newValue) ->
                txt_area.setScrollTop(Double.MAX_VALUE));

        txt_field.setOnKeyPressed((event) -> {
            if(event.getCode() == KeyCode.ENTER) {
                executeDemand();
            }
        });
        button_execute.setOnAction((event) -> executeDemand());
        button_clear.setOnAction((event) -> txt_field.clear());
        button_console.setOnAction((event) -> txt_area.clear());
    }

    private void executeDemand(){
        DataOutput dataOutput = new DataOutput();
        String userCommand = txt_field.getText();
        txt_area.appendText(dataOutput.exec(userCommand));
    }
}
