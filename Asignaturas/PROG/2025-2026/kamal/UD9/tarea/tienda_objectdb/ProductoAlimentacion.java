package tienda_objectdb;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity(name = "ProductoAlimentacionTienda")
@DiscriminatorValue("ALIMENTACION")
public class ProductoAlimentacion extends Producto {

    private int caducidad;

    public ProductoAlimentacion() {
    }

    public ProductoAlimentacion(String nombre, double precio, int caducidad) {
        super(nombre, precio);
        this.caducidad = caducidad;
    }

    public int getCaducidad() {
        return caducidad;
    }

    public void setCaducidad(int caducidad) {
        this.caducidad = caducidad;
    }

    @Override
    public double calcularPrecioFinal() {
        if (caducidad <= 3) {
            return precio * 0.9;
        }
        return precio;
    }
   

    @Override
	public String mostrarInformacion() {
		StringBuilder sb = new StringBuilder();
		sb.append("Producto de alimentación. ");
		sb.append(" Nombre: "+nombre);
		sb.append(" Precio base: " + String.format("%.2f", precio)); 
		sb.append(" Cadudidad en días: " + caducidad);
		sb.append(" Precio: "+ String.format("%.2f",calcularPrecioFinal()));
		return sb.toString();
		
	}

	public void mostrar(){
		System.out.println(mostrarInformacion());
	}
}