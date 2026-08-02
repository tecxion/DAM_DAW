import java.util.concurrent.Semaphore;

class Carretilla {
    // Campos privados de la clase Carretilla
    /**
     * Identificador de la carretilla
     */
    private final int id;

    /**
     * Semáforo de la carretilla para gestionar el acceso de los operarios a ella
     * Solo 1 operario puede tener acceso a la carretilla cada vez
     */
    private final Semaphore semaforo = new Semaphore(1, true);

    /**
     * Constructor parametrizado
     * @param id Identificador de la carretilla
     */
    public Carretilla(int id) {
        this.id = id;
    }

    // Getters y Setters para encapsulación
    public int getId() {
        return id;
    }

    // Bloquea la carretilla mientras el operario la usa
    // Si no está disponible, el operario espera a que lo esté
    public void usar() throws InterruptedException {
        semaforo.acquire();
    }

    // Libera la carretilla
    public void liberar() throws InterruptedException {
        semaforo.release();
    }

    // Sobrecarga del método toString para los logs
    @Override
    public String toString() {
        return String.valueOf(id);
    }

}
