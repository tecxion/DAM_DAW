class Camion extends Thread {

    // Campos privados de la clase Camion
    /**
     * Identificador del camión
     */
    private final String nombre;

    /**
     * Hangar al que está asociado el camión
     */
    private final Hangar hangar;

    /**
     * Tiempo máximo entre recogidas del camión en milisegundos
     */
    private final long maxTiempoRecogida;

    /**
     * Número máximo de intentos de recogida del camión
     */
    private final int maxIntentos;

    /**
     * Constructor parametrizado
     * @param nombre Identificador del camión
     * @param hangar Hangar al que está asociado el camión
     * @param maxTiempoRecogida Tiempo máximo entre recogidas del camión en milisegundos
     * @param maxIntentos Número máximo de intentos de recogida del camión
     */
    Camion(String nombre, Hangar hangar, long maxTiempoRecogida, int maxIntentos) {
        this.nombre = nombre;
        this.hangar = hangar;
        this.maxTiempoRecogida = maxTiempoRecogida;
        this.maxIntentos = maxIntentos;
    }

    /**
     * Método que codifica la lógica de ejecución del camión (hilo consumidor)
     */
    @Override
    public void run() {
        int intentosFallidos = 0;

        // Bucle FOR para las iteraciones porque en los logs de ejemplo pone que se usa bucle FOR en vez de WHILE
        // Solo se cuentan las iteraciones exitosas
        for (int iteracion = 1; intentosFallidos < maxIntentos;) {
            try {
                // El camión retira de forma exitosa un elemento del hangar
                if (hangar.retirar()) {
                    // Log de iteración exitosa del camión
                    System.out.println("[" + java.time.LocalDateTime.now() + "] - En iteración '" + iteracion +
                            "' del bucle FOR del camión '" + nombre +
                            "' se ha procedido con éxito a invocar al método 'retirar' del hangar asociado.");
                    System.out.println("------------------------------------------------------------------------");

                    // Resetear los intentos fallidos consecutivos
                    intentosFallidos = 0;

                    // Aumentar el número de iteraciones exitosas
                    iteracion++;

                    // Tiempo de espera aleatorio entre recogidas
                    Thread.sleep((long) (Math.random() * (maxTiempoRecogida + 1)));

                // Si el camión no consigue retirar de forma exitosa un elemento del hangar, sumar un intento fallido
                } else {
                    intentosFallidos++;
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                break;
            }
        }

        // Se muestra el log de máximo número de intentos fallidos alcanzados
        if (intentosFallidos >= maxIntentos) {
            System.out.println("[" + java.time.LocalDateTime.now() + "] - Tras " + maxIntentos +
                    " intentos infructuosos de retirar elementos de la zona de carga/descarga del hangar '" +
                    hangar.getNombre() + "' se abandona la tarea.");
            System.out.println("------------------------------------------------------------------------");
        }
    }

}
