import java.io.File;
import java.io.FilenameFilter;

/**
 * Ejemplo de uso de FilenameFilter para filtrar archivos por extensión
 */
public class EjemploFiltroArchivos {
    
    // Clase interna que implementa FilenameFilter
    static class FiltroExtension implements FilenameFilter {
        private String extension;
        
        public FiltroExtension(String extension) {
            this.extension = extension.toLowerCase();
        }
        
        @Override
        public boolean accept(File dir, String name) {
            return name.toLowerCase().endsWith(extension);
        }
    }
    
    public static void main(String[] args) {
        try {
            // Directorio a listar
            File directorio = new File(".");
            
            // Filtrar archivos .txt
            String[] archivosTxt = directorio.list(new FiltroExtension(".txt"));
            
            System.out.println("Archivos .txt encontrados:");
            if (archivosTxt != null && archivosTxt.length > 0) {
                for (String archivo : archivosTxt) {
                    System.out.println(" - " + archivo);
                }
            } else {
                System.out.println("No se encontraron archivos .txt");
            }
            
            // Filtrar archivos .java
            String[] archivosJava = directorio.list(new FiltroExtension(".java"));
            
            System.out.println("\nArchivos .java encontrados:");
            if (archivosJava != null && archivosJava.length > 0) {
                for (String archivo : archivosJava) {
                    System.out.println(" - " + archivo);
                }
            } else {
                System.out.println("No se encontraron archivos .java");
            }
            
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}