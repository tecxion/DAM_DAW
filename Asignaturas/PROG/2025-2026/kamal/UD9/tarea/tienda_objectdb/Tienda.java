package tienda_objectdb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;



public class Tienda {

	private HashMap<String, Producto> productos;
	private ArrayList<LineaCarrito> carrito;
	
	public Tienda() {
        productos = new HashMap<>();
        carrito = new ArrayList<>();
    }
	
	public ArrayList<LineaCarrito> getCarrito(){
		return new ArrayList<>(carrito);
		
	}
	//este método modifica el precio de un producto por nombre, en la base de datos y en el HashMap
	public boolean modificarPrecio(EntityManager em, String nombreProducto, double nuevoPrecio) {
	    if (nombreProducto == null || nombreProducto.trim().isEmpty() || nuevoPrecio < 0) {
	        return false;
	    }

	    String clave = nombreProducto.trim().toLowerCase();

	    em.getTransaction().begin();
	    try {
	        Producto p = em.createQuery(
	                "SELECT p FROM ProductoTienda p WHERE LOWER(p.nombre) = :nombre",
	                Producto.class)
	            .setParameter("nombre", clave)
	            .getResultStream()
	            .findFirst()
	            .orElse(null);

	        if (p == null) {
	            em.getTransaction().rollback();
	            return false;
	        }

	        p.setPrecio(nuevoPrecio);

	        em.getTransaction().commit();

	        productos.put(p.getNombre().toLowerCase(), p);
	        return true;

	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        e.printStackTrace();
	        return false;
	    }
	}
	
	//Este método elimina un producto por nombre, en la base de datos y en el HashMap
	public boolean eliminarProducto(EntityManager em, String nombreProducto) {
	    if (nombreProducto == null || nombreProducto.trim().isEmpty()) {
	        return false;
	    }

	    String clave = nombreProducto.trim().toLowerCase();

	    em.getTransaction().begin();
	    try {
	        Producto p = em.createQuery(
	                "SELECT p FROM ProductoTienda p WHERE LOWER(p.nombre) = :nombre",
	                Producto.class)
	            .setParameter("nombre", clave)
	            .getResultStream()
	            .findFirst()
	            .orElse(null);

	        if (p == null) {
	            em.getTransaction().rollback();
	            return false;
	        }

	        em.remove(p);
	        em.getTransaction().commit();

	        productos.remove(clave);
	        return true;

	    } catch (Exception e) {
	        if (em.getTransaction().isActive()) {
	            em.getTransaction().rollback();
	        }
	        e.printStackTrace();
	        return false;
	    }
	}
	
	
	boolean agregarProductoCatalogo(Producto p) {
		if(p == null) {
			return false;
		}
		String nombre = p.getNombre();
        if (nombre == null || nombre.trim().isEmpty()) {
            return false;
        }
        String clave = nombre.trim().toLowerCase();
		if(productos.containsKey(clave)) {
			System.out.println("El producto ya existe, no se puede añadir");
			return false;
		}
		 


	     productos.put(clave, p);
	     return true;
		
	}
	void mostrarProductosDisponibles() {
		if (productos.isEmpty()) {
            System.out.println("No hay productos en el catálogo.");
            return;
        }

        System.out.println("\nProductos disponibles:");
        for (Producto p : productos.values()) {
            System.out.println("- " + p.mostrarInformacion());
        	 // p.mostrar();
        }

	}
	Producto buscarProducto(String nombre) {
		if (nombre == null || nombre.trim().isEmpty()) {
            return null;
        }

        return productos.get(nombre.trim().toLowerCase());
	}
	
	boolean anadirAlCarrito(String nombreProducto, int cantidad) {
		if (cantidad <= 0) {
            return false;
        }

        Producto p = buscarProducto(nombreProducto);
        if (p == null) {
            return false;
        }
        boolean encontrado = false;
        
        //Si el producto ya existe en el carrito, no creamos una nueva línea, incrementamos la cantidad
        for(LineaCarrito lc : carrito)
        	if(lc.getProducto().getNombre().equalsIgnoreCase(nombreProducto)) {
        		encontrado = true;
        		lc.setCantidad(lc.getCantidad() + cantidad);
        	}
        if(!encontrado)
        	carrito.add(new LineaCarrito(p, cantidad));
        return true;
	}
	
	void mostrarCarrito() {
		if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }

        System.out.println("\nCarrito:");
        for (LineaCarrito linea : carrito) {
            System.out.println("- " + linea.mostrarLinea());
        }

        System.out.println("Total de la compra: " + String.format("%.2f", calcularTotalPedido()));
	}
	double calcularTotalPedido() {
		double total = 0.0;

        for (LineaCarrito linea : carrito) {
            total += linea.calcularSubtotal();
        }

        return total;
	}

}
