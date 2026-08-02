package tarea_25_26;
public class Manager extends Empleado {
    private double bono;

    public Manager(String nombre, int edad, double salarioBase, double bono) {
        super(nombre, edad, salarioBase);
        this.bono = bono;
    }

    public double getBono() {
        return bono;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + bono;
    }

    @Override
    public void imprimirDetalles() {
        System.out.println("=== MANAGER ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Salario base: " + salarioBase);
        System.out.println("Bono: " + bono);
        System.out.println("Salario final: " +String.format("%.2f",calcularSalario()));
    }
  //Otra forma aprovechando el método mostrarInformación():
    /*@Override
    public void imprimirDetalles() {
        System.out.println("=== Manager ===" + mostrarInformacion());
    }*/
    
}