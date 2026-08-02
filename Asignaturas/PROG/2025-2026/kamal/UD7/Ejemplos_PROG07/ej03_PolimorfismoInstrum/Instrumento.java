
package ej03_PolimorfismoInstrum;

/**
 *
 * Clase Instrumento
 */
public abstract class Instrumento {
    
    public void tocarNota (String nota) {
        System.out.printf ("Instrumento: tocar nota %s.\n", nota); 
    }
    
}
