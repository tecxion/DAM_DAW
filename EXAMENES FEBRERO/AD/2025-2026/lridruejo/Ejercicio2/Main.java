import java.sql.*;

public class Main {
    public static void main(String[] args) {

        // Datos de la conexión
        String URL = "jdbc:mysql://localhost:3306/EmpresaDB";
        String USER = "examen";
        String PASSWORD = "examen";

        // Creación de recursos
        Connection cn = null;
        String sql = null;

        try {
            // Establecer la conexión
            cn = DriverManager.getConnection(URL, USER, PASSWORD);

            // Insertar un nuevo empleado
            sql = "INSERT INTO Empleados (nombre, puesto, salario) VALUES (?, ?, ?)";

            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                ps.setString(1, "Laura García");
                ps.setString(2, "Analista");
                ps.setDouble(3, 2500.0);
                ps.executeUpdate();
            }

            // Modificar el salario
            sql = "UPDATE Empleados SET salario = salario + ? WHERE puesto = ?";
            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                ps.setInt(1, 500);
                ps.setString(2, "Analista");
                ps.executeUpdate();
            }

            sql = "SELECT nombre, salario FROM Empleados WHERE salario > ?";
            try (PreparedStatement ps = cn.prepareStatement(sql)) {
                ps.setDouble(1, 2000.0);
                try (ResultSet rs = ps.executeQuery()) {
                    while (rs.next()) {
                        String nombre = rs.getString("nombre");
                        String salario = rs.getString("salario");
                        System.out.println(nombre + " - " + salario);
                    }
                }
            }

        } catch (SQLException e) {
            System.err.println("Error SQL: " + e.getMessage());
        } finally {
            // Cerrar la conexión (el resto de recursos están dentro de try-with-resources
            if (cn != null) {
                try {
                    cn.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar la conexión: " + e.getMessage());
                }
            }
        }

    }
}