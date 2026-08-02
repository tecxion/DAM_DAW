package Gestion_Empleados;

public class DesarrolladorJunior extends Empleado implements Imprimible {

	private int horasExtras;

	public DesarrolladorJunior(String nombre, int edad, double salarioBase, int horasExtras) {
		super(nombre, edad, salarioBase);
		this.horasExtras = horasExtras;
	}

	@Override
	public double calcularSalario() {
		double salario = this.salarioBase + (horasExtras * 18);
		return salario;
	}

	@Override
	public void imprimirDetalles() {
		// Imprimimos los datos del objeto padre.
		super.imprimirDetalles();
		System.out.println("Tipo de empleado: desarrollador junior.");
		System.out.println("Horas extras del desarrollador junior : " + String.valueOf(this.horasExtras));
		double salarioCompleto = this.calcularSalario();
		System.out.println("Salario completo del desarrollador junior: " + String.valueOf(salarioCompleto));
		this.imprimirMensajeFinal();

	};

}
