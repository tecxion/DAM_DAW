package Fibonacci;

import java.util.Scanner;

public class FibonacciIterativo4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        boolean entradaValida = false;

        do {
            System.out.print("Introduce un número entero no negativo para calcular el Fibonacci: ");
            String entrada = sc.nextLine(); // Leer el número como cadena

            try {
                n = validarNumero(entrada); // Llamar a la función que valida y convierte
                entradaValida = true; // Si no hay excepción, la entrada es válida
            } catch (NumberFormatException e) {
                System.out.println("Error: Debes introducir un número entero válido.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        } while (!entradaValida);

        // Llamar a la función de Fibonacci e imprimir el resultado
        int resultado = fibonacciIterativo(n);
        System.out.println("El número de Fibonacci de " + n + " es: " + resultado);

        sc.close();
    }

    // Método para validar el número y convertirlo a entero
    public static int validarNumero(String entrada) throws IllegalArgumentException {
        int numero;

        // Intentar convertir la entrada en un entero
        try {
            numero = Integer.parseInt(entrada);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("La entrada no es un número válido.");
        }

        // Validar que el número no sea negativo
        if (numero < 0) {
            throw new IllegalArgumentException("El número debe ser no negativo.");
        }

        return numero;
    }

    // Método para calcular Fibonacci de manera iterativa
    public static int fibonacciIterativo(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
