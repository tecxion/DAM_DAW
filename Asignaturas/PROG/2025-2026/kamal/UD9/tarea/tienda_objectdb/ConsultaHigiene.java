package tienda_objectdb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultaHigiene {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("src/tienda_objectdb/productos_tienda.odb");
            em = emf.createEntityManager();

            List<ProductoHigiene> higiene =
                    em.createQuery("SELECT p FROM ProductoHigieneTienda p", ProductoHigiene.class)
                      .getResultList();

            System.out.println("PRODUCTOS DE HIGIENE");
            System.out.println("--------------------------------");

            for (ProductoHigiene p : higiene) {
               p.mostrar();
            }

        } catch (Exception e) {
            System.out.println("Error al consultar productos de higiene: " + e.getMessage());
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