package ej05_TreeSet.copy;


import java.util.SequencedSet;
import java.util.TreeSet;

public class Treeset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeSet<Integer> conjunto=new TreeSet<>();
		SequencedSet<Integer> conjunto2;
	
		
		//int n=10;
		//if (!conjunto.add(n)) System.out.println("Número ya en la lista.");
		//int val;
		int val;
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
	//	conjunto.removeAll(conjunto2);
		System.out.println();
		for (Integer i: conjunto) { 

			System.out.println("Elemento almacenado:"+i); 

		}
	}

}
