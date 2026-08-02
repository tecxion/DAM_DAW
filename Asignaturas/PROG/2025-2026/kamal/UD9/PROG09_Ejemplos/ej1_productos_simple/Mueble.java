package ej1_productos_simple;
public class Mueble extends Producto {
    private String material;
    private String color;

    public Mueble(String codigo, String nombre, double precio, String material, String color) {
        super(codigo, nombre, precio);
        this.material = material;
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public String getColor() {
        return color;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Material: " + material);
        System.out.println("Color: " + color);
    }
}
