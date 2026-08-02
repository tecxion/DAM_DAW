import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectCoches {
    public static void mostrarCoches() {
        Connection cn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            cn = DatabaseConnection.getConnection();
            String sql = "SELECT marca, modelo, potencia, combustible FROM coches";

            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println("\n--- LISTA DE COCHES ---");
            while (rs.next()) {
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                String potencia = rs.getString("potencia");
                String combustible = rs.getString("combustible");

                System.out.println(marca + " - " + modelo + " - " + potencia + " CV - " + combustible);
            }
            System.out.println("--- FIN DE LA LISTA ---\n");
        } catch (SQLException e) {
            System.out.println("Error al obtener los coches: " + e.getMessage());
        } finally {
            // Cerrar recursos
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar el ResultSet: " + e.getMessage());
                }
            }
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