package org.example;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "proveedor", schema = "supermercadodb")
public class Proveedor {

    // Atributos de la clase Proveedor
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "nombre", nullable = false, length = 100)
    private String nombre;

    @Column(name = "pais_origen", length = 50)
    private String paisOrigen;

    @Column(name = "presupuesto_anual", precision = 15, scale = 2)
    private BigDecimal presupuestoAnual;

    // Getters y Setters
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

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public BigDecimal getPresupuestoAnual() {
        return presupuestoAnual;
    }

    public void setPresupuestoAnual(BigDecimal presupuestoAnual) {
        this.presupuestoAnual = presupuestoAnual;
    }

}