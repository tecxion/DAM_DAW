package ej07_ejercicio_resuelto_excepciones;
import java.util.Scanner;
public class Exc {
	
	
	
	public  void ejec(){
		Scanner sc = new Scanner(System.in);
		int valor = -1;
		String entrada = "4";
		do {
			 System.out.println("Introduce un número entero: ");
			entrada = sc.nextLine();
			 valor = validarEntrada(entrada);
			
		}while(valor <0 || valor >100);
		 System.out.println("Has introducido el número : " + valor);
		 sc.close();
	}
	
	
	
	private int validarEntrada(String entrada) { 
		int num = -1;
		try {
			num = Integer.parseInt(entrada);
		 	if (num <0  || num > 100) {
			System.out.println("Debes introducir un número entre 0 y 100.");
		 	}
		//si no está entre 1 y 100, lanzar una excepción throw new Exception("El número debe estar entre 1 y 100.");
		//devolver el valor numérico

		} catch (NumberFormatException e) {
		   System.out.println("Debes introducir un número entero válido.");
		}
		return num;
	}	
}

