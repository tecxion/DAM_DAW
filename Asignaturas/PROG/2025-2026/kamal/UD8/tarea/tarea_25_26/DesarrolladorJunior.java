package tarea_25_26;
public class DesarrolladorJunior extends Empleado {
    private int horasExtras;

    public DesarrolladorJunior(String nombre, int edad, double salarioBase, int horasExtras) {
        super(nombre, edad, salarioBase);
        this.horasExtras = horasExtras;
    }

    public int getHorasExtras() {
        return horasExtras;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (horasExtras * 18);
    }

    @Override
    public void imprimirDetalles() {
        System.out.println("=== DESARROLLADOR JUNIOR ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Salario base: " + salarioBase);
        System.out.println("Horas extra: " + horasExtras);
        System.out.println("Salario final: " + String.format("%.2f",calcularSalario()));
    }
    
    //Otra forma mejor aprovechando el método mostrarInformación():
    /*@Override
    public void imprimirDetalles() {
        System.out.println("=== Desarrollador Junior ===" + mostrarInformacion());
    }*/
    
}