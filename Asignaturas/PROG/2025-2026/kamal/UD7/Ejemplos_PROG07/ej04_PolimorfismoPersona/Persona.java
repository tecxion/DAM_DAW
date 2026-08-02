/*
 * Clase Persona
 */
package ej04_PolimorfismoPersona;

import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;
/**
 * Clase Persona
 */
public abstract class Persona implements Imprimible {
        protected String nombre;
        protected String apellidos;
        protected GregorianCalendar fechaNacim;

        // Constructores
        // -------------
                
        // Constructor
        public Persona (String nombre, String apellidos, GregorianCalendar fechaNacim) {           
            this.nombre= nombre;
            this.apellidos= apellidos;
            this.fechaNacim= (GregorianCalendar) fechaNacim.clone();
        }
        
        // Métodos get
        // -------------
        
        // Método getNombre
        protected String getNombre (){
            return nombre;
        }
        
        // Método getApellidos
        protected String getApellidos (){
            return apellidos;
        }
        
        // Método getFechaNacim
        protected GregorianCalendar getFechaNacim (){
            return this.fechaNacim;
        }

        // Métodos set
        // -------------

        // Método setNombre
        protected void setNombre (String nombre){
            this.nombre= nombre;
        }
        
        // Método setApellidos
        protected void setApellidos (String apellidos){
            this.apellidos= apellidos;
        }
        
        // Método setFechaNacim
        protected void setFechaNacim (GregorianCalendar fechaNacim){
            this.fechaNacim= fechaNacim;
        }       
                
        // Implementación de los métodos de la interfaz Imprimible
        // -------------------------------------------------------
        

        // Método devolverContenidoString 
        @Override
        public String devolverContenidoString () {
            
            SimpleDateFormat formattedDate = new SimpleDateFormat("dd-MMM-yyyy"); 
            
            String dateFormatted = formattedDate.format(this.fechaNacim.getTime()); 
            
            String contenido= "{" + this.nombre + ", " + this.apellidos + ", " + dateFormatted + "}";
            return contenido;
        }        
        
        // Métodos estáticos (herramientas)
        // --------------------------------       
        
}

