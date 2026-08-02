package tarea_25_26;
public class DesarrolladorSenior extends Empleado {
    private int horasTrabajadas;

    public DesarrolladorSenior(String nombre, int edad, double salarioBase, int horasTrabajadas) {
        super(nombre, edad, salarioBase);
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getHorasTrabajadas() {
        return horasTrabajadas;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (horasTrabajadas * 35);
    }

    @Override
    public void imprimirDetalles() {
        System.out.println("=== DESARROLLADOR SENIOR ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Salario base: " + salarioBase);
        System.out.println("Horas trabajadas extra: " + horasTrabajadas);
        System.out.println("Salario final: " + String.format("%.2f",calcularSalario()));
    }
    
  //Otra forma mejor aprovechando el método mostrarInformación():
    /*@Override
    public void imprimirDetalles() {
        System.out.println("=== Desarrollador Senior ===" + mostrarInformacion());
    }*/
    
}