package com.example.restaurantepizza.Models;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import com.example.restaurantepizza.Threads.HiloCliente;


public class Cliente extends ImageView {

    private HiloCliente hiloCliente;

    public Cliente(MonitorRecepcionista monitorRecepcionista, MonitorMesero monitorMesero, Image image) {
        this.hiloCliente = new HiloCliente(monitorRecepcionista, monitorMesero);
        this.setImage(image);
        // Configura la posición inicial del cliente
        setTranslateX(0);
        setTranslateY(0);
    }

    // Otros métodos y acciones del cliente



    public void entrarRestaurante() {
        // Lógica para entrar al restaurante
        setTranslateX(600);
        setTranslateY(200);
    }


    public void abandonarRestaurante() {
        // Lógica para abandonar el restaurante
        setTranslateX(1000);
        setTranslateY(300);
    }

    // Otros métodos y acciones del cliente
}

