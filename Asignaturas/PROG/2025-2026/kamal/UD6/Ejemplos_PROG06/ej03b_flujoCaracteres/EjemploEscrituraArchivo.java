package ej03b_flujoCaracteres;
import java.io.*;

public class EjemploEscrituraArchivo {
    public static void main(String[] args) {
        try {
        	//con el argumento 'true' añadimos información boolan append con 'false' desaparece lo que había
            //PrintWriter out = new PrintWriter(new FileWriter("c:\\ficherosJava\\salida.txt", true));
        	//Con ruta relativa, el directorio actual es la raiz en este caso "PROG09_Ejemplos" Ver eclipse-workspace
        	PrintWriter out = new PrintWriter(new FileWriter("src/ej03b_flujoCaracteres/salida.txt", true));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String s;
            System.out.println("Escribe texto (escribe 'salir' en una línea para terminar):");
            while (!(s = br.readLine()).equals("salir")) {
                out.println(s);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}