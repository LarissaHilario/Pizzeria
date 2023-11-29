package com.example.restaurantepizza;


import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

public class HelloController {

    @FXML
    private ImageView nino;

    @FXML
    private Button button;


    public void moverClienteAMesa() {
        // Obtén las coordenadas de la nueva posición de la mesa
        double nuevaX =600;
        double nuevaY = 200;

        // Crea una transición de traducción
        TranslateTransition transition = new TranslateTransition(Duration.seconds(2), nino);

        // Establece las nuevas coordenadas
        transition.setToX(nuevaX);
        transition.setToY(nuevaY);

        // Reproduce la transición
        transition.play();

    }

    void onCLick(MouseEvent event) {

    }



}