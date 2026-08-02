package tutorial;
import javax.persistence.*;
import java.util.*;
public class ConsultaPuntos {
    public static void main(String[] args) {
        // Open a database connection
        // (create a new database if it doesn't exist yet):
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory(
                "$objectdb/db/p2.odb");
        EntityManager em = emf.createEntityManager();

    

        // Find the number of Point objects in the database:
        Query q1 = em.createQuery("SELECT COUNT(p) FROM Point p");
        System.out.println("Total Points: " + q1.getSingleResult());

        // Find the average X value:
        Query q2 = em.createQuery("SELECT AVG(p.x) FROM Point p");
        System.out.println("Average X: " + q2.getSingleResult());
        
        // Find the average Y value:
        Query q3 = em.createQuery("SELECT AVG(p.y) FROM Point p");
        System.out.println("Average Y: " + q3.getSingleResult());
        
        // Retrieve all the Point objects from the database:
        TypedQuery<Point> query =
            em.createQuery("SELECT p FROM Point p", Point.class);
        List<Point> results = query.getResultList();
        for (Point p : results) {
            System.out.println(p);
           
        }
        
        // Close the database connection:
        em.close();
        emf.close();
    }
}