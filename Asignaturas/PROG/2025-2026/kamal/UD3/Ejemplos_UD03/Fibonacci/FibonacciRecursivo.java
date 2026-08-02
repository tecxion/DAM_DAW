package Fibonacci;

import java.util.Scanner;
// n = 0 vale 0, n = 1 vale 1 n = 2 vale 1, n = 3  vale 2  n = 4 vale 3 n = 5 vale 5
// tamaño es n    fibonacci (n)   -> if n== 0 devolver 0 if n == 1 devolver 1 
// caso contario devolver fibonacci (n-2) + fibonacci (n-1)
public class FibonacciRecursivo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduce un número entero n: ");
        int n = sc.nextInt();

        for(int i =0 ; i<=n ; i++) {
	        if (i < 0) {
	            System.out.println("El número debe ser mayor o igual a 0.");
	        } else {
	            System.out.println("El número de Fibonacci en la posición " + i + " es: " + fibonacciRecursivo(i));
	        }
    }
        sc.close();
    }

    public static int fibonacciRecursivo(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fibonacciRecursivo(n - 1) + fibonacciRecursivo(n - 2);
    }
}
