
package ej03_PolimorfismoInstrum;

/**
 *
 * Clase Piano
 */
public class Piano extends Instrumento {

    @Override
    public void tocarNota (String nota) {
        System.out.printf ("Piano: tocar nota %s.\n", nota); 
    }
}
