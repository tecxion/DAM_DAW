/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej06_sentencia_return;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author FMA
 */
public class Sentencia_return {

    private static BufferedReader stdin = new BufferedReader( new InputStreamReader(System.in));
    
    public static int suma(int numero1, int numero2)
    {
        int resultado;
        resultado = numero1 + numero2;
        return resultado; //Mediante return devolvemos el resultado de la suma
    }
    
    public static void main(String[] args) throws IOException {
        //DeclaraciÃ³n de variables
        String input; //Esta variable recibirÃ¡ la entrada de teclado
        int primer_numero, segundo_numero; //Estas variables almacenarÃ¡n los operandos
        
        // Solicitamos que el usuario introduzca dos nÃºmeros por consola
        System.out.print ("Introduce el primer operando:"); 
        input = stdin.readLine(); //Leemos la entrada como cadena de caracteres
        primer_numero = Integer.parseInt(input); //Transformamos a entero lo introducido
        System.out.print ("Introduce el segundo operando: "); 
        input = stdin.readLine(); //Leemos la entrada como cadena de caracteres
        segundo_numero = Integer.parseInt(input);  //Transformamos a entero lo introducido
        
        //Imprimimos los nÃºmeros introducidos
        System.out.println ("Los operandos son: " + primer_numero + " y " + segundo_numero);
        System.out.println ("obteniendo su suma... ");
        
        //Invocamos al mÃ©todo que realiza la suma, pasÃ¡ndole los parÃ¡metros adecuados
        System.out.println ("La suma de ambos operandos es: " + suma(primer_numero,segundo_numero));
        
       
    }
    
}
