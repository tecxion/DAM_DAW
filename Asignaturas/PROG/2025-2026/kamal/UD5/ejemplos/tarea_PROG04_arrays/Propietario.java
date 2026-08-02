package tarea_PROG04_arrays;

public class Propietario {
	private String nombre;
	private String dni;
	private String numTelefono;
	
	public Propietario() {	
		nombre="sin nombre";
		dni="12345678Z";
		numTelefono ="000000000";
	}
	
	public Propietario(String nombre, String dni, String numTelefono) {	
		this.nombre = nombre;
		this.dni= dni;
		this.numTelefono = numTelefono;
	}
	
	public static boolean validarDni(String dni) {
		
		return dni.matches("\\d{8}[A-Za-z]");
	}
	
	@Override 
	public String toString() {
		return "Propietario: [nombre: " + nombre + " DNI: " + dni + " Número de teléfono: " + numTelefono + "]";
	}
	
}
