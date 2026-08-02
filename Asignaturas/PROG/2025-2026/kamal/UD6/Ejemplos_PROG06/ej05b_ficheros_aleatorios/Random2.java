/*
 *  Ejemplo 2: Programa Java para modificar un entero dentro del fichero enteros.dat con acceso aleatorio.
Para ello se pide la posición que ocupa el entero a modificar dentro del fichero, a continuación se lee y
 muestra el valor actual, se pide el nuevo valor y finalmente se escribe el nuevo valor en la posición indicada, 
 modificando de esta forma el valor antiguo por el nuevo.
  */

package ej05b_ficheros_aleatorios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Random2{

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RandomAccessFile fichero = null;
        int pos, numero;
        long size;
        try {
            fichero = new RandomAccessFile("c:\\ficherosJava\\enteros.dat", "rw");                                        

            //calcular cuántos enteros tiene el fichero
            size = fichero.length();
            size = size / 4;
            System.out.println("El fichero tiene " + size + " enteros");

            //Modificar el entero que se encuentra en una posición determinada
            do {
                System.out.println("Introduce una posición (>=1 y <= " + size + "): ");
                pos = sc.nextInt();
            } while (pos < 1 || pos > size);

            pos--;  //la posición 1 realmente es la 0
           
            //nos situamos en la posición (byte de inicio) del entero a modificar
            //en Java un entero ocupa 4 bytes
            fichero.seek(pos*4);

            //leemos y mostramos el valor actual
            System.out.println("Valor actual: " + fichero.readInt());
           
            //pedimos que se introduzca el nuevo valor
            System.out.println("Introduce nuevo valor: ");
            numero = sc.nextInt();

            //nos situamos de nuevo en la posición del entero a modificar
            //esto es necesario porque después de la lectura que hemos realizado para mostrar                     
            //el valor el puntero de lectura/escritura ha avanzado al siguiente entero del fichero.
            //si no hacemos esto escribiremos sobre el siguiente entero
            fichero.seek(pos*4);

            //escribimos el entero
            fichero.writeInt(numero);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}