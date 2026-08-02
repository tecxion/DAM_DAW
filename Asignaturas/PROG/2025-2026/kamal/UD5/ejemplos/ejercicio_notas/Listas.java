package ej07_List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;

public class Listas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		
		//mejor List<Integer> al=new ArrayList<>();
		ArrayList<Integer> listaenteros = new ArrayList<Integer>();
		
		 List<Integer> al2=new ArrayList<>();
		 al2.add(4);
		 al2.add(5);
		 //para borrar un elemento tipo entero así, si ponermos 5 intenta borrar el del indice 5 da error
		 al2.remove(0);
		 al2.remove(Integer.valueOf(5));
		 al2.add(5);
		 if(al2.isEmpty())
			 System.out.println("Lista vacía");
		 else
			 for( Integer i: al2)
				 System.out.println("Al2 " +i);
		 //otro ejemplo
		 List<String> lista = new ArrayList<>();
		 lista.add("Ana");
		 lista.add("Luis");
		 lista.add("María");
		 lista.add(1, "Pedro");
		 lista.remove(2); //borra el que hay en el indice 2 
		 lista.remove("Ana"); //borra "Ana"
		 lista.size();       // número de elementos
		 lista.isEmpty();    // ¿está vacía?
		 lista.contains("Ana"); 
		 lista.clear();      // vacía la lista

		 
		 for (Integer i: al2) System.out.println("Elemento ArrayList:" + i); // Muestra la lista.
		
		 List<Integer> al=new ArrayList<>(); // Declaración y creación del ArrayList de enteros.

		al.add(15); al.add(5); al.add(11); al.add(9); // Añadimos dos elementos a la lista.

		al.set(al.indexOf(11), 12); 
		
		for (Integer i: al) System.out.println("Elemento ArrayList:" + i); // Muestra la lista.
		
		//ordenación de la lista
		Collections.sort(al);
		System.out.println("Lista Ordenada");
		for (Integer i: al) System.out.println("Elemento ArrayList:" + i); // Muestra la lista.
		//Ordenamos la lista en orden inverso
		al.sort(Collections.reverseOrder());
		System.out.println("Lista Ordenada inversa");
		for (Integer i: al) System.out.println("Elemento ArrayList:" + i); // Muestra la lista.
	}

}
