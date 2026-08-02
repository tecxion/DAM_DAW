import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Ejemplo básico de uso de la interfaz Path
 * Muestra cómo crear objetos Path y obtener información sobre rutas
 */
public class EjemploPathBasico {
    
    public static void main(String[] args) {
        // Crear objetos Path usando Paths.get()
        Path pathAbsoluto = Paths.get("C:/Users/usuario/documents/archivo.txt");
        Path pathRelativo = Paths.get("documents/archivo.txt");
        
        // Obtener información del Path
        System.out.println("Path absoluto: " + pathAbsoluto);
        System.out.println("¿Es absoluto? " + pathAbsoluto.isAbsolute());
        System.out.println("Nombre del archivo: " + pathAbsoluto.getFileName());
        System.out.println("Directorio padre: " + pathAbsoluto.getParent());
        System.out.println("Número de elementos: " + pathAbsoluto.getNameCount());
        
        // Trabajar con Path relativo
        System.out.println("\nPath relativo: " + pathRelativo);
        System.out.println("¿Es absoluto? " + pathRelativo.isAbsolute());
        
        // Convertir a ruta absoluta
        Path pathAbsolutoDesdeRelativo = pathRelativo.toAbsolutePath();
        System.out.println("Convertido a absoluto: " + pathAbsolutoDesdeRelativo);
    }
}