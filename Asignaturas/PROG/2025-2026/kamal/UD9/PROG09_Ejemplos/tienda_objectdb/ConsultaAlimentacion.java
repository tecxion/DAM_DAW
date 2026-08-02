package tienda_objectdb;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ConsultaAlimentacion {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("$objectdb/db/productos_tienda.odb");
            em = emf.createEntityManager();

            List<ProductoAlimentacion> alimentos =
                    em.createQuery("SELECT p FROM ProductoAlimentacion p", ProductoAlimentacion.class)
                      .getResultList();

            System.out.println("PRODUCTOS DE ALIMENTACIÓN");
            System.out.println("--------------------------------");

            for (ProductoAlimentacion p : alimentos) {
                System.out.println(p);
            }

        } catch (Exception e) {
            System.out.println("Error al consultar productos de alimentación: " + e.getMessage());
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