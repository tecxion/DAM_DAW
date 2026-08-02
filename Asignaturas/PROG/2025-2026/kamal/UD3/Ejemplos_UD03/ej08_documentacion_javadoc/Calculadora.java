package ej08_documentacion_javadoc;
/**
 * Clase que representa una calculadora básica.
 * Proporciona métodos para realizar operaciones matemáticas simples como suma, resta,
 * multiplicación y división.
 * 
 * @author Enrique Rivas
 * @version 1.0
 */
public class Calculadora {

    /**
     * Suma dos números enteros.
     * 
     * @param a Primer número a sumar.
     * @param b Segundo número a sumar.
     * @return La suma de los dos números.
     */
    public int sumar(int a, int b) {
        return a + b;
    }

    /**
     * Resta dos números enteros.
     * 
     * @param a Minuendo.
     * @param b Sustraendo.
     * @return La resta de los dos números.
     */
    public int restar(int a, int b) {
        return a - b;
    }

    /**
     * Multiplica dos números enteros.
     * 
     * @param a Primer número a multiplicar.
     * @param b Segundo número a multiplicar.
     * @return El producto de los dos números.
     */
    public int multiplicar(int a, int b) {
        return a * b;
    }

    /**
     * Divide dos números enteros.
     * 
     * @param a Dividendo.
     * @param b Divisor.
     * @return El cociente de la división.
     * @throws ArithmeticException Si el divisor es 0.
     */
    public int dividir(int a, int b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("No se puede dividir por cero.");
        }
        return a / b;
    }

    /**
     * Método principal para probar las operaciones de la calculadora.
     * 
     * @param args Argumentos de la línea de comandos (no se utilizan en este programa).
     */
    public static void main(String[] args) {
        Calculadora calc = new Calculadora();
        System.out.println("Suma: " + calc.sumar(5, 3));
        System.out.println("Resta: " + calc.restar(5, 3));
        System.out.println("Multiplicación: " + calc.multiplicar(5, 3));
        System.out.println("División: " + calc.dividir(6, 3));
    }
}
