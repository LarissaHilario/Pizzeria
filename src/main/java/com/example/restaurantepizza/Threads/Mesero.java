package com.example.restaurantepizza.Threads;

import com.example.restaurantepizza.Models.MonitorRestaurante;

public class Mesero extends Thread {
    private MonitorRestaurante monitor;

    public Mesero(MonitorRestaurante monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            // Toma una orden de un cliente
            try {
                monitor.tomarOrden();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            // Lleva la pizza al cliente
            try {
                monitor.llevarPizza();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}