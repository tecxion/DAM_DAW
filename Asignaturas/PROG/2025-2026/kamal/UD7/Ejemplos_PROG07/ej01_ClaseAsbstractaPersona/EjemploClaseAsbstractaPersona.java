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
public class EjemploClaseAsbstractaPersona {

     /**
     *  Ejemplo de uso de clases abstractas y métodos abstractos
     */
    public static void main(String[] args) {
        // Declaración de objetos de las clases Persona, Profesor y Alumno
        Persona pers1, pers2;
        Alumno al1, al2;
        Profesor prof1, prof2;
        
        //pers1= new Persona (); // Error: una clase abstracta no puede ser instanciada
        
        al1= new Alumno ("Juan", "Torres", new GregorianCalendar (1990, 10, 6), "1DAM-B", 7.5);
        
        prof1= new Profesor  ("Antonio", "Campos", new GregorianCalendar (1970, 8, 15), "Electricidad", 2000);
        
        // Llamada a métodos abstractos en la clase Persona
        // Pero heredados y definidos en las clases Profesor y en Alummno
        al1.mostrar();      
        prof1.mostrar();
    }
    
}
