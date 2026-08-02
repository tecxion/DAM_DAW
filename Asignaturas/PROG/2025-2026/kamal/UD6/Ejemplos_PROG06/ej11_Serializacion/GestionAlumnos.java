package ej11_Serializacion;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class GestionAlumnos {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Alumno> alumnos = new ArrayList<>();
      //al iniciar el programa recuperamos la información 
        Fichero_ArrayList.recuperar(alumnos, "src/ej11_Serializacion/alumnos.dat" );
        
        
        AlmacenAlumnos almacen = new AlmacenAlumnos();
        // al iniciar recuperamos los datos del fichero
        almacen.cargar("src/ej11_Serializacion/alumnos.dat");
        
        int opcion;

        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Añadir alumno");
            System.out.println("2. Mostrar alumnos");
            
            System.out.println("3. Mostrar Media de las notas");
            
            System.out.println("4. Mostrar alumno con mayor nota");
            
            System.out.println("5. Ordenar por nota");
            System.out.println("6. Ordenar por nombre");
            System.out.println("7. Salir");
            System.out.print("Opción: ");

            opcion = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (opcion) {

                case 1:
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    
                    
                    System.out.print("Nota (0-10): ");
                    double nota = sc.nextDouble();

                    if (nota >= 0 && nota <= 10) {
                    	
                        alumnos.add(new Alumno(nombre, dni, nota));
                        
                        if(!almacen.altaAlumno(new Alumno(nombre, dni, nota)))
                        	System.out.println("Alumnmo no añadido, dni duplicado o vacío");
                        	
                        
                        
                        System.out.println("Alumno añadido.");
                    } else {
                        System.out.println("Nota no válida.");
                    }
                    break;

                case 2:
                    if (alumnos.isEmpty()) {
                        System.out.println("No hay alumnos.");
                    } else {
                        for (Alumno a : alumnos) {
                            System.out.println(a);
                        }
                    }
                                    
                    almacen.listarAlumnos();
                                       
                    break;
                    
                case 3:
                	System.out.println("La me dia de las notas es: " +almacen.mediaNotas());
                	break;
                	
                case 4: 
                	System.out.println(almacen.alummnoMasNota());
                	System.out.println(almacen.alummnoMasNota2());
                	break;
                    

                case 5:
               
                   
                	Collections.sort(alumnos, Comparator.comparingDouble(Alumno::getNota));
                   //más actual
                    alumnos.sort(Comparator.comparingDouble(Alumno::getNota));
                    
                    //orden inverso
                    alumnos.sort(Comparator.comparingDouble(Alumno::getNota).reversed());
                    //Primero por nota y si empatan por nombre:
                    alumnos.sort(Comparator.comparingDouble(Alumno::getNota).thenComparing(Alumno::getNombre));
                    
                    
                    System.out.println("Ordenado por nota.");
                                       
                    break;

                case 6:
                    Collections.sort(alumnos, 
                        Comparator.comparing(Alumno::getNombre));
                    System.out.println("Ordenado por nombre.");
                    break;

                case 7:
                    System.out.println("Programa finalizado.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

        } while (opcion != 7);
      //al finalizar el programa escribimos la información 
        Fichero_ArrayList.grabar(alumnos, "src/ej11_Serializacion/alumnos.dat" );
        
     // al salir
        almacen.guardar("src/ej11_Serializacion/alumnos.dat");
        sc.close();
    }
}
