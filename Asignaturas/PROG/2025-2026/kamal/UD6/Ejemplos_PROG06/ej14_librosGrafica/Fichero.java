package ej14_librosGrafica;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Fichero {

	
	
	//Método para leer el ArrayList de clientes del fichero clientes.dat
	public static void recuperar(ArrayList  c, String nombre ){  
		ArrayList  aux = new ArrayList();
		   try {
			   System.out.print("Leyendo ArrayList del fichero  "+ nombre + ".. ");

			   ObjectInputStream leyendoFichero = new ObjectInputStream(new FileInputStream(nombre) );
			   aux = ( ArrayList )leyendoFichero.readObject();
			   leyendoFichero.close();

			   System.out.println("Se han leído bien");
		       for(int i = 0; i < aux.size(); i++)
					c.add(aux.get(i));
	
		   } catch (Exception e) {
			   System.out.println( e.getMessage() );
		   }
	}
	
	//Método para grabar el ArrayList de ventas en el fichero ventas.dat
	public static void grabar(ArrayList v, String nombre){  
		   try {
				System.out.print("Guardando ArrayList en el fichero "+ nombre + ".. ");
			
				ObjectOutputStream escribiendoFichero = new ObjectOutputStream( 
				new FileOutputStream(nombre) );
				escribiendoFichero.writeObject(v);
				escribiendoFichero.close();
			
				System.out.println("Se han grabado bien.");
		   } catch (Exception e) {
			   System.out.println( e.getMessage() );
		   }
	}
	
	
}
