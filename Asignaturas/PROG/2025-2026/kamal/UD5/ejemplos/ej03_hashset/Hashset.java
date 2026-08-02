package ej03_hashset;

import java.util.HashSet;
import java.util.Iterator;

public class Hashset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<Integer> conjunto=new HashSet<>();
		
		//int n=10;
		//if (!conjunto.add(n)) System.out.println("Número ya en la lista.");
		int val=0;
		for (int i=0;i<10;i++) {
			val = (int)(Math.random()*10 +1);
			if(!conjunto.add(val)) System.out.println("Número"+ val +" ya en la lista.");
		}     
	
		Iterator<Integer> I = conjunto.iterator();
		while(I.hasNext())
			System.out.println("ITE: " +I.next());
		
		for (Integer i: conjunto) { 
				System.out.println("Elemento almacenado:"+i); 
		}

	}

}
