import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Ejemplo de lectura y escritura de archivos de texto con buffers
 */
public class EjemploFlujosCaracteres {
    
    public static void leerArchivo(String nombreArchivo) {
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            int numeroLinea = 1;
            
            System.out.println("Contenido del archivo " + nombreArchivo + ":");
            System.out.println("=========================================");
            
            // Leer línea por línea
            while ((linea = br.readLine()) != null) {
                System.out.println(numeroLinea + ": " + linea);
                numeroLinea++;
            }
            
        } catch (IOException e) {
            System.err.println("Error al leer archivo: " + e.getMessage());
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar archivo: " + e.getMessage());
            }
        }
    }
    
    public static void escribirArchivo(String nombreArchivo, String contenido) {
        BufferedWriter bw = null;
        
        try {
            bw = new BufferedWriter(new FileWriter(nombreArchivo));
            bw.write(contenido);
            System.out.println("Archivo escrito correctamente: " + nombreArchivo);
            
        } catch (IOException e) {
            System.err.println("Error al escribir archivo: " + e.getMessage());
        } finally {
            try {
                if (bw != null) bw.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar archivo: " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        // Escribir en un archivo
        String contenido = "Línea 1: Hola Mundo\nLínea 2: Este es un ejemplo\nLínea 3: De escritura de archivos";
        escribirArchivo("ejemplo.txt", contenido);
        
        // Leer el archivo creado
        leerArchivo("ejemplo.txt");
    }
}