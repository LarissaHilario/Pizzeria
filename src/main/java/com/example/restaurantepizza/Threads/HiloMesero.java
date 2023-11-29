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
                synchronized (monitorMesero) {
                    while (monitorMesero.getPizzasDisponibles() <= 0 || !monitorMesero.hayOrdenesPendientes() || !hayMesasDisponibles()) {
                        monitorMesero.wait();
                    }
                    int numeroOrden = monitorMesero.tomarOrden();
                    System.out.println("Mesero toma orden: Orden #" + numeroOrden);
                    Thread.sleep(5000);
                    System.out.println("Mesero entrega pizza: Orden #" + numeroOrden);
                    monitorMesero.notify(); // Notificar solo a un cliente que la pizza está lista.
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void entregarPizzas() {
        while (true) {
            try {
                synchronized (monitorMesero) {
                    while (!monitorMesero.hayOrdenesPendientes()) {
                        monitorMesero.wait();
                    }
                    monitorMesero.entregarPizza();
                    System.out.println("Mesero entrega pizza.");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private boolean hayMesasDisponibles() {
        return monitorMesero.getPizzasDisponibles() > 0;
    }

    @Override
    public void run() {
        while (true) {
            tomarOrden();
            entregarPizzas();
        }
    }
}
