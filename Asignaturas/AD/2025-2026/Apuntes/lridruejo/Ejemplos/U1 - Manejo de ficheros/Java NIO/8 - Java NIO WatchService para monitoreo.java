import java.nio.file.*;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class EjemploWatchService {
    
    public void monitorearDirectorio() throws IOException, InterruptedException {
        Path directorio = Paths.get(".");
        WatchService watchService = FileSystems.getDefault().newWatchService();
        
        // Registrar para eventos
        directorio.register(watchService, 
            StandardWatchEventKinds.ENTRY_CREATE,
            StandardWatchEventKinds.ENTRY_DELETE,
            StandardWatchEventKinds.ENTRY_MODIFY);
        
        // Procesar eventos
        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                WatchEvent.Kind<?> kind = event.kind();
                Path filename = (Path) event.context();
                
                System.out.println("Evento: " + kind + " - " + filename);
            }
            key.reset();
        }
    }
}