import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

/**
 * Ejemplo de creación y eliminación de archivos y directorios
 */
public class EjemploFilesCreacionEliminacion {
    
    public static void main(String[] args) {
        try {
            // Crear un directorio
            Path directorio = Paths.get("C:/Users/usuario/mi_directorio");
            if (!Files.exists(directorio)) {
                Files.createDirectory(directorio);
                System.out.println("Directorio creado: " + directorio);
            }
            
            // Crear directorios anidados
            Path directoriosAnidados = Paths.get("C:/Users/usuario/dir1/dir2/dir3");
            Files.createDirectories(directoriosAnidados);
            System.out.println("Directorios anidados creados: " + directoriosAnidados);
            
            // Crear un archivo
            Path archivo = directorio.resolve("mi_archivo.txt");
            if (!Files.exists(archivo)) {
                Files.createFile(archivo);
                System.out.println("Archivo creado: " + archivo);
            }
            
            // Eliminar archivo
            Files.deleteIfExists(archivo);
            System.out.println("Archivo eliminado (si existía): " + archivo);
            
        } catch (IOException e) {
            System.err.println("Error en operaciones de archivo: " + e.getMessage());
        }
    }
}