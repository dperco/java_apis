module org.example.port_wifi {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires com.github.oshi;

    opens org.example.port_wifi to javafx.fxml;
    exports org.example.port_wifi;
}