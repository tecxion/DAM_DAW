import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Ejemplo de verificación de existencia y permisos usando la clase Files
 */
public class EjemploFilesVerificacion {
    
    public static void main(String[] args) {
        Path path = Paths.get("C:/Users/usuario/ejemplo.txt");
        
        // Verificar existencia y permisos
        System.out.println("Path: " + path);
        System.out.println("¿Existe? " + Files.exists(path));
        System.out.println("¿Se puede leer? " + Files.isReadable(path));
        System.out.println("¿Se puede escribir? " + Files.isWritable(path));
        System.out.println("¿Se puede ejecutar? " + Files.isExecutable(path));
        System.out.println("¿Es un directorio? " + Files.isDirectory(path));
        System.out.println("¿Es un archivo regular? " + Files.isRegularFile(path));
        
        try {
            // Obtener más propiedades si el archivo existe
            if (Files.exists(path)) {
                System.out.println("Tamaño: " + Files.size(path) + " bytes");
                System.out.println("Última modificación: " + Files.getLastModifiedTime(path));
                System.out.println("Propietario: " + Files.getOwner(path));
            }
        } catch (Exception e) {
            System.err.println("Error al obtener propiedades: " + e.getMessage());
        }
    }
}