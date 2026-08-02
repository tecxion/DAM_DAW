package Gestion_Empleados;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Utilidades para validar la informacion que se introduce.
public class Utilidades {

	public static Scanner sc = new Scanner(System.in);

	// Utilidades para validar informacion que introduce el usuario.

	// Regex para validar codigo de dispositivo.
	public static boolean validarStringNumerosYLetrasInsensibleMayus(String string) {
		// Evitamos null pointer exception..si viene nulo.
		if (string == null || string.isEmpty())
			return false;
		// Evitamos espacios al principio y al final.
		string = string.trim();
		/*
		 * Explicacion breve.. ^ indica el comienzo del String. Luego entre corchetes va
		 * el patron de caracteres aceptados es sensible a mayusculas, minusculas. +
		 * Indica minimo 1 vez. $ indica fin de String. Agrego acentos porque fallan xd:
		 * áéíóúÁÉÍÓÚñÑ Fuente:
		 * https://es.stackoverflow.com/questions/431121/como-puedo-agregarle-una-coma-a
		 * -una-expresi%C3%B3n-delimitadora-de-caracteres
		 */
		Pattern patronRegex = Pattern.compile("^[a-zA-Z0-9áéíóúÁÉÍÓÚñÑ ]+$");
		Matcher comprobadorRegex = patronRegex.matcher(string);
		return comprobadorRegex.matches();
	}

	public static boolean validarStringSoloLetras(String string) {
		/*
		 * Explicacion breve.. ^ indica el comienzo del String. Luego entre corchetes va
		 * el patron de caracteres aceptados es sensible a mayusculas, minusculas. +
		 * Indica minimo 1 vez. $ indica fin de String. Fuente de los acentos:
		 * https://es.stackoverflow.com/questions/431121/como-puedo-agregarle-una-coma-a
		 * -una-expresi%C3%B3n-delimitadora-de-caracteres
		 */
		// Evitamos null pointer exception..si viene nulo.
		if (string == null || string.isEmpty())
			return false;
		// Evitamos espacios al principio y al final.
		string = string.trim();
		Pattern patronRegex = Pattern.compile("^[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+$");
		Matcher comprobadorRegex = patronRegex.matcher(string);
		return comprobadorRegex.matches();
	}

	public static int leerInteger() {
		int numObtenido = 0;
		boolean lecturaIntegerValida = false;
		while (!lecturaIntegerValida) {
			try {
				numObtenido = Integer.parseInt(sc.nextLine());
				lecturaIntegerValida = true;
			} catch (Exception e) {
				System.out.println("Error al intentar leer el valor numerico.\nError: " + e);
				System.out.print("Dime una entrada valida [int]: ");
				lecturaIntegerValida = false;
			}
		}
		return numObtenido;
	}

	public static double leerDouble() {
		double numObtenido = 0.0;
		boolean lecturaDoubleValida = false;
		while (!lecturaDoubleValida) {
			try {
				numObtenido = Double.parseDouble(sc.nextLine());
				lecturaDoubleValida = true;
			} catch (Exception e) {
				System.out.println("Error al intentar leer el valor double.\nError: " + e);
				System.out.print("Dime una Nº double valido [Double]: ");
				lecturaDoubleValida = false;
			}
		}
		return numObtenido;
	}

	public static void pausarInteracion() {
		System.out.print("Pulsa intro para continuar....");
		sc.nextLine();
	}

	public static String leerStringValida(String complementoMensaje) {
		String stringLeida = sc.nextLine();
		while (Utilidades.validarStringNumerosYLetrasInsensibleMayus(stringLeida) == false) {
			System.out.println("El " + complementoMensaje + " introducido no es valido.");
			System.out.print("Dime un " + complementoMensaje + " valido [a-zA-Z0-9]: ");
			stringLeida = sc.nextLine();
		}
		return stringLeida;
	}

	public static String leerStringValidaSoloLetras(String complementoMensaje) {
		String stringLeida = sc.nextLine();
		while (Utilidades.validarStringSoloLetras(stringLeida) == false) {
			System.out.println("El " + complementoMensaje + " introducido no es valido.");
			System.out.print("Dime un " + complementoMensaje + " valido [a-zA-Z]: ");
			stringLeida = sc.nextLine();
		}
		return stringLeida;
	}

	public static void imprimirTituloPrograma() {
		System.out.println("------ Programa de Gestion de Empleados de la Empresa FPD Rioja ------");
	}

	public static void imprimirSubTituloPrograma(String nombreSubmenu) {
		Utilidades.imprimirTituloPrograma();
		System.out.println("------ " + nombreSubmenu + " ------");

	}

}