package tienda_objectdb;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainProductos {

    public static void main(String[] args) {
        EntityManagerFactory emf = null;
        EntityManager em = null;

        try {
            emf = Persistence.createEntityManagerFactory("$objectdb/db/productos_tienda.odb");
            em = emf.createEntityManager();

            em.getTransaction().begin();

            em.persist(new ProductoAlimentacion("manzana", 0.50, 2));
            em.persist(new ProductoAlimentacion("leche", 1.20, 5));
            em.persist(new ProductoAlimentacion("pan", 1.00, 1));

            em.persist(new ProductoHigiene("jabon", 2.50, false));
            em.persist(new ProductoHigiene("champu", 3.75, false));
            em.persist(new ProductoHigiene("detergente", 5.00, true));

            em.getTransaction().commit();

            System.out.println("Productos guardados correctamente en ObjectDB.");

        } catch (Exception e) {
            System.out.println("Error al guardar productos: " + e.getMessage());
            e.printStackTrace();
            if (em != null && em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
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