package ej11_Serializacion;
import java.io.*;
import java.util.HashMap;

public class Fichero_HashMap {

    

    // Método para leer un HashMap<K, V> desde un fichero
    public static <K, V> HashMap<K, V> recuperar(String nombre) {
        HashMap<K, V> mapa = new HashMap<>();
        try {
        	ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream(nombre));
        	System.out.print("Leyendo HashMap del fichero " + nombre + "... ");
            
            // Leemos el objeto y lo casteamos a HashMap<K, V>
            @SuppressWarnings("unchecked")
            HashMap<K, V> aux = (HashMap<K, V>) leyendoFichero.readObject();
            
            leyendoFichero.close();
            
            mapa.putAll(aux);

            System.out.println("Se ha leído correctamente.");
        } catch (FileNotFoundException e) {
            System.out.println("El fichero no existe. No se ha podido recuperar la información.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        }
        return mapa;
    }
    
    
 // Método para guardar un HashMap<K, V> en un fichero
    public static <K, V> void grabar(HashMap<K, V> mapa, String nombre) {
        try {
        	ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream(nombre));
        	System.out.print("Guardando HashMap en el fichero " + nombre + "... ");

            // Escribimos el objeto en el fichero
            escribiendoFichero.writeObject(mapa);
            escribiendoFichero.close();
            System.out.println("Se ha guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al escribir en el fichero: " + e.getMessage());
        }
    }
}
