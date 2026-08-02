package gestionpedidos;

/**
 * Representa un pedido dentro del sistema de gestión. Esta clase contiene la
 * información del cliente, los detalles del producto y las reglas de negocio
 * para el cálculo de costes finales.
 * 
 * @author jcgarrido605r
 * @version 1.0
 */
public class Pedido {

    private int id;
    private String nombreCliente;
    private double precio;
    private int cantidad;
    private boolean urgente;
    private double costeUrgente;
    private double porcentajeDescuentoSobre100;

    /**
     * Construye un nuevo pedido con los datos esenciales de identificación,
     * cliente y producto, aplicando por defecto los costes de urgencia y descuentos.
     * 
     * @param id Identificador numérico único del pedido.
     * @param nombreCliente Nombre del cliente que realiza la compra.
     * @param precio Valor unitario del artículo.
     * @param cantidad Número de unidades solicitadas.
     * @param urgente Estado que define si el pedido tiene prioridad de envío.
     */
    public Pedido(int id, String nombreCliente, double precio, int cantidad, boolean urgente) {
        this.setId(id);
        this.setNombreCliente(nombreCliente);
        this.setPrecio(precio);
        this.setCantidad(cantidad);
        this.setUrgente(urgente);
        this.setCosteUrgente(20);
        this.setPorcentajeDescuentoSobre100(0.1);
    }
    
    /**
     * Determina el importe total de la compra. El cálculo final incluye 
     * recargos por gestión de urgencia y beneficios de descuento por volumen 
     * de compra si se supera el límite establecido.
     * 
     * @return El importe total neto que el cliente debe abonar.
     */
    public double calcularTotal() {
    	double total = getPrecio() * getCantidad();
        if (isUrgente()) {
            total = total + getCosteUrgente();
        }
        if (total > 100) {
            total = total - (total * getPorcentajeDescuentoSobre100());
        }
        return total;
    }

	/**
	 * Indica si el pedido requiere un tratamiento de envío prioritario.
	 * @return true si el pedido es urgente, false en caso contrario.
	 */
	public boolean isUrgente() {
		return urgente;
	}

	/**
	 * Modifica la prioridad de envío del pedido.
	 * @param urgente true para marcarlo como prioritario.
	 */
	public void setUrgente(boolean urgente) {
		this.urgente = urgente;
	}

	/**
	 * Obtiene el número de unidades del producto solicitadas en este pedido.
	 * @return Cantidad de artículos.
	 */
	public int getCantidad() {
		return cantidad;
	}

	/**
	 * Actualiza el número de unidades del pedido.
	 * @param cantidad Nueva cantidad de artículos.
	 */
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	/**
	 * Obtiene el coste por unidad definido para el artículo.
	 * @return Precio unitario.
	 */
	public double getPrecio() {
		return precio;
	}

	/**
	 * Establece el coste por unidad del artículo.
	 * @param precio Nuevo precio unitario.
	 */
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	/**
	 * Proporciona el nombre del titular asociado al pedido.
	 * @return Nombre del cliente.
	 */
	public String getNombreCliente() {
		return nombreCliente;
	}

	/**
	 * Registra o cambia el nombre del cliente del pedido.
	 * @param nombreCliente Nombre del titular.
	 */
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	/**
	 * Obtiene el identificador único del pedido en el sistema.
	 * @return ID del pedido.
	 */
	public int getId() {
		return id;
	}

	/**
	 * Asigna un identificador único al pedido.
	 * @param id Nuevo identificador.
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Obtiene el factor de descuento aplicado cuando el pedido supera el umbral de compra.
	 * @return Valor decimal del porcentaje de descuento.
	 */
	public double getPorcentajeDescuentoSobre100() {
		return porcentajeDescuentoSobre100;
	}

	/**
	 * Define el factor de descuento para compras de volumen elevado.
	 * @param porcentajedescuentoSobre100 Nuevo porcentaje en formato decimal (ej: 0.1 para 10%).
	 */
	public void setPorcentajeDescuentoSobre100(double porcentajedescuentoSobre100) {
		this.porcentajeDescuentoSobre100 = porcentajedescuentoSobre100;
	}

	/**
	 * Obtiene el importe adicional establecido para los pedidos prioritarios.
	 * @return Valor del coste por urgencia.
	 */
	public double getCosteUrgente() {
		return costeUrgente;
	}

	/**
	 * Configura el importe adicional que se cobrará por la gestión urgente.
	 * @param costeUrgente Nuevo importe de recargo.
	 */
	public void setCosteUrgente(double costeUrgente) {
		this.costeUrgente = costeUrgente;
	}
}