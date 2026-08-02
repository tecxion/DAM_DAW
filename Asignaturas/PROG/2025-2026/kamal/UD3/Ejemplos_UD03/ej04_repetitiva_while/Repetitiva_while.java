/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej04_repetitiva_while;

/**
 *
 * @author FMA
 */
public class Repetitiva_while {
     public static void main(String[] args) {
        // Declaración e inicialización de variables
        int numero = 7;
        int contador;
        int resultado=0;
        
        //Salida de información
        System.out.println ("Tabla de multiplicar del " + numero);
        System.out.println (".............................. ");
        
        //Utilizamos ahora el bucle while
        contador = 1; //inicializamos la variable contadora
        while (contador <= 10) //Establecemos la condición del bucle 
        {
            resultado = contador * numero; 
           
            if(contador == 5) {
            	contador++;
            	continue;
            }
           
            System.out.println(numero + " x " +  contador + " = " + resultado);
            //Modificamos el valor de la variable contadora, para hacer que el
            //bucle pueda seguir iterando hasta llegar a finalizar 
            contador++;
        }
    }
    
}
