package com.example.restaurantepizza;

import com.example.restaurantepizza.Models.MonitorMesero;
import com.example.restaurantepizza.Models.MonitorRecepcionista;
import com.example.restaurantepizza.Threads.HiloCliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1000, 900);
        primaryStage.setTitle("pizzeria");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

        public static void main(String[] args) {
        launch(args);

        }
}