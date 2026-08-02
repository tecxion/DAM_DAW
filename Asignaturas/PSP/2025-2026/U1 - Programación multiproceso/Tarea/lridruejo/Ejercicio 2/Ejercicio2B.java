import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ejercicio2B {

    public static void main(String[] args) {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String cadena;
        Process proceso;

        try {
            // Pedir cadena por teclado
            System.out.println("Escribe una cadena:");
            cadena = br.readLine();

            // Ejecutar el programa Ejercicio2A 3 veces con la cadena como argumento
            for (int i = 1; i < 4; i++) {
                System.out.println("Proceso " + i);

                // Crear el proceso con la cadena como argumento
                proceso = Runtime.getRuntime().exec("java Ejercicio2A " + cadena);

                // Leer la salida del proceso
                InputStreamReader isrProceso = new InputStreamReader(proceso.getInputStream());
                BufferedReader brProceso = new BufferedReader(isrProceso);
                String linea;

                // Mostrar por pantalla la salida del proceso
                while ((linea = brProceso.readLine()) != null) {
                    System.out.println(linea);
                }

                brProceso.close();
            }

            System.out.println("Ya se han creado todos los procesos.");

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}