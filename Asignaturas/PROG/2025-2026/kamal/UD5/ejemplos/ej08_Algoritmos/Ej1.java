package ej08_Algoritmos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
public class Ej1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Con arrays
		Integer[] array={10,9,99,3,5};
		
		System.out.println("Antes de ordenar");
		for(int i : array) {
			System.out.println("valor: " + i);
		}
		//Ordenar el array mediante el método sort de la clase Arrays.
		Arrays.sort(array);
		
		System.out.println("Después de ordenar");
		for(int i : array) {
			System.out.println("valor: " + i);
		}
		//orden inverso
		Arrays.sort(array, Collections.reverseOrder());
		System.out.println("Después de ordenar inverso");
		for(int i : array) {
			System.out.println("valor: " + i);
		}
		
		//Convetir array a lista
		List <Integer> enLista =   Arrays.asList(array);
		System.out.println("El primero de la lista: "+enLista.getFirst());
		for (Integer i : enLista) System.out.println("En Lista: " + i);
		//Esto no está permitido en la Lista genérica: enLista.add(5);
		
		//Con ArrayList
		ArrayList<Integer> lista=new ArrayList<Integer>();
		lista.add(10); lista.add(9); lista.add(99); lista.add(3); lista.add(5);
		
		//Ordenamos la lista
		Collections.sort(lista);
		System.out.println("ArrayList Después de ordenar");
		for(int i : lista) {
			System.out.println("valor: " + i);
		}
		        
	    // Ordenar en orden descendente: 
	     Collections.sort(lista, Collections.reverseOrder());
	   
	     //Ordenar creando un comparador personalizado:    
	     // Lista de ejemplo
	        List<Integer> numeros = new ArrayList<>(Arrays.asList(5, 1, 4, 3, 2));
	        System.out.println("Lista original: " + numeros);
	        System.out.println("Lista ordenada en orden descendente: " + lista);
	        // Ordenar en orden descendente usando un Comparator personalizado
	        Collections.sort(numeros, new Comparator<Integer>() {
	            @Override
	            public int compare(Integer a, Integer b) {
	                // Comparar b con a para invertir el orden (de mayor a menor)
	                return b.compareTo(a);
	            }
	        });
	        System.out.println("Lista ordenada descendente (Comparator personalizado): " + numeros);
	    
		
		//barajamos la lista (desordenar)
		Collections.shuffle(lista);
		System.out.println("ArrayList Después de desordenar");
		for(int i : lista) {
			System.out.println("valor: " + i);
		}
		System.out.println("Máx: "+Collections.max(lista));
		//Convertimos la lista en array
		Integer[] enArray=new Integer[lista.size()];

		lista.toArray(enArray);
	
		
	}

}
