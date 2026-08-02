package GreenBox;

public class ProductoLimpieza extends Producto {

	private FormatoProductoLimpieza formato;

	public FormatoProductoLimpieza getFormato() {
		return this.formato;
	}

	/**
	 * 
	 * @param formato
	 */
	public void setFormato(FormatoProductoLimpieza formato) {
		this.formato = formato;
	}

	public ProductoLimpieza() {
		// TODO - implement ProductoLimpieza.ProductoLimpieza
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param categoria
	 * @param precio
	 * @param stock
	 * @param formato
	 */
	public ProductoLimpieza(String nombre, String descripcion, CategoriaProducto categoria, double precio, int stock, FormatoProductoLimpieza formato) {
		// TODO - implement ProductoLimpieza.ProductoLimpieza
		throw new UnsupportedOperationException();
	}

}