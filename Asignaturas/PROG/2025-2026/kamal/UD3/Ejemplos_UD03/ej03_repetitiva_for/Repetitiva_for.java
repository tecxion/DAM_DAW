/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej03_repetitiva_for;

/**
 *
 * @author FMA
 */
public class Repetitiva_for {

  /* En este ejemplo se utiliza la estructura repetitiva for
     * para representar en pantalla la tabla de multiplicar del siete 
     */
    public static void main(String[] args) {
        // DeclaraciÃ³n e inicializaciÃ³n de variables
        int numero = 7;
        int contador;
        int resultado=0;
        
        //para arrays
        int []lista = new int [10]; // desde 0 a 9
        
        
        for (int i = 0; i<lista.length;i++) {
        	lista[i] = (int) Math.pow(i, 2.0);
        }
        for (int i=0; i<lista.length; i++){
        	System.out.print(lista[i] + " ");
        }
        System.out.print("\n");
        for( int val : lista) {
        	
        	System.out.print(val+ " ");
        	
        }
       
        System.out.println();
        for (int val:lista){
        	System.out.print(val + " ");
        }
        
        //Salida de informaciÃ³n
        System.out.println ("\nTabla de multiplicar del " + numero);
        System.out.println (".............................. ");
        
        //Utilizamos ahora el bucle for
        for (contador=1; contador<=10;contador++)
        /* La cabecera del bucle incorpora la inicializaciÃ³n de la variable
         * de control, la condiciÃ³n de multiplicaciÃ³n hasta el 10 y el
         * incremento de dicha variable de uno en uno en cada iteraciÃ³n del
         * bucle. 
         * En este caso contador++ incrementarÃ¡ en una unidad el valor de 
         * dicha variable.
         */
            
        {
            resultado = contador * numero; 
            if (contador == 4) {
            	 //System.out.println("Hemos llegado a 4");
            	 continue;
            }
            System.out.println(numero + " x " + contador + " = " + resultado);
            /* A travÃ©s del operador + aplicado a cadenas de caracteres, 
             * concatenamos los valores de las variables con las cadenas de
             * caracteres que necesitamos para representar correctamente la
             * salida de cada multiplicaciÃ³n.
             */
        }
    }
}
