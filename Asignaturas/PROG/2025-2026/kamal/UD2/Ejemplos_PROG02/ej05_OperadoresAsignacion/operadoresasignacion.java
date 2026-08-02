package ej05_OperadoresAsignacion;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FMA
 */
public class operadoresasignacion {
  
    // clase principal main que inicia la aplicación
    public static void main(String[] args) {
        int x;
        int y;
        x = 5;  // operador asignación
        y = 3;  // operador asignación

        //operadores de asignación combinados
        System.out.printf("El valor de x es %d y el valor de y es %d\n", x,y);
        x += y;
        // podemos utilizar indistintamente printf o println
        System.out.println(" Suma combinada: x += y " + " ............ x vale " + x);
        x = 5;
        x -= y;
        System.out.println(" Resta combinada: x -= y " + " ........... x vale " + x);
        x = 5;
        x *= y;
        System.out.println(" Producto combinado: x *= y " + " ........ x vale " + x);
        x = 5;
        x /= y;
        System.out.println(" Division combinada: x /= y " + " ........ x vale " + x);
        x = 5;
        x %= y;
        System.out.println(" Resto combinada: x %= y " + " ........... x vale " + x);
    } // fin main
} // fin operadoresasignacion
