package org.example.port_wifi;

import jpcap.*;
import jpcap.packet.*;

public class NetworkScanner {
    public static void main(String[] args) {
        // Obtén todas las interfaces de red
        NetworkInterface[] devices = JpcapCaptor.getDeviceList();

        // Imprime todas las interfaces de red
        for (NetworkInterface device : devices) {
            System.out.println(device.name + ":\n" + device.description);

            // Imprime todas las direcciones IP de cada interfaz de red
            for (NetworkInterfaceAddress address : device.addresses) {
                System.out.println(address.address);
            }
        }
    }
}