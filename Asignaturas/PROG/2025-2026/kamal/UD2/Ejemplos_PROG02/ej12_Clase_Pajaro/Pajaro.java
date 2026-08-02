/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ej12_Clase_Pajaro;

/**
 *
 * @author FMA
 */
public class Pajaro {

        String nombre;
    int posX, posY;

    public Pajaro() {

    }

    public Pajaro(String nombre, int posX, int posY) {
        this.nombre=nombre;
        this.posX=posX;
        this.posY=posY;
    }
    double volar (int posX, int posY) {

        double desplazamiento = Math.sqrt( posX*posX + posY*posY );
        this.posX = posX;
        this.posY = posY;

        return desplazamiento;
    }

    public static void main(String[] args) {

       Pajaro loro = new Pajaro("Lucy",50,50) ;
       double d = loro.volar(50,50);
       System.out.println("El desplazamiento ha sido " + d);
       System.out.printf("El desplazamiento ha sido %.2f", d);
    }
    
}
