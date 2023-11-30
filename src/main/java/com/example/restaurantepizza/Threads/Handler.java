package com.example.restaurantepizza.Threads;

import com.example.restaurantepizza.Models.MonitorMesero;
import com.example.restaurantepizza.Models.MonitorRecepcionista;
import javafx.beans.InvalidationListener;

import java.util.Observable;

public class Handler extends Observable implements Runnable {

    MonitorRecepcionista monitorRecepcionista ;
    MonitorMesero monitorMesero ;

    public Handler(MonitorRecepcionista monitorRecepcionista, MonitorMesero monitorMesero) {
        this.monitorMesero =  new MonitorMesero(7);
        this.monitorRecepcionista = new MonitorRecepcionista(20);
    }


    @Override
    public void run() {

        monitorRecepcionista.setMonitorMesero(monitorMesero);
        while (true) {

            HiloCliente cliente = new HiloCliente(monitorRecepcionista, monitorMesero);
            cliente.start();

            try {

                Thread.sleep(1000);

            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

