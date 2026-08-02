package ej01_Token;



import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;


public class Token {

    public static void contarPalabrasyNumeros(String nombre_fichero) {

        StreamTokenizer sTokenizer = null;
        int contapal = 0, numNumeros = 0;

        try {

            sTokenizer = new StreamTokenizer(new FileReader(nombre_fichero));

            while (sTokenizer.nextToken() != StreamTokenizer.TT_EOF) {
            	//vemos lo que contiene sTokenizer
            	//System.out.print(sTokenizer);
            	
                if (sTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    contapal++;
                    //mostramos el valor del string
                    System.out.println("Palabra: "+ sTokenizer.sval);
                }
                else if (sTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                	//mostramos el valor numérico double
                	System.out.println("Numero: "+ sTokenizer.nval);
                	numNumeros++;
                    
                }
            }

            System.out.println("Número de palabras en el fichero: " + contapal);
            System.out.println("Número de números en el fichero: " + numNumeros);

        } catch (FileNotFoundException ex) {
           System.out.println(ex.getMessage()) ;
        } catch (IOException ex) {
           System.out.println(ex.getMessage()) ;
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    	//src/ej01_Token/ejemploToken.txt
        contarPalabrasyNumeros("c:\\ficherosJava\\datos.txt");
        contarPalabrasyNumeros("src/ej01_Token/ejemploToken.txt");
    }
}

