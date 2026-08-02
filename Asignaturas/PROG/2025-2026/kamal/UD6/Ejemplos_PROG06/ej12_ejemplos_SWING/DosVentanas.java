package ej12_ejemplos_SWING;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class DosVentanas {

	private JFrame ventanaPrincipal;
	private JDialog ventanaSecundaria;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new DosVentanas();
	}
	
	public DosVentanas()
	{
		// Construcción de ventana principal
		ventanaPrincipal = new JFrame("Ventana principal");
		JButton boton = new JButton("Abre secundaria");
		ventanaPrincipal.getContentPane().add(boton);
		ventanaPrincipal.pack();
		
		// Construcción de ventana secundaria
		ventanaSecundaria = new JDialog(ventanaPrincipal,"Ventana secundaria");
		JLabel etiqueta = new JLabel("Hola");
		ventanaSecundaria.getContentPane().add(etiqueta);
		ventanaSecundaria.pack();

		// Hacer que el botón abra la ventana secundaria y cierre la
		// principal
		boton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaPrincipal.setVisible(false);
				ventanaSecundaria.setLocationRelativeTo(null);
				ventanaSecundaria.setVisible(true);
			}
		
		});
		
		// Hacer que al cerrarse la secundaria con la x de arriba a la
		// derecha, se muestre la primaria
		ventanaSecundaria.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				ventanaPrincipal.setVisible(true);
				ventanaSecundaria.setVisible(false);
			}
		
			public void windowClosed(WindowEvent e) {
				ventanaPrincipal.setVisible(true);
				ventanaSecundaria.setVisible(false);
			}
		});
		
		// Mostrar la ventana principal
		ventanaPrincipal.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		ventanaPrincipal.setLocationRelativeTo(null);
		ventanaPrincipal.setVisible(true);
	}

}