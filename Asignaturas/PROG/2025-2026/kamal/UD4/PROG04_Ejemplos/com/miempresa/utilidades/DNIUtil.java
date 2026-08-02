package com.miempresa.utilidades;

public class DNIUtil {

    private static final String LETRAS_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";

    // Calcula la letra a partir del número
    public static char calcularLetra(int dni) {
        return LETRAS_DNI.charAt(dni % 23);
    }

    // Devuelve el NIF completo (número + letra)
    public static String generarNIF(int dni) {
        return dni + String.valueOf(calcularLetra(dni));
    }

    // Comprueba si un NIF es válido
    public static boolean validarNIF(String nif) {

        if (nif == null || nif.length() < 8 || nif.length() > 9) {
            return false;
        }

        try {
            int numero = Integer.parseInt(nif.substring(0, nif.length() - 1));
            char letraLeida = nif.charAt(nif.length() - 1);
            char letraCalculada = calcularLetra(numero);

            return letraLeida == letraCalculada;

        } catch (NumberFormatException e) {
            return false;
        }
    }
}
