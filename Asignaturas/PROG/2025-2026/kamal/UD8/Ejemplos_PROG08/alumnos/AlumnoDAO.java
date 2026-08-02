package alumnos;
// Clase DAO para acceso a datos AlumnoDAO.java
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlumnoDAO {

    public void insertarAlumno(Alumno alumno) {
        String sql = "INSERT INTO alumnos (dni, nombre, edad) VALUES (?, ?, ?)";
        //La conexión se cierra automáticamente.
        //Esto es gracias a que Connection implementa AutoCloseable.
        //al salir del bloque try, la conexión se cierra automáticamente, aunque haya errores dentro.
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, alumno.getDni());
            stmt.setString(2, alumno.getNombre());
            stmt.setInt(3, alumno.getEdad());
            stmt.executeUpdate();
            System.out.println("Alumno insertado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void modificarEdad(String dni, int nuevaEdad) {
        String sql = "UPDATE alumnos SET edad = ? WHERE dni = ?";
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

           stmt.setInt(1, nuevaEdad);
            stmt.setString(2, dni);
            stmt.executeUpdate();
            //stmt.executeUpdate("UPDATE alumnos SET edad ="+ nuevaEdad+" WHERE dni = '"+ dni +"'");
                       
            System.out.println("Edad actualizada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarAlumno(String dni) {
        String sql = "DELETE FROM alumnos WHERE dni = ?";
        try (Connection conn = ConnectionDB.openConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, dni);
            stmt.executeUpdate();
            System.out.println("Alumno eliminado correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Alumno> listarAlumnos() {
        List<Alumno> lista = new ArrayList<>();
        String sql = "SELECT * FROM alumnos";
        try (Connection conn = ConnectionDB.openConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                String dni = rs.getString("dni");
                String nombre = rs.getString("nombre");
                int edad = rs.getInt("edad");
                lista.add(new Alumno(dni, nombre, edad));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
