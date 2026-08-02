import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertCoche {
    public static void insertarCoche(String matricula, String marca, String modelo, String potencia, String combustible) {
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO coches (matricula, marca, modelo, potencia, combustible) VALUES (?, ?, ?, ?, ?)";

            ps = cn.prepareStatement(sql);
            ps.setString(1, matricula);
            ps.setString(2, marca);
            ps.setString(3, modelo);
            ps.setString(4, potencia);
            ps.setString(5, combustible);

            int filasInsertadas = ps.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println("Coche insertado correctamente: " + matricula);
            } else {
                System.out.println("No se pudo insertar el coche.");
            }
        } catch (SQLException e) {
            System.out.println("Error al insertar el coche: " + e.getMessage());
        } finally {
            // Cerrar recursos
            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar el PreparedStatement: " + e.getMessage());
                }
            }
            DatabaseConnection.closeConnection(cn);
        }
    }
}