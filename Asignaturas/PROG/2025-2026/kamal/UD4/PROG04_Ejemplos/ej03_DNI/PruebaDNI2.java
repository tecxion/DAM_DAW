package ej03_DNI;
public class PruebaDNI2 {

    public static void main(String[] args) {

        DNI2 dni = new DNI2();

        // ===== EJEMPLO 1: establecer el DNI a partir de un número =====
        
            dni.establecer(12345678);
            System.out.println("DNI numérico: " + dni.obtenerDNI());
            System.out.println("NIF completo: " + dni.obtenerNIF());
       

        System.out.println();

        // ===== EJEMPLO 2: establecer el DNI a partir de un NIF =====
       
            dni.establecer("12345678Z");
            System.out.println("DNI numérico: " + dni.obtenerDNI());
            System.out.println("NIF completo: " + dni.obtenerNIF());
        

        System.out.println();

        // ===== EJEMPLO 3: NIF incorrecto =====
      
            dni.establecer("12345678A"); // Letra incorrecta
            System.out.println("NIF completo: " + dni.obtenerNIF());
        
    }
}