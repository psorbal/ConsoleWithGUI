package com.console.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(String[] args){
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {

        FXMLLoader fmxLoader = new FXMLLoader();
        fmxLoader.setLocation(this.getClass().getResource("/model_fx.fxml"));
        AnchorPane anchorPane = fmxLoader.load();

        Scene scene = new Scene(anchorPane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Interactive console");
        primaryStage.setWidth(820);
        primaryStage.setHeight(450);
        primaryStage.show();
    }
}
