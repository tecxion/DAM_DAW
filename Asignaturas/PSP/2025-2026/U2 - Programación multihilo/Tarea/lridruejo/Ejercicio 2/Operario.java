import java.util.List;

class Operario extends Thread {

    // Campos privados de la clase Operario
    /**
     * Identificador del operario
     */
    private final int id;

    /**
     * Lista de carretillas asignadas al operario
     */
    private final List<Carretilla> carretillasDisponibles;

    /**
     * Tiempo máximo de inactividad del operario en milisegundos
     */
    private final long maxTiempoInactividad;

    /**
     * Tiempo máximo de manipulación de una carretilla en milisegundos
     */
    private final long maxTiempoManipulacion;

    /**
     * Constructor parametrizado
     *
     * @param id                     Identificador del operario
     * @param carretillasDisponibles Lista de carretillas asignadas al operario
     * @param maxTiempoInactividad   Tiempo máximo de inactividad del operario en milisegundos
     * @param maxTiempoManipulacion  Tiempo máximo de manipulación de una carretilla en milisegundos
     */
    public Operario(int id, List<Carretilla> carretillasDisponibles, long maxTiempoInactividad, long maxTiempoManipulacion) {
        this.id = id;
        this.carretillasDisponibles = carretillasDisponibles;
        this.maxTiempoInactividad = maxTiempoInactividad;
        this.maxTiempoManipulacion = maxTiempoManipulacion;
    }

    /**
     * Método que codifica la lógica de ejecución del operario
     */
    @Override
    public void run() {
        // Ejecutar de forma indefinida hasta detención manual
        while (true) {
            try {
                Carretilla carretillaElegida;

                // Si solo hay una carretilla asignada al operario, elegir esa
                if (carretillasDisponibles.size() == 1) {
                    carretillaElegida = carretillasDisponibles.get(0);

                    // Si hay dos carretillas asignadas al operario
                } else {
                    // Elegir una carretilla al azar
                    carretillaElegida = carretillasDisponibles.get((int) (Math.random() * carretillasDisponibles.size()));
                }

                // Log de solicitud de uso de una carretilla
                System.out.println("[" + java.time.LocalDateTime.now() + "] Operario '" + id +
                        "' tiene necesidad de manipular una carretilla (puede usar: " + carretillasDisponibles + ") " +
                        "y solicita la unidad '" + carretillaElegida.getId() + "'.");

                // Usar la carretilla cuando esté libre
                // Como el semáforo es justo, nunca se va a quedar un operario esperando indefinidamente
                carretillaElegida.usar();

                synchronized (System.out) {
                    // Log de inicio de uso de una carretilla
                    System.out.println("[" + java.time.LocalDateTime.now() + "] Operario '" + id +
                            "' manipulando la carretilla '" + carretillaElegida.getId() + "'.");
                }

                // Tiempo de manipulación de la carretilla
                Thread.sleep((int) (Math.random() * maxTiempoManipulacion));

                // Liberar la carretilla al terminar de manipularla
                carretillaElegida.liberar();

                synchronized (System.out) {
                    // Log de liberación de la carretilla
                    System.out.println("[" + java.time.LocalDateTime.now() + "] Operario '" + id +
                            "' ha terminado de manipular la carretilla '" + carretillaElegida.getId() + "'.");
                }

                // Tiempo de inactividad entre usos de carretillas
                Thread.sleep((int) (Math.random() * maxTiempoInactividad));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }

}
