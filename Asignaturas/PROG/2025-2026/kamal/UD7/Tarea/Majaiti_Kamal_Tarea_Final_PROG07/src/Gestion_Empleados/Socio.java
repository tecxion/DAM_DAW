package Gestion_Empleados;

public class Socio extends Empleado implements Imprimible {

	private int stockOptions;

	public Socio(String nombre, int edad, double salarioBase, int stockOptions) {
		super(nombre, edad, salarioBase);
		this.stockOptions = stockOptions;
	}

	@Override
	public double calcularSalario() {
		
		// Lo hago asi para forzar que siemple el resultado de la multiplicacion sea double.
		double multiploStockOptions=122.0;
		double salario = this.salarioBase + (this.stockOptions * multiploStockOptions);
		return salario;
	}

	@Override
	public void imprimirDetalles() {
		super.imprimirDetalles();
		System.out.println("Tipo de empleado: Socio.");
		System.out.println("Stock Options del Socio: " + String.valueOf(this.stockOptions));
		double salarioCompleto = this.calcularSalario();
		System.out.println("Salario Completo del Socio: " + String.valueOf(salarioCompleto));
		this.imprimirMensajeFinal();

	};

}
