package contenidos_array_cadenas;

import java.text.DecimalFormat;

import javax.swing.plaf.FontUIResource;

public class Cadenas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		String cadena = "Bienvenido";
		
		System.out.println("Longitud: "+ cadena.length());
		System.out.println("Primer caracter: "+ cadena.charAt(0));
		
		
		String numero = Integer.toString(5);
		System.out.println("Número: "+ numero);
		
		System.out.println(cadena.substring(0,5));
		System.out.println(cadena.substring(2));
		
		System.out.println("A "+5f*3);
		System.out.println("A "+5d/5.5);
		
		//cuidado con el operador '+' es necesario utilizar paréntesis
		System.out.println("A "+5d + 5.5);
		System.out.println("A "+(5d+5.5));
		
		String c = "45.67";
		double n;
		try {  

		     n=Double.valueOf(c).doubleValue();
		     System.out.println( n*2);

		} catch (NumberFormatException e) {
			System.out.println("Ha sido imposible convertir el valor");
		}
		
		float precio = 3.3f;
		String salida = String.format("El precio es: %.2f €", precio);
		System.out.println(salida);
		
		
		StringBuilder sb = new StringBuilder();
		sb.append("!");
		sb.append(4);
		sb.append('¡');
		DecimalFormat f = new DecimalFormat("0.00");
		Double num = 5.56789;
		sb.append(f.format(num));
		System.out.println(sb);
		System.out.println(sb.toString());
		
		
		//entre cadenas y arrays
		String cadena2="hola esto es una cadena";
		String[] palabras = cadena2.split(" ");
		String res = String.join("-", palabras);
		System.out.println(res);
		
		String frase= "Hola clase de Informática";
		
		String []p = frase.split(" ");
		
		for (int i = 0; i<p.length ; i++)
			System.out.print(p[i]+ " ");
		
		System.out.print("\n");
		
		for (int i =p.length-1 ; i>=0 ; i--)
			System.out.print(p[i]+ " ");
		
		String v = String.join(" ", p);
		System.out.print("\n");
		System.out.print(v);
	}

}