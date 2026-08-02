package org.example;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "autor", schema = "bibliotecadb")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    // Relación inversa
    @OneToMany(mappedBy = "autor", fetch = FetchType.LAZY)
    private List<Libro> libros = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Libro> getLibros() { return libros; }

    public void setLibros(List<Libro> libros) { this.libros = libros; }

    // Método helper para mantener la consistencia bidireccional
    public void agregarLibro(Libro libro) {
        libros.add(libro);
        libro.setAutor(this);
    }

    public void quitarLibro(Libro libro) {
        libros.remove(libro);
        libro.setAutor(null);
    }

}