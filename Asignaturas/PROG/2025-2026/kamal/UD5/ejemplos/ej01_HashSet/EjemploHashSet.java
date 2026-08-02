package ej01_HashSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.HashSet;
import javax.swing.JOptionPane;

/**
 *
 * @author 
 */
public class EjemploHashSet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        HashSet<Integer> conjunto=new HashSet<>();
        String str;
        do {
            str=JOptionPane.showInputDialog("Introduce un número "+(conjunto.size()+1)+":");
        try {
            Integer n= Integer.parseInt(str);
            if (!conjunto.add(n))
                JOptionPane.showMessageDialog(null, "Número ya en la lista. Debes introducir otro.");
        }
        catch (NumberFormatException e)
                { JOptionPane.showMessageDialog(null,"Número erróneo."); }
        } while (conjunto.size()<5);
        
        // Calcular la suma
        Integer suma=0;
        for (Integer i: conjunto) {
            suma=suma+i;
        }
        JOptionPane.showMessageDialog(null,"La suma es:"+suma);
    }

    
}
