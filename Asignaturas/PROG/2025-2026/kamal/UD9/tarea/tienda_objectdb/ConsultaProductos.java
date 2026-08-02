package tienda_objectdb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultaProductos {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("src/tienda_objectdb/productos_tienda.odb");
            em = emf.createEntityManager();

            List<Producto> productos =
                    em.createQuery("SELECT p FROM ProductoTienda p", Producto.class)
                      .getResultList();

            System.out.println("LISTADO COMPLETO DE PRODUCTOS");
            System.out.println("--------------------------------");

            for (Producto p : productos) {
                System.out.println(p.mostrarInformacion());
            }

        } catch (Exception e) {
            System.out.println("Error al consultar productos: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (em != null && em.isOpen()) {
                em.close();
            }
            if (emf != null && emf.isOpen()) {
                emf.close();
            }
        }
    }
}