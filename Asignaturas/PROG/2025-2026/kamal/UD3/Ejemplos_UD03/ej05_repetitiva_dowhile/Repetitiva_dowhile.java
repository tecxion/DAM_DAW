/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej05_repetitiva_dowhile;

/**
 *
 * @author FMA
 */
public class Repetitiva_dowhile {

    public static void main(String[] args) {
        // DeclaraciÃ³n e inicializaciÃ³n de variables
        int numero = 7;
        int contador;
        int resultado=0;
        
        //Salida de informaciÃ³n
        System.out.println ("Tabla de multiplicar del " + numero);
        System.out.println (".............................. ");
        
        //Utilizamos ahora el bucle do-while
        contador = 1; //inicializamos la variable contadora
        do
        {
            resultado = contador * numero; 
            System.out.println(numero + " x " + contador + " = " + resultado);
            //Modificamos el valor de la variable contadora, para hacer que el
            //bucle pueda seguir iterando hasta llegar a finalizar
            contador++;
        }while (contador <= 10); //Establecemos la condiciÃ³n del bucle 
        
    }
    
}
