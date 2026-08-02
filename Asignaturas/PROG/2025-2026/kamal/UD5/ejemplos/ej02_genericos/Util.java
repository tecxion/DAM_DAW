package ej02_genericos;

public class Util<T> {

    T t1;

    public void invertir(T[] array) {

        for (int i = 0; i < array.length / 2; i++) {

            t1 = array[i];

            array[i] = array[array.length - i - 1];

            array[array.length - i - 1] = t1;

        }

    }
    
    public static void main(String[] args) {
        // TODO code application logic here
    	
    	Integer[] numeros={0,1,2,3,4,5,6,7,8,9};
    	Double[] num2 = {2.3,2.7, 7.6};
    	String[] cadenas = {"hola", "esto", "es", "una", "cadena"};
    	Util<Integer> u= new Util<Integer>();

    	u.invertir(numeros);

    	for (int i=0;i<numeros.length;i++) 
    		System.out.print( i!=numeros.length-1 ? numeros[i]+", " : numeros[i] );

    	System.out.println();
    	Util<Double> d= new Util<>();
    	
    	d.invertir(num2);
    	for (int i=0;i<num2.length;i++) 
    		System.out.print( i!=num2.length-1 ? num2[i]+", " : num2[i] );
    	
    	System.out.println();
    	Util<String> c = new Util<>();
    	c.invertir(cadenas);
    	for (int i=0;i<cadenas.length;i++) 
    		System.out.print( i!=cadenas.length-1 ? cadenas[i]+", " : cadenas[i] );
    	
    }
}