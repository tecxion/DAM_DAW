package ej13_ejemplos_SWING_Edu4Java;

//pedimos al usuario que introduzca dos números a través de las cajas de diálogo showInputDialog

import javax.swing.JOptionPane;

public class Adding2 {

	public static void main(String[] args) {
		
		// Solicita el primer número al usuario
		String n1 = JOptionPane.showInputDialog(null, "First number to add");
		
		// Valida que el primer número sea un entero
		while (!isNumber(n1)) {
			n1 = JOptionPane.showInputDialog(null,
					"Invalid first number. Please insert another number");
		}
		
		// Solicita el segundo número al usuario
		String n2 = JOptionPane.showInputDialog(null, "Second number to add");
		
		// Valida que el segundo número sea un entero
		while (!isNumber(n2)) {
			n2 = JOptionPane.showInputDialog(null,
					"Invalid second number. Please insert another number");
		}
		
		// Convierte los números a enteros y los suma
		int r = Integer.parseInt(n1) + Integer.parseInt(n2);
		
		// Muestra el resultado de la suma
		JOptionPane.showMessageDialog(null, "The result of the addition of: "
				+ n1 + " and: " + n2 + " is " + r);
	}

	// Método auxiliar que comprueba si una cadena es un número entero válido
	private static boolean isNumber(String n) {
		try {
			Integer.parseInt(n); // Intenta convertir la cadena a entero
			return true;         // Si lo consigue, devuelve true
		} catch (NumberFormatException nfe) {
			return false;        // Si falla, devuelve false
		}
	}
}
