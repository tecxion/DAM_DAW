import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Stream;

public class EjemploRecorridoDirectorios {
    
    public void listarDirectorio() throws IOException {
        Path directorio = Paths.get(".");
        
        // Listar contenido simple
        try (Stream<Path> stream = Files.list(directorio)) {
            stream.filter(Files::isRegularFile)
                  .map(Path::getFileName)
                  .forEach(System.out::println);
        }
    }
    
    public void recorridoRecursivo() throws IOException {
        Path directorioBase = Paths.get(".");
        
        // Recorrer recursivamente
        try (Stream<Path> stream = Files.walk(directorioBase)) {
            stream.filter(Files::isRegularFile)
                  .filter(path -> path.toString().endsWith(".java"))
                  .forEach(System.out::println);
        }
    }
    
    public void buscarArchivos() throws IOException {
        Path directorioBase = Paths.get(".");
        
        // Buscar con criterios específicos
        try (Stream<Path> stream = Files.find(directorioBase, 
                Integer.MAX_VALUE, 
                (path, attrs) -> 
                    attrs.isRegularFile() && 
                    attrs.size() > 1024 && 
                    path.toString().endsWith(".txt"))) {
            
            stream.forEach(path -> 
                System.out.println(path + " - " + attrs.size() + " bytes"));
        }
    }
}