import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeleteCoche {
    public static void eliminarCoche(String matricula) {
        Connection cn = null;
        PreparedStatement ps = null;

        try {
            cn = DatabaseConnection.getConnection();
            String sql = "DELETE FROM coches WHERE matricula = ?";

            ps = cn.prepareStatement(sql);
            ps.setString(1, matricula);

            int filasEliminadas = ps.executeUpdate();

            if (filasEliminadas > 0) {
                System.out.println("Coche eliminado correctamente: " + matricula);
            } else {
                System.out.println("No se encontró ningún coche con la matrícula " + matricula);
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el coche: " + e.getMessage());
        } finally {
            // Cerrar recursos
            try {
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException e) {
                System.out.println("Error al cerrar el PreparedStatement: " + e.getMessage());
            }
            DatabaseConnection.closeConnection(cn);
        }
    }
}