import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.Iterator;

/**
 * Ejemplo de uso de FileSystem para obtener información del sistema de archivos
 */
public class EjemploFileSystem {
    
    public static void main(String[] args) {
        // Obtener el sistema de archivos por defecto
        FileSystem sistemaFicheros = FileSystems.getDefault();
        
        // Obtener las raíces del sistema de archivos
        System.out.println("Raíces del sistema de archivos:");
        Iterable<Path> raices = sistemaFicheros.getRootDirectories();
        for (Path raiz : raices) {
            System.out.println(" - " + raiz);
        }
        
        // Trabajar con un path específico
        Path rutaFichero = sistemaFicheros.getPath("C:/Users/usuario/ejemplo.txt");
        System.out.println("\nInformación del path:");
        System.out.println("Nombre del archivo: " + rutaFichero.getFileName());
        System.out.println("Directorio padre: " + rutaFichero.getParent());
        
        // Iterar sobre los elementos del path
        System.out.println("\nElementos del path:");
        Iterator<Path> iterador = rutaFichero.iterator();
        while (iterador.hasNext()) {
            System.out.println(" - " + iterador.next());
        }
        
        // Separador del sistema
        System.out.println("\nSeparador del sistema: '" + sistemaFicheros.getSeparator() + "'");
    }
}