import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Ejemplo de acceso aleatorio a archivos usando RandomAccessFile
 */
public class EjemploAccesoAleatorio {
    
    public static void escribirRegistros(String nombreArchivo) {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "rw")) {
            
            // Escribir algunos registros
            raf.writeUTF("Juan");      // Nombre (String)
            raf.writeInt(25);          // Edad (int)
            raf.writeDouble(750.50);   // Saldo (double)
            
            raf.writeUTF("María");
            raf.writeInt(30);
            raf.writeDouble(1200.75);
            
            raf.writeUTF("Pedro");
            raf.writeInt(35);
            raf.writeDouble(500.25);
            
            System.out.println("Registros escritos correctamente");
            
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }
    }
    
    public static void leerRegistro(String nombreArchivo, int numeroRegistro) {
        try (RandomAccessFile raf = new RandomAccessFile(nombreArchivo, "r")) {
            
            // Calcular posición del registro (cada registro tiene: String + int + double)
            // UTF: 2 bytes por carácter + 2 bytes para longitud
            // int: 4 bytes
            // double: 8 bytes
            long posicion = numeroRegistro * (raf.readUTF().length() * 2 + 2 + 4 + 8);
            raf.seek(posicion);
            
            // Leer registro
            String nombre = raf.readUTF();
            int edad = raf.readInt();
            double saldo = raf.readDouble();
            
            System.out.println("Registro " + numeroRegistro + ":");
            System.out.println("  Nombre: " + nombre);
            System.out.println("  Edad: " + edad);
            System.out.println("  Saldo: " + saldo);
            
        } catch (IOException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        String archivo = "registros.dat";
        
        // Escribir registros
        escribirRegistros(archivo);
        
        // Leer registros específicos
        leerRegistro(archivo, 0);  // Primer registro
        leerRegistro(archivo, 1);  // Segundo registro
        leerRegistro(archivo, 2);  // Tercer registro
    }
}