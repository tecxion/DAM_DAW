package tienda_objectdb;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("HIGIENE")
public class ProductoHigiene extends Producto {

    private boolean usoProfesional;

    public ProductoHigiene() {
    }

    public ProductoHigiene(String nombre, double precio, boolean usoProfesional) {
        super(nombre, precio);
        this.usoProfesional = usoProfesional;
    }

    public boolean isUsoProfesional() {
        return usoProfesional;
    }

    public void setUsoProfesional(boolean usoProfesional) {
        this.usoProfesional = usoProfesional;
    }

    @Override
    public double calcularPrecioFinal() {
        if (usoProfesional) {
            return precio * 1.15;
        }
        return precio;
    }

    @Override
    public String toString() {
        return "ProductoHigiene { " +
                "id=" + getId() +
                ", nombre='" + nombre + '\'' +
                ", precio base=" + String.format("%.2f", precio) +
                ", usoProfesional=" + usoProfesional +
                ", precio final=" + String.format("%.2f", calcularPrecioFinal()) +
                " }";
    }
}