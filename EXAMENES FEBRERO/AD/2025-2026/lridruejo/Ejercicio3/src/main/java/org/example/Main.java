package org.example;

import jakarta.persistence.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Para el ejercicio supongo que ya hay un EntityManager y una transacción activa
        // así que estas líneas no son necesarias
        // EntityManagerFactory emf = null;
        // EntityManager em = null;

        try {
            // Para el ejercicio supongo que ya hay un EntityManager y una transacción activa
            // así que estas líneas no son necesarias
            // emf = Persistence.createEntityManagerFactory("BibliotecaPU");
            // em = emf.createEntityManager();
            // em.getTransaction().begin();

            // A) CONSULTA (SELECT)
            listarLibrosCategoria(em, "Ciencia Ficción");

            // B) INSERCIÓN (INSERT)
            insertarAutorConLibro(em, "Isaac Asimov", "Fundación", "Ciencia Ficción");

            // C) MODIFICACIÓN (UPDATE)
            modificarCategoriaLibro(em, "Obra Maestra");

            em.getTransaction().commit();

        } catch (Exception e) {
            System.err.println("Error durante la ejecución de la aplicación");
            System.err.println(e.getClass().getName() + ": " + e.getMessage());

            // Rollback por seguridad
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

    // 1. Consultar todos los libros de una categoría
    public static void listarLibrosCategoria(EntityManager em, String categoria) {

        // Consulta para seleccionar todos los libros de esa categoría
        String jpql = "FROM Libro WHERE categoria = '" + categoria + "'";
        List<Libro> libros = em.createQuery(jpql, Libro.class).getResultList();

        if (libros.isEmpty()) {
            System.out.println("No hay libros de la categoria " + categoria);
        } else {
            // Iteración sobre cada libro de la lista
            for (Libro libro : libros) {
                System.out.println(libro.getTitulo());
            }
        }

        System.out.println();
    }

    // 2. Insertar un nuevo autor con un libro
    public static void insertarAutorConLibro(EntityManager em, String nombreAutor, String tituloLibro, String categoria) {
        Autor autor = new Autor();
        autor.setNombre(nombreAutor);
        em.persist(autor);

        Libro libro = new Libro();
        libro.setTitulo(tituloLibro);
        libro.setCategoria(categoria);
        libro.setAutor(autor);

        // Método helper para mantener consistencia
        autor.agregarLibro(libro);

        em.persist(libro);
    }

    // 3. Modificar categoría libro
    public static void modificarCategoriaLibro(EntityManager em, String nuevaCategoria) {
        Libro libro = em.find(Libro.class, 1);
        libro.setCategoria(nuevaCategoria);
        em.merge(libro);
        em.flush();
    }
}