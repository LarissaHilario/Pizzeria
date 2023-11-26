package com.example.restaurantepizza.Threads;

import com.example.restaurantepizza.Models.MonitorRestaurante;

public class Recepcionista extends Thread {
    private MonitorRestaurante monitor;

    public Recepcionista(MonitorRestaurante monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            try {
                monitor.atenderCliente();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
