/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej01_ClaseAsbstractaPersona;

import java.util.GregorianCalendar;

/**
 *
 * @author 
 */
public abstract class Persona {
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

        // Métodos abstractos
        
        // Método mostrar
        protected abstract void mostrar (); // No se define: es abstracto. Ya lo harán sus subclases.
        
    
}
