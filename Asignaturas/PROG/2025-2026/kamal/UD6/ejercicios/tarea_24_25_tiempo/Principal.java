package tarea_24_25_tiempo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;


public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Cancion> canciones = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String fichero="src/tarea_24_25_tiempo/canciones.txt";
		// Crear las opciones del menú
        String[] opciones = {
            "Leer canciones del fichero",
            "Añadir canción",
            "Eliminar canción",
            "Desordenar canciones",
            "Mostrar canciones",
            "Escribir Fichero",
            "Salir"
        };
         
        // Instanciar el menú
        Menu menu = new Menu("Menú de opciones", opciones);

        // Mostrar el menú y capturar la elección
        int opcionSeleccionada;
        do {
            opcionSeleccionada = menu.mostrarYObtenerSeleccion();
        	
            switch (opcionSeleccionada) {
                case 1:
                   lecturaFichero(fichero,canciones);
                    break;
                case 2:
                	anadirCancion(canciones, sc);
                    break;
                case 3:
                	eliminarCancion(canciones, sc);
                    break;
                case 4:
                	if(canciones.isEmpty()) { 
                		  System.out.println("No hay canciones el la lista.");
                		break;}
                	Collections.shuffle(canciones);
                	mostrarCanciones(canciones);
                    break;
                case 5:
                	mostrarCanciones(canciones);
                    break;
                case 6:
                	escribirFichero(fichero,canciones);
                	break;
                case 7:
                    System.out.println("Saliendo del programa...");
                    break;
                
            }
        } while (opcionSeleccionada != 7);

        sc.close();
		
	}
	
	public static void anadirCancion(ArrayList<Cancion> c, Scanner sc) {
		System.out.println("Dime el título de la canción que quieres añadir:");
		String t =sc.nextLine();
		System.out.println("Dime la duración en segundos de la canción que quieres añadir:");
		int d =validarEntero(sc, 0, 9999);
		
		c.add(new Cancion(t,d));
		System.out.println("Canción " + t + " añadida correctamente");
				
	}
	public static void  eliminarCancion(ArrayList<Cancion> c, Scanner sc) {
		if(c.isEmpty()) { 
			System.out.println("No hay ninguna canción");
			return;
		}
			
		System.out.println("Estas con las canciones que hay:");
		mostrarCanciones(c);
		System.out.println("Dime el número de canción que quieres eliminar, 0 para salir sin eliminar");
		
		int max = c.size();
		
		int i = validarEntero(sc, 0, max);
		if(i==0) {
			System.out.println("Has elegido no eliminar ninguna canción"); 
			return;
		}else {
			c.remove(i-1);
			System.out.println("Canción eliminada"); 
		}
		mostrarCanciones(c);
		
	}
	
	public static void lecturaFichero(String f, ArrayList<Cancion> c) {
	    FileReader fr = null;
	    BufferedReader br = null;
	    try {
	        fr = new FileReader(f);
	        br = new BufferedReader(fr);
	        String linea;
	        String [] datos;
	        boolean archivoVacio = true; // Bandera para saber si se han leído líneas
	        while ((linea = br.readLine()) != null) {
	        	datos = linea.split(";");
	        	c.add(new Cancion(datos[0].trim(), Integer.parseInt(datos[1].trim())));
	            System.out.println(linea); // Imprime cada línea leída
	            archivoVacio = false; // Se ha leído al menos una línea
	        }
	        if (archivoVacio) {
	            System.out.println("El fichero está vacío.");
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
	
	
	public static void escribirFichero(String f, ArrayList<Cancion> c) {
	    FileWriter fichero = null;
	    BufferedWriter pw = null;
	    if(c.isEmpty()) {
	    	  System.out.println("No hay nada que escribir, la lista de canciones está vacía.");
	    	  return;
	    }
	    try {
	    	
	    	//En una línea lo anterior
	    	pw = new BufferedWriter(new FileWriter(f, false));
	    	for(Cancion s : c) {
	    		  	pw.write(s.getTitulo());
	    		  	pw.write(';');
	    		  	pw.write(Double.toString(s.getDuracion()));
	  	        	pw.newLine(); // Añade un salto de línea
	    	}
	         
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
	
	public static void mostrarCanciones(ArrayList<Cancion> c) {
		if(c.isEmpty()) {
	    	  System.out.println("No hay nada que mostrar, la lista de canciones está vacía.");
	    	  return;
	    }
		Double duracion = 0.0;
		for(int i =0; i<c.size();i++) {
			System.out.println(i+1 + " " + c.get(i) );
			duracion += c.get(i).getDuracion();
		}
		System.out.println("La duración total de las canciones es " + (int) (duracion/60) + " minutos " + (int)(duracion%60) + " segundos ");
	}

	private static int validarEntero(Scanner sc, int min, int max) {
        while (true) {
            try {
                int valor = Integer.parseInt(sc.nextLine());
                if (valor >= min && valor <= max) {
                    return valor;
                }
                System.out.print("Introduce un número entre " + min + " y " + max + ": ");
            } catch (NumberFormatException e) {
                System.out.print("Entrada no válida. Inténtalo de nuevo: ");
            }
        }
    }
}
