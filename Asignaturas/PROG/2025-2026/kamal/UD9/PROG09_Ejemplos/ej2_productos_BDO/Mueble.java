package ej2_productos_BDO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
	
	@Entity
	public class Mueble {
	    @Id @GeneratedValue
	    private long id;
	    private String nombre;
	    private double precio;
	    private String material;
	    private String color;
	
	    public Mueble() {
	    }
	
	    public Mueble( String nombre, double precio, String material, String color) {
	        
	        this.nombre = nombre;
	        this.precio = precio;
	        this.material = material;
	        this.color = color;
	    }
	
	    public long getId() { return id; }
	    public String getNombre() { return nombre; }
	    public double getPrecio() { return precio; }
	    public String getMaterial() { return material; }
	    public String getColor() { return color; }
	
	    public void setPrecio(double precio) { this.precio = precio; }
	    
	    
	    @Override
	    public String toString() {
	        return id + " - " + nombre + " (" + precio + ")";
	    }
	}