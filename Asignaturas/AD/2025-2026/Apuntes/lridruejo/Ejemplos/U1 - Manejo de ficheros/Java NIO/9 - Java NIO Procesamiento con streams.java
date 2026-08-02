import java.nio.file.*;
import java.io.IOException;
import java.util.stream.Stream;
import java.util.List;
import java.util.stream.Collectors;

public class EjemploStreamsNIO {
    
    public void procesarArchivosParalelo() throws IOException {
        Path directorio = Paths.get("src");
        
        // Procesamiento paralelo de archivos
        try (Stream<Path> stream = Files.walk(directorio)) {
            List<Path> archivosJava = stream
                .parallel()
                .filter(Files::isRegularFile)
                .filter(path -> path.toString().endsWith(".java"))
                .filter(path -> {
                    try {
                        return Files.size(path) > 1000; // Mayor a 1KB
                    } catch (IOException e) {
                        return false;
                    }
                })
                .collect(Collectors.toList());
        }
    }
}