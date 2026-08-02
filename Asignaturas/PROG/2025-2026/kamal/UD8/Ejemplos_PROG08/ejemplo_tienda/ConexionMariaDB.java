package ejemplo_tienda_mio;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMariaDB {

    private static final String URL = "jdbc:mariadb://localhost:3306/tienda";
    private static final String USER = "usr_tienda";
    private static final String PASSWORD = "fpdrioja";

    private ConexionMariaDB() {
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}