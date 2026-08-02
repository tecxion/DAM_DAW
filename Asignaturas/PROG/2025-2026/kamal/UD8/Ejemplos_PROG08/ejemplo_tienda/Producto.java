package ejemplo_tienda_mio;

public abstract class Producto implements Mostrable {

	protected String nombre;
	protected double precio;
	public Producto(String nombre, double precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	protected abstract double calcularPrecioFinal();

	protected String mostrarInformacion() {
		return "Nombre: " + nombre + " Precio: " + String.format("%.2f",precio);
	}

}
