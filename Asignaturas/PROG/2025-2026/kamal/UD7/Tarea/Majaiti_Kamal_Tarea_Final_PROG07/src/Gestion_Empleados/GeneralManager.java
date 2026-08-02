package Gestion_Empleados;

public class GeneralManager extends Empleado implements Imprimible {

	private double bono;

	public GeneralManager(String nombre, int edad, double salarioBase, double bono) {
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
		System.out.println("Tipo de empleado: General Manager.");
		System.out.println("Bono del Manager General: " + String.valueOf(this.bono));
		double salarioCompleto = this.calcularSalario();
		System.out.println("Salario completo del General Manager: " + String.valueOf(salarioCompleto));
		this.imprimirMensajeFinal();

	};

}
