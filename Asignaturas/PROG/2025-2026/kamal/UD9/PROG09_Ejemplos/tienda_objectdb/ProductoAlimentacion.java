package tienda_objectdb;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
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
    public String toString() {
        return "ProductoAlimentacion { " +
                "id=" + getId() +
                ", nombre='" + nombre + '\'' +
                ", precio base=" + String.format("%.2f", precio) +
                ", caducidad=" + caducidad +
                ", precio final=" + String.format("%.2f", calcularPrecioFinal()) +
                " }";
    }
}