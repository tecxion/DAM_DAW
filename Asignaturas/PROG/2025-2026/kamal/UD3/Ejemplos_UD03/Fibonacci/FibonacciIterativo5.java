package Fibonacci;

import java.util.Scanner;

public class FibonacciIterativo5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = -1;
        boolean entradaValida = false;

        do {
            System.out.print("Introduce un número entero no negativo para calcular el Fibonacci: ");
            String entrada = sc.nextLine(); // Leer el número como cadena

            n = validarNumero(entrada); // Llamar a la función que valida y convierte
            if (n >= 0) {
                entradaValida = true; // Si la validación es exitosa, continuar
            } else {
                System.out.println("Error: Debes introducir un número entero no negativo.");
            }
        } while (!entradaValida);

        // Llamar a la función de Fibonacci e imprimir el resultado
        int resultado = fibonacciIterativo(n);
        System.out.println("El número de Fibonacci de " + n + " es: " + resultado);

        sc.close();
    }

    // Método para validar el número y convertirlo a entero
    public static int validarNumero(String entrada) {
        int numero;

        try {
            numero = Integer.parseInt(entrada); // Intentar convertir la entrada en un entero
            if (numero < 0) {
                return -1; // Retornar -1 si el número es negativo
            }
        } catch (NumberFormatException e) {
            return -1; // Retornar -1 si la entrada no es un número válido
        }

        return numero; // Retornar el número válido
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
