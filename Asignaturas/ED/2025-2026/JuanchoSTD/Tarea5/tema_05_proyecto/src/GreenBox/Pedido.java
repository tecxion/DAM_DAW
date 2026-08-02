package GreenBox;

public class Pedido {

	private int tarjetaBancaria;
	private EstadoPedido estado;
	private java.util.Date fecha;
	private double importeTotal;

	public Pedido() {
		// TODO - implement Pedido.Pedido
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param tarjetaBancaria
	 * @param estado
	 * @param fecha
	 * @param importeTotal
	 */
	public Pedido(int tarjetaBancaria, EstadoPedido estado, java.util.Date fecha, double importeTotal) {
		// TODO - implement Pedido.Pedido
		throw new UnsupportedOperationException();
	}

	public int getTarjetaBancaria() {
		return this.tarjetaBancaria;
	}

	/**
	 * 
	 * @param tarjetaBancaria
	 */
	public void setTarjetaBancaria(int tarjetaBancaria) {
		this.tarjetaBancaria = tarjetaBancaria;
	}

	public EstadoPedido getEstado() {
		return this.estado;
	}

	/**
	 * 
	 * @param estado
	 */
	public void setEstado(EstadoPedido estado) {
		this.estado = estado;
	}

	public java.util.Date getFecha() {
		return this.fecha;
	}

	/**
	 * 
	 * @param fecha
	 */
	public void setFecha(java.util.Date fecha) {
		this.fecha = fecha;
	}

	public double getImporteTotal() {
		return this.importeTotal;
	}

	/**
	 * 
	 * @param importeTotal
	 */
	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

}