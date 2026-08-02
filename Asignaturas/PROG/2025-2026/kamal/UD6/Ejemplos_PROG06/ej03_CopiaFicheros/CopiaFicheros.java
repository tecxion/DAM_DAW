	package ej03_CopiaFicheros;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 *
 * @author
 */
public class CopiaFicheros {

/*
Buffer pequeño (ej: 64 bytes)
muchas operaciones de lectura
más lento

Buffer grande (ej: 64 KB)
menos llamadas al sistema
más rápido
más memoria usada
 */
	
    public static void copia(String origen, String destino) throws IOException {
        try {
            OutputStream fsalida;
            try ( // Obtener los nombres de los ficheros de origen y destino
                    // y abrir la conexión a los ficheros.
	           InputStream fentrada = new FileInputStream(origen)) {
	                fsalida = new FileOutputStream(destino);
	                // Crear una variable para leer el flujo de bytes del origen
	                byte[] buffer = new byte[1024];
	                while (true) {
	                    // Leer el flujo de bytes
	                    int n = fentrada.read(buffer);
	                    System.out.print(" n vale: "+ n);
	                    
	                    // Si no queda nada por leer, salir del while
	                    if (n < 0) {
	                        break;
	                    }
	                    // Escribir el flujo de bytes leídos al fichero destino
	                    fsalida.write(buffer, 0, n);
	                    System.out.println("Fichero copiado con éxito");
	                }
	              // Cerrar los ficheros
	            }
            fsalida.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
    	//String origen = "c:\\ficherosJava\\img_origen.png";
    	//String destino = "c:\\ficherosJava\\img_destino.png";
    	//String origen = "c:\\ficherosJava\\origen.txt";
    	String origen = "c:/ficherosJava/origen.txt";
    	
    		String destino = "c:\\ficherosJava\\destino.txt";

    	System.out.println("vamos a copiar el fichoro " + origen + " en el fichero: " + destino);
    	copia(origen, destino);
    	origen = "src/ej03_CopiaFicheros/img_origen.png";
    	destino = "src/ej03_CopiaFicheros/img_destino.png";
    	copia(origen, destino);
    	
    }

}
