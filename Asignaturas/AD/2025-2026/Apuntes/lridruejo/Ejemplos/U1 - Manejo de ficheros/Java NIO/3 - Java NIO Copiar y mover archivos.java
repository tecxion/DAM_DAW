import java.nio.file.*;
import java.io.IOException;

public class EjemploCopiarMover {
    
    public void copiarArchivo() throws IOException {
        Path origen = Paths.get("archivo_origen.txt");
        Path destino = Paths.get("archivo_copia.txt");
        
        // Copiar reemplazando si existe
        Files.copy(origen, destino, StandardCopyOption.REPLACE_EXISTING);
        
        // Copiar con atributos
        Files.copy(origen, destino, 
                  StandardCopyOption.COPY_ATTRIBUTES,
                  StandardCopyOption.REPLACE_EXISTING);
    }
    
    public void moverArchivo() throws IOException {
        Path origen = Paths.get("archivo_viejo.txt");
        Path destino = Paths.get("archivo_nuevo.txt");
        
        // Mover/renombrar archivo
        Files.move(origen, destino, StandardCopyOption.REPLACE_EXISTING);
        
        // Mover entre directorios
        Path origenDir = Paths.get("dir1/archivo.txt");
        Path destinoDir = Paths.get("dir2/archivo.txt");
        Files.move(origenDir, destinoDir);
    }
}