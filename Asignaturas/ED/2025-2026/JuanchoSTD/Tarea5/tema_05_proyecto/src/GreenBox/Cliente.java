package GreenBox;

public class Cliente extends Usuario {

	private String email;
	private String nombreCompleto;
	private String direccion;

	/**
	 * 
	 * @param pedido
	 */
	public void realizaPedido(Pedido pedido) {
		// TODO - implement Cliente.realizaPedido
		throw new UnsupportedOperationException();
	}

	public Pedido[] consultaPedidos() {
		// TODO - implement Cliente.consultaPedidos
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param pedido
	 */
	public boolean cancelaPedidoPendiente(Pedido pedido) {
		// TODO - implement Cliente.cancelaPedidoPendiente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param direccion
	 * @param nombreCompleto
	 */
	public void modificaDatosPersonales(String email, String direccion, String nombreCompleto) {
		// TODO - implement Cliente.modificaDatosPersonales
		throw new UnsupportedOperationException();
	}

	public Cliente() {
		// TODO - implement Cliente.Cliente
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param email
	 * @param nombreCompleto
	 * @param direccion
	 */
	public Cliente(String email, String nombreCompleto, String direccion) {
		// TODO - implement Cliente.Cliente
		throw new UnsupportedOperationException();
	}

	public String getEmail() {
		return this.email;
	}

	/**
	 * 
	 * @param email
	 */
	private void setEmail(String email) {
		this.email = email;
	}

	public String getNombreCompleto() {
		return this.nombreCompleto;
	}

	/**
	 * 
	 * @param nombreCompleto
	 */
	private void setNombreCompleto(String nombreCompleto) {
		this.nombreCompleto = nombreCompleto;
	}

	public String getDireccion() {
		return this.direccion;
	}

	/**
	 * 
	 * @param direccion
	 */
	private void setDireccion(String direccion) {
		this.direccion = direccion;
	}

}