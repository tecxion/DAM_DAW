package com.miempresa.aplicacion;

import com.miempresa.utilidades.MetodosUtilitarios;
import com.miempresa.utilidades.DNIUtil;

public class Main {
    public static void main(String[] args) {
        MetodosUtilitarios.mostrarMensaje("Hola desde otro paquete");
        MetodosUtilitarios.mostrarMensajes(args);
        
        boolean valido = DNIUtil.validarNIF("12345678Z");
        if(valido)
        	System.out.println("El DNI  es válido");
        else
        	System.out.println("El DNI no es válido");

        char letra = DNIUtil.calcularLetra(12345678);

        System.out.println(letra);

    }
}
    