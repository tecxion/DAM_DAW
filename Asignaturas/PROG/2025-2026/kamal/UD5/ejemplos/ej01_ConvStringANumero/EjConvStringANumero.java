/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej01_ConvStringANumero;

import javax.swing.JOptionPane;

/**
 *
 * @author carlosgonzalez
 */
public class EjConvStringANumero {

     boolean operacionCancelada;

    /**
     * Constructor de la clase.
     */
    public EjConvStringANumero() {
        setOperacionCancelada(false);
    }

    /**
     * Método que permite comprobar si la última operación tipo Pedir ha sido
     * cancelada.
     * @return true si la última operación realizada ha sido cancelada, false
     * en otro caso.
     */
    public boolean isOperacionCancelada() {
        return operacionCancelada;
    }

    /**
     * Método que permite cambiar el estado de la variable privada
     * operacionCancelada. Este método es privado y solo debe usarse desde
     * un método propio de esta clase.
     * @param operacionCancelada True o false, el nuevo estado para la variable.
     */
    private void setOperacionCancelada(boolean operacionCancelada) {
        this.operacionCancelada = operacionCancelada;
    }    

    /**
     * Clase que pide al usuario que introduzca un número. El número esperado
     * es un número de doble precisión, en cualquiera de sus formatos. Admitirá
     * números como: 2E10 (2*10^10); 2,45; etc.
     * @param titulo
     * @param mensaje
     * @return
     */
    public double PedirNumeroDouble(String titulo, String mensaje) {
        double d = 0;
        setOperacionCancelada(false);
        boolean NumeroValido = false;
        do {

            String s = (String) JOptionPane.showInputDialog(null, mensaje,
                    titulo, JOptionPane.PLAIN_MESSAGE, null, null, "");

            if (s != null) {
                try {
                    d = Double.valueOf(s).doubleValue();
                    NumeroValido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El número introducido no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else { NumeroValido=true; // Cancelado
                   setOperacionCancelada(true);
            }
        } while (!NumeroValido);
        return d;
    }

    /**
     * Clase que pide al usuario que introduzca un número. El número esperado
     * es un número de precisión sencilla, en cualquiera de sus formatos.
     * @param titulo
     * @param mensaje
     * @return
     */
    public float PedirNumeroFloat (String titulo, String mensaje) {
        float d = 0;
        setOperacionCancelada(false);
        boolean NumeroValido = false;
        do {

            String s = (String) JOptionPane.showInputDialog(null, mensaje,
                    titulo, JOptionPane.PLAIN_MESSAGE, null, null, "");

            if (s != null) {
                try {
                    d = Float.valueOf(s).floatValue();
                    NumeroValido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El número introducido no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else { NumeroValido=true; // Cancelado
                   setOperacionCancelada(true);
            }
        } while (!NumeroValido);
        return d;
    }

    /**
     * Clase que pide al usuario que introduzca un número. El número esperado
     * es un número entero.
     * @param titulo
     * @param mensaje
     * @return
     */
    public int PedirNumeroInteger (String titulo, String mensaje) {
        int d = 0;
        setOperacionCancelada(false);
        boolean NumeroValido = false;
        do {

            String s = (String) JOptionPane.showInputDialog(null, mensaje,
                    titulo, JOptionPane.PLAIN_MESSAGE, null, null, "");

            if (s != null) {
                try {
                    //d = Integer.valueOf(s).intValue();
                    d = Integer.parseInt(s);
                    NumeroValido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El número introducido no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else { NumeroValido=true; // Cancelado
                   setOperacionCancelada(true);
            }
        } while (!NumeroValido);
        return d;
    }

    /**
     * Clase que pide al usuario que introduzca un número. El número esperado
     * es un número entero.
     * @param titulo
     * @param mensaje
     * @return
     */
    public long PedirNumeroLong (String titulo, String mensaje) {
        long d = 0;
        setOperacionCancelada(false);
        boolean NumeroValido = false;
        do {

            String s = (String) JOptionPane.showInputDialog(null, mensaje,
                    titulo, JOptionPane.PLAIN_MESSAGE, null, null, "");

            if (s != null) {
                try {
                    d = Long.valueOf(s).longValue();
                    NumeroValido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El número introducido no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else { NumeroValido=true; // Cancelado
                   setOperacionCancelada(true);
            }
        } while (!NumeroValido);
        return d;
    }

     /**
     * Clase que pide al usuario que introduzca un número. El número esperado
     * es un número entero corto.
     * @param titulo
     * @param mensaje
     * @return
     */
    public short PedirNumeroShort (String titulo, String mensaje) {
        short d = 0;
        setOperacionCancelada(false);
        boolean NumeroValido = false;
        do {

            String s = (String) JOptionPane.showInputDialog(null, mensaje,
                    titulo, JOptionPane.PLAIN_MESSAGE, null, null, "");

            if (s != null) {
                try {
                    d = Short.valueOf(s).shortValue();
                    NumeroValido = true;
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "El número introducido no es válido.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else { NumeroValido=true; // Cancelado
                   setOperacionCancelada(true);
            }
        } while (!NumeroValido);
        return d;
    }
    
}
