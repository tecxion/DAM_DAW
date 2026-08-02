import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * Ejemplo de uso de la clase File para operaciones básicas con ficheros y directorios
 */
public class EjemploClaseFile {
    
    public static void main(String[] args) {
        try {
            // Crear un objeto File
            File directorio = new File("mi_directorio");
            File archivo = new File(directorio, "mi_archivo.txt");
            
            // Crear directorio
            if (directorio.mkdir()) {
                System.out.println("Directorio creado: " + directorio.getAbsolutePath());
            }
            
            // Crear archivo
            if (archivo.createNewFile()) {
                System.out.println("Archivo creado: " + archivo.getName());
            }
            
            // Verificar existencia
            System.out.println("¿Existe el archivo? " + archivo.exists());
            System.out.println("¿Es un directorio? " + archivo.isDirectory());
            System.out.println("¿Es un archivo? " + archivo.isFile());
            
            // Obtener información
            System.out.println("Nombre: " + archivo.getName());
            System.out.println("Ruta absoluta: " + archivo.getAbsolutePath());
            System.out.println("Tamaño: " + archivo.length() + " bytes");
            
            // Establecer fecha de modificación
            archivo.setLastModified(new Date().getTime());
            System.out.println("Última modificación: " + new Date(archivo.lastModified()));
            
            // Renombrar archivo
            File archivoRenombrado = new File(directorio, "archivo_renombrado.txt");
            if (archivo.renameTo(archivoRenombrado)) {
                System.out.println("Archivo renombrado correctamente");
            }
            
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}