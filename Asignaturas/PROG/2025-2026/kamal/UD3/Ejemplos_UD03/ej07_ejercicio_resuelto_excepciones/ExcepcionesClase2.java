package ej07_ejercicio_resuelto_excepciones;

import java.util.Scanner;
//Lo mismo que el ejemplo anterior, 
//toda la validación se hace directamente en el main, 
//sin lanzar excepciones propias ni crear métodos adicionales:
public class ExcepcionesClase2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int valor = -1;

        do {
            System.out.print("Introduce un número entre 0 y 100: ");
            String entrada = sc.nextLine();

            try {
                valor = Integer.parseInt(entrada);

                if (valor < 0 || valor > 100) {
                    System.out.println("El número debe estar entre 0 y 100.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Debes introducir un número entero válido.");
            }

        } while (valor < 0 || valor > 100);

        System.out.println("Número válido: " + valor);
        sc.close();
    }
}
