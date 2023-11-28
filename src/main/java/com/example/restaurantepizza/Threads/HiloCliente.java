package com.example.restaurantepizza.Threads;
import com.example.restaurantepizza.Models.MonitorMesero;
import com.example.restaurantepizza.Models.MonitorRecepcionista;
import java.util.Random;

public class HiloCliente extends Thread {
    private static final Random random = new Random();
    private final MonitorRecepcionista monitorRecepcionista;
    private final MonitorMesero monitorMesero;

    public HiloCliente(String nombre, MonitorRecepcionista recepcionista, MonitorMesero mesero) {
        super(nombre);
        this.monitorRecepcionista = recepcionista;
        this.monitorMesero = mesero;
    }

    private void llegarAlRestaurante() {
        System.out.println(getName() + " llega al restaurante.");
    }

    private void entrarAlRestaurante() throws InterruptedException {
        monitorRecepcionista.entrarRestaurante(this);
        System.out.println(getName() + " entra al restaurante.");
    }

    private void pedirPizza() throws InterruptedException {
        int numeroOrden = monitorMesero.tomarOrden();
        System.out.println(getName() + " pide una pizza: Orden #" + numeroOrden);
        // Simula el tiempo que tarda en comer.
        Thread.sleep(5000);
        System.out.println(getName() + " come la pizza: Orden #" + numeroOrden);
        monitorRecepcionista.salirRestaurante();
    }

    private void esperar() {
        System.out.println(getName() + " espera su pizza.");
        try {
            Thread.sleep(3000); // Simula el tiempo que tarda en hacer la pizza.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void comer() {
        System.out.println(getName() + " come la pizza.");
        try {
            Thread.sleep(random.nextInt(5000)); // Simula el tiempo que tarda en comer.
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            llegarAlRestaurante();
            entrarAlRestaurante();
            pedirPizza();
            esperar();
            comer();
            monitorRecepcionista.salirRestaurante();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
