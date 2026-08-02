import java.nio.file.*;
import java.io.IOException;

public class UtilidadesNIO {
    
    public void crearEnlaceSimbolico() throws IOException {
        Path objetivo = Paths.get("archivo_original.txt");
        Path enlace = Paths.get("enlace_simbolico");
        
        Files.createSymbolicLink(enlace, objetivo);
    }
    
    public void verificarArchivosTemporales() throws IOException {
        // Crear archivo temporal
        Path tempFile = Files.createTempFile("prefijo", ".sufijo");
        Path tempDir = Files.createTempDirectory("temp_dir");
        
        // Configurar para eliminar al salir
        tempFile.toFile().deleteOnExit();
        tempDir.toFile().deleteOnExit();
    }
    
    public void obtenerSeparadores() {
        String separador = FileSystems.getDefault().getSeparator();
        System.out.println("Separador del sistema: " + separador);
        
        // Listar raíces del sistema de archivos
        for (Path root : FileSystems.getDefault().getRootDirectories()) {
            System.out.println("Raíz: " + root);
        }
    }
}