package ej13_Clase_Coche;

public class Principal {
    public static void main(String[] args) {
        // Crear un objeto de la clase Coche
        Coche miCoche = new Coche("Toyota", "Corolla", "Rojo", 1800);

        // Mostrar la información inicial del coche
        System.out.println("Información inicial del coche:");
        miCoche.mostrarInformacion();
        System.out.println();

        // Arrancar el coche
        System.out.println("Arrancando el coche...");
        miCoche.arrancar();
        miCoche.mostrarInformacion();
        System.out.println();

        // Acelerar el coche
        System.out.println("Acelerando el coche en 50 km/h...");
        miCoche.acelerar(50);
        miCoche.mostrarInformacion();
        System.out.println();

        // Frenar el coche
        System.out.println("Frenando el coche en 20 km/h...");
        miCoche.frenar(20);
        miCoche.mostrarInformacion();
        System.out.println();

        // Acelerar nuevamente
        System.out.println("Acelerando el coche en 30 km/h...");
        miCoche.acelerar(30);
        miCoche.mostrarInformacion();
        System.out.println();

        // Detener el coche
        System.out.println("Deteniendo el coche...");
        miCoche.parar();
        miCoche.mostrarInformacion();
    }
}
