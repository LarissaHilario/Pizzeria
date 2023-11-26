package com.example.restaurantepizza.Models;

import java.util.LinkedList;
import java.util.Queue;

public class MonitorRestaurante {
    private int mesasOcupadas;
    private final int mesasTotales;
    private int meserosOcupados;
    private int meserosTotales;
    private Queue<Orden> ordenes;

    public MonitorRestaurante(int mesasTotales, int meserosTotales) {
        this.mesasTotales = mesasTotales;
        this.meserosTotales = meserosTotales;
        this.ordenes = new LinkedList<>();
    }

    public void llegar() throws InterruptedException {
        synchronized (this) {
            while (mesasOcupadas >= mesasTotales) {
                wait();
            }

            mesasOcupadas++;
        }
    }

    public void sentarse() throws InterruptedException {
        synchronized (this) {
            while (meserosOcupados < meserosTotales) {
                wait();
            }

            meserosOcupados++;
        }
    }

    public void sentar() throws InterruptedException {
        synchronized (this) {
            while (mesasOcupadas >= mesasTotales) {
                wait();
            }

            mesasOcupadas++;
            notifyAll();
        }
    }


    public void pedirPizza() throws InterruptedException {
        synchronized (this) {
            while (ordenes.isEmpty()) {
                wait();
            }

            Orden orden = ordenes.poll();

            System.out.println("El cliente " + orden.getCliente() + " pide una pizza.");
        }
    }
    public void esperarPizza() throws InterruptedException {
        synchronized (this) {
            while (ordenes.isEmpty()) {
                wait();
            }
        }
    }

    public void atenderCliente() throws InterruptedException {
        synchronized (this) {
            while (mesasOcupadas <= 0) {
                wait();
            }

            mesasOcupadas--;
            notifyAll();
        }
    }

    public void tomarOrden() throws InterruptedException {
        synchronized (this) {
            while (meserosOcupados <= 0) {
                wait();
            }

            meserosOcupados--;
            notifyAll();
        }
    }

    public void llevarPizza() throws InterruptedException {
        synchronized (this) {
            while (ordenes.isEmpty()) {
                wait();
            }

            Orden orden = ordenes.poll();

            System.out.println("El mesero " + orden.getMesero() + " lleva la pizza al cliente " + orden.getCliente());
        }
    }

    public void irse() throws InterruptedException {
        synchronized (this) {
            mesasOcupadas--;
            notifyAll();
        }
    }
}

