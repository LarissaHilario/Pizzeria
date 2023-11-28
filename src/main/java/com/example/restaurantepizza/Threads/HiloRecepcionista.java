package com.example.restaurantepizza.Threads;

import com.example.restaurantepizza.Models.MonitorRecepcionista;

public class HiloRecepcionista extends Thread {
    private final MonitorRecepcionista monitorRecepcionista;

    public HiloRecepcionista(MonitorRecepcionista recepcionista) {
        this.monitorRecepcionista = recepcionista;
    }

    private void atenderClientes() {
        while (true) {
            try {
                HiloCliente cliente = monitorRecepcionista.atenderCliente();
                System.out.println("Recepcionista atiende a " + cliente.getName());
                // La asignación de mesas se realiza en el método asignarMesa dentro de entrarRestaurante.
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void asignarMesa(HiloCliente cliente) {
        // Lógica para asignar una mesa al cliente.
        // Aquí puedes imprimir un mensaje indicando la asignación de la mesa.
        System.out.println("Recepcionista asigna mesa a " + cliente.getName());
    }

    @Override
    public void run() {
        atenderClientes();
    }
}


