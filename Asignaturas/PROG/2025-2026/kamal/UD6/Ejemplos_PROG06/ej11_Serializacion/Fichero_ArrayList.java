package ej11_Serializacion;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class Fichero_ArrayList {
	
	// Método para leer el ArrayList<T> desde el fichero
	public static <T> void recuperar(List <T> c, String nombre ){  

		   try {
			   
			   ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream(nombre) );
			   System.out.print("Leyendo ArrayList del fichero  "+ nombre + ".. ");
			   
			   @SuppressWarnings("unchecked")
			   ArrayList  <T>aux = ( ArrayList <T>)leyendoFichero.readObject();
			   
			   leyendoFichero.close();
			   
			   c.addAll(aux);
			   System.out.println("Se han leído correctamente.");
	        
		   } catch (FileNotFoundException e) {
	            System.out.println("El fichero no existe. No se ha podido recuperar la información.");
	        } catch (IOException | ClassNotFoundException e) {
	            System.out.println("Error al leer el fichero: " + e.getMessage());
	        }
	}
	
	// Método para guardar un ArrayList<T> en el fichero
	public static <T> void grabar(List<T> v, String nombre){  
		   try {
						
				ObjectOutputStream escribiendoFichero = new ObjectOutputStream(new FileOutputStream(nombre));
				System.out.print("Guardando ArrayList en el fichero "+ nombre + ".. ");
				
				// Escribimos el objeto en el fichero
				escribiendoFichero.writeObject(v);
				escribiendoFichero.close();
				System.out.println("Se han grabado correctamente.");
		   } catch (Exception e) {
			   System.out.println("Error al escribir en el fichero: " + e.getMessage());
		   }
	}

}
