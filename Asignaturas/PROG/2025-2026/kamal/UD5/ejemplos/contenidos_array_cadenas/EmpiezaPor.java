
//Este programa pide una cadena al usuario y comprueba cuantas palabras empiezan por cada vocal
//y el total de distintas de vocal
package contenidos_array_cadenas;

import java.util.Scanner;

public class EmpiezaPor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		//pedir la cadena al ususario Scanner    sc.nextLine()
		System.out.println("Introduce una cadena");
		String cadena = sc.nextLine();
		//descomponer esa cadena en un array de cadenas (palabras) en un array de String palabras =    cadena.split(" ");
		//String[] palabras =  cadena.split("\\s+");
		String[] palabras =  cadena.split(" ");
		//comprobamos cuantas palabras empiezan por cada vocal. 
		
		  //Crear los contadores inicializados a 0
		int cont_a =0, cont_e =0,cont_i =0, cont_o =0, cont_u =0, otros=0;
		
		for(int i=0; i<palabras.length; i++) {
			// crear un Switch para ver si el primer caracter de la palabra es una vocal u otra o diferente a vocal (default)
			switch(palabras[i].charAt(0)) {
			case 'a':
			case 'A':
				cont_a++;
				break;
			case 'e':
			case 'E':
				cont_e++;
				break;
			case 'i':
			case 'I':
				cont_i++;
				break;
			case 'o':
			case 'O':
				cont_o++;
				break;
			case 'U':
			case 'u':
				cont_u++;
				break;
			default:
				otros++;
			
			}//switch
			
		}//for
				  
		System.out.println("Contador aes; " + cont_a);
		System.out.println("Contador es; " + cont_e);
		System.out.println("Contador ies; " + cont_i);
		System.out.println("Contador oes; " + cont_o);
		System.out.println("Contador ues; " + cont_u);
		System.out.println("Contador otros; " + otros);
		
		sc.close();
	}//main

}
