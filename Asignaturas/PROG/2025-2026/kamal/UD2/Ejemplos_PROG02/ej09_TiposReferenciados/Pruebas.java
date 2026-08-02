package ej09_TiposReferenciados;

public class Pruebas {

	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		
		String[] array;
		array = new String[10];

		for (int x=0;x<array.length;x++)
		  System.out.print(array[x]);
		  System.out.println();
		
		
		float f = 5.67f;
		
		//definición y asignación de un array array de enteros
		int[] numeros = {1, 3, 4 ,5 };
		
		//definición y asignación de un array array de enteros
		//ahora j apunta a números todo lo que haga con 'j' modificará 'numeros' 
		//las dos variables apuntan a la misma dirección de memoria
		int []j = numeros;
		
		//modificación de un valor del array por su índice
		numeros[3]=45;
		//modificación de un valor del array por su índice
		j[0]=14;
		
		//se muestra el contenido del array 'numeros'
		for  (int i:numeros){
			System.out.println(i);
		}
		
		System.out.println("********************");
		//se muestra el contenido del array 'j'
		for  (int i:j){
			System.out.println(i);
		}
		
		
		//Hacemos lo mismo con cadenas String
		String cad = new String( "cadena	");
		
		String p = cad;
		//p ="otra cadena";
		
		System.out.println(cad);
		System.out.println(p);
		
		String [] palabras = p.split(" ");
		//p = p.concat(" adios");
		
		//System.out.println(palabras[0]);
		for  (String i:palabras){
			System.out.println(i);
		}
		 System.out.println(palabras[0].charAt(0));
		/*Aquí ocurre algo importante: debido a que las cadenas son inmutables en Java,
		 *  p no modifica el valor original "cadena" ni el lugar al que apunta cad. 
		 *  En su lugar, p pasa a apuntar a un nuevo objeto de cadena "otra cadena" 
		 *  en el String Pool. Por lo tanto, después de esta asignación,
		 *   a sigue apuntando a "cadena", mientras que d ahora apunta a "otra cadena".
		 *   Las cadenas en Java son inmutables, lo que significa que una vez creadas,
		 *    su contenido no se puede cambiar. 
		 *    Cuando intentas modificar una cadena o reasignar una variable de tipo
		 *     String, Java simplemente crea una nueva instancia de cadena en lugar 
		 *     de alterar la existente.
		 */

	}

}
