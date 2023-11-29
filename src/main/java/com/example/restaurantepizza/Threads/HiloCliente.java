package com.example.restaurantepizza.Threads;
import com.example.restaurantepizza.HelloController;
import com.example.restaurantepizza.Models.MonitorMesero;
import com.example.restaurantepizza.Models.MonitorRecepcionista;
import java.util.Random;

public class HiloCliente extends Thread {
    private static int contadorClientes = 0;
    private MonitorRecepcionista monitorRecepcionista;
    private MonitorMesero monitorMesero;

    public HiloCliente(MonitorRecepcionista monitorRecepcionista, MonitorMesero monitorMesero) {
        this.monitorRecepcionista = monitorRecepcionista;
        this.monitorMesero = monitorMesero;
        this.setName("Cliente-" + contadorClientes++);
    }


    public void entrarRestaurante(){
        System.out.println("Cliente " + getId() + " ha entrado al restaurante y su mesa.");
    }

    public void pedirPizza() {
        System.out.println("Cliente " + getId() + " ha pedido una pizza.");
    }

    public void esperarPizza(){
        System.out.println("Cliente " + getId() + " esperando su pizza.");
    }

    public void entregarPizza() {
        monitorRecepcionista.entregarPizza(this);
    }

    public void comerPizza(){
        System.out.println("Cliente " + getId() + " esta comiendo su Pizza");
    }


    @Override
    public void run() {
        monitorRecepcionista.llegarCliente(this);
        entrarRestaurante();
        pedirPizza();
        monitorMesero.atenderPedido(this);
        esperarPizza();
        entregarPizza();
        comerPizza();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        monitorRecepcionista.abandonarRestaurante(this);
       /* try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

    }
}