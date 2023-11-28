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
        if (!ordenes.isEmpty()) {
            Thread.sleep(1000); // Simula el tiempo que toma entregar la pizza.
            ordenes.poll();
            pizzasDisponibles--;
            System.out.println("Mesero entrega pizza");
        }
    }

    public synchronized int getPizzasDisponibles() {
        return pizzasDisponibles;
    }
}

