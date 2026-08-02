package ej10_otro_ejemplo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManejoArchivosMixto {

    public static void main(String[] args) {
        String ruta = "src/datos_mixto.txt";

        // Escribir datos mixtos en el archivo
        escribirDatosMixto(ruta, new String[][] {
            {"1,2", "Casa"},
            {"3,4", "Escuela"},
            {"5,6", "Parque"}
        });

        // Leer y mostrar los datos del archivo
        leerDatosMixto(ruta);
    }

    // Método para escribir datos mixtos (números y cadenas) en un archivo
    public static void escribirDatosMixto(String ruta, String[][] datos) {
        BufferedWriter bw = null;
        try {
            File archivo = new File(ruta);
            bw = new BufferedWriter(new FileWriter(archivo, true)); // true para añadir

            for (String[] dato : datos) {
                if (dato.length == 2) {
                    String coordenadas = dato[0]; // Por ejemplo, "1,2"
                    String texto = dato[1];       // Por ejemplo, "Casa"
                    bw.write(coordenadas + ";" + texto); // Formato: x,y;texto
                    bw.newLine();
                }
            }
            System.out.println("Datos escritos exitosamente en: " + archivo.getAbsolutePath());
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.toString());
        } finally {
            try {
                if (bw != null) bw.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el BufferedWriter: " + e.toString());
            }
        }
    }

    // Método para leer datos mixtos del archivo
    public static void leerDatosMixto(String ruta) {
        BufferedReader br = null;
        try {
            File archivo = new File(ruta);
            if (!archivo.exists()) {
                System.out.println("El archivo no existe: " + ruta);
                return;
            }
            br = new BufferedReader(new FileReader(archivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                // Separar la línea en coordenadas y texto usando ';'
                String[] partes = linea.split(";");
                if (partes.length == 2) {
                    String coordenadas = partes[0]; // Por ejemplo, "1,2"
                    String texto = partes[1];       // Por ejemplo, "Casa"

                    // Separar las coordenadas en x e y
                    String[] coords = coordenadas.split(",");
                    if (coords.length == 2) {
                        int x = Integer.parseInt(coords[0].trim());
                        int y = Integer.parseInt(coords[1].trim());
                        System.out.println("Coordenadas: (" + x + ", " + y + "), Descripción: " + texto);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + e.toString());
        } catch (IOException e) {
            System.out.println("Error de entrada/salida: " + e.toString());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir coordenadas a números: " + e.toString());
        } finally {
            try {
                if (br != null) br.close();
            } catch (IOException e) {
                System.out.println("Error al cerrar el BufferedReader: " + e.toString());
            }
        }
    }
}