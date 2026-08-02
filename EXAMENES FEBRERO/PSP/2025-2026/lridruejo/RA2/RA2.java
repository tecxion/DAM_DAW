import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class RA2 {
    private static Camion camion = new Camion();
    private static CountDownLatch latch = new CountDownLatch(3);

    public static void main(String[] args) {
        // Hilos productores
        List<CadenaMontaje> fabrica = new ArrayList<CadenaMontaje>();
        CadenaMontaje cadena1 = new CadenaMontaje(1, camion, latch);
        CadenaMontaje cadena2 = new CadenaMontaje(2, camion, latch);
        CadenaMontaje cadena3 = new CadenaMontaje(3, camion, latch);
        fabrica.add(cadena1);
        fabrica.add(cadena2);
        fabrica.add(cadena3);

        // Hilo consumidor (renovación camiones)
        Thread renovadorCamion = new Thread(() -> {
            while (latch.getCount() > 0) {
                try {
                    camion.renovarCamiones(latch);
                } catch (Exception e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        renovadorCamion.start();

        for (CadenaMontaje cadena : fabrica) {
            cadena.start();
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        if (camion.estaIncompleto()) {
            System.out.println("El camión " + camion.getNumCamion() + " está incompleto.");
        }


    }
}
