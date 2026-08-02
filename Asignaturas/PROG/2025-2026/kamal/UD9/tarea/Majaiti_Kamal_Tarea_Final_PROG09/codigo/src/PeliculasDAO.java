import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class PeliculasDAO {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_GREEN = "\u001B[32m";

	public static void insertarPelicula(Pelicula PeliculaNueva, EntityManagerFactory conexion) {

		// Al metodo se le pasa la conexion o puntero de persistencia de EntityManager
		// de ObjectBD ya instanciado al abrir el programa y se reutiliza.
		// Comprobamos que la pelicula no tiene nulos.
		if (PeliculaNueva == null || PeliculaNueva.getTitulo() == null || PeliculaNueva.getGenero() == null) {
			System.out.println(ANSI_RED + "El objeto pelicula que se intenta insertar no es valido." + ANSI_RESET);
			return;
		}

		try {
			EntityManager em = conexion.createEntityManager(); // Creamos una nueva sesion de BBDD.
			em.getTransaction().begin(); // Iniciamos una nueva transaccion.
			em.persist(PeliculaNueva); // Guardamos los datos del Obj Pelicula.
			em.getTransaction().commit(); // Salvamos los cambios en el fichero.
			System.out.println(ANSI_GREEN + "Pelicula agregada correctamente." + ANSI_RESET);
		} catch (Exception e) {
			// Si da error pintamos la causa.
			System.out.println(ANSI_RED + "Error al agregar la Pelicula a BBDD" + ANSI_RESET);
			e.printStackTrace();

		}

	}

	public static boolean existePelicula(String Titulo, EntityManagerFactory conexion) {
		EntityManager em = conexion.createEntityManager();
		try {
			// https://stackoverflow.com/questions/17136162/objectdb-select-where-query
			// Me he basado en el ejemplo de ConsultaAlimentacion.java en vez de usar un
			// ArrayList he usado count. Por lo visto tengo que usar Long y no Integer me
			// daba error.

			// Consulta que compruba si un objeto con un titulo ya existe.
			// Se indica el titulo y se obtiene el resultado.
			Long resultadoConsultaInt = em
					.createQuery("SELECT COUNT(p) FROM Pelicula p WHERE p.Titulo = :Titulo", Long.class)
					.setParameter("Titulo", Titulo).getSingleResult();

			em.close();
			// Devuelve true si es mayor que 0 indicando que ya existe la pelicula.
			return resultadoConsultaInt > 0 ? true : false;

		} catch (Exception e) {
			// Si da error se lo mostramos al usuario y pintamos la pila de llamadas para
			// determinar la causa.
			System.out.println(ANSI_RED + "Error al comprobar la Pelicula a BBDD" + ANSI_RESET);
			e.printStackTrace();
			return false;
		}

	}

	public static void actualizarDuracion(String titulo, int duracion, EntityManagerFactory conexion) {
		// Comprobamos si existe la pelicula, si no existe volvemos del metodo sin hacer
		// nada.
		if (!existePelicula(titulo, conexion)) {
			System.out.printf(ANSI_RED
					+ "Error al intentar actualizar la Pelicula con titulo \"%s\" en la BBDD, ya que no existe.\n"
					+ ANSI_RESET, titulo);
			return;
		}

		// Manual de como actualizar...un poco lioso...
		// https://www.objectdb.com/java/jpa/persistence/update
		// https://www.objectdb.com/java/jpa/entity/id#entity_identification

		// Creamos una nueva sesion contra BBDD.
		EntityManager em = conexion.createEntityManager();
		try {
			// Iniciamos una nueva TX.
			em.getTransaction().begin();

			// Recuperamos el objeto pelicula de Objectdb.
			Pelicula PeliculaActualizar = em.find(Pelicula.class, titulo);

			// Actualizamos la pelicula obtenida con su metodo.
			PeliculaActualizar.setDuracion_minutos(duracion);
			// Guardamos los cambios.
			em.getTransaction().commit();
			// Terminamos la sesion.
			em.close();

		} catch (Exception e) {
			// Si da error pintamos el error y la pila de llamadas.
			System.out.println(ANSI_RED + "Error al comprobar la Pelicula a BBDD" + ANSI_RESET);
			e.printStackTrace();
		}

	}

	public static void eliminarPelicula(String titulo, EntityManagerFactory conexion) {
		// Comprobamos si la pelicula existe, si no existe salimos del metodo.
		if (!existePelicula(titulo, conexion)) {
			System.out.printf(
					ANSI_RED + "Error al intentar borrar la Pelicula con titulo \"%s\" de la BBDD, porque no existe.\n"
							+ ANSI_RESET,
					titulo);
			return;
		}
		// Metodo borrar: https://www.objectdb.com/java/jpa/persistence/delete
		// Cremos una sesion nueva.
		EntityManager em = conexion.createEntityManager();
		try {
			// Iniciamos la TX.
			em.getTransaction().begin();
			// Recuperamos el objeto pelicula de Objectdb, borramos, guardamos y cerramos la
			// sesion.
			Pelicula PeliculaEliminar = em.find(Pelicula.class, titulo);
			em.remove(PeliculaEliminar);
			em.getTransaction().commit();
			em.close();

		} catch (Exception e) {
			// Si da error, lo mostramos la usuario y pintamos la pila de llamadas.
			System.out.println(ANSI_RED + "Error al comprobar la Pelicula a BBDD" + ANSI_RESET);
			e.printStackTrace();
		}
	};

	public static ArrayList<Pelicula> listarTodasLasPeliculas(EntityManagerFactory conexion) {
		// Creamos una nueva sesion.
		EntityManager em = conexion.createEntityManager();
		// Creamos una lista vacia de peliculas donde guardaremos las peliculas obtenidas desde objectDB.
		List<Pelicula> resultadoConsulta = null;
		try {
			// Iniciamos una nueva transaccion
			em.getTransaction().begin();

			// Recuperamos todas las pelicula de Objectdb.
			resultadoConsulta = em.createQuery("SELECT p FROM Pelicula p", Pelicula.class).getResultList();
			// Cerramos la conexion
			em.close();
			// Casteamos List a ArrayList y devolvemos el resultado.
			// https://stackoverflow.com/questions/5134466/how-to-cast-arraylist-from-list
			return new ArrayList<>(resultadoConsulta);

		} catch (Exception e) {
			// En caso de error, pintamos el mensaje y la pila de llamadas.
			System.out.println(ANSI_RED + "Error al obtener la Pelicula a BBDD" + ANSI_RESET);
			e.printStackTrace();
		}

        // Casteamos List a ArrayList y devolvemos el resultado.
        // https://stackoverflow.com/questions/5134466/how-to-cast-arraylist-from-list
        return new ArrayList<>(resultadoConsulta);


	};

	public static ArrayList<String> obtenerGeneros(EntityManagerFactory conexion) {
		// Creamos una nueva sesion.
		EntityManager em = conexion.createEntityManager();
		// Creamos una lista vacia para guardar las categorias que obtendremos mas adelanta.
		List<String> resultadoConsulta = null;
		try {
			// Iniciamos una nueva TX, aunque para leer no hace falta...pero bueno.
			em.getTransaction().begin();
			// Recuperamos todas las categorias unicas de peliculas de Objectdb.
			resultadoConsulta = em.createQuery("SELECT distinct p.genero FROM Pelicula p", String.class)
					.getResultList();
			em.close();
			// Devolvemos las categorias obtenidas casteando a ArrayList.
			// https://stackoverflow.com/questions/5134466/how-to-cast-arraylist-from-list
			return new ArrayList<>(resultadoConsulta);

		} catch (Exception e) {
			System.out.println(ANSI_RED + "Error al obtener los generos de las peliculas desde BBDD" + ANSI_RESET);
			e.printStackTrace();
			return new ArrayList<>();
		}

	};

	public static ArrayList<Pelicula> listarporGenero(String Genero, EntityManagerFactory conexion) {
		// Cremaos una nueva sesion.
		EntityManager em = conexion.createEntityManager();
		// Creamos una lista donde guardar los objetos pelicula que pertenecen al genero indicado.
		List<Pelicula> resultadoConsulta = null;
		try {
			// Iniciamos una nueva TX aunque no hace falta en lectura.
			em.getTransaction().begin();
			// Recuperamos todas los objetos de pelicula de Objectdb que pertenecen a ese genero.
			resultadoConsulta = em.createQuery("SELECT p FROM Pelicula p WHERE p.genero = :genero", Pelicula.class)
					.setParameter("genero", Genero).getResultList();
			// Cerramos la sesion.
			em.close();
			// Devolvemos el resultado pedido.
			return new ArrayList<>(resultadoConsulta);

		} catch (Exception e) {
			// Indicamos el error y pintamos la pila de llamadas.
			System.out.println(ANSI_RED + "Error al obtener la Pelicula a BBDD" + ANSI_RESET);
			e.printStackTrace();
		}
		// Devolvemos un listado vacio... 
		return new ArrayList<>(resultadoConsulta);

	};

}
