package tarea_25_26;
public abstract class Empleado implements Imprimible {
    protected String nombre;
    protected int edad;
    protected double salarioBase;

    public Empleado(String nombre, int edad, double salarioBase) {
        this.nombre = nombre;
        this.edad = edad;
        this.salarioBase = salarioBase;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public abstract double calcularSalario();

    public String mostrarInformacion() {
        return "\nNombre: " + nombre +
               "\nEdad: " + edad +
               "\nSalario base: " + salarioBase +
               "\nSalario final: " + String.format("%.2f",calcularSalario());
    }
}