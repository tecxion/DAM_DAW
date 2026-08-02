package ej14_Clase_Persona;

public class Principal {
    public static void main(String[] args) {
        // Crear un objeto de la clase Persona
        Persona persona1 = new Persona("Juan", 25, "Masculino");

        // Mostrar información inicial de la persona
        System.out.println("Información inicial de la persona:");
        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Edad: " + persona1.getEdad());
        System.out.println("Género: " + persona1.getGenero());
        System.out.println();

        // La persona saluda
        System.out.println("Acción: La persona saluda.");
        persona1.saludar();
        System.out.println();

        // La persona cumple años
        System.out.println("Acción: La persona cumple años.");
        persona1.cumplirAnios();
        System.out.println();

        // Mostrar información actualizada de la persona
        System.out.println("Información actualizada de la persona:");
        System.out.println("Nombre: " + persona1.getNombre());
        System.out.println("Edad: " + persona1.getEdad());
        System.out.println("Género: " + persona1.getGenero());
    }
}
