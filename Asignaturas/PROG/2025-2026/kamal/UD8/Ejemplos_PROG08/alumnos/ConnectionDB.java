package alumnos;
// Clase para la conexión a la base de datos ConnectionDB.java
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    private static final String URL = "jdbc:mariadb://localhost:3306/prueba";
    //private static final String URL = "jdbc:mysql://localhost:3306/prueba";
    private static final String USER = "usr_prueba";
    private static final String PASSWORD = "Fpdrioja";

    public static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
