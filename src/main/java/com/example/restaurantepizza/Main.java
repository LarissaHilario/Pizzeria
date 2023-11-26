package com.example.restaurantepizza;

import com.example.restaurantepizza.Models.MonitorRestaurante;
import com.example.restaurantepizza.Threads.Cliente;
import com.example.restaurantepizza.Threads.Mesero;
import com.example.restaurantepizza.Threads.Recepcionista;


public class Main {

            public static void main(String[] args) throws InterruptedException {
                // Crea el monitor del restaurante
                MonitorRestaurante monitor = new MonitorRestaurante(20, 6);

                // Crea los clientes
                for (int i = 0; i < 100; i++) {
                    Cliente cliente = new Cliente(monitor);
                    cliente.start();
                }

                // Crea la recepcionista
                Recepcionista recepcionista = new Recepcionista(monitor);
                recepcionista.start();

                // Crea los meseros
                for (int i = 0; i < 6; i++) {
                    Mesero mesero = new Mesero(monitor);
                    mesero.start();
                }

                // Espera a que terminen todos los hilos
                for (Thread hilo : Thread.getAllStackTraces().keySet()) {
                    hilo.join();
                }
            }
        }


