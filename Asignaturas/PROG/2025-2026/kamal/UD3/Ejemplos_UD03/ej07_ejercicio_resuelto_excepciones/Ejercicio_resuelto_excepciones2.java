/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej07_ejercicio_resuelto_excepciones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ejercicio_resuelto_excepciones2 {
    public static void main(String[] args) {
        int numero = -1;
        int intentos = 0;
        Scanner sc = new Scanner(System.in); // Crear el Scanner una vez al inicio

        do {
            try {
                System.out.print("Introduzca un número entre 0 y 100: ");
                numero = sc.nextInt(); // Leer el número
                if (numero < 0 || numero > 100) {
                    System.out.println("El número debe estar entre 0 y 100.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe introducir un número entero.");
                sc.nextLine(); // Limpiar el flujo de entrada
            } finally {
                intentos++;
            }
        } while (numero < 0 || numero > 100);

        sc.close(); // Cerrar el Scanner al final
        System.out.println("El número introducido es: " + numero);
        System.out.println("Número de intentos: " + intentos);
    }
}
