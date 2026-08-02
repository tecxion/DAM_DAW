package ej07_List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Collections;

public class Listas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LinkedList<Integer> t=new LinkedList<Integer>(); // Declaración y creación del LinkedList de enteros.

		t.add(15); // Añade un elemento al final de la lista.

		t.add(52); // Añade otro elemento al final de la lista.

		t.set(t.indexOf(52),2); 

		t.add(t.get(0)+t.get(1)); // Suma los valores contenidos en la posición 1 y 2, y lo agrega al final.

		//t.remove(0); // Elimina el primer elementos de la lista.

		for (Integer i: t) System.out.println("Elemento LinkedList:" + i); // Muestra la lista.  
		//for (int i=0; i<t.size();i++) System.out.println("Elemento LinkedList:" + t.get(i)); // Muestra la lista.  
		//Ordenación de la lista
		Collections.sort(t);
		System.out.println("Lista Ordenada");
		for (Integer i: t) System.out.println("Elemento LinkedList:" + i); // Muestra la lista.  
		
		
		ArrayList<Integer> al=new ArrayList<Integer>(); // Declaración y creación del ArrayList de enteros.

		al.add(15); al.add(5); al.add(11); al.add(9); // Añadimos dos elementos a la lista.

		al.set(al.indexOf(11), 12); 
		
		for (Integer i: al) System.out.println("Elemento ArrayList:" + i); // Muestra la lista.
		
		//ordenación de la lista
		//Collections.sort(al);
		
		//Ordenamos la lista en orden inverso
		al.sort(Collections.reverseOrder());
		System.out.println("Lista Ordenada");
		for (Integer i: al) System.out.println("Elemento ArrayList:" + i); // Muestra la lista.
	}

}
