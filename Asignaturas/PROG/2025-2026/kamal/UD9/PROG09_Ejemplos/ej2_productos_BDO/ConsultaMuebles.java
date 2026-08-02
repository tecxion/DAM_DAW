package ej2_productos_BDO;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.util.List;

public class ConsultaMuebles {
    public static void main(String[] args) {
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/mueblesPU.odb");
        EntityManager em = emf.createEntityManager();

        List<Mueble> muebles =
            em.createQuery("SELECT m FROM Mueble m", Mueble.class).getResultList();

        for (Mueble m : muebles) {
        		System.out.println(m);
        }

        em.close();
        emf.close();
    }
}