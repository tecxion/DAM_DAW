package ej04_OperadoresAritmeticos;

/*
 * operadoresaritmeticos.java
 * Programa que muestra el uso de los operadores aritméticos
 */

/**
 *
 * @author FMA
 */
public class operadoresaritmeticos {
    public static void main(String[] args) {
    	short x = 7;
        int y = 5;
        float f1 = 13.5f;
        float f2 = 8f;
        System.out.println("El valor de x es " + x + ", y es " + y);
        System.out.println("El resultado de x + y es " + (x + y));
        System.out.println("El resultado de x - y es " + (x - y));
        System.out.printf("%s\n%s%s\n","División entera:","x / y = ",(x/y));
        System.out.println("Resto de la división entera: x % y = " + (x % y));
        System.out.println("El valor de f1 es " + f1 + ", f2 es " + f2);
        System.out.println("El resultado de f1 / f2 es " + (f1 / f2));
        //ejemplo para saber cuantos contenedores podemos llenar y lo que sobra
        int num = 8000;
        int capacidad = 255;
        int llenos = num / capacidad;
        int sobran = num % capacidad;
   
        System.out.printf("con %d elementos llenamos %d contenedores y sobran %d elementos. Con contenedores de %d elementos de capacidad%n",num, llenos, sobran, capacidad);
        
        System.out.printf("Operación con números enteros %.3f%n", 5.55555555);
        
        System.out.print("******************************\n");
        
        //seleccionar cifras de un número
        int n = 34567;
        System.out.println(n/10);
        System.out.println(n%10);
    } // fin de main
} // fin de la clase operadoresaritmeticos
