package ej14_librosGrafica;

import java.io.Serializable;

public class Cliente implements Serializable{

	private String dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private String telefono;
	
	
	// constructor con parámetros
	public Cliente(String dni, String n, String a, String d, String t) {
		this.dni = dni;
		this.nombre = n;
		this.apellidos = a;
		this.direccion = d;
		this.telefono = t;
	}
	//constructor vacío
	public Cliente(){
				
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}			
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(); 
		sb.append("\n************************");
		sb.append("\nDNI: ");
		sb.append(this.dni);
		sb.append("\nNombre: ");
		sb.append(this.nombre);
		sb.append("\nApellidos: ");
		sb.append(this.apellidos);
		sb.append("\nDirección: ");
		sb.append(this.direccion);
		sb.append("\nTeléfono: ");
		sb.append(this.telefono);
		 sb.append("\n************************");
		return sb.toString();
	}
	
}
