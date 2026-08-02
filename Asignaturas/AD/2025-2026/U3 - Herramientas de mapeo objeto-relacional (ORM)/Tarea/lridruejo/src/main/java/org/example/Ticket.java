package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "ticket", schema = "supermercadodb")
public class Ticket {

    // Atributos de la clase Ticket
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "codigo_ticket", nullable = false, length = 100)
    private String codigoTicket;

    @Column(name = "fecha")
    private LocalDate fecha;

    @Column(name = "ubicacion_tienda", length = 100)
    private String ubicacionTienda;

    // Getters y Setters
    public Integer getId() { return id; }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodigoTicket() {
        return codigoTicket;
    }

    public void setCodigoTicket(String codigoTicket) {
        this.codigoTicket = codigoTicket;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getUbicacionTienda() {
        return ubicacionTienda;
    }

    public void setUbicacionTienda(String ubicacionTienda) {
        this.ubicacionTienda = ubicacionTienda;
    }

}