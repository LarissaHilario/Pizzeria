module com.example.restaurantepizza {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.restaurantepizza to javafx.fxml;
    exports com.example.restaurantepizza;
}