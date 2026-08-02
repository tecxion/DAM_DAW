package ej09_ColeccionesyArrays;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class Ej01Colecciones {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		//Son clases genéricas, indicamos el tipo de objetos que van a almacenar con <tipo>	
	HashSet<String> c = new HashSet<>();
	ArrayList<String> a = new ArrayList<>();
	
	String cadena ="Hola";
	
	//collection HashSet
	c.add(cadena);
	c.add("nueva");
	System.out.println(c.isEmpty());
	System.out.println(c.size());
	//recorremos creando una variable del tipo contenido en el conjunto
	for(String val : c) {
		System.out.println(val);
	}
	//Asignar a un array
	Object[] arr;
	arr = c.toArray();
	for(int i =0; i<arr.length; i++)
		System.out.println(arr[i]);
	
	//list ArrayList 
	a.add(cadena);
	a.add("otra");
	System.out.println(a.isEmpty());
	System.out.println(a.size());
	for(String val : a) {
		System.out.println(val);
	}
	
	//recorrer con iterador
	Iterator<String> it = a.iterator();
	while(it.hasNext()) {
		System.out.println(it.next());
	}
	
	}
	
	
}
