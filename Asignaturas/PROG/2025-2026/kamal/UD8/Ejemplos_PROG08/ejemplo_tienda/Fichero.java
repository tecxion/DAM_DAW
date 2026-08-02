package ejemplo_tienda_mio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Fichero {

	public static void leerFichero(String f, Tienda t) {
	    int lineasValidas = 0;
	    int lineasIgnoradas = 0;

	    try {
	    	FileReader fr = new FileReader(f);
	         BufferedReader br = new BufferedReader(fr);
	        String linea;
	        while ((linea = br.readLine()) != null) {
	            linea = linea.trim();
	            if (linea.isEmpty()) continue;

	            String[] partes = linea.split(";");
	            if (partes.length != 4) { 
	            	lineasIgnoradas++; continue; 
	            }
	            
	            String tipo = partes[0].trim();
	            boolean ok;
	            if(tipo.equals("higiene")) {
	            	String nombre = partes[1].trim();
	            	String precio = partes[2].trim();
	            	String profesional = partes[3].trim().toLowerCase();

	            	if (nombre.isEmpty() || precio.isEmpty() || profesional.isEmpty()) {
	            		lineasIgnoradas++; continue;
	            	}
	            	double prec;
	            	try {
	            		prec = Double.parseDouble(precio);
	            	}catch(Exception e){
	            		lineasIgnoradas++; continue;
	            	}
	            	if (!profesional.equals("true") && !profesional.equals("false")) {
	            		lineasIgnoradas++; continue;
	            	}

	            	boolean prof = Boolean.parseBoolean(profesional);
	            	
	            
	            
	            	ok = t.agregarProductoCatalogo(new ProductoHigiene(nombre, prec, prof));
	            }
	            else if(tipo.equals("alimentacion")) {
	            	String nombre = partes[1].trim();
	            	String precio = partes[2].trim();
	            	String dias = partes[3].trim();

	            	if (nombre.isEmpty() || precio.isEmpty() || dias.isEmpty()) {
	            		lineasIgnoradas++; continue;
	            	}
	            	double prec;
	            	int d;
	            	try {
	            		prec = Double.parseDouble(precio);
	            	}catch(Exception e){
	            		lineasIgnoradas++; continue;
	            	}
	            	try {
	            		d = Integer.parseInt(dias);
	            	}catch(Exception e){
	            		lineasIgnoradas++; continue;
	            	}
	            	
	            	
	            	
	            
	            
	            	ok = t.agregarProductoCatalogo(new ProductoAlimentacion(nombre, prec, d));
	            
	            
	            
	            }
	            else
	            	ok= false;
	            
	            if (ok) lineasValidas++;
	            else lineasIgnoradas++; // duplicado o inválido según tus reglas
	        }
	        br.close();

	    } catch (FileNotFoundException e) {
	        System.out.println("No existe el fichero de datos. Se creará al guardar.");
	    } catch (IOException e) {
	        System.out.println("Error de entrada/salida: " + e.getMessage());
	    }
	    
	    System.out.println("Cargados: " + lineasValidas + " | Ignorados: " + lineasIgnoradas);
	}
	
	
	public static void escribirFichero(String f, Tienda t) {

	    try {
	    	FileWriter fw = new FileWriter(f);
	        BufferedWriter bw = new BufferedWriter(fw);
	        for (LineaCarrito lc : t.getCarrito()) {

	        	String linea = lc.mostrarLinea();
	                  
	            bw.write(linea);
	            bw.newLine();
	        }
	        
	        bw.write("------------------------------------");
			bw.newLine();
			String totalTexto = String.format("TOTAL A PAGAR:  %.2f€", t.calcularTotalPedido());
			bw.write(totalTexto);
			bw.newLine();
			bw.newLine();
			bw.write("      ¡Gracias por su visita!       ");
			bw.newLine();

	        
	        bw.close();
	        System.out.println("Fichero guardado correctamente.");

	    } catch (IOException e) {
	        System.out.println("Error al escribir el fichero: " + e.getMessage());
	    }
	}
	
	
}
