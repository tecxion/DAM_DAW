import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.io.IOException;

/**
 * Ejemplo de copia y movimiento de archivos
 */
public class EjemploFilesCopiaMovimiento {
    
    public static void main(String[] args) {
        try {
            // Definir rutas
            Path origen = Paths.get("C:/Users/usuario/origen.txt");
            Path destinoCopia = Paths.get("C:/Users/usuario/copia.txt");
            Path destinoMovimiento = Paths.get("C:/Users/usuario/movido.txt");
            
            // Crear archivo de origen si no existe
            if (!Files.exists(origen)) {
                Files.createFile(origen);
                Files.writeString(origen, "Contenido de prueba");
            }
            
            // Copiar archivo
            Files.copy(origen, destinoCopia, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo copiado de " + origen + " a " + destinoCopia);
            
            // Mover/renombrar archivo
            Files.move(destinoCopia, destinoMovimiento, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Archivo movido de " + destinoCopia + " a " + destinoMovimiento);
            
        } catch (IOException e) {
            System.err.println("Error en operaciones de copia/movimiento: " + e.getMessage());
        }
    }
}