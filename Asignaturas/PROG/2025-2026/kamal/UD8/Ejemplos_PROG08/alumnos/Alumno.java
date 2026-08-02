package alumnos;
// Clase de modelo
public class Alumno {
    private String dni;
    private String nombre;
    private int edad;

    public Alumno(String dni, String nombre, int edad) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
    }

    public String getDni() { return dni; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }

    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }

    @Override
    public String toString() {
        return "Alumno [DNI=" + dni + ", Nombre=" + nombre + ", Edad=" + edad + "]";
    }
}