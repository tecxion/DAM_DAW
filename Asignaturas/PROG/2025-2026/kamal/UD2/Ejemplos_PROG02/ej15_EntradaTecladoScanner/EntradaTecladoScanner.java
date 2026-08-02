/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej15_EntradaTecladoScanner;

import java.util.Scanner;

/**
 *
 * @author FMA
 */
public class EntradaTecladoScanner {

     public static void main(String[] args) {
        
        // Creamos objeto teclado
        Scanner teclado = new Scanner(System.in);

        // Declaramos variables a utilizar
        String nombre, ciudad;
        int edad;
        boolean estudias;
        float salario;

        // Entrada de datos
        System.out.println("Nombre: ");
        nombre=teclado.nextLine();
        System.out.println("Edad: ");
        edad=teclado.nextInt();
        /*Cuidado
        //Cuando se usa nextInt() (o cualquier método nextXXX() que no sea
        //nextLine()), el método consume el número pero deja el carácter de 
        //nueva línea (\n) en el buffer de entrada.si leemos con Scanner,
        //los métodos nextline
        ///puedes limpiar el buffer de entrada justo después de cualquier 
        ///llamada a nextInt() (o cualquier otro método nextXXX()).ç
        /// Esto se hace llamando a nextLine() después de nextInt() 
        ///para "consumir" el salto de línea restante en el buffer 
        ///antes de leer la próxima entrada.
         */
        teclado.nextLine();
        System.out.println("Ciudad: ");
        ciudad=teclado.nextLine();
        System.out.println("Estudias: ");
        estudias=teclado.nextBoolean();
        System.out.println("Salario: ");
        salario=teclado.nextFloat();
        
        // Salida de datos
        System.out.println("Bienvenido: " + nombre);
        System.out.println("Tienes: " + edad +" años");
        System.out.println("Ciudad: " + ciudad);
        System.out.println("Estudias: " + estudias);
        System.out.println("Tu salario es: " + salario +" euros");
    }

    
}
