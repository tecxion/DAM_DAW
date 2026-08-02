import java.util.ArrayList;
import java.util.List;

class Hangar {

    // Campos privados de la clase Hangar
    /**
     * Identificador del hangar
     */
    private final String nombre;

    /**
     * Capacidad máxima del hangar
     */
    private final int capacidadMax;

    /**
     * Elementos almacenados en el hangar
     * Lo mejor sería usar una cola (interfaz Queue con la implementación LinkedList) para aplicar el principio FIFO
     * Pero cumpliría el requisito de usar arrays o la interfaz java.util.List
     */
    private final List<Integer> elementosAlmacenados = new ArrayList<>();

    /**
     * Tiempo máximo de espera del camión en milisegundos
     */
    private final long maxTiempoEsperaCamion;

    /**
     * Constructor parametrizado
     * @param nombre Identificador del hangar
     * @param capacidadMax Capacidad máxima del hangar
     * @param maxTiempoEsperaCamion Tiempo máximo de espera del camión en milisegundos
     */
    Hangar(String nombre, int capacidadMax, long maxTiempoEsperaCamion) {
        this.nombre = nombre;
        this.capacidadMax = capacidadMax;
        this.maxTiempoEsperaCamion = maxTiempoEsperaCamion;
    }

    // Getters y Setters para encapsulación
    public String getNombre() {
        return nombre;
    }

    public int getNumElementosAlmacenados() {
        return elementosAlmacenados.size();
    }

    /**
     * Método synchronized para almacenar un elemento
     * @param elemento Número entero aleatorio producido por la fábrica
     */
    public synchronized void almacenar(int elemento) throws InterruptedException {
        // Si el hangar está lleno, la fábrica espera hasta que el camión retire un elemento y haya espacio disponible
        if (elementosAlmacenados.size() >= capacidadMax) {
            wait();
        }

        // Almacenar el elemento al final de la lista
        elementosAlmacenados.add(elemento);

        // Log de almacenamiento
        System.out.println("[" + java.time.LocalDateTime.now() + "] - Se acaba de almacenar un item (elemento: '" +
                elemento + "') en la zona de carga/descarga del hangar '" + nombre + "'.");
        System.out.println("------------------------------------------------------------------------");

        // Notificar al camión de que el hangar tiene elementos disponibles
        notifyAll();
    }

    /**
     * Método synchronized para retirar un elemento
     * @return
     * @throws InterruptedException
     */
    public synchronized boolean retirar() throws InterruptedException {
        // Si el hangar está vacío, el camión espera hasta que se almacena un elemento o un tiempo máximo
        if (elementosAlmacenados.isEmpty()) {
            wait(maxTiempoEsperaCamion);
            // Si el hangar sigue vacío después del tiempo de espera máximo del camión, considerar intento fallido
            if (elementosAlmacenados.isEmpty()) {
                return false;
            }
        }

        // Guardar el elemento que se va a retirar para el log
        int elemento = elementosAlmacenados.get(0);

        // Retirar el primer elemento de la lista
        elementosAlmacenados.remove(0);

        // Log de retirada
        System.out.println("[" + java.time.LocalDateTime.now() + "] - Se acaba de retirar un item (elemento: '" +
                elemento + "') de la zona de carga/descarga del hangar '" + nombre + "'.");

        // Notificar a la fábrica de que el hangar tiene espacio disponible
        notifyAll();

        // El camión ha retirado un elemento con éxito
        return true;
    }

}
