package ej06_sentencia_return;

public class EjemploReturn {
    public static void main(String[] args) {
        int num = 7;
        System.out.println("El número " + num + " es: " + evaluarNumero(num));
        num = 8;
        System.out.println("El número " + num + " es: " + evaluarNumero2(num));
    }

    public static String evaluarNumero(int numero) {
        if (numero > 0) {
            return "positivo";
        } else if (numero < 0) {
            return "negativo";
        } else {
            return "cero";
        }
    }
    public static String evaluarNumero2(int numero) {
        String resultado;
        if (numero > 0) {
            resultado = "positivo";
        } else if (numero < 0) {
            resultado = "negativo";
        } else {
            resultado = "cero";
        }
        return resultado;
    }

}
