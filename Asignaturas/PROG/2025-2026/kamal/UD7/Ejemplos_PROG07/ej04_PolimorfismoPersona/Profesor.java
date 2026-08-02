/*
 * Clase Profesor
 */
package ej04_PolimorfismoPersona;

/**

 */
import java.util.*;
import java.text.*;

/**
 *
 * Clase Profesor
 */
public class Profesor extends Persona {
	String especialidad;
	double salario; 
        
        // Constructores
        // -----------

        public Profesor (String nombre, String apellidos, GregorianCalendar fechaNacim, String especialidad, double salario) {
            super (nombre, apellidos, fechaNacim);
            this.especialidad= especialidad;
            this.salario= salario;            
        }
                
        public Profesor (String nombre, String apellidos, GregorianCalendar fechaNacim) {
            super (nombre, apellidos, fechaNacim);
            // Valores por omisión para un profesor: especialidad "GEN" y sueldo de 1000 euros.
            this.especialidad= "GEN";
            this.salario= 1000;                        
        }


        // Métodos get
        // -----------
        
        // Método getEspecialidad
        public String getEspecialidad (){
            return especialidad;
        }

        // Método getSalario
        public double getSalario (){
            return salario;
        }

        // Métodos set
        // -----------

        // Método setSalario
        public void setSalario (double salario){
            this.salario= salario;
        }
        
        // Método setESpecialidad
        public void setESpecialidad (String especialidad){
            this.especialidad= especialidad;
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
            
            contenido=contenido + ", " + this.especialidad + ", " + this.salario + "}";
            // Devolvemos el String creado.
            return contenido;
        }
        
}

