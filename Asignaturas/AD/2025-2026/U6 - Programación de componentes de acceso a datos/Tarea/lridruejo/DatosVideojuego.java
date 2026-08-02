public class DatosVideojuego {

    // Atributos
    private String titulo;
    private double precio;
    private int copiasDisponibles;

    // Constructor
    public DatosVideojuego(String titulo, double precio, int copiasDisponibles) {
        this.titulo = titulo;
        this.precio = precio;
        this.copiasDisponibles = copiasDisponibles;
    }

    // Getters y Setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCopiasDisponibles() {
        return copiasDisponibles;
    }

    public void setCopiasDisponibles(int copiasDisponibles) {
        this.copiasDisponibles = copiasDisponibles;
    }
}
