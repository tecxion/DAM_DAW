package ej02_Tipos;

/*
 * ejemplotipos.java
 * Programa que crea variables de distintos tipos primitivos
 * y los muestra por pantalla
 *
 */
/**
 *
 * @author FMA
 */
public class ejemplotipos {

	// el método main inicia la ejecución de la aplicación
		public static void main(String[] args) {
			// Código de la aplicación
			int i = 10;
			float f = 3.14f;
			double d = 3.14;
			char c1 = 'a';
			char c2 = 65;
			boolean encontrado = true;
			String msj = "Bienvenido a Java";

			boolean a = msj.contains("en");
			String letra = String.valueOf(c1);
			
			System.out.println("Letra: "+ letra);
			System.out.println("hola " + c2);
			System.out.println("contiene a " + a);
			int numeroAleatorio = (int) (Math.random() * 25 + 1);
			System.out.println("El número aleatorio entre 1 y 25 es: " + numeroAleatorio);

			System.out.printf("La variable i es de tipo entero y su valor es: %06d\n", i);
			System.out.println("La variable f es de tipo float y su valor es: "+f);
			System.out.println("La variable d es de tipo double y su valor es: " + d);
			System.out.println("La variable c1 es de tipo carácter y su valor es: " + c1);
			System.out.println("La variable c2 es de tipo carácter y su valor es: " + c2);
			System.out.println("La variable encontrado es de tipo booleano y su valor es: " + encontrado);
			System.out.println("La variable msj es de tipo String y su valor es: " + msj);
			// se puede ver el valor entero de char

			System.out.printf("el valor de c1 es: %c %d y el de c2 es: %c  %d", c1, (int) c1, c2, (int) c2);
			for (int j = 65; j <= 122; j++) {
				System.out.printf("\nel valor de %c  es %d ", (char) j, j);
			}
		} // fin del método main

} // fin de la clase ejemplotipos
