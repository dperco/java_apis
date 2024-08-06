package org.example.port_wifi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    public static class SerialCommunicator {
        public boolean connect(String port) {
            return false;
        }

        public void sendCommand(String s) {
        }

        public void disconnect() {
        }
    }
}