package ej14_Clase_Persona;

public class Persona {
    // Atributos de la clase Persona
    private String nombre;
    private int edad;
    private String genero;

    // Constructor
    public Persona(String nombre, int edad, String genero) {
        this.nombre = nombre;
        this.edad = edad;
        this.genero = genero;
    }

    // Método para que la persona salude
    public void saludar() {
        System.out.println("Hola, mi nombre es " + nombre + " y tengo " + edad + " años.");
    }

    // Método para que la persona cumpla años (incrementa la edad en 1)
    public void cumplirAnios() {
        edad++;
        System.out.println("¡Feliz cumpleaños! Ahora tengo " + edad + " años.");
    }

    // Métodos adicionales para obtener información sobre la persona
    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getGenero() {
        return genero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
