package gestionpedidos;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Clase encargada de administrar el conjunto de pedidos de la aplicación.
 * Permite el registro, consulta y cálculo de importes de los pedidos almacenados.
 * 
 * @author jcgarrido605r
 * @version 1.0
 */
public class GestorPedidos {

	private Map<Integer, Pedido> pedidos = new LinkedHashMap<Integer, Pedido>();

	/**
	 * Registra un nuevo pedido en el sistema.
	 * 
	 * @param p El objeto Pedido que se desea añadir.
	 */
	public void anyadirPedido(Pedido p) {
		pedidos.put(p.getId(), p);
	}

	/**
	 * Muestra por la salida estándar un resumen detallado de todos los pedidos
	 * actualmente registrados en el sistema.
	 */
	public void mostrarPedidos() {

		for (Pedido p : pedidos.values()) {
			System.out.println("Pedido " + p.getId() + " Cliente: " + p.getNombreCliente());
			if (p.isUrgente()) {
				System.out.println("URGENTE");
			}
			System.out.println("Total: " + p.calcularTotal());
			System.out.println("-----------------");
		}
	}

	/**
	 * Obtiene el coste total de un pedido específico mediante su identificador.
	 * 
	 * @param idPedido El identificador del pedido a consultar.
	 * @return El total calculado del pedido.
	 * @throws IllegalArgumentException Si el identificador proporcionado no existe en el sistema.
	 */
	public double calcularTotalPedido(int idPedido) {
	    Pedido pedido = pedidos.get(idPedido);
	    if (pedido == null) {
	        throw new IllegalArgumentException("No se encuentra el pedido con ID: " + idPedido);
	    }
	    return pedido.calcularTotal();
	
	}
}