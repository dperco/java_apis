package org.example.demo_port_ip;

import com.fazecast.jSerialComm.SerialPort;
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

        private SerialPort serialPort;

        public boolean connect(String portName) {
            serialPort = SerialPort.getCommPort(portName);
            serialPort.setComPortParameters(9600, 8, 1, 0);
            serialPort.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

            return serialPort.openPort();
        }

        public void disconnect() {
            if (serialPort != null && serialPort.isOpen()) {
                serialPort.closePort();
            }
        }

        public void sendCommand(String command) {
            if (serialPort != null && serialPort.isOpen()) {
                byte[] commandBytes = command.getBytes();
                serialPort.writeBytes(commandBytes, commandBytes.length);
            }
        }
    }
}