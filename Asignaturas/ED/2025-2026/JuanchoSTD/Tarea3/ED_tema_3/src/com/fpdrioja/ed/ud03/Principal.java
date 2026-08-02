package com.fpdrioja.ed.ud03;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Introduce cadena donde se buscará");
		String str = s.nextLine();
		System.out.println("Introduce cadena de busqueda");
		String word = s.nextLine();

		String resultado = wordEnds(str, word);
		System.out.println(resultado);

	}

	/*
	 * Dados dos parámetros (1)una cadena (la llamaremos "str") y (2)una cadena NO
	 * vacía (la llamaremos "word"); la función devolverá una cadena compuesta del
	 * caracter que aparece justo antes y justo después de cada aparición de "word"
	 * en "str". Se deben ignorar aquellos casos donde no hay caracter antes o
	 * después. En caso de que estén duplicados, se añadirán dos veces. En caso de que
	 * str o word estén vacios se devolverá una cadena vacía. 
	 * 
	 * Ejemplos: 
	 * wordEnds("abcXY123XYijk", "XY") → "c13i" 
	 * wordEnds("XY123XY", "XY") → "13" 
	 * wordEnds("XY1XY", "XY") → "11"
	 */

	public static String wordEnds(String str, String word) {
		StringBuffer result = new StringBuffer();

		if (!word.trim().isEmpty()) {
			int i = 0;

			if (str.length() >= word.length() + 1 && str.substring(0, word.length()).equals(word)) {
				i = word.length() - 1;
				result.append(str.charAt(i + 1));
			}

			while (i < str.length() - word.length()) {
				if (str.substring(i + 1, i + 1 + word.length()).equals(word)) {
					result.append(str.charAt(i));
					i = i + word.length();
					if (i < str.length() - 1) {
						result.append(str.charAt(i + 1));
					}
				} else {
					i++;
				}
			}
		}else {
			result.append("");
		}

		return result.toString().trim();
	}

}