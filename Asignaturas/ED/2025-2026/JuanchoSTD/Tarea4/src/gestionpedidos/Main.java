package gestionpedidos;

/**
 * Clase principal que sirve como punto de entrada para la aplicación
 * de gestión de pedidos.
 * 
 * @author jcgarrido605r
 * @version 1.0
 */
public class Main {

    /**
     * Arranca la aplicación, inicializa el gestor y realiza una demostración
     * del registro y visualización de pedidos.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        GestorPedidos gestorPedidos = new GestorPedidos();

        Pedido pedido1 = new Pedido(1, "Laura", 30, 2, false);
        Pedido pedido2 = new Pedido(2, "Carlos", 60, 2, true);
        Pedido pedido3 = new Pedido(3, "Ana", 15, 5, false);

        gestorPedidos.anyadirPedido(pedido1);
        gestorPedidos.anyadirPedido(pedido2);
        gestorPedidos.anyadirPedido(pedido3);

        gestorPedidos.mostrarPedidos();

        System.out.println("Total pedido 2: " + gestorPedidos.calcularTotalPedido(2));
    }
}