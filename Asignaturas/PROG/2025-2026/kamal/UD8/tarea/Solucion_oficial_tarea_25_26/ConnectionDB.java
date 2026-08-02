package tarea_25_26;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {

    private static final String URL = "jdbc:mariadb://localhost:3306/peliculas";
    private static final String USER = "user";
    private static final String PASSWORD = "P1234";



    public static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
