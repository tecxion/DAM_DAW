/*


 * 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//Programa que pida un mes y le devuelva el núm
package ej02_condicional_switch;

/**
 *
 * @author FMA
 */
public class Condicional_switch {

   /*Vamos a realizar el cÃ¡lculo de la nota de un examen 
     * de tipo test. Para ello, tendremos en cuenta el nÃºmero
     * total de preguntas, los aciertos y los errores. Dos errores
     * anulan una respuesta correcta.
     * 
     * La nota que vamos a obtener serÃ¡ un nÃºmero entero.
     * 
     * Finalmente, se muestra por pantalla la nota obtenida, asÃ­
     * como su calificaciÃ³n no numÃ©rica. 
     * 
     * La obtenciÃ³n de la calificaciÃ³n no numÃ©rica se ha realizado
     * utilizando la estructura condicional mÃºltiple o switch. 
     * 
     */
    public static void main(String[] args) {
         // DeclaraciÃ³n e inicializaciÃ³n de variables
    	int contador;
    	int numero;
    	 for (contador=1; contador<=10;contador++) {

    		 numero = (int) (Math.random()*3);
	    	//System.out.print(numero);
	        
	        switch (numero) {
	            case 0:
	            	System.out.println("Piedra");
	            	break;
	            case 1:
	            	
	            	System.out.println("Papel");
	                break;
	                    
	             
	            case 2 : 
	            	System.out.println("Tijera");
	            break;
	            
	            default: 
	            	System.out.println("Esta opción ("+ numero +") no está contemplada");            
	                   
	        }
    	 }
        
        
    }
    
}
