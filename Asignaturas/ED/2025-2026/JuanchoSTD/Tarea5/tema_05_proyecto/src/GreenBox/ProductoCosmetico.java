package GreenBox;

public class ProductoCosmetico extends Producto {

	private TipoPiel tipoPiel;

	public TipoPiel getTipoPiel() {
		return this.tipoPiel;
	}

	/**
	 * 
	 * @param tipoPiel
	 */
	public void setTipoPiel(TipoPiel tipoPiel) {
		this.tipoPiel = tipoPiel;
	}

	public ProductoCosmetico() {
		// TODO - implement ProductoCosmetico.ProductoCosmetico
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param nombre
	 * @param descripcion
	 * @param categoria
	 * @param precio
	 * @param stock
	 * @param tipoPiel
	 */
	public ProductoCosmetico(String nombre, String descripcion, CategoriaProducto categoria, double precio, int stock, TipoPiel tipoPiel) {
		// TODO - implement ProductoCosmetico.ProductoCosmetico
		throw new UnsupportedOperationException();
	}

}