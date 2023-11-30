package com.example.restaurantepizza;


import com.example.restaurantepizza.Models.MonitorMesero;
import com.example.restaurantepizza.Models.MonitorRecepcionista;
import com.example.restaurantepizza.Threads.Handler;
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

import java.util.Observable;
import java.util.Observer;

public class HelloController implements Observer {

    private MonitorMesero monitorMesero;
    private MonitorRecepcionista monitorRecepcionista;
    private Handler handler;

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

    @FXML
    void onClicked(MouseEvent event) {
        double nuevaX =600;
        double nuevaY = 200;
        this.handler = new Handler(monitorRecepcionista, monitorMesero);
        handler.addObserver(this);
        Thread h1= new Thread(handler);
        h1.start();



    }

    @Override
    public void update(Observable o, Object arg) {


    }
}