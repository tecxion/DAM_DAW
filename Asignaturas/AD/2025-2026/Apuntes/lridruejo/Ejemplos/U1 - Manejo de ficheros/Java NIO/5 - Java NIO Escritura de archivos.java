import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class EjemploEscritura {
    
    public void escribirContenido() throws IOException {
        Path archivo = Paths.get("salida.txt");
        
        // Escribir bytes
        byte[] datos = "Hola Mundo".getBytes(StandardCharsets.UTF_8);
        Files.write(archivo, datos);
        
        // Escribir líneas de texto
        List<String> lineas = Arrays.asList("Línea 1", "Línea 2", "Línea 3");
        Files.write(archivo, lineas, StandardCharsets.UTF_8);
        
        // Añadir al final del archivo
        Files.write(archivo, 
                   Arrays.asList("Línea adicional"),
                   StandardCharsets.UTF_8,
                   StandardOpenOption.APPEND);
    }
    
    public void escribirConBufferedWriter() throws IOException {
        Path archivo = Paths.get("salida.txt");
        
        try (var writer = Files.newBufferedWriter(archivo, 
                StandardCharsets.UTF_8, 
                StandardOpenOption.CREATE,
                StandardOpenOption.TRUNCATE_EXISTING)) {
            
            writer.write("Línea 1");
            writer.newLine();
            writer.write("Línea 2");
            writer.write(" - continuación");
        }
    }
}