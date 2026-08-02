package Fibonacci;

import java.util.Scanner;

public class FibonacciIterativo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número entero n: ");
        int n = sc.nextInt();

        if (n < 0) {
            System.out.println("El número debe ser mayor o igual a 0.");
        } else {
            System.out.println("El número de Fibonacci en la posición " + n + " es: " + fibonacciIterativo(n));
        }

        sc.close();
    }

    public static int fibonacciIterativo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
}
