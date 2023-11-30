package com.example.restaurantepizza;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;


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