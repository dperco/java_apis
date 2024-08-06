package org.example.port_wifi;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.port_wifi.HelloController;
import oshi.SystemInfo;
import oshi.hardware.NetworkIF;

public class DeviceConfigurator extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Device Configurator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // IP Address
        Label ipLabel = new Label("IP Address:");
        GridPane.setConstraints(ipLabel, 0, 0);
        TextField ipInput = new TextField();
        GridPane.setConstraints(ipInput, 1, 0);

        // Username
        Label userLabel = new Label("Username:");
        GridPane.setConstraints(userLabel, 0, 1);
        TextField userInput = new TextField();
        GridPane.setConstraints(userInput, 1, 1);

        // Password
        Label passLabel = new Label("Password:");
        GridPane.setConstraints(passLabel, 0, 2);
        TextField passInput = new TextField();
        GridPane.setConstraints(passInput, 1, 2);

        // Port
        Label portLabel = new Label("Port:");
        GridPane.setConstraints(portLabel, 0, 3);
        TextField portInput = new TextField();
        GridPane.setConstraints(portInput, 1, 3);

        // Baud Rate
        Label baudRateLabel = new Label("Baud Rate:");
        GridPane.setConstraints(baudRateLabel, 0, 4);
        TextField baudRateInput = new TextField();
        GridPane.setConstraints(baudRateInput, 1, 4);

        // Protocol
        Label protocolLabel = new Label("Protocol:");
        GridPane.setConstraints(protocolLabel, 0, 5);
        TextField protocolInput = new TextField();
        GridPane.setConstraints(protocolInput, 1, 5);

        // Connect Button
        Button connectButton = new Button("Connect and Configure");
        GridPane.setConstraints(connectButton, 1, 6);

        connectButton.setOnAction(e -> {
            String ip = ipInput.getText();
            String user = userInput.getText();
            String pass = passInput.getText();
            String port = portInput.getText();
            String baudRate = baudRateInput.getText();
            String protocol = protocolInput.getText();
            configureDevice(ip, user, pass, port, baudRate, protocol);
        });

        grid.getChildren().addAll(ipLabel, ipInput, userLabel, userInput, passLabel, passInput, portLabel, portInput, baudRateLabel, baudRateInput, protocolLabel, protocolInput, connectButton);

        Scene scene = new Scene(grid, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

        checkWifiConnection();
    }

    private void configureDevice(String ip, String user, String pass, String port, String baudRate, String protocol) {
        HelloController.SerialCommunicator communicator = new HelloController.SerialCommunicator();
        if (communicator.connect(port)) { // Usar el puerto especificado
            communicator.sendCommand("SET IP " + ip);
            communicator.sendCommand("SET USER " + user);
            communicator.sendCommand("SET PASS " + pass);
            communicator.sendCommand("SET BAUDRATE " + baudRate);
            communicator.sendCommand("SET PROTOCOL " + protocol);
            communicator.disconnect();
            System.out.println("Device configured successfully.");
        } else {
            System.out.println("Failed to connect to the device.");
        }
    }

    private void checkWifiConnection() {
        SystemInfo si = new SystemInfo();
        for (NetworkIF net : si.getHardware().getNetworkIFs()) {
            if (net.getName().contains("Wi-Fi") || net.getName().contains("Wireless")) {
                System.out.println(net.getName() + ": " + (net.getSpeed() > 0 ? "Conectado" : "Desconectado"));
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}