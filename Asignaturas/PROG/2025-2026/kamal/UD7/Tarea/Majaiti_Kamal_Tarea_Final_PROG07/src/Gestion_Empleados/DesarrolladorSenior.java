package Gestion_Empleados;

public class DesarrolladorSenior extends Empleado implements Imprimible {

	private int horasTrabajadas;

	public DesarrolladorSenior(String nombre, int edad, double salarioBase, int horasTrabajadas) {
		super(nombre, edad, salarioBase);
		this.horasTrabajadas = horasTrabajadas;
	}

	@Override
	public double calcularSalario() {
		double salario = this.salarioBase + (horasTrabajadas * 35);
		return salario;
	}

	@Override
	public void imprimirDetalles() {
		// Imprimimos los datos del objeto padre.
		super.imprimirDetalles();
		System.out.println("Tipo de empleado: Desarrollador Senior.");
		System.out.println("Horas trabajadas del Desarrollador Senior: " + String.valueOf(this.horasTrabajadas));
		double salarioCompleto = this.calcularSalario();
		System.out.println("Salario completo del Desarrollador Senior: " + String.valueOf(salarioCompleto));
		this.imprimirMensajeFinal();

	};

}
