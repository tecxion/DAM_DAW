package ej09_Escritura_Lectura_Flujos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Ejemplo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		crearFichero("src/ej09_Escritura_Lectura_Flujos/fichero2.txt");
		listarFicheros("src/ej09_Escritura_Lectura_Flujos");
		eliminarFichero("src/ej09_Escritura_Lectura_Flujos/fichero2.txt");
		escrituraFicheroTexto("src/ej09_Escritura_Lectura_Flujos/fichero.txt");
		escrituraFicheroTexto("src/ej09_Escritura_Lectura_Flujos/fichero.txt", "Escribo esto otro");
		lecturaFicheroTexto("src/ej09_Escritura_Lectura_Flujos/fichero.txt");
		//escrituraFicheroTexto("fichero.txt");
	}
	
	
	public static void crearFichero(String ruta) {
	    File fichero = new File(ruta);
	    try {
	        if (fichero.createNewFile()) {
	            System.out.println("Fichero creado exitosamente: " + fichero.getAbsolutePath());
	        } else {
	            System.out.println("El fichero ya existe: " + fichero.getAbsolutePath());
	        }
	    } catch (IOException e) {
	        System.out.println("Error al crear el fichero: " + e.toString());
	    } catch (SecurityException e) {
	        System.out.println("Permiso denegado para crear el fichero: " + e.toString());
	    }
	}
	
	
	
	public static void eliminarFichero(String ruta) {
	    File fichero = new File(ruta);
	    try {
	        if (fichero.exists()) {
	            if (fichero.delete()) {
	                System.out.println("Fichero eliminado exitosamente: " + fichero.getAbsolutePath());
	            } else {
	                System.out.println("No se pudo eliminar el fichero: " + fichero.getAbsolutePath());
	            }
	        } else {
	            System.out.println("El fichero no existe: " + fichero.getAbsolutePath());
	        }
	    } catch (SecurityException e) {
	        System.out.println("Permiso denegado para eliminar el fichero: " + e.toString());
	    }
	}
	
	
	public static void listarFicheros(String ruta) {
	    File directorio = new File(ruta);
	   
	    // Verificar si la ruta existe y es un directorio
	    if (!directorio.exists()) {
	        System.out.println("La ruta no existe: " + ruta);
	        return;
	    }
	    if (!directorio.isDirectory()) {
	        System.out.println("La ruta no es un directorio: " + ruta);
	        return;
	    }
	    
	    // Obtener la lista de ficheros y directorios
	    File[] listaFicheros = directorio.listFiles();
	    
	    if (listaFicheros == null || listaFicheros.length == 0) {
	        System.out.println("El directorio está vacío: " + ruta);
	        return;
	    }
	    
	    // Iterar sobre los elementos y mostrarlos
	    System.out.println("Contenido del directorio: " + directorio.getAbsolutePath());
	    for (File elemento : listaFicheros) {
	        if (elemento.isDirectory()) {
	            System.out.println("[Directorio] " + elemento.getName());
	        } else {
	            System.out.println("[Archivo] " + elemento.getName());
	        }
	    }
	}
	
	

	public static void lecturaFicheroTexto(String f) {
	    FileReader fr = null;
	    BufferedReader br = null;
	    try {
	        fr = new FileReader(f);
	        br = new BufferedReader(fr);
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            System.out.println(linea); // Imprime cada línea leída
	        }
	    } catch (FileNotFoundException e) {
	        System.out.println("Archivo no encontrado: " + e.toString());
	    } catch (IOException e) {
	        System.out.println("Error de entrada/salida: " + e.toString());
	    } finally {
	        try {
	            if (br != null) br.close();
	            if (fr != null) fr.close();
	        } catch (IOException e) {
	            System.out.println(e.toString());
	        }
	    }
	}
	
	public static void escrituraFicheroTexto(String f) {
	    FileWriter fichero = null;
	    BufferedWriter pw = null;
	    //PrintWriter pw2 = null;
	    try {
	    	fichero = new FileWriter(f, true); // true para añadir al final, false para sobrescribir
	        pw = new BufferedWriter(fichero);
	        pw.write("Línea de texto");
	        pw.newLine(); // Añade un salto de línea
	        
	        //pw2 = new PrintWriter(fichero);
	        //pw2.println("Línea de texto"); // Aquí puedes escribir el texto que desees
	        
	       
	    } catch (FileNotFoundException e) {
	        System.out.println("Archivo no encontrado: " + e.toString());
	    
	    } catch (Exception e) {
	        System.out.println(e.toString());
	    } finally {
	        try {
	            if (pw != null) pw.close();
	            if (fichero != null) fichero.close();
	        } catch (Exception e) {
	            System.out.println(e.toString());
	        }
	    }
	}
	
	
	public static void escrituraFicheroTexto(String f, String texto ) {
	    FileWriter fichero = null;
	    BufferedWriter pw = null;
	    //PrintWriter pw2 = null;
	    try {
	    	//fichero = new FileWriter(f, true); // true para añadir al final, false para sobrescribir
	        //pw = new BufferedWriter(fichero);
	    	//En una línea lo anterior
	    	pw = new BufferedWriter(new FileWriter(f, true));
	        pw.write(texto);
	        pw.newLine(); // Añade un salto de línea
	        
	        //otra forma
	        //pw2 = new PrintWriter(fichero);
	        //pw2.println("Línea de texto"); // Aquí puedes escribir el texto que desees
	        
	       
	    } catch (FileNotFoundException e) {
	        System.out.println("Archivo no encontrado: " + e.toString());
	    
	    } catch (Exception e) {
	        System.out.println(e.toString());
	    } finally {
	        try {
	            if (pw != null) pw.close();
	            if (fichero != null) fichero.close();
	        } catch (Exception e) {
	            System.out.println(e.toString());
	        }
	    }
	}
	
}
