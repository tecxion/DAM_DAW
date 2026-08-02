package ej07_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class GestionNotas {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Double> notas = new ArrayList<>();

       
        for(int i = 0; i<10; i++)
        	notas.add(Math.random()*10);
        	
        notas.add(5.67);
        
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Añadir nota");
            System.out.println("2. Eliminar nota");
            System.out.println("3. Mostrar notas");
            System.out.println("4. Mostrar media");
            System.out.println("5. Ordenar y mostrar");
            System.out.println("6. Salir");
            System.out.print("Elige opción: ");

            
            
            
            
            opcion = sc.nextInt();

            switch (opcion) {

                case 1:
                    System.out.print("Introduce nota (0-10): ");
                    double nota = sc.nextDouble();

                    if (nota >= 0 && nota <= 10) {
                        notas.add(nota);
                        System.out.println("Nota añadida.");
                    } else {
                        System.out.println("Nota no válida.");
                    }
                    break;

                case 2:
                    System.out.print("Introduce nota a eliminar: ");
                    double eliminar = sc.nextDouble();

                    if (notas.remove(Double.valueOf(eliminar))) {
                        System.out.println("Nota eliminada.");
                    } else {
                        System.out.println("La nota no existe.");
                    }
                    break;

                case 3:
                    if (notas.isEmpty()) {
                        System.out.println("No hay notas.");
                    } else {
                        //System.out.println("Notas: " + notas);
                    	System.out.print("Notas: [ ");

                    
                    	for (double i : notas) {
                    	    System.out.printf("%.2f ", i);
 
                    	}

                    	System.out.println("]");
                    }
                    break;

                case 4:
                    mostrar(notas);
                    break;
                case 5:
                	//Collections.sort(notas);
                	notas.sort(null);
                	//orden inverso
                	//Collections.sort(notas, Collections.reverseOrder());
                	//notas.sort(Comparator.reverseOrder());
                	mostrar(notas);
                	break;
                
                case 6:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 6);

        sc.close();
    }
    
    public static void mostrar(List<Double> notas){
    	if (notas.isEmpty()) {
            System.out.println("No hay notas.");
        } else {
            //System.out.println("Notas: " + notas);
        	System.out.print("Notas: [ ");

        
        	for (double i : notas) {
        	    System.out.printf("%.2f ", i);

        	}

        	System.out.println("]");
        }
    	
    }
}
