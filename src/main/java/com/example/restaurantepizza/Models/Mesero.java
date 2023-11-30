package com.example.restaurantepizza.Models;

import com.example.restaurantepizza.Threads.HiloCliente;

import java.util.Queue;

public class Mesero {
    private int meserosDisponibles;
    private Queue<HiloCliente> colaPedidos;

    public int getMeserosDisponibles() {
        return meserosDisponibles;
    }

    public void setMeserosDisponibles(int meserosDisponibles) {
        this.meserosDisponibles = meserosDisponibles;
    }

    public Queue<HiloCliente> getColaPedidos() {
        return colaPedidos;
    }

    public void setColaPedidos(Queue<HiloCliente> colaPedidos) {
        this.colaPedidos = colaPedidos;
    }
}
