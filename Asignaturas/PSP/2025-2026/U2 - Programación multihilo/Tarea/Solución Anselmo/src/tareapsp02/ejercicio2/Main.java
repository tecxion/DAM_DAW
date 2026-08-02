package tareapsp02.ejercicio2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Alejandro Leal
 */
public class Main {

    public static void main(String[] args) {
        
        // número de operarios de carretilla en el escenario
        int carretilleros = 4;
        
        // número de carretillas en el escenario
        int carretillas = 3;
        
        // Lista que tiene los grupos de carretillas que puede usar cada
        // operario (se trata de una lista de listas)
        List<List<Integer>> listaCarretillas = new ArrayList<>();
        
        // lista con los identificadores de carretillas que puede usar el primer
        // operario
        List<Integer> carretillas_operario1 = new ArrayList<>();
            carretillas_operario1.add(1);
            
        // lista con los identificadores de carretillas que puede usar el segundo
        // operario
        List<Integer> carretillas_operario2 = new ArrayList<>();
            carretillas_operario2.add(1);
            carretillas_operario2.add(2);
            
        // lista con los identificadores de carretillas que puede usar el tercer
        // operario
        List<Integer> carretillas_operario3 = new ArrayList<>();
            carretillas_operario3.add(2);
            carretillas_operario3.add(3);
            
        // lista con los identificadores de carretillas que puede usar el cuarto
        // operario
        List<Integer> carretillas_operario4 = new ArrayList<>();
            carretillas_operario4.add(3);
            
        listaCarretillas.add(carretillas_operario1); // agregación de las listas
        listaCarretillas.add(carretillas_operario2); // de carretillas disponibles
        listaCarretillas.add(carretillas_operario3); // para cada uno de los
        listaCarretillas.add(carretillas_operario4); // carretilleros
        
        // lista que dispondrá de los semáforos que serán utilizados para los
        // recursos que deben ser administrados que, en este caso, son las
        // carretillas disponibles (3 unidades)
        List<Semaphore> semaforosDeCarretillas = new ArrayList<>();
        
        // creamos y almacenamos los semáforos que serán utilizados
        for(int i=0; i < carretillas; i++){
            semaforosDeCarretillas.add(new Semaphore(1));
        }
        
        // creación, y ejecución, de los hilos que competirán por los recursos
        // (carretillas) haciendo uso de los semáforos asociados a éstos
        for(int i = 1; i <= carretilleros; i++){
            (new Operario(i, listaCarretillas, semaforosDeCarretillas)).start();
        }   
    }
}