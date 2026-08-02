/*
 * Clase Alumno.
 */
package ej02_InterfazImprimible;
import java.util.*;
import java.text.*;

/**
 *
 * Clase Alumno
 */
public class Alumno extends Persona  {
        protected String grupo;
        protected double notaMedia; 
    
        
        // Constructor
        // -----------
        public Alumno (String nombre, String apellidos, GregorianCalendar fechaNacim, String grupo, double notaMedia) {
            super (nombre, apellidos, fechaNacim);
            this.grupo= grupo;
            this.notaMedia= notaMedia;            
        }
        
        // Métodos get
        // ------------
        
        // Método getGrupo
        public String getGrupo (){
            return grupo;
        }

        // Método getNotaMedia
        public double getNotaMedia (){
            return notaMedia;
        }

        // Métodos set
        // -----------

        // Método setGrupo
        public void setGrupo (String grupo){
            this.grupo= grupo;
        }
        
        // Método setNotaMedia
        public void setNotaMedia (double notaMedia){
            this.notaMedia= notaMedia;
        }
        
        // Redefinición de los métodos de la interfaz Imprimible
        // -------------------------------------------------------
               
        // Método devolverContenidoString
        @Override
        public String devolverContenidoString () {
            // Aprovechamos el método estático para transformar una Hashtable en String
            String contenido= super.devolverContenidoString();
            
            //Eliminamos el último carácter, que contiene una llave de cierre.
            contenido=contenido.substring(0, contenido.length()-1);
            
            contenido =contenido + ", " + this.grupo + ", " + this.notaMedia + "}";
            // Devolvemos el String creado.
            return contenido;
        }

        
        
}

