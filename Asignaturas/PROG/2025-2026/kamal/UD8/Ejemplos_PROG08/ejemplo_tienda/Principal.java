package ejemplo_tienda_mio;

import java.util.Scanner;


public class Principal {

	   public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        Tienda tienda = new Tienda();
	        final String ENTRADA = "src/ejemplo_tienda_mio/productos.txt"; 
	        final String SALIDA = "src/ejemplo_tienda_mio/carrito.txt";
	        //Desde un método
	        //cargarProductosIniciales(tienda);
	        //Desde el fichero de productos
	        Fichero.leerFichero(ENTRADA, tienda);
	        // Opción 1: cargar desde MariaDB
	       CargadorBD.cargarDesdeMariaDB(tienda);
	        
	        int opcion;
	        do {
	            mostrarMenu();
	            opcion = leerEntero(sc, "Seleccione una opción: ");

	            switch (opcion) {
	                case 1:
	                    tienda.mostrarProductosDisponibles();
	                    break;

	                case 2:
	                    anadirProductoAlCarrito(sc, tienda);
	                    break;

	                case 3:
	                    tienda.mostrarCarrito();
	                    break;

	                case 4:
	                    System.out.println("\nResumen final del pedido:");
	                    tienda.mostrarCarrito();
	                    System.out.println("Gracias por su compra.");
	                    Fichero.escribirFichero(SALIDA, tienda);
	                    break;

	                default:
	                    System.out.println("Opción incorrecta.");
	            }

	        } while (opcion != 4);

	        sc.close();
	    }

	    public static void mostrarMenu() {
	        System.out.println("\nMENÚ TIENDA");
	        System.out.println("1. Mostrar productos disponibles");
	        System.out.println("2. Añadir producto al carrito");
	        System.out.println("3. Ver carrito y total");
	        System.out.println("4. Finalizar pedido");
	    }

	    public static void cargarProductosIniciales(Tienda tienda) {
	        tienda.agregarProductoCatalogo(new ProductoAlimentacion("manzana", 0.50, 2));
	        tienda.agregarProductoCatalogo(new ProductoAlimentacion("leche", 1.20, 5));
	        tienda.agregarProductoCatalogo(new ProductoAlimentacion("pan", 1.00, 1));

	        tienda.agregarProductoCatalogo(new ProductoHigiene("jabon", 2.50, false));
	        tienda.agregarProductoCatalogo(new ProductoHigiene("champu", 3.75, false));
	        tienda.agregarProductoCatalogo(new ProductoHigiene("detergente", 5.00, true));
	    }

	    public static void anadirProductoAlCarrito(Scanner sc, Tienda tienda) {
	        System.out.print("Nombre del producto: ");
	        String nombre = sc.nextLine().trim();

	        Producto p = tienda.buscarProducto(nombre);
	        if (p == null) {
	            System.out.println("Error: el producto no existe.");
	            return;
	        }

	        int cantidad = leerEntero(sc, "Cantidad: ");
	        if (cantidad <= 0) {
	            System.out.println("Error: la cantidad debe ser un entero positivo.");
	            return;
	        }

	        if (tienda.anadirAlCarrito(nombre, cantidad)) {
	            System.out.println("Producto añadido al carrito.");
	        } else {
	            System.out.println("No se pudo añadir el producto al carrito.");
	        }
	    }

	    public static int leerEntero(Scanner sc, String mensaje) {
	        while (true) {
	            System.out.print(mensaje);
	            try {
	                return Integer.parseInt(sc.nextLine().trim());
	            } catch (NumberFormatException e) {
	                System.out.println("Error: debe introducir un número entero válido.");
	            }
	        }
	    }

}
