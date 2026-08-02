import java.io.File;
import java.io.IOException;

/**
 * Crear y eliminar ficheros y directorios
 */
public class UtilidadesFicheros {
    
    /**
     * Crea un fichero nuevo
     */
    public static boolean crearFichero(String ruta) {
        try {
            File fichero = new File(ruta);
            if (fichero.createNewFile()) {
                System.out.println("Fichero creado: " + fichero.getAbsolutePath());
                return true;
            } else {
                System.out.println("El fichero ya existe o no se pudo crear");
                return false;
            }
        } catch (IOException e) {
            System.err.println("Error al crear el fichero: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Elimina un fichero
     */
    public static boolean eliminarFichero(String ruta) {
        File fichero = new File(ruta);
        if (fichero.exists() && fichero.delete()) {
            System.out.println("Fichero eliminado: " + ruta);
            return true;
        } else {
            System.out.println("No se pudo eliminar el fichero: " + ruta);
            return false;
        }
    }
    
    /**
     * Crea un directorio
     */
    public static boolean crearDirectorio(String ruta) {
        File directorio = new File(ruta);
        if (directorio.mkdir()) {
            System.out.println("Directorio creado: " + directorio.getAbsolutePath());
            return true;
        } else {
            System.out.println("No se pudo crear el directorio: " + ruta);
            return false;
        }
    }
    
    /**
     * Crea directorios anidados (mkdirs)
     */
    public static boolean crearDirectoriosAnidados(String ruta) {
        File directorios = new File(ruta);
        if (directorios.mkdirs()) {
            System.out.println("Directorios creados: " + directorios.getAbsolutePath());
            return true;
        } else {
            System.out.println("No se pudieron crear los directorios: " + ruta);
            return false;
        }
    }
    
    public static void main(String[] args) {
        // Ejemplos de uso
        crearFichero("test_fichero.txt");
        crearDirectorio("directorio_simple");
        crearDirectoriosAnidados("dir1/dir2/dir3");
        
        // Listar contenido
        File actual = new File(".");
        System.out.println("\nContenido actual:");
        for (String elemento : actual.list()) {
            System.out.println(" - " + elemento);
        }
        
        // Limpieza
        eliminarFichero("test_fichero.txt");
    }
}