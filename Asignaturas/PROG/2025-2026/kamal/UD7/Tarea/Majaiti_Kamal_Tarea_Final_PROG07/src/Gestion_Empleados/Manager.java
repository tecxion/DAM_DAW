package Gestion_Empleados;

public class Manager extends Empleado implements Imprimible {

	private double bono;

	public Manager(String nombre, int edad, double salarioBase, double bono) {
		super(nombre, edad, salarioBase);
		this.bono = bono;
	}

	@Override
	public double calcularSalario() {
		double salario = this.salarioBase + bono;
		return salario;
	}

	@Override
	public void imprimirDetalles() {
		// Imprimimos los datos del objeto padre.
		super.imprimirDetalles();
		System.out.println("Tipo de empleado: Manager.");
		System.out.println("Bono del Manager: " + String.valueOf(this.bono));
		double salarioCompleto = this.calcularSalario();
		System.out.println("Salario completo del manager: " + String.valueOf(salarioCompleto));
		this.imprimirMensajeFinal();
	};

}
