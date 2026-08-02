
import java.util.ArrayList;

import javax.persistence.EntityManagerFactory;

public class Main {

	/// colores de consola:
	/// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_GREEN = "\u001B[32m";
	private static EntityManagerFactory db = ConnectionDB.openConnection();

	public static void main(String[] args) {
		int OpcionMenu = 1;
		Utilidades.imprimirTituloPrograma();
		while (OpcionMenu == 1) {
			OpcionMenu = Main.MenuPrincipal();
		}
		try {
			if (db.isOpen()) {
				db.close();
			}
		} catch (Exception e) {
			System.out.println(ANSI_RED + "ERROR al intentar cerrar la conexion." + ANSI_RESET);
			e.printStackTrace();
		}

	}

	public static int MenuPrincipal() {
		System.out.println("1. Insertar una pelicula.");
		System.out.println("2. Actualizar la duracion de una pelicula.");
		System.out.println("3. Eliminar una pelicula.");
		System.out.println("4. Listar todas las peliculas.");
		System.out.println("5. Listar todas las peliculas por genero.");
		System.out.println("6. Salir.");
		System.out.print("Escoge una opcion: ");
		int opcion = Utilidades.leerInteger();

		switch (opcion) {

		// Agregar pelicula.
		case 1:
			Utilidades.imprimirSubTituloPrograma("Agregar una pelicula nueva");
			Main.agregarPelicula();
			return 1;

		// Actualizar duracion Pelicula por titulo.
		case 2:
			Utilidades.imprimirSubTituloPrograma("Actualizar una pelicula que ya existe.");
			Main.ActualizarDuracionPeliculaPorTitulo();
			return 1;

		// Eliminar una pelicula.
		case 3:
			Utilidades.imprimirSubTituloPrograma("Eliminar una pelicula guardada.");
			Main.EliminarPelicula();
			return 1;

		case 4:
			Utilidades.imprimirSubTituloPrograma("Listar pelicula guardadas.");
			Main.ListarPeliculas();
			return 1;

		case 5:
			Utilidades.imprimirSubTituloPrograma("Listar pelicula por genero.");
			Main.ListarPeliculasPorGenero();
			return 1;

		case 6:
			System.out.println("Saliendo del programa....");
			return 0;

		default:
			System.out.println("Opcion no valida...");
			return 1;
		}

	}

	private static void ListarPeliculasPorGenero() {
		ArrayList<String> generosPelicula = PeliculasDAO.obtenerGeneros(db);
		// Comprobamos que existen generos de peliculas ya que si no tenemos un bucle infinito.
		if (generosPelicula.size()==0) {
			System.out.println(ANSI_RED + "ERROR: No hay generos de peliculas disponibles en BBDD." + ANSI_RESET);
			return;
			
		}
		int contador = 0;
		System.out.println("Escoge el genero que quieres listar:");
		for (String genero : generosPelicula) {
			System.out.println(contador + ". " + genero);
			contador = contador + 1;
		}
		System.out.print("Escoge un genero [int]: ");
		int opcionGenero = Utilidades.leerInteger(generosPelicula.size() - 1, 0);
		String GeneroElegido = generosPelicula.get(opcionGenero);
		ArrayList<Pelicula> listaPelicuasGenero = PeliculasDAO.listarporGenero(GeneroElegido, db);
		pintarPeliculas(listaPelicuasGenero);
		Utilidades.pausarInteracion();

	}

	private static void ListarPeliculas() {
		ArrayList<Pelicula> listaPeliculas = PeliculasDAO.listarTodasLasPeliculas(db);
		pintarPeliculas(listaPeliculas);
		Utilidades.pausarInteracion();
	}

	private static void EliminarPelicula() {
		String titulo = Utilidades.leerStringValida("titulo de pelicula");
		while (!PeliculasDAO.existePelicula(titulo, db)) {
			System.out.println(ANSI_RED + "ERROR: No existe una pelicula con este titulo." + ANSI_RESET);
			titulo = Utilidades.leerStringValida("titulo de pelicula que exista");
		}
		PeliculasDAO.eliminarPelicula(titulo, db);
		Utilidades.pausarInteracion();

	}

	private static void ActualizarDuracionPeliculaPorTitulo() {
		String titulo = Utilidades.leerStringValida("titulo de pelicula");
		while (!PeliculasDAO.existePelicula(titulo, db)) {
			System.out.println(ANSI_RED + "ERROR: No existe una pelicula con este titulo." + ANSI_RESET);
			titulo = Utilidades.leerStringValida("titulo de pelicula que exista");
		}
		int duracion_minutos = Utilidades.leerMinutos();

		PeliculasDAO.actualizarDuracion(titulo, duracion_minutos, db);
		Utilidades.pausarInteracion();
	}

	private static void agregarPelicula() {

		String titulo = Utilidades.leerStringValida("titulo de pelicula");
		while (PeliculasDAO.existePelicula(titulo, db)) {
			System.out.println(ANSI_RED + "ERROR: Ya existe una pelicula con este titulo." + ANSI_RESET);
			titulo = Utilidades.leerStringValida("titulo de pelicula");
		}
		String director = Utilidades.leerStringValida("director de la pelicula");
		String genero = Utilidades.leerStringValida("genero de la pelicula");
		int anio_estreno = Utilidades.leerAnyo();
		int duracion_minutos = Utilidades.leerMinutos();
		Pelicula peliculaNueva = new Pelicula(titulo, director, genero, anio_estreno, duracion_minutos);
		PeliculasDAO.insertarPelicula(peliculaNueva, db);
		Utilidades.pausarInteracion();

	}

	public static void pintarPeliculas(ArrayList<Pelicula> listaPeliculas) {
		if (listaPeliculas.size() == 0) {
			System.out.println(ANSI_RED + "Se han obtenido 0 peliculas..." + ANSI_RESET);
			return;
		}
		int contador = 1;
		for (Pelicula pelicula : listaPeliculas) {
			System.out.printf(ANSI_GREEN + "---- Pelicula Nº %d ----\n", contador);
			System.out.println(ANSI_PURPLE + pelicula.toString());
			contador = contador + 1;
		}
	}

}
