package tienda_objectdb;

public class LineaCarrito {

	private Producto producto;
	private int cantidad;
	public LineaCarrito(Producto producto, int cantidad) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double calcularSubtotal() {
		
		return cantidad*producto.calcularPrecioFinal();
	}
	 
	public String mostrarLinea() {
		
		return producto.mostrarInformacion() + " Cantidad: " +cantidad + " Total: "+  String.format("%.2f",calcularSubtotal()); 
	}

}