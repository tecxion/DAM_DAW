import java.io.*;
import java.util.Scanner;

public class EjemploSecuencial {
    
    public static void main(String[] args) {
        String archivo = "datos_secuencial.dat";
        
        // 1. Crear y escribir en el fichero
        escribirFichero(archivo);
        
        // 2. Leer datos del fichero
        leerFichero(archivo);
        
        // 3. Buscar información en el fichero
        buscarEnFichero(archivo, "Ana");
        
        // 4. Copiar fichero a otro
        copiarFichero(archivo, "copia_datos.dat");
    }
    
    // Crear un fichero o abrirlo para grabar datos
    public static void escribirFichero(String nombreArchivo) {
        try {
            DataOutputStream archivo = new DataOutputStream(
                new FileOutputStream(nombreArchivo));
            
            // Escribimos algunos registros
            archivo.writeUTF("Juan");
            archivo.writeInt(25);
            archivo.writeDouble(750.50);
            
            archivo.writeUTF("Ana");
            archivo.writeInt(30);
            archivo.writeDouble(820.75);
            
            archivo.writeUTF("Luis");
            archivo.writeInt(28);
            archivo.writeDouble(690.25);
            
            archivo.close();
            System.out.println("Datos escritos correctamente en " + nombreArchivo);
            
        } catch (IOException e) {
            System.err.println("Error al escribir: " + e.getMessage());
        }
    }
    
    // Leer datos del fichero
    public static void leerFichero(String nombreArchivo) {
        try {
            DataInputStream archivo = new DataInputStream(
                new FileInputStream(nombreArchivo));
            
            System.out.println("\n--- CONTENIDO DEL FICHERO ---");
            
            // Leemos hasta llegar al final del archivo
            while (archivo.available() > 0) {
                String nombre = archivo.readUTF();
                int edad = archivo.readInt();
                double salario = archivo.readDouble();
                
                System.out.printf("Nombre: %s, Edad: %d, Salario: %.2f%n", 
                                nombre, edad, salario);
            }
            
            archivo.close();
            
        } catch (EOFException e) {
            System.out.println("Fin del archivo alcanzado");
        } catch (IOException e) {
            System.err.println("Error al leer: " + e.getMessage());
        }
    }
    
    // Búsqueda de información en un fichero
    public static void buscarEnFichero(String nombreArchivo, String nombreBuscado) {
        try {
            DataInputStream archivo = new DataInputStream(
                new FileInputStream(nombreArchivo));
            
            System.out.println("\n--- BÚSQUEDA: " + nombreBuscado + " ---");
            boolean encontrado = false;
            
            while (archivo.available() > 0) {
                String nombre = archivo.readUTF();
                int edad = archivo.readInt();
                double salario = archivo.readDouble();
                
                if (nombre.equals(nombreBuscado)) {
                    System.out.println("¡REGISTRO ENCONTRADO!");
                    System.out.printf("Nombre: %s, Edad: %d, Salario: %.2f%n", 
                                    nombre, edad, salario);
                    encontrado = true;
                    break;
                }
            }
            
            if (!encontrado) {
                System.out.println("Registro no encontrado");
            }
            
            archivo.close();
            
        } catch (EOFException e) {
            System.out.println("Fin del archivo alcanzado durante búsqueda");
        } catch (IOException e) {
            System.err.println("Error en búsqueda: " + e.getMessage());
        }
    }
    
    // Copiar datos de un fichero a otro
    public static void copiarFichero(String origen, String destino) {
        try {
            DataInputStream entrada = new DataInputStream(
                new FileInputStream(origen));
            DataOutputStream salida = new DataOutputStream(
                new FileOutputStream(destino));
            
            System.out.println("\n--- COPIANDO ARCHIVO ---");
            
            // Copiamos todos los datos
            while (entrada.available() > 0) {
                String nombre = entrada.readUTF();
                int edad = entrada.readInt();
                double salario = entrada.readDouble();
                
                salida.writeUTF(nombre);
                salida.writeInt(edad);
                salida.writeDouble(salario);
            }
            
            entrada.close();
            salida.close();
            System.out.println("Archivo copiado correctamente a: " + destino);
            
        } catch (IOException e) {
            System.err.println("Error al copiar: " + e.getMessage());
        }
    }
}