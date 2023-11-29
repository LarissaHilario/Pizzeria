package com.example.restaurantepizza;

import com.example.restaurantepizza.Models.MonitorMesero;
import com.example.restaurantepizza.Models.MonitorRecepcionista;
import com.example.restaurantepizza.Threads.HiloCliente;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 930, 570);
        HelloController controller = fxmlLoader.getController();
        stage.setTitle("Pizzería");
        stage.setScene(scene);
        stage.show();
    }

        public static void main(String[] args) {
        launch();
            MonitorRecepcionista monitorRecepcionista = new MonitorRecepcionista(20);
            MonitorMesero monitorMesero = new MonitorMesero(7);
            monitorRecepcionista.setMonitorMesero(monitorMesero);

            while (true) {
                HiloCliente cliente = new HiloCliente(monitorRecepcionista, monitorMesero);
                cliente.start();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


        }
}