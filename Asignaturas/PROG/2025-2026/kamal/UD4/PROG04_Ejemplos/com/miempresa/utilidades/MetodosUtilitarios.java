package com.miempresa.utilidades;

public class MetodosUtilitarios {
    public static void mostrarMensaje(String mensaje) {
        System.out.println("Mensaje: " + mensaje);
    }
    
    public static void mostrarMensajes(String[] mensaje) {
        
    	for(int i=0;i<mensaje.length;i++)
    		System.out.println("Mensaje: "+i +" "+ mensaje[i]);
    }
    
    
}
    