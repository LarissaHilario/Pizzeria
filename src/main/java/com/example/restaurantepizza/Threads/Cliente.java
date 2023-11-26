package com.example.restaurantepizza.Threads;

import com.example.restaurantepizza.Models.MonitorRestaurante;

public class Cliente extends Thread {

    private final MonitorRestaurante monitor;

    public Cliente(MonitorRestaurante monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        try {
            // Llega al restaurante
            monitor.llegar();

            // Se imprime que el cliente llegó
            System.out.println("El cliente " + Thread.currentThread().getId() + " ha llegado al restaurante.");

            // Se sienta en una mesa
            monitor.sentar();

            // Se imprime que el cliente entró
            System.out.println("El cliente " + Thread.currentThread().getId() + " ha entrado al restaurante.");

            // Pide una pizza
            monitor.pedirPizza();

            // Se imprime que le tomaron la orden
            System.out.println("El cliente " + Thread.currentThread().getId() + " le han tomado la orden.");

            // Bloquea al cliente hasta que le den su pizza
            monitor.esperarPizza();

            // Se imprime que le dieron la orden
            System.out.println("El cliente " + Thread.currentThread().getId() + " le han dado la orden.");

            // Come la pizza
            Thread.sleep((int) (Math.random() * 1000));

            // Se va del restaurante
            monitor.irse();

            // Se imprime que el cliente se ha ido
            System.out.println("El cliente " + Thread.currentThread().getId() + " se ha ido del restaurante.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
