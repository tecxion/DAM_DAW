package tienda_objectdb;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class Principal {

	   public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        Tienda tienda = new Tienda();
	        
	        
	        
	        final String SALIDA = "src/tienda_objectdb/carrito.txt";
	   
	        
	        EntityManagerFactory emf =
	                Persistence.createEntityManagerFactory("src/tienda_objectdb/productos_tienda.odb");
	            EntityManager em = emf.createEntityManager();


	          	    List<Producto> lista =
	        	        em.createQuery("SELECT p FROM ProductoTienda p", Producto.class)
	        	          .getResultList();

	        	    for (Producto p : lista) {
	                    tienda.agregarProductoCatalogo(p);
	                }
	        	   

	        	    System.out.println("Productos cargados desde la base de datos.");
	        	
	           
	            
	            // Mostramos los poducutos cargados
	            tienda.mostrarProductosDisponibles();

	         
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
	                	 modificarProducto(sc, tienda, em);
	                     break;
	                case 5:
	                	eliminarProducto(sc, tienda, em);
	                    break;
	                case 6:
	                    System.out.println("\nResumen final del pedido:");
	                    tienda.mostrarCarrito();
	                    System.out.println("Gracias por su compra.");
	                    Fichero.escribirFichero(SALIDA, tienda);
	                    break;

	                default:
	                    System.out.println("Opción incorrecta.");
	            }

	        } while (opcion != 6);
	        em.close();
            emf.close();
	        sc.close();
	    }

	    public static void mostrarMenu() {
	        System.out.println("\nMENÚ TIENDA");
	        System.out.println("1. Mostrar productos disponibles");
	        System.out.println("2. Añadir producto al carrito");
	        System.out.println("3. Ver carrito y total");
	        System.out.println("4. Modificar el precio de un producto");
	        System.out.println("5. Eliminar un producto");
	        System.out.println("6. Finalizar pedido");
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

	    public static void modificarProducto(Scanner sc, Tienda tienda, EntityManager em) {
	        System.out.print("Nombre del producto a modificar: ");
	        String nombre = sc.nextLine().trim();

	        double nuevoPrecio;
	        while (true) {
	            System.out.print("Nuevo precio: ");
	            try {
	                nuevoPrecio = Double.parseDouble(sc.nextLine().trim());
	                if (nuevoPrecio < 0) {
	                    System.out.println("El precio no puede ser negativo.");
	                    continue;
	                }
	                break;
	            } catch (NumberFormatException e) {
	                System.out.println("Introduce un número válido.");
	            }
	        }

	        if (tienda.modificarPrecio(em, nombre, nuevoPrecio)) {
	            System.out.println("Producto modificado correctamente.");
	        } else {
	            System.out.println("No se pudo modificar el producto.");
	        }
	    }
	    
	    public static void eliminarProducto(Scanner sc, Tienda tienda, EntityManager em) {
	        System.out.print("Nombre del producto a eliminar: ");
	        String nombre = sc.nextLine().trim();

	        if (tienda.eliminarProducto(em, nombre)) {
	            System.out.println("Producto eliminado correctamente.");
	        } else {
	            System.out.println("No se pudo eliminar el producto.");
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
