/*
 * Ejemplo de polimorfismo y ligadura dinámica
 */
package ej03_PolimorfismoInstrum;


import java.io.BufferedReader;
import java.io.InputStreamReader;


public class EjemploPolimorfismoInstrumentos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         String tipo= null;
         String nota= null;
         Instrumento instrumento1= null;
        // ¿Flauta o Piano?
        do {
            System.out.println("Elija instrumento: flauta(F) o piano(P): ");          
            try {
                tipo= lecturaTeclado();
            }
            catch (Exception e) {
                System.err.println(e.getMessage());               
            }        
            if (tipo.equals("P") || tipo.equals("p")) tipo="piano";
            else if (tipo.equals("F") || tipo.equals("f")) tipo="flauta";
            else tipo="X";

        } while (tipo.equals("X"));        

        // Nota musical
        System.out.println("Escriba nota musical: ");          
        try {
            nota= lecturaTeclado();
        }
        catch (Exception e) {
            System.err.println(e.getMessage());               
        }        
        
        // Creación del objeto instrumento1 (desconocido en tiempo de compilación)
        // Sabemos que será subclase de Instrumento, pero no sabemos si será Flauta o Piano
        // (dependerá de la ejecución)
        if (tipo.equals("piano")) {
            instrumento1= new Piano (); // Ejemplo de objeto polimórfico (puede ser Piano o Flauta)
        }     
        else if (tipo.equals("flauta")) {
            instrumento1=  new Flauta ();  // Ejemplo de objeto polimórfico (puede ser Piano o Flauta)          
        } else {
            
        }
        
        // Interpretamos una nota con el objeto instrumento1
        // No sabemos si se ejecutará el método tocarNota de Piano o de Faluta
        // (dependerá de la ejecución)
        instrumento1.tocarNota(nota);   // Ejemplo de ligadura dinámica (tiempo de ejecución)       
        
    }

    //---------------------------------------------------------------        
    // MÉTODO lecturaTeclado: Captura de una cadena de teclado
    //---------------------------------------------------------------      
    private static String lecturaTeclado () throws Exception {
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            BufferedReader reader = new BufferedReader(inputStreamReader);
            String line = reader.readLine();
            return line;
        }
        catch (Exception e) {
            throw e;

        }

    }

}
