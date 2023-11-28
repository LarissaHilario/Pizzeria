package com.example.restaurantepizza.Threads;

import com.example.restaurantepizza.Models.MonitorMesero;

public class HiloMesero extends Thread {
    private final MonitorMesero monitorMesero;



    public HiloMesero(MonitorMesero mesero) {
        this.monitorMesero = mesero;
    }


    private void tomarOrden() {
        while (true) {
            try {
                int numeroOrden = monitorMesero.tomarOrden();
                System.out.println("Mesero toma orden: Orden #" + numeroOrden);
                // Simula el tiempo que tarda en entregar la pizza.
                Thread.sleep(5000);
                System.out.println("Mesero entrega pizza: Orden #" + numeroOrden);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void entregarPizzas() {
        while (true) {
            try {
                monitorMesero.entregarPizza();
                System.out.println("Mesero entrega pizza.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
        tomarOrden();
        entregarPizzas();
    }
}

