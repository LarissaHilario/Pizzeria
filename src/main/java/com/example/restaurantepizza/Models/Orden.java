package com.example.restaurantepizza.Models;

public class Orden {

    private int cliente;
    private int mesero;
    private String pizza;

    public Orden(int cliente, int mesero, String pizza) {
        this.cliente = cliente;
        this.mesero = mesero;
        this.pizza = pizza;
    }

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getMesero() {
        return mesero;
    }

    public void setMesero(int mesero) {
        this.mesero = mesero;
    }

    public String getPizza() {
        return pizza;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }
}

