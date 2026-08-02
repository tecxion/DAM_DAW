package ej00_BufferReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class PruebaBufferReader {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		//Hasta ahora hemos utilizado la clase Scanner
		Scanner sc = new Scanner(System.in);
		
		//Ahora veamos la clase BufferedReader
		BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Escribe algo: ");
		String cadena = teclado.readLine();
		
		System.out.println("Has escrito: " + cadena);
	
		boolean no_ok = true;
		int num1, num2, suma;
		
		while(no_ok) {
			try {
	            System.out.print("Escribe el primer número: ");
	            num1 = Integer.parseInt(teclado.readLine());
	            System.out.print("Escribe el segundo número: ");
	            num2 = Integer.parseInt(teclado.readLine());
	            no_ok = false;
	            suma = num1 + num2;
	            System.out.println("La suma es: " + suma);
	        } catch (IOException e) {
	            System.out.println("Error al leer la entrada.");
	        } catch (NumberFormatException e) {
	            System.out.println("Por favor, introduce un número válido.");
	        }
		}
				
		
	}

}
