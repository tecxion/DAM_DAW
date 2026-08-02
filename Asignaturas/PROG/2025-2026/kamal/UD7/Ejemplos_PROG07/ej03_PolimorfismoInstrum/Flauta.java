package ej03_PolimorfismoInstrum;


/**
 *
 * Clase Flauta
 */
public class Flauta extends Instrumento {
    
    @Override
    public void tocarNota (String nota) {
        System.out.printf ("Flauta: tocar nota %s.\n", nota); 
    }
        
}
