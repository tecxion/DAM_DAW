package ej04_LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.SequencedSet;

public class LinkedHashset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedHashSet<Integer> conjunto=new LinkedHashSet<>();
		SequencedSet<Integer> conjunto2;
		
		//int n=10;
		//if (!conjunto.add(n)) System.out.println("Número ya en la lista.");
		int val=0;
		for (int i=0;i<10;i++) {
			val = (int)(Math.random()*10 +1);
			if(!conjunto.add(val)) System.out.println("Número"+ val +" ya en la lista.");
		}     

		
		for (Integer i: conjunto) { 

				System.out.println("Elemento almacenado:"+i); 

		}
		
		System.out.println();
		conjunto2= conjunto.reversed();
		
		for (Integer i: conjunto2) { 

			System.out.println("Elemento almacenado:"+i); 

	}

	}

}
