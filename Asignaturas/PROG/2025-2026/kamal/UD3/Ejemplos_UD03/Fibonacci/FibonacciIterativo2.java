package Fibonacci;

import java.util.Scanner;

public class FibonacciIterativo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = -1; // Variable para guardar la entrada del usuario
        boolean entradaValida = false;

        // Bucle para controlar la entrada hasta que sea válida
        do {
            try {
                System.out.print("Introduce un número entero no negativo para calcular el Fibonacci: ");
                n = Integer.parseInt(sc.nextLine()); // Leer la entrada como String y convertirla
                if (n < 0) {
                    System.out.println("El número debe ser no negativo. Inténtalo de nuevo.");
                } else {
                    entradaValida = true; // La entrada es válida
                }
            } catch (Exception e) {
                System.out.println("Error: Debes introducir un número entero válido.");
            }
        } while (!entradaValida);

        // Llamar a la función de Fibonacci e imprimir el resultado
        int resultado = fibonacciIterativo(n);
        System.out.println("El número de Fibonacci de " + n + " es: " + resultado);

        sc.close();
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
