package GreenBox;

public abstract class Producto {

	private String nombre;
	private String descripcion;
	private CategoriaProducto categoria;
	private double precio;
	private int stock;

	public String getNombre() {
		return this.nombre;
	}

	/**
	 * 
	 * @param nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	/**
	 * 
	 * @param descripcion
	 */
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getCategoria() {
		// TODO - implement Producto.getCategoria
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param categoria
	 */
	public void setCategoria(String categoria) {
		// TODO - implement Producto.setCategoria
		throw new UnsupportedOperationException();
	}

	public double getPrecio() {
		return this.precio;
	}

	/**
	 * 
	 * @param precio
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return this.stock;
	}

	/**
	 * 
	 * @param stock
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}

	public Producto() {
		// TODO - implement Producto.Producto
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param categoria
	 * @param precio
	 * @param stock
	 */
	public Producto(String nombre, String descripcion, CategoriaProducto categoria, double precio, int stock) {
		// TODO - implement Producto.Producto
		throw new UnsupportedOperationException();
	}

}