package ejercicios_28_01;

import java.util.Scanner;

/*
Crea un programa que pida a un usuario una tabla de multiplicar (por ejemplo, la del 7), 
le pregunte aleatoriamente cada número de la tabla de multiplicar (de 1 a 10), 
y compruebe si la contestación es correcta. Si la respuesta es correcta, el programa hará otra pregunta.
Si la respuesta es incorrecta, volverá a preguntar sobre ese mismo número hasta que acierte. 
El programa finaliza cuando el usuario ha contestado correctamente a todos los números de la tabla de multiplicar.
*/
public class Tabla {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int tabla = 7;
		int[] numeros = {3,5,6};
		boolean no_acertado = true;
		int indice;
		for(int i=0; i<numeros.length;i++) {
			do {
				indice = (int)(Math.random()*numeros.length);
			}while(numeros[indice] == -1 );
			
			no_acertado=true;	
			while(no_acertado) {
				System.out.println("Dime el resultado de " + tabla + " x " + numeros[indice] + ": ");
				if(tabla*numeros[indice] == sc.nextInt()) {
					numeros[indice]=-1;
					no_acertado=false;
					System.out.println("Has acertado");
				}else {
					System.out.println("Has fallado, vuelve a intentarlo");	
				}	
			}		
		}
		System.out.println("Has contestado correctamente a todos los números de la tabla de multiplicar");
		sc.close();
		
	}

}
