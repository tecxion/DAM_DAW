import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateCoche {
    public static void aumentarPotencia(String marca, int incremento) {
        Connection cn = null;
        PreparedStatement updatePs = null;
        ResultSet rs = null;

        try {
            cn = DatabaseConnection.getConnection();
            int cochesActualizados = 0;

            // Actualizar la potencia de los coches
            String updateSQL = "UPDATE coches SET potencia = potencia + ? WHERE marca = ?";

            updatePs = cn.prepareStatement(updateSQL);
            updatePs.setInt(1, incremento);
            updatePs.setString(2, marca);

            cochesActualizados = updatePs.executeUpdate();

            if (cochesActualizados > 0) {
                System.out.println("Potencia aumentada en " + incremento + " CV para " + cochesActualizados + " coches de la marca " + marca + ".");
            } else {
                System.out.println("No se encontraron coches de la marca " + marca);
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar la potencia: " + e.getMessage());
        } finally {
            // Cerrar recursos
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar el ResultSet: " + e.getMessage());
                }
            }
            if (updatePs != null) {
                try {
                    updatePs.close();
                } catch (SQLException e) {
                    System.out.println("Error al cerrar el PreparedStatement: " + e.getMessage());
                }
            }
            DatabaseConnection.closeConnection(cn);
        }
    }
}