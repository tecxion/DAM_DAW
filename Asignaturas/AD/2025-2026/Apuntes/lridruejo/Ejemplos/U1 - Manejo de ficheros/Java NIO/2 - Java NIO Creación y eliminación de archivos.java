import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class EjemploCreacionArchivos {
    
    public void crearArchivosYDirectorios() throws IOException {
        // Crear directorios
        Path directorio = Paths.get("mi_directorio");
        Files.createDirectories(directorio);
        
        // Crear archivo
        Path archivo = directorio.resolve("datos.txt");
        Files.createFile(archivo);
        
        // Crear estructura de directorios anidados
        Path estructuraCompleta = Paths.get("dir1/dir2/dir3");
        Files.createDirectories(estructuraCompleta);
    }
    
    public void eliminarArchivos() throws IOException {
        Path archivo = Paths.get("mi_directorio/datos.txt");
        
        // Eliminar si existe
        Files.deleteIfExists(archivo);
        
        // Eliminar directorio (debe estar vacío)
        Path directorio = Paths.get("mi_directorio");
        Files.deleteIfExists(directorio);
    }
}