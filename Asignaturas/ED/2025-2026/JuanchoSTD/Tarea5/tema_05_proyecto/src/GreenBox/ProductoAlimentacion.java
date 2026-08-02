package GreenBox;

public class ProductoAlimentacion extends Producto {

	private double peso;
	private boolean perecedero;

	public double getPeso() {
		return this.peso;
	}

	/**
	 * 
	 * @param peso
	 */
	public void setPeso(double peso) {
		this.peso = peso;
	}

	public boolean getPerecedero() {
		return this.perecedero;
	}

	/**
	 * 
	 * @param perecedero
	 */
	public void setPerecedero(boolean perecedero) {
		this.perecedero = perecedero;
	}

	public ProductoAlimentacion() {
		// TODO - implement ProductoAlimentacion.ProductoAlimentacion
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param categoria
	 * @param precio
	 * @param stock
	 * @param peso
	 * @param perecedero
	 */
	public ProductoAlimentacion(String nombre, String descripcion, CategoriaProducto categoria, double precio, int stock, double peso, boolean perecedero) {
		// TODO - implement ProductoAlimentacion.ProductoAlimentacion
		throw new UnsupportedOperationException();
	}

}