/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package ej16_EscTeclado;

import javax.swing.* ;
import java.awt.event.* ;
/**
 *
 * @author JJBH
 */
// Definimos la clase que hereda de JFrame
public class EscuchaTeclas extends JFrame {
    // Variables para escribir
    private String linea1 = "", linea2 = "", linea3 = "";
    private JTextArea areaTexto;

    // Constructor de la clase
    public EscuchaTeclas () {
        // Crear objeto JTextArea
        areaTexto = new JTextArea( 10, 15 );
        areaTexto.setText( "Pulsa cualquier tecla del teclado..." );
        areaTexto.setEnabled( false );

        // Añadir al JFrame el objeto areaTexto
        this.getContentPane().add( areaTexto );

        // Crear el objeto oyente de teclas
        OyenteTeclas oyenteTec = new OyenteTeclas() ;

        // Registrar el oyente en el JFrame
        this.addKeyListener(oyenteTec);

    }

    // Implementar la clase oyente que implemente el interface KeyListener
    class OyenteTeclas implements KeyListener{
        // Gestionar evento de pulsación de cualquier tecla
        public void keyPressed( KeyEvent evento )
        {
            linea1 = "Se oprimió tecla: " + evento.getKeyText( evento.getKeyCode() );
            establecerTexto( evento );
        }

        // Gestionar evento de liberación de cualquier tecla
        public void keyReleased( KeyEvent evento )
        {
           linea1 = "Se soltó tecla: " + evento.getKeyText( evento.getKeyCode() );
            establecerTexto( evento );
        }

        // manejar evento de pulsación de una tecla de acción
        public void keyTyped( KeyEvent evento )
         {
          linea1 = "Se escribió tecla: " + evento.getKeyChar();
          establecerTexto( evento );
         }
    }

    // Establecer texto en el componente areaTexto
    private void establecerTexto( KeyEvent evento )
    {
        // getKeyModifiersText devuelve una cadena que indica
        // el modificador de la tecla, por ejemplo Shift
        String temp = evento.getKeyModifiersText( evento.getModifiers() );

        linea2 = "Esta tecla " + ( evento.isActionKey() ? "" : "no " ) +
         "es una tecla de acción";
        linea3 = "Teclas modificadoras oprimidas: " + ( temp.equals( "" ) ? "ninguna" : temp );

        // Establecer texto en el componente areaTexto
        areaTexto.setText( linea1 + "\n" + linea2 + "\n" + linea3 + "\n" );
    }

    public static void main( String args[] )
    {
      // Crear objeto y establecer propidades
      EscuchaTeclas ventana = new EscuchaTeclas();
      ventana.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
      ventana.setTitle("Título de la ventana");
      ventana.setSize( 360, 120 );
      ventana.setVisible(true);
      
    }
}
