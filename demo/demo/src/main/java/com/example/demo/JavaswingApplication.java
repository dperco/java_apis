package com.example.demo;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JavaswingApplication {
	public static void main(String[] args) {
		// Crear el marco (ventana)
		JFrame frame = new JFrame("Aplicación Simple con Java Swing");
		frame.setSize(400, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Crear un panel
		JPanel panel = new JPanel();
		frame.add(panel);
		placeComponents(panel);

		// Hacer visible el marco
		frame.setVisible(true);
	}

	private static void placeComponents(JPanel panel) {
		panel.setLayout(null);

		// Crear un botón
		JButton button = new JButton("Haz clic aquí");
		button.setBounds(150, 100, 100, 40);
		panel.add(button);

		// Agregar un ActionListener al botón
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Mostrar un mensaje en la consola al hacer clic en el botón
				System.out.println("¡Botón clicado!");
			}
		});
	}
}
