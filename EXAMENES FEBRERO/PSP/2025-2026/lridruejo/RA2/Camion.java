import java.util.concurrent.CountDownLatch;

class Camion {
    private final int CAPACIDAD = 6;
    private static int numCamion = 1;
    private int vehiculos;

    Camion() {
        vehiculos = 0;
    }

    int getNumCamion() {
        return numCamion;
    }

    boolean estaIncompleto() {
        return vehiculos < CAPACIDAD;
    }

    synchronized void almacenar(int id) {
        while (vehiculos == CAPACIDAD) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        vehiculos++;
        System.out.println("El hilo (cadena de montaje " + id +
                ") almacena en el camión número: " + numCamion);
        notifyAll();
    }

    synchronized void renovarCamiones(CountDownLatch latch) {
        while (vehiculos < CAPACIDAD) {
            try {
                // Comprobar si las cadenas de montaje han terminado
                if (latch.getCount() == 0) {
                    return;
                }
                // Esperar si las cadenas de montaje no han terminado y el camión no está lleno
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("El camión número " + numCamion + " ya está completo.");
        vehiculos = 0;
        numCamion++;
        notifyAll();
    }
}
