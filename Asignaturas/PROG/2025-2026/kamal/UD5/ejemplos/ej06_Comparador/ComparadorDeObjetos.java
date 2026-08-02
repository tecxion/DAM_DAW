package ej06_Comparador;

import java.util.Comparator;
import java.util.TreeSet;

class Objeto {

    public int a;

    public int b;

	protected Objeto(int a, int b) {
		super();
		this.a = a;
		this.b = b;
	}
	@Override
	public String toString() {
	
		return "a: " + a + ", b: "+b;
	}
}

class ComparadorDeObjetos implements Comparator<Objeto> {

    public int compare(Objeto o1, Objeto o2) { 
    	
    	 int sumao1=o1.a+o1.b;  int sumao2=o2.a+o2.b;

         if (sumao1>sumao2) return 1; 

         else if (sumao1<sumao2) return -1;

         else return 0;
    }    

    public static void main(String[] args) {
    	
	 
    	TreeSet<Objeto> ts=new TreeSet<Objeto>(new ComparadorDeObjetos());
    	
    	Objeto o1 = new Objeto(3,4);
    	Objeto o2 = new Objeto(1,4);
    	Objeto o3 = new Objeto(6,4);
    	ts.add(o1);
    	ts.add(o2);
    	ts.add(o3);
    
    	
    	for(Objeto o:ts) {
    		System.out.println(o);
    	}
   
    	
    }

    
}

 
	
