import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PeliculasDAO {

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_GREEN = "\u001B[32m";

	public static void insertarPelicula(Pelicula PeliculaNueva, Connection conexion) {

		if (PeliculaNueva == null || PeliculaNueva.getTitulo() == null || PeliculaNueva.getGenero() == null) {
			System.out.println(ANSI_RED + "El objeto pelicula que se intenta insertar no es valido." + ANSI_RESET);
			return;
		}
		String sql = "INSERT INTO catalogo (Titulo, director, Genero, anio_estreno, duracion_minutos) VALUES (?, ?, ?, ?, ?)";
		try (PreparedStatement consulta = conexion.prepareStatement(sql)) {
			consulta.setString(1, PeliculaNueva.getTitulo());
			consulta.setString(2, PeliculaNueva.getDirector());
			consulta.setString(3, PeliculaNueva.getGenero());
			consulta.setLong(4, PeliculaNueva.getAnio_estreno());
			consulta.setLong(5, PeliculaNueva.getDuracion_minutos());
			consulta.execute();
			consulta.close();
			System.out.println(ANSI_GREEN + "Pelicula agregada correctamente." + ANSI_RESET);
		} catch (Exception e) {
			System.out.println(ANSI_RED + "Error al agregar la Pelicula a BBDD" + ANSI_RESET);
			e.printStackTrace();

		}

	}

	public static boolean existePelicula(String titulo, Connection conexion) {
		String sql = "select count(*) from catalogo where Titulo= ? ";
		try (PreparedStatement consulta = conexion.prepareStatement(sql);) {
			consulta.setString(1, titulo);
			consulta.executeQuery();
			ResultSet resultadoConsulta = consulta.getResultSet();
			int resultadoConsultaInt = 0;
			if (resultadoConsulta.next()) {
				resultadoConsultaInt = resultadoConsulta.getInt(1);
			}
			consulta.close();
			resultadoConsulta.close();
			return resultadoConsultaInt == 1 ? true : false;

		} catch (Exception e) {
			System.out.println(ANSI_RED + "Error al agregar la Pelicula a BBDD" + ANSI_RESET);
			e.printStackTrace();
			return false;
		}

	}

	public static void actualizarDuracion(String titulo, int duracion, Connection conexion) {
		if (!existePelicula(titulo, conexion)) {
			System.out.printf(ANSI_RED
					+ "Error al intentar actualizar la Pelicula con titulo \"%s\" en la BBDD, ya que no existe.\n"
					+ ANSI_RESET, titulo);
			return;
		}

		String sql = "update catalogo set duracion_minutos = ? where Titulo= ?";
		try (PreparedStatement consulta = conexion.prepareStatement(sql)) {
			consulta.setInt(1, duracion);
			consulta.setString(2, titulo);
			int filasAfectadas = consulta.executeUpdate();
			consulta.close();
			System.out.printf(ANSI_GREEN
					+ "Se han actualizado %d peliculas con el titulo %s a la duracion de %d minutos.\n" + ANSI_RESET,
					filasAfectadas, titulo, duracion);
		} catch (Exception e) {
			System.out.printf(ANSI_RED + "Error al actualizar la duracion de la la Pelicula %s en BBDD\n" + ANSI_RESET,
					titulo);
			e.printStackTrace();

		}

	}

	public static void eliminarPelicula(String titulo, Connection conexion) {

		if (!existePelicula(titulo, conexion)) {
			System.out.printf(
					ANSI_RED + "Error al intentar borrar la Pelicula con titulo \"%s\" de la BBDD, porque no existe.\n"
							+ ANSI_RESET,
					titulo);
			return;
		}
		String sql = "delete from catalogo where Titulo= ?";
		try (PreparedStatement consulta = conexion.prepareStatement(sql)) {
			consulta.setString(1, titulo);
			int filasAfectadas = consulta.executeUpdate();
			consulta.close();
			System.out.printf(ANSI_GREEN + "Se han borrado %d peliculas con el titulo: %s.\n" + ANSI_RESET,
					filasAfectadas, titulo);
		} catch (Exception e) {
			System.out.printf(ANSI_RED + "Error al actualizar la duracion de la la Pelicula %s en BBDD\n" + ANSI_RESET,
					titulo);
			e.printStackTrace();

		}
	};

	public static ArrayList<Pelicula> listarTodasLasPeliculas(Connection conexion) {

		ArrayList<Pelicula> resultadoConsulta = new ArrayList<>();
		;
		final String sql = "SELECT pelicula_id,Titulo,director,Genero,anio_estreno,duracion_minutos FROM catalogo";
		try (Statement consulta = conexion.createStatement()) {

			try (ResultSet resultado = consulta.executeQuery(sql)) {
				while (resultado.next()) {

					Pelicula pelicula = new Pelicula(resultado.getString("titulo"), resultado.getString("director"),
							resultado.getString("genero"), resultado.getInt("anio_estreno"),
							resultado.getInt("duracion_minutos"));

					resultadoConsulta.add(pelicula);
				}
				resultado.close();
				consulta.close();
			} catch (Exception e) {
				System.out.println(ANSI_RED + "Error al obtener el listado desde BBDD." + ANSI_RESET);
				e.printStackTrace();
				Utilidades.pausarInteracion();

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return resultadoConsulta;

	};

	public static ArrayList<String> obtenerGeneros(Connection conexion) {
		ArrayList<String> generosPelicula = new ArrayList<String>();
		String sql = "SELECT distinct Genero FROM catalogo";

		try (Statement consulta = conexion.createStatement()) {
			try (ResultSet resultadoConsulta = consulta.executeQuery(sql)) {

				while (resultadoConsulta.next()) {
					generosPelicula.add(resultadoConsulta.getString("Genero"));
				}
				resultadoConsulta.close();
				consulta.close();
			} catch (Exception e) {
				System.out.println(ANSI_RED + "Error al obtener el listado desde BBDD." + ANSI_RESET);
				e.printStackTrace();
				Utilidades.pausarInteracion();
			}

		} catch (Exception e) {
			System.out.println(ANSI_RED + "Error al preparar la consulta SQL." + ANSI_RESET);
			e.printStackTrace();
		}

		return generosPelicula;

	}

	public static ArrayList<Pelicula> listarporGenero(String Genero, Connection conexion) {
		ArrayList<Pelicula> resultadoConsulta = new ArrayList<>();
		;
		String sql = "SELECT pelicula_id,Titulo,director,Genero,anio_estreno,duracion_minutos FROM catalogo where Genero = ?";
		try (PreparedStatement consulta = conexion.prepareStatement(sql)) {

			consulta.setString(1, Genero);
			try {
				ResultSet resultado = consulta.executeQuery();
				while (resultado.next()) {

					Pelicula pelicula = new Pelicula(resultado.getString("titulo"), resultado.getString("director"),
							resultado.getString("genero"), resultado.getInt("anio_estreno"),
							resultado.getInt("duracion_minutos"));

					resultadoConsulta.add(pelicula);
				}
				resultado.close();
				consulta.close();
			} catch (Exception e) {
				System.out.println(ANSI_RED + "Error al obtener el listado desde BBDD." + ANSI_RESET);
				e.printStackTrace();
				Utilidades.pausarInteracion();

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return resultadoConsulta;

	};

}
