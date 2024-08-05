

package com.example.deviceconfigurator;

import com.example.deviceconfigurator.DeviceConfigurator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.example.demo_port_ip.HelloController;

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

        // Connect Button
        Button connectButton = new Button("Connect and Configure");
        GridPane.setConstraints(connectButton, 1, 3);

        connectButton.setOnAction(e -> {
            String ip = ipInput.getText();
            String user = userInput.getText();
            String pass = passInput.getText();
            configureDevice(ip, user, pass);
        });

        grid.getChildren().addAll(ipLabel, ipInput, userLabel, userInput, passLabel, passInput, connectButton);

        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void configureDevice(String ip, String user, String pass) {
        HelloController.SerialCommunicator communicator = new HelloController.SerialCommunicator();
        if (communicator.connect("COM3")) { // Cambia "COM3" por el puerto correcto
            communicator.sendCommand("SET IP " + ip);
            communicator.sendCommand("SET USER " + user);
            communicator.sendCommand("SET PASS " + pass);
            communicator.disconnect();
            System.out.println("Device configured successfully.");
        } else {
            System.out.println("Failed to connect to the device.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}