package ej03c_codific_fichero;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LeerArchivo {
    public static void main(String[] args) {
        FileInputStream fichero = null;
        try {
            // Elegimos fichero para leer flujos de bytes "crudos"
           fichero = new FileInputStream("c:\\ficherosJava\\texto.txt");
        	 
            //InputStreamReader sirve de puente de flujos de byte a caracteres
            InputStreamReader unReader = new InputStreamReader(fichero);
            // Vemos la codificación actual
            System.out.println("Codificación del archivo: " + unReader.getEncoding());
            unReader.close(); // Cerrar el lector para liberar recursos
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (fichero != null) {
                try {
                    fichero.close(); // Cerrar el flujo de entrada
                } catch (IOException ex) {
                    Logger.getLogger(LeerArchivo.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}