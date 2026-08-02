package tarea_25_26;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PeliculasDAO {

    public void insertarPelicula(String titulo, String director, String genero, int anioEstreno, int duracionMinutos) {
        if (!validarTexto(titulo) || !validarTexto(director) || !validarTexto(genero)) {
            System.out.println("Error: título, director y género no pueden estar vacíos.");
            return;
        }

        if (anioEstreno <= 1800 || duracionMinutos <= 0) {
            System.out.println("Error: el año de estreno o la duración no son válidos.");
            return;
        }

        String sql = "INSERT INTO catalogo (titulo, director, genero, anio_estreno, duracion_minutos) VALUES (?, ?, ?, ?, ?)";
       
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, titulo);
            ps.setString(2, director);
            ps.setString(3, genero);
            ps.setInt(4, anioEstreno);
            ps.setInt(5, duracionMinutos);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Película insertada correctamente.");
            } else {
                System.out.println("No se pudo insertar la película.");
            }

        } catch (SQLException e) {
            System.out.println("Error al insertar la película: " + e.getMessage());
        }
    }

    public void actualizarDuracion(String titulo, int duracion) {
        if (!validarTexto(titulo)) {
            System.out.println("Error: el título no puede estar vacío.");
            return;
        }

        if (duracion <= 0) {
            System.out.println("Error: la duración debe ser mayor que 0.");
            return;
        }

        String sql = "UPDATE catalogo SET duracion_minutos = ? WHERE titulo = ?";

        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, duracion);
            ps.setString(2, titulo);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Duración actualizada correctamente.");
            } else {
                System.out.println("No se encontró ninguna película con ese título.");
            }

        } catch (SQLException e) {
            System.out.println("Error al actualizar la duración: " + e.getMessage());
        }
    }

    public void eliminarPelicula(String titulo) {
        if (!validarTexto(titulo)) {
            System.out.println("Error: el título no puede estar vacío.");
            return;
        }

        String sql = "DELETE FROM catalogo WHERE titulo = ?";

        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, titulo);

            int filas = ps.executeUpdate();

            if (filas > 0) {
                System.out.println("Película eliminada correctamente.");
            } else {
                System.out.println("No se encontró ninguna película con ese título.");
            }

        } catch (SQLException e) {
            System.out.println("Error al eliminar la película: " + e.getMessage());
        }
    }

    public void listarTodasLasPeliculas() {
        String sql = "SELECT * FROM catalogo";

        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            boolean hayPeliculas = false;

            System.out.println("\n===== LISTADO COMPLETO DE PELÍCULAS =====");

            while (rs.next()) {
                hayPeliculas = true;

                System.out.println("ID: " + rs.getInt("pelicula_id"));
                System.out.println("Título: " + rs.getString("titulo"));
                System.out.println("Director: " + rs.getString("director"));
                System.out.println("Género: " + rs.getString("genero"));
                System.out.println("Año de estreno: " + rs.getInt("anio_estreno"));
                System.out.println("Duración: " + rs.getInt("duracion_minutos") + " minutos");
                System.out.println("-----------------------------------------");
            }

            if (!hayPeliculas) {
                System.out.println("No hay películas registradas en la base de datos.");
            }

        } catch (SQLException e) {
            System.out.println("Error al listar las películas: " + e.getMessage());
        }
    }

    public void listarPorGenero(String genero) {
        if (!validarTexto(genero)) {
            System.out.println("Error: el género no puede estar vacío.");
            return;
        }

        String sql = "SELECT * FROM catalogo WHERE genero = ?";

        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, genero);

            try (ResultSet rs = ps.executeQuery()) {
                boolean hayPeliculas = false;

                System.out.println("\n===== PELÍCULAS DEL GÉNERO: " + genero + " =====");

                while (rs.next()) {
                    hayPeliculas = true;

                    System.out.println("ID: " + rs.getInt("pelicula_id"));
                    System.out.println("Título: " + rs.getString("titulo"));
                    System.out.println("Director: " + rs.getString("director"));
                    System.out.println("Año de estreno: " + rs.getInt("anio_estreno"));
                    System.out.println("Duración: " + rs.getInt("duracion_minutos") + " minutos");
                    System.out.println("-----------------------------------------");
                }

                if (!hayPeliculas) {
                    System.out.println("No se encontraron películas de ese género.");
                }
            }

        } catch (SQLException e) {
            System.out.println("Error al listar las películas por género: " + e.getMessage());
        }
    }

    private boolean validarTexto(String texto) {
        return texto != null && !texto.isBlank();
    }
}