/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej07_ejercicio_resuelto_excepciones;

import java.util.Scanner;

public class Ejercicio_resuelto_excepciones4 {
	public static void main(String[] args) {
         // Variable para almacenar el número ingresado
        int numero = leerNumero(); // Validar la entrada y convertirla a número
        
        System.out.println("En el programa principal, el número es: " + numero);
        
    }

    /**
     * Valida que la entrada sea un número entero válido y dentro del rango 0-100.
     * 
     * @param entrada La entrada del usuario como String.
     * @return El número entero validado, o -1 si la entrada no es válida.
     */
    public static int leerNumero() {
    	Scanner sc = new Scanner(System.in); // Crear el Scanner una vez al inicio
    	 int intentos = 0; // Contador de intentos
        int numero = -1; // Valor inicial para identificar entradas no válidas
        String entrada;
        do {
            System.out.print("Introduzca un número entre 0 y 100: ");
            entrada = sc.nextLine(); // Leer la entrada como texto
           
            try {
                numero = Integer.parseInt(entrada); // Convertir la entrada a entero
                if (numero < 0 || numero > 100) {
                    System.out.println("El número debe estar entre 0 y 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe introducir un número entero válido.");
            }
            intentos++;
        } while (numero < 0 || numero > 100);

        sc.close(); // Cerrar el Scanner al final
        System.out.println("El número introducido es: " + numero);
        System.out.println("Número de intentos: " + intentos);
        return numero;
    }
}