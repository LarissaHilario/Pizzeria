package com.example.restaurantepizza;


import com.example.restaurantepizza.Models.Cliente;
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
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.util.Observable;
import java.util.Observer;
public class HelloController implements Observer {
    private MonitorMesero monitorMesero;
    private MonitorRecepcionista monitorRecepcionista;
    private Handler handler;

    @FXML
    private Cliente nino;

    @FXML
    private Button button;

    @FXML
    public void initialize() {
        // Instantiate Handler with the required parameters
        handler = new Handler(monitorRecepcionista, monitorMesero);

        nino = new Cliente(monitorRecepcionista, monitorMesero, new Image(getClass().getResource("../../../images/nino.png").toExternalForm()));
        // Set initial position
        nino.setTranslateX(0);
        nino.setTranslateY(0);

        // Add nino to the AnchorPane
        AnchorPane anchorPane = (AnchorPane) button.getParent();
        anchorPane.getChildren().add(nino);

        // Add nino as an observer to the handler
        handler.addObserver(this);

        // Set up event handler for nino
        nino.setOnMouseClicked(event -> onClicked(event));
    }


    @FXML
    void onClicked(MouseEvent event) {
        // Start the handler thread
        Thread h1 = new Thread(handler);
        h1.start();

        // Perform nino's action
        nino.entrarRestaurante();
    }

    @Override
    public void update(Observable o, Object arg) {

    }

    // Rest of the code...
}
