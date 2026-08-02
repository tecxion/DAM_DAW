import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.stream.Stream;

/**
 * Ejemplo de recorrido y listado de directorios
 */
public class EjemploFilesRecorridoDirectorios {
    
    public static void main(String[] args) {
        Path directorio = Paths.get("C:/Users/usuario");
        
        try {
            // Listar contenido del directorio
            System.out.println("Contenido del directorio " + directorio + ":");
            try (Stream<Path> stream = Files.list(directorio)) {
                stream.forEach(path -> {
                    try {
                        String tipo = Files.isDirectory(path) ? "DIR" : "ARCHIVO";
                        System.out.println(tipo + " - " + path.getFileName() + 
                                         " (" + Files.size(path) + " bytes)");
                    } catch (IOException e) {
                        System.err.println("Error al obtener información de: " + path);
                    }
                });
            }
            
            // Recorrer recursivamente (incluyendo subdirectorios)
            System.out.println("\nRecorrido recursivo:");
            try (Stream<Path> stream = Files.walk(directorio, 3)) { // Profundidad máxima 3
                stream.forEach(path -> {
                    int profundidad = directorio.relativize(path).getNameCount();
                    String sangria = "  ".repeat(profundidad);
                    String tipo = Files.isDirectory(path) ? "📁" : "📄";
                    System.out.println(sangria + tipo + " " + path.getFileName());
                });
            }
            
        } catch (IOException e) {
            System.err.println("Error al recorrer directorio: " + e.getMessage());
        }
    }
}