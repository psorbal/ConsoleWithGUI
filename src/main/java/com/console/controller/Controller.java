package com.console.controller;

import com.console.application.model.DataOutput;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;

public class Controller {

    @FXML
    Button buttonExecute;

    @FXML
    Button buttonClear;

    @FXML
    Button buttonConsole;

    @FXML
    TextArea textArea;

    @FXML
    TextField textField;

    @FXML
    void initialize() {
        textArea.textProperty().addListener((observable, oldValue, newValue) ->
                textArea.setScrollTop(Double.MAX_VALUE));

        textField.setOnKeyPressed(event -> {
            if(event.getCode() == KeyCode.ENTER) {
                executeDemand();
            }
        });

        buttonExecute.setOnAction(event -> executeDemand());
        buttonClear.setOnAction(event -> textField.clear());
        buttonConsole.setOnAction(event -> textArea.clear());
    }

    private void executeDemand(){
        DataOutput dataOutput = new DataOutput();
        String userCommand = textField.getText();
        textArea.appendText(dataOutput.exec(userCommand));
    }
}
