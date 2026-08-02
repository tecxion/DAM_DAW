package ej03_TiposEnumerados;

/*
 * tiposenumerados.java
 * Ejemplo de Tipos enumerados
 */

/**
 *
 * @author FMA
 */
public class tiposenumerados {
    public enum Dias {Lunes, Martes, Miercoles, Jueves, Viernes, Sabado, Domingo};
    
    public static void main(String[] args) {
    	 // codigo de la aplicacion
        Dias diaactual = Dias.Martes;
        Dias diasiguiente = Dias.Miercoles;
        //se puede crear un array del tipo enumerado para obtener todos sus elementos
        Dias [] d = Dias.values();
        System.out.println("El tercer día es: " +d[2]);
       
        System.out.print("Hoy es: ");
        System.out.println(diaactual);
        System.out.println("Mañana\nes\n"+diasiguiente);
        
        System.out.print("Hoy es el día " + diaactual.ordinal() + " de la semana");
        System.out.println();
        //SE puede recorrer la enumeración así:
       for(Dias e : Dias.values()) {
    	   
    	   System.out.print(e+ " ");
    	   
       }
        
        
          
    
    } // fin main

} // fin tiposenumerados
