package ej07_ejercicio_resuelto_excepciones;

import java.util.Scanner;

public class ExcepcionesClase {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int valor = -1;

        do {
            try {
                System.out.print("Introduce un número entre 0 y 100: ");
                String entrada = sc.nextLine();
                valor = validarEntrada(entrada);  // lanza excepción si no es válido
            } catch (Exception e) {
                System.out.println(e.getMessage());  // mensaje
            }
        } while (valor < 0 || valor > 100);

        System.out.println("Número válido: " + valor);
        sc.close();
    }

    // Método para validar si la entrada es un número entre 0 y 100
    private static int validarEntrada(String entrada) throws Exception {
        int num;

        try {
            num = Integer.parseInt(entrada);  // puede lanzar NumberFormatException
        } catch (NumberFormatException e) {
            throw new Exception("Debes introducir un número entero válido.");
        }

        if (num < 0 || num > 100) {
            throw new Exception("El número debe estar entre 0 y 100.");
        }

        return num;
    }
}
