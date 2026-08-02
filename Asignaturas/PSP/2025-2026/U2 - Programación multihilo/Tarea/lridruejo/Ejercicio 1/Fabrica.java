import java.util.List;

class Fabrica extends Thread {

    // Campos privados de la clase Fabrica
    /**
     * Lista de hangares en los que la fábrica (hilo productor) almacena los elementos que genera
     */
    private final List<Hangar> hangares;

    /**
     * Cantidad de elementos que produce la fábrica
     */
    private final int produccion;

    /**
     * Valor máximo de los elementos producidos por la fábrica
     */
    private final int maxValorElementos;

    /**
     * Tiempo máximo entre producciones de la fábrica en milisegundos
     */
    private final long maxTiempoProduccion;

    /**
     * Constructor parametrizado
     * @param produccion Cantidad de elementos que produce la fábrica
     * @param hangares Lista de hangares en los que la fábrica almacena su producción
     */
    Fabrica(int produccion, int maxValorElementos, long maxTiempoProduccion, List<Hangar> hangares) {
        this.produccion = produccion;
        this.maxValorElementos = maxValorElementos;
        this.maxTiempoProduccion = maxTiempoProduccion;
        this.hangares = hangares;
    }

    /**
     * Método que codifica la lógica de ejecución de la fábrica (hilo productor)
     */
    @Override
    public void run() {
        for (int i = 0; i < produccion; i++) {
            try {
                // Producir el elemento
                int elemento = (int) (Math.random() * (maxValorElementos + 1)); // Número entero aleatorio entre 0 y maxValorElementos

                // Si el hangar 1 tiene menos elementos, almacenar en el hangar 1
                if (hangares.get(0).getNumElementosAlmacenados() < hangares.get(1).getNumElementosAlmacenados()) {
                    hangares.get(0).almacenar(elemento);

                // Si el hangar 2 tiene menos elementos, almacenar en el hangar 2
                } else if (hangares.get(0).getNumElementosAlmacenados() > hangares.get(1).getNumElementosAlmacenados()) {
                    hangares.get(1).almacenar(elemento);

                // Si los dos hangares tienen el mismo número de elementos, almacenar en un hangar de forma aleatoria
                } else {
                    System.out.println("[" + java.time.LocalDateTime.now() + "] - Se va a decidir al azar en qué hangar almacenar");
                    int numHangar = (int) (Math.random() * hangares.size());
                    hangares.get(numHangar).almacenar(elemento);
                }

                // Tiempo de espera aleatorio entre producciones
                Thread.sleep((long) (Math.random() * (maxTiempoProduccion + 1)));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}
