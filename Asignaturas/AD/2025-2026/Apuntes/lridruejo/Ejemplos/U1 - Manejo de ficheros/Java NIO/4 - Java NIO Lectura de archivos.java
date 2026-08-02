import java.nio.file.*;
import java.nio.charset.StandardCharsets;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class EjemploLectura {
    
    public void leerTodoElContenido() throws IOException {
        Path archivo = Paths.get("datos.txt");
        
        // Leer todos los bytes
        byte[] bytes = Files.readAllBytes(archivo);
        String contenido = new String(bytes, StandardCharsets.UTF_8);
        
        // Leer todas las líneas
        List<String> lineas = Files.readAllLines(archivo, StandardCharsets.UTF_8);
        
        // Leer con Stream (eficiente para archivos grandes)
        try (Stream<String> stream = Files.lines(archivo, StandardCharsets.UTF_8)) {
            stream.filter(linea -> linea.contains("importante"))
                  .forEach(System.out::println);
        }
    }
    
    public void leerConBufferedReader() throws IOException {
        Path archivo = Paths.get("datos.txt");
        
        try (var reader = Files.newBufferedReader(archivo, StandardCharsets.UTF_8)) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
        }
    }
}