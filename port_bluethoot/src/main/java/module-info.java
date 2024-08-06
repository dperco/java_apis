module org.example.port_bluethoot {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;

    opens org.example.port_bluethoot to javafx.fxml;
    exports org.example.port_bluethoot;
}