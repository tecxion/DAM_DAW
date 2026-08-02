package tarea_25_26;
public class Socio extends Empleado {
    private int stockOptions;

    public Socio(String nombre, int edad, double salarioBase, int stockOptions) {
        super(nombre, edad, salarioBase);
        this.stockOptions = stockOptions;
    }

    public int getStockOptions() {
        return stockOptions;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (stockOptions * 122);
    }

   /* @Override
    public void imprimirDetalles() {
        System.out.println("=== SOCIO ===");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Salario base: " + salarioBase);
        System.out.println("Stock options: " + stockOptions);
        System.out.println("Salario final: " + String.format("%.2f",calcularSalario()));
    }*/
  //Otra forma mejor aprovechando el método mostrarInformación():
    @Override
    public void imprimirDetalles() {
        System.out.println("=== SOCIO ==="+mostrarInformacion());
    }
    
}