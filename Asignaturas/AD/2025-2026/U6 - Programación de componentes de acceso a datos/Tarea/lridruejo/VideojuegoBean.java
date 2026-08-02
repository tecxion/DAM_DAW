import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class VideojuegoBean implements Serializable {

    // Propiedades del Bean (estado actual)
    private String titulo;
    private double precio;
    private int copiasDisponibles;

    // Lista para almacenar los videojuegos
    private final List<DatosVideojuego> listaVideojuegos;

    // Índice para navegar por la lista
    private int indiceActual;

    // Constructor sin argumentos
    public VideojuegoBean() {
        // Inicializar la lista
        listaVideojuegos = new ArrayList<>();
        indiceActual = 0;

        // Cargar datos
        cargarDatosSimulados();

        // Establecer las propiedades del Bean con los datos del primer videojuego si la lista no está vacía
        if (!listaVideojuegos.isEmpty()) {
            actualizarPropiedades(listaVideojuegos.getFirst());
        }
    }

    // Constructor que inicializa las propiedades con un videojuego
    public VideojuegoBean(DatosVideojuego videojuego) {
        // Inicializar la lista vacía
        listaVideojuegos = new ArrayList<>();
        indiceActual = 0;

        // Añadir el videojuego a la lista y actualizar las propiedades del Bean
        listaVideojuegos.add(videojuego);

        // Actualizar las propiedades del Bean
        actualizarPropiedades(listaVideojuegos.getFirst());
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

    // Método que simula la carga de datos
    private void cargarDatosSimulados() {
        listaVideojuegos.add(new DatosVideojuego("The Legend of Zelda", 49.99, 12));
        listaVideojuegos.add(new DatosVideojuego("Red Dead Redemption 2", 34.99, 10));
        listaVideojuegos.add(new DatosVideojuego("Hollow Knight", 54.99, 15));
        listaVideojuegos.add(new DatosVideojuego("Elden Ring", 69.99, 20));
    }

    // Método que actualiza las propiedades del Bean con un videojuego
    private void actualizarPropiedades(DatosVideojuego datosVideojuego) {
        titulo = datosVideojuego.getTitulo();
        precio = datosVideojuego.getPrecio();
        copiasDisponibles = datosVideojuego.getCopiasDisponibles();
    }

    // Métodos de navegación
    public void siguienteJuego() {
        // Si no hay videojuegos
        if (listaVideojuegos.isEmpty()) {
            System.out.println("No hay videojuegos en el catálogo.");
            return;
        }

        // Si el videojuego actual es el último
        if (indiceActual == listaVideojuegos.size() - 1) {
            System.out.println("Ya estás en el último videojuego del catálogo.");
            return;
        }

        // Si el videojuego actual no es el último
        // Aumentar el índice
        indiceActual++;

        // Actualizar las propiedades del Bean
        actualizarPropiedades(listaVideojuegos.get(indiceActual));

    }

    public void anteriorJuego() {
        // Si no hay videojuegos
        if (listaVideojuegos.isEmpty()) {
            System.out.println("No hay videojuegos en el catálogo.");
            return;
        }

        // Si el videojuego actual es el primero
        if (indiceActual == 0) {
            System.out.println("Ya estás en el primer videojuego del catálogo.");
            return;
        }

        // Si el videojuego actual no es el primero
        // Reducir el índice
        indiceActual--;

        // Actualizar las propiedades del Bean
        actualizarPropiedades(listaVideojuegos.get(indiceActual));

    }
}
