package ej2_productos_BDO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/mueblesPU.odb");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Mueble m1 = new Mueble( "Silla nórdica", 129.99, "Madera de roble", "Blanco");
        em.persist(m1);
        Mueble m2 = new Mueble("Mesa auxiliar", 89.50, "Madera de haya", "Natural");
        em.persist(m2);
        
        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}