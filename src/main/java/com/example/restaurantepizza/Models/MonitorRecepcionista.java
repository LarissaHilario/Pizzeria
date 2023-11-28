package com.example.restaurantepizza.Models;

import com.example.restaurantepizza.Threads.HiloCliente;

import java.util.Arrays;
import java.util.LinkedList;

import java.util.Queue;

public class MonitorRecepcionista {
    private boolean restauranteLleno;
    private Queue<HiloCliente> colaClientes;
    private boolean[] mesasDisponibles;

    public MonitorRecepcionista(int numMesas) {
        this.restauranteLleno = false;
        this.colaClientes = new LinkedList<>();
        this.mesasDisponibles = new boolean[numMesas];
        Arrays.fill(mesasDisponibles, true); // Todas las mesas inicialmente disponibles.
    }

    public synchronized void entrarRestaurante(HiloCliente cliente) throws InterruptedException {
        if (restauranteLleno) {
            colaClientes.offer(cliente);
            wait(); // Espera hasta que haya espacio en el restaurante.
        } else {
            asignarMesa(cliente);
        }
    }
    public synchronized HiloCliente atenderCliente() throws InterruptedException {
        if (restauranteLleno) {
            wait(); // Espera hasta que haya espacio en el restaurante.
        }

        HiloCliente cliente = colaClientes.poll();
        if (cliente != null) {
            restauranteLleno = true;
            notify(); // Notifica a los clientes en espera que el restaurante está lleno.
        }

        return cliente;
    }


    private void asignarMesa(HiloCliente cliente) {
        for (int i = 0; i < mesasDisponibles.length; i++) {
            if (mesasDisponibles[i]) {
                mesasDisponibles[i] = false; // Marca la mesa como ocupada.
                System.out.println("Recepcionista asigna mesa " + (i + 1) + " a " + cliente.getName());
                return;
            }
        }
        System.out.println("No hay mesas disponibles para " + cliente.getName());
        // Aquí podrías manejar el caso en que no hay mesas disponibles.
    }

    public synchronized void salirRestaurante() {
        if (colaClientes.isEmpty()) {
            restauranteLleno = false;
            notify(); // Notifica a los clientes en espera que hay espacio.
        }
    }
}



