module org.example.demo_port_ip {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires com.fazecast.jSerialComm;

    opens org.example.demo_port_ip to javafx.fxml;
    exports org.example.demo_port_ip;
    exports com.example.deviceconfigurator;
    opens com.example.deviceconfigurator to javafx.fxml;
}