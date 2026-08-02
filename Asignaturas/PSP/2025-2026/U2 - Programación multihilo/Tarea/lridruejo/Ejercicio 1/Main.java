import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int produccionFabrica = 20; // Cantidad de elementos a producir por la fábrica
        int capacidadHangar = produccionFabrica / 2; // Capacidad máxima de cada hangar
        int maxValorElementosFabrica = 499; // Valor máximo de los elementos producidos por la fábrica
        long maxTiempoProduccionFabrica = 99; // Tiempo máximo entre producciones de la fábrica en milisegundos
        long maxTiempoRecogidaCamion = 99; // Tiempo máximo entre recogidas de cada camión en milisegundos
        long maxTiempoEsperaCamion = maxTiempoProduccionFabrica * 5; // Tiempo máximo de espera de cada camión antes de considerar intento fallido en milisegundos
        int maxIntentosCamion = 5; // Número máximo de intentos fallidos de recogida de cada camión

        // Crear los hangares
        Hangar hangar1 = new Hangar("UNO", capacidadHangar, maxTiempoEsperaCamion);
        Hangar hangar2 = new Hangar("DOS", capacidadHangar, maxTiempoEsperaCamion);
        List<Hangar> hangares = new ArrayList<>();
        hangares.add(hangar1);
        hangares.add(hangar2);

        // Crear la fábrica (hilo productor)
        Fabrica fabrica = new Fabrica(produccionFabrica, maxValorElementosFabrica, maxTiempoProduccionFabrica, hangares);

        // Crear los camiones (hilos consumidores)
        Camion camion1 = new Camion("UNO", hangar1, maxTiempoRecogidaCamion, maxIntentosCamion); // camion1 asociado a hangar1
        Camion camion2 = new Camion("DOS", hangar2, maxTiempoRecogidaCamion, maxIntentosCamion); // camion2 asociado a hangar2

        // Notificar inicio de ejecución con marca temporal
        System.out.println("Tras haber sido creados los objetos (una fábrica y dos hangares con sus correspondientes " +
                "camiones), se inicia la ejecución de los hilos [" + java.time.LocalTime.now() + "]");

        // Iniciar ejecución de los hilos
        fabrica.start(); // Hilo productor que fabrica los elementos y los almacena en los hangares
        camion1.start(); // Hilo consumidor que recoge los elementos del hangar1
        camion2.start(); // Hilo consumidor que recoge los elementos del hangar2
    }
}
