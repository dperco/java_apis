package org.example.port_bluethoot;

import javax.bluetooth.;

public class BluetoothConnector {

    public void connect() {
        try {
            LocalDevice localDevice = LocalDevice.getLocalDevice();
            DiscoveryAgent agent = localDevice.getDiscoveryAgent();

            agent.startInquiry(DiscoveryAgent.GIAC, new DiscoveryListener() {
                @Override
                public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
                    try {
                        System.out.println("Device found: " + btDevice.getFriendlyName(false));
                        // Aquí puedes agregar el código para establecer una conexión con btDevice y enviar comandos
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void inquiryCompleted(int discType) {
                    System.out.println("Device inquiry completed");
                }

                @Override
                public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {}

                @Override
                public void serviceSearchCompleted(int transID, int respCode) {}
            });

            System.out.println("Starting device inquiry...");
        } catch (BluetoothStateException e) {
            e.printStackTrace();
        }
    }
}
