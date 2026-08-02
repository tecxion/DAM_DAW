package tareapsp02.ejercicio2;

import java.util.List;
import java.util.concurrent.Semaphore;

/**
 *
 * @author Alejandro Leal
 */
public class Operario extends Thread {
    
    /**
     * identificador del operario
     */
    private int posicion;
    
    /**
     * lista que contiene las carretillas que cada operario puede solicitar
     */
    private List<List<Integer>> listaCarretillas;
    
    /**
     * lista que contienen los semáforos asociados a cada carretilla
     */
    private List<Semaphore> semaforoCarretillas;
    
    /**
     * 
     * @param posicion identificador del operario
     * @param listaCarretillas  lista que contiene las carretillas que cada 
     *                          operario puede solicitar 
     * @param semaforoCarretillas   lista que contienen los semáforos asociados a 
     *                              cada carretilla
     */
    public Operario(int posicion, List<List<Integer>> listaCarretillas, List<Semaphore> semaforoCarretillas){
        this.posicion = posicion;
        this.listaCarretillas = listaCarretillas;
        this.semaforoCarretillas = semaforoCarretillas;
    }
    
    /**
     * lógica asociada a la ejecución del hilo
     */
    @Override
    public void run() {

        while (true) {          // bucle infinito
            
            inactividad();      // invocación de método en el cual no se compite
                                // por un recurso compartido
            
            utilizaCarretilla();// invocación de método que simula la solicitud,
                                // y uso, de un recurso compartido
        }
    }

    /**
     * operación realizada por el hilo en la cual se simula inactividad que, en
     * este caso, significa ausencia de necesidad de solicitar (y utilizar)
     * un recurso compartido
     */
    private void inactividad() {
        try {
            sleep(1+(int) (500*Math.random())); // se duerme el hilo durante un 
                                                // tiempo indeterminado entre 0
                                                // y 0,5 segundos para simular
                                                // que no tiene necesidad de
                                                // utilizar algún recurso
        } catch (InterruptedException ex) { // se notifica por la salida estándar
                                            // de la excepción ocurrida
            System.out.println("[" + java.time.LocalDateTime.now() + "] "
                    + "Excepción: " + ex.getMessage());
        }
    }

    /**
     * este método realiza las operaciones de solicitud (y uso) por parte de los
     * operarios de los recursos limitados (carretillas) mediante el uso de 
     * semáforos
     */
    private void utilizaCarretilla() {
        
        int carretillaUtilizada = -1;   // identificar de carretilla que
                                        // solicitará el operario
        try {
            // lista de carretillas entre las cuales es susceptible de ser
            // solicitada, mediante el uso de semáforo, una de ellas por parte
            // del operario
            List<Integer> misCarretillas = listaCarretillas.get(posicion-1);
            
            if(misCarretillas.size()==1){   // caso en el que los operarios
                                            // solo disponen de acceso a un
                                            // posible carretilla
                carretillaUtilizada = misCarretillas.get(0)-1;
               
                // solicitud enviada al semáforo de la única opción de carretilla
                // elegible
                semaforoCarretillas.get(carretillaUtilizada).acquire();
                
                // se informa a través de la salida estándar
                System.out.println("[" + java.time.LocalDateTime.now() + "] "
                    + "Operario '" + posicion + "' tiene necesidad de "
                    + "manipular una carretilla (puede usar: " + 
                    listaCarretillas.get(posicion-1) + ") y solicita la "
                    + "unidad '" + (carretillaUtilizada+1) + "'.");
            }else{  // caso en el que los operarios disponen de acceso a más de
                    // una posible carretilla
                
                // se decide al azar qué carretilla, entre las 2 opciones
                // posibles, será solicitada
                carretillaUtilizada = misCarretillas.get((int) (2*Math.random()))-1;
                
                // solicitud enviada al semáforo de la carretilla elegida al azar
                semaforoCarretillas.get(carretillaUtilizada).acquire();
                
                // se informa a través de la salida estándar
                System.out.println("[" + java.time.LocalDateTime.now() + "] "
                    + "Operario '" + posicion + "' tiene necesidad de "
                    + "manipular una carretilla (puede usar: " + 
                    listaCarretillas.get(posicion-1) + ") y solicita la "
                    + "unidad '" + (carretillaUtilizada+1) + "'.");
            }
        } catch (InterruptedException ex) { // se notifica por la salida estándar
                                            // de la excepción ocurrida
            System.out.println("[" + java.time.LocalDateTime.now() + "] "
                    + "Excepción: " + ex.getMessage());
        }
        
        // se informa a través de la salida estándar
        System.out.println("[" + java.time.LocalDateTime.now() + "] Operario '" + posicion + "' manipulando la "
                + "carretilla '" + (carretillaUtilizada + 1) + "'.");
        
        try {
           sleep(1+(int) (300*Math.random()));  // se duerme el hilo durante un 
                                                // tiempo indeterminado entre 0
                                                // y 0,3 segundos para simular
                                                // que está haciendo uso del 
                                                // recurso solicitado y asignado
        } catch (InterruptedException ex) { // se notifica por la salida estándar
                                            // de la excepción ocurrida
            System.out.println("[" + java.time.LocalDateTime.now() + "] "
                    + "Excepción: " + ex.getMessage());
        }
        
        //se notifica por la salida estándar que el operario ha terminado de
        // manipular la carretilla
        System.out.println("[" + java.time.LocalDateTime.now() + "] Operario '" + posicion + "' ha terminado de "
                + "manipular la carretilla '" + (carretillaUtilizada + 1) + "'.");

        semaforoCarretillas.get(carretillaUtilizada).release(); // liberación de
                                            // la carretilla asignada al operario
                                            // hasta el momento actual
    }
}