import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        long maxTiempoInactividad = 500; // Tiempo máximo de inactividad de los operarios en milisegundos
        long maxTiempoManipulacion = 300; // Tiempo máximo de manipulación de una carretilla en milisegundos

        // Crear las carretillas
        Carretilla carretilla1 = new Carretilla(1);
        Carretilla carretilla2 = new Carretilla(2);
        Carretilla carretilla3 = new Carretilla(3);

        // Asignar las carretillas a los operarios
        List<Carretilla> carretillasOp1 = new ArrayList<>();
        carretillasOp1.add(carretilla1);
        List<Carretilla> carretillasOp2 = new ArrayList<>();
        carretillasOp2.add(carretilla1);
        carretillasOp2.add(carretilla2);
        List<Carretilla> carretillasOp3 = new ArrayList<>();
        carretillasOp3.add(carretilla2);
        carretillasOp3.add(carretilla3);
        List<Carretilla> carretillasOp4 = new ArrayList<>();
        carretillasOp4.add(carretilla3);

        // Crear los operarios
        Operario operario1 = new Operario(1, carretillasOp1, maxTiempoInactividad, maxTiempoManipulacion);
        Operario operario2 = new Operario(2, carretillasOp2, maxTiempoInactividad, maxTiempoManipulacion);
        Operario operario3 = new Operario(3, carretillasOp3, maxTiempoInactividad, maxTiempoManipulacion);
        Operario operario4 = new Operario(4, carretillasOp4, maxTiempoInactividad, maxTiempoManipulacion);

        // Iniciar la ejecución de los hilos
        operario1.start();
        operario2.start();
        operario3.start();
        operario4.start();
    }

}
