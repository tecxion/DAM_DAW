/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej04_repetitiva_while;

/**
 *
 */
import java.util.Scanner;
public class Repetitiva_while2 {
     public static void main(String[] args) {
        // Declaración e inicialización de variables
       Scanner sc = new Scanner(System.in);
    	String entrada; 
       int numero = 0;
       
    	 
         do{
        	
	        try {
	        	 System.out.println("introduce un número entero positivo");
	        	 entrada = sc.nextLine();
	        	 //numero = sc.nextInt();
	        	numero = Integer.parseInt(entrada);
	        	 if(numero <= 0 || numero > 1000) {
	        		 System.out.println("Debes introducir un número entre 1 y 1000");
	        	 }
	        }catch(Exception e) {
	        	 System.out.println("Debes introducir un número válido");
	        	 //sc.nextLine(); // Limpiar el flujo de entrada para evitar el bucle infinito
	        }
        	
        }while(numero <= 0 || numero > 1000);
        
         boolean primo = true;
        for(int i = 2; i <= numero; i++) {
        	primo = true;
        	for (int j =2; j <=i/2; j++) {
        		if(i % j == 0) {
        			primo = false;
        			break;
        		}
        	}  		
        	if(primo) {
        		System.out.println("El número " +  i + " es primo.");
        	}	
        	
        }
         
        sc.close();
            
     }
}     
