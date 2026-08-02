/*
 * Ejemplo de utilización de clases que implementan la interfaz Imprimible.
 */
package ej02_InterfazImprimible;

import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * Ejemplo de utilización de clases que implementan la interfaz Imprimible
 */
public class EjemploInterfazImprimible {

    /**
     * Clase principal
     */
    public static void main(String[] args) {
        String stringContenidoAlumno, stringContenidoProfesor;
        
        // Creación de objetos alumno y profesor
        Alumno al1= new Alumno ("Juan", "Torres Mula", new GregorianCalendar (1990, 10, 6), "1DAM-B", 7.5);
        Profesor prof1= new Profesor  ("Antonio", "Campos Pin", new GregorianCalendar (1970, 8, 15), "Informática", 2000);
      
        // Obtención del contenido del objeto alumno a través de los métodos del interfaz Imprimible
        stringContenidoAlumno= al1.devolverContenidoString();
        
        // Obtención del contenido del objeto profesor a través de los métodos del interfaz Imprimible
        stringContenidoProfesor= prof1.devolverContenidoString();
                
        // Impresión en pantalla del contenido del objeto alumno a través de las estructuras obtenidas
        System.out.printf ("Contenido del objeto alumno: %s\n", stringContenidoAlumno);
        
        // Impresión en pantalla del contenido del objeto alumno a través de las estructuras obtenidas
        System.out.printf ("Contenido del objeto profesor: %s\n", stringContenidoProfesor);

        
    }
}
