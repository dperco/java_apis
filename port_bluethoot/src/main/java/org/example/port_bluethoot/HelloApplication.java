package org.example.port_bluethoot;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DeviceConfigurator extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Device Configurator");

        GridPane grid = new GridPane();
        grid.setPadding(new Insets(10, 10, 10, 10));
        grid.setVgap(8);
        grid.setHgap(10);

        // Aquí van tus campos de texto y etiquetas...

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
    }

    private void configureDevice(String ip, String user, String pass, String port, String baudRate, String protocol) {
        BluetoothConnector connector = new BluetoothConnector();
        connector.connect();
        // Aquí puedes agregar el código para configurar el dispositivo después de establecer la conexión Bluetooth
    }

    public static void main(String[] args) {
        launch(args);
    }
}