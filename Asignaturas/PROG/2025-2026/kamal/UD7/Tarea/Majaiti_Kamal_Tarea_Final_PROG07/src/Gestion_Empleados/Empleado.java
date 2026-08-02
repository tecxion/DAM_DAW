package Gestion_Empleados;

// Ya puestos, le añado la interface, total, creo un imprmir detalles.
public abstract class Empleado implements Imprimible{

	protected String nombre;
	protected int edad;
	protected double salarioBase;

	public Empleado(String nombre, int edad, double salarioBase) {
		this.nombre = nombre;
		this.edad = edad;
		this.salarioBase = salarioBase;
	}

	public abstract double calcularSalario();

	public String mostrarInformacion() {

		return "Datos del Empleado:\nNombre: " + nombre + "\nEdad: " + edad + "\nSalario Base: " + salarioBase;
	}

	public void imprimirMensajeInicio() {
		System.out.println("----- Inicio Datos del Empleado -----");
	}

	public void imprimirMensajeFinal() {
		System.out.println("----- Fin datos del Empleado -----");
	}

	
	// Lo pongo aqui, no quiero repetir este trozo de codigo en todas las clases hijas, me da mucha pereza, asi lo llamo desde Super =).
	public void imprimirDetalles() {
		this.imprimirMensajeInicio();
		System.out.println(this.mostrarInformacion());
		/* Al ser una clase abstracta nunca van a llamarle desde una instancia de la clase Empleado,
		 *  asi que el mensaje de Fin le llamo desde las clases hijas.
		 */
	}
}
