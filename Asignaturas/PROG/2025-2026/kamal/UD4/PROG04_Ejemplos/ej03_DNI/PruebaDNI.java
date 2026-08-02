package ej03_DNI;
public class PruebaDNI {

    public static void main(String[] args) {

        DNI dni = new DNI();

        // ===== EJEMPLO 1: establecer el DNI a partir de un número =====
        try {
            dni.establecer(12345678);
            System.out.println("DNI numérico: " + dni.obtenerDNI());
            System.out.println("NIF completo: " + dni.obtenerNIF());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // ===== EJEMPLO 2: establecer el DNI a partir de un NIF =====
        try {
            dni.establecer("12345678Z");
            System.out.println("DNI numérico: " + dni.obtenerDNI());
            System.out.println("NIF completo: " + dni.obtenerNIF());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println();

        // ===== EJEMPLO 3: NIF incorrecto =====
        try {
            dni.establecer("12345678A"); // Letra incorrecta
            System.out.println("NIF completo: " + dni.obtenerNIF());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}