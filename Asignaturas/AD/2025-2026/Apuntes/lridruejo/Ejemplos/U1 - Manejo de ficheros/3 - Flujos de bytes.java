import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Ejemplo de copia de archivos usando flujos de bytes
 */
public class EjemploFlujosBytes {
    
    public static void copiarArchivo(String origen, String destino) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        
        try {
            // Crear flujos de entrada y salida
            fis = new FileInputStream(origen);
            fos = new FileOutputStream(destino);
            
            // Buffer para lectura/escritura
            byte[] buffer = new byte[1024];
            int bytesLeidos;
            
            // Copiar archivo
            while ((bytesLeidos = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesLeidos);
            }
            
            System.out.println("Archivo copiado correctamente: " + origen + " -> " + destino);
            
        } catch (IOException e) {
            System.err.println("Error al copiar archivo: " + e.getMessage());
        } finally {
            // Cerrar flujos
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (IOException e) {
                System.err.println("Error al cerrar flujos: " + e.getMessage());
            }
        }
    }
    
    public static void main(String[] args) {
        // Copiar un archivo
        copiarArchivo("origen.txt", "copia_origen.txt");
    }
}