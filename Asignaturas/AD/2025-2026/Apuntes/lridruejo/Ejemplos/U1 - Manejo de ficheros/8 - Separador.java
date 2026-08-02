import java.io.File;

public class EjemploSeparador {
    
    // Función que adapta una ruta al separador del sistema actual
    public static String adaptarSeparador(String ruta) {
        String separadorOriginal = "\\"; // Suponemos que la ruta viene con separadores de Windows
        try {
            // Reemplazamos todos los separadores originales por el separador del sistema
            return ruta.replaceAll(separadorOriginal, File.separator);
        } catch (Exception e) {
            System.err.println("Error al adaptar la ruta: " + e.getMessage());
            return ruta;
        }
    }
    
    public static void main(String[] args) {
        // Ruta con separadores de Windows
        String rutaWindows = "C:\\datos\\programacion\\fichero.txt";
        
        // Adaptamos la ruta al sistema actual
        String rutaAdaptada = adaptarSeparador(rutaWindows);
        
        // Creamos un objeto File con la ruta adaptada
        File archivo = new File(rutaAdaptada);
        
        // Mostramos información
        System.out.println("Ruta original: " + rutaWindows);
        System.out.println("Ruta adaptada: " + rutaAdaptada);
        System.out.println("Separador del sistema: " + File.separator);
        System.out.println("¿Es absoluta? " + archivo.isAbsolute());
    }
}