package com.example.restaurantepizza.Models;

import java.util.LinkedList;
import java.util.Queue;

public class MonitorMesero {
    private int pizzasDisponibles;
    private int numeroOrden = 1;

    private Queue<String> ordenes;

    public MonitorMesero(int capacidadRestaurante) {
        this.pizzasDisponibles = capacidadRestaurante * 5; // Inicializamos con pizzas suficientes.
        this.ordenes = new LinkedList<>();
    }

    public synchronized int tomarOrden() {
        return numeroOrden++;
    }
    public synchronized void entregarPizza() throws InterruptedException {
        while (ordenes.isEmpty()) {
            wait(); // Espera hasta que haya órdenes pendientes.
        }

        Thread.sleep(1000); // Simula el tiempo que toma entregar la pizza.
        ordenes.poll();
        pizzasDisponibles--;
        System.out.println("Mesero entrega pizza");
        notify(); // Notifica al cliente específico que la pizza está lista.
    }

    public synchronized boolean hayOrdenesPendientes() {
        return !ordenes.isEmpty();
    }

    public synchronized void notificarClientes() {
        notifyAll();
    }

    public synchronized int getPizzasDisponibles() {
        return pizzasDisponibles;
    }
}


