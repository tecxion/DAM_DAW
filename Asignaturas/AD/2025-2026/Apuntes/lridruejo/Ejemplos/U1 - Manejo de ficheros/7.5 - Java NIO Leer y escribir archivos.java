import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.IOException;
import java.util.List;

/**
 * Ejemplo de lectura y escritura de archivos usando métodos de Files
 */
public class EjemploFilesLecturaEscritura {
    
    public static void main(String[] args) {
        try {
            Path archivo = Paths.get("C:/Users/usuario/datos.txt");
            
            // Escribir en archivo (sobrescribe si existe)
            String contenido = "Línea 1\nLínea 2\nLínea 3";
            Files.writeString(archivo, contenido, StandardOpenOption.CREATE, 
                            StandardOpenOption.TRUNCATE_EXISTING);
            System.out.println("Archivo escrito: " + archivo);
            
            // Leer todo el contenido como String
            String contenidoLeido = Files.readString(archivo);
            System.out.println("Contenido leído:\n" + contenidoLeido);
            
            // Leer como lista de líneas
            List<String> lineas = Files.readAllLines(archivo);
            System.out.println("Líneas leídas:");
            for (int i = 0; i < lineas.size(); i++) {
                System.out.println((i + 1) + ": " + lineas.get(i));
            }
            
            // Añadir contenido al final del archivo
            String contenidoAdicional = "\nLínea adicional";
            Files.writeString(archivo, contenidoAdicional, StandardOpenOption.APPEND);
            System.out.println("Contenido adicional añadido");
            
        } catch (IOException e) {
            System.err.println("Error en operaciones de lectura/escritura: " + e.getMessage());
        }
    }
}