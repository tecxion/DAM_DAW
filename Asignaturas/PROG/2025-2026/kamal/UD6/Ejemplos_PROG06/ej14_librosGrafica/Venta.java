package ej14_librosGrafica;

import java.io.Serializable;
import java.util.ArrayList;

public class Venta implements Serializable {

	private Libro libro;
	private Cliente cliente;
	private String fecha;
	private int cantidad;
	
	public Venta(Libro l, Cliente c, String f, int cant) {
		this.libro = l;
		this.cliente = c;
		this.fecha = f;
		this.cantidad = cant;
	}
	
	public Libro getLibro() {
		return libro;
	}
	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		double total = this.libro.getPrecio() * this.cantidad;
		sb.append("\n************************");
		sb.append("\nCliente: ");
		sb.append(this.cliente);
		sb.append("\nLibro: ");
		sb.append(this.libro);
		sb.append("\nFecha: ");
		sb.append(this.fecha);
		sb.append("\nCantidad: ");
		sb.append(this.cantidad);
		sb.append("\nTotal: ");
		sb.append(total);
		sb.append("\n************************");
		
		return sb.toString();
	}
	
	
	
	
}
