module org.example.port_config {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.port_config to javafx.fxml;
    exports org.example.port_config;
}