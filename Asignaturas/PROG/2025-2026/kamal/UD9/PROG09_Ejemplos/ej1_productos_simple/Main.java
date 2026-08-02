package ej1_productos_simple;
public class Main {
    public static void main(String[] args) {
        Mueble m1 = new Mueble("M001", "Silla nórdica", 129.99, "Madera de roble", "Blanco");
        Mueble m2 = new Mueble("M002", "Mesa auxiliar", 89.50, "Madera de haya", "Natural");

        m1.mostrarInformacion();
        System.out.println("-------------------");
        m2.mostrarInformacion();
    }
}