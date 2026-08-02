// Clase que representa una cadena de montaje (hilo productor)

import java.util.concurrent.CountDownLatch;

class CadenaMontaje extends Thread {
    private int id;
    private final int PRODUCCION_MAX = 5;
    Camion camion;
    CountDownLatch latch;

    CadenaMontaje(int id, Camion camion, CountDownLatch latch) {
        this.id = id;
        this.camion = camion;
        this.latch = latch;
    }

    @Override
    public void run() {
        int vehiculosProducidos = 0;

        while (vehiculosProducidos < PRODUCCION_MAX) {
            camion.almacenar(id);
            vehiculosProducidos++;
        }

        latch.countDown();
    }
}
