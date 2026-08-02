/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej07_ejercicio_resuelto_excepciones;

import java.util.Scanner;

public class Ejercicio_resuelto_excepciones3 {
    public static void main(String[] args) {
        int numero = -1; // Variable para almacenar el número ingresado
        int intentos = 0; // Contador de intentos
        Scanner sc = new Scanner(System.in); // Crear el Scanner una vez al inicio

        do {
            try {
                System.out.print("Introduzca un número entre 0 y 100: ");
                String entrada = sc.nextLine(); // Leer la entrada como texto
                numero = validaNumero(entrada); // Validar y convertir la entrada a número
                if (numero < 0 || numero > 100) {
                    System.out.println("El número debe estar entre 0 y 100. Inténtelo de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Debe introducir un número entero. Inténtelo de nuevo.");
            } finally {
                intentos++; // Incrementar los intentos en cada iteración
            }
        } while (numero < 0 || numero > 100);

        sc.close(); // Cerrar el Scanner al final
        System.out.println("El número introducido es: " + numero);
        System.out.println("Número de intentos: " + intentos);
    }

    /**
     * Valida que la entrada sea un número entero válido.
     * 
     * @param entrada La entrada del usuario como String.
     * @return El número entero validado.
     * @throws NumberFormatException Si la entrada no es un número entero válido.
     */
    public static int validaNumero(String entrada) throws NumberFormatException {
        int numero = Integer.parseInt(entrada); // Convertir la entrada a entero
        return numero; // Retornar el número validado
    }
}
