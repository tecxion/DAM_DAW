import java.nio.file.Path;
import java.nio.file.Paths;

public class EjemploPath {
    
    public void operacionesPath() {
        // Crear Paths de diferentes formas
        Path pathRelativo = Paths.get("archivo.txt");
        Path pathCompleto = Paths.get("directorio", "subdir", "archivo.java");
        Path pathAbsoluto = Paths.get("/home/usuario/documents/config.xml");
        
        // Operaciones comunes con Path
        System.out.println("Nombre archivo: " + pathRelativo.getFileName());
        System.out.println("Directorio padre: " + pathRelativo.getParent());
        System.out.println("Es absoluto: " + pathRelativo.isAbsolute());
        
        // Resolver paths
        Path base = Paths.get("/base/directorio");
        Path relativo = Paths.get("subdir/archivo.txt");
        Path resuelto = base.resolve(relativo);
        
        // Normalizar paths
        Path complejo = Paths.get("./.././dir/../archivo.txt");
        Path normalizado = complejo.normalize();
    }
}