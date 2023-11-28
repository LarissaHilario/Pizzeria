package com.example.restaurantepizza;

import com.example.restaurantepizza.Models.MonitorMesero;
import com.example.restaurantepizza.Models.MonitorRecepcionista;
import com.example.restaurantepizza.Threads.HiloCliente;
import com.example.restaurantepizza.Threads.HiloMesero;
import com.example.restaurantepizza.Threads.HiloRecepcionista;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main  {
    /*@Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }*/

    public static void main(String[] args) {
        int capacidadRestaurante = 20;
        MonitorRecepcionista recepcionista = new MonitorRecepcionista(capacidadRestaurante);
        MonitorMesero mesero = new MonitorMesero(capacidadRestaurante);

        HiloRecepcionista hiloRecepcionista = new HiloRecepcionista(recepcionista);
        HiloMesero hiloMesero = new HiloMesero(mesero);

        hiloRecepcionista.start();
        hiloMesero.start();

        // Crea un número determinado de clientes
        int numClientes = 30;
        for (int i = 0; i < numClientes; i++) {
            HiloCliente cliente = new HiloCliente("Cliente " + i, recepcionista, mesero);
            cliente.start();
        }
    }
}
