package ejemplo_anterior_clientes;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
//import org.checkerframework.checker.units.qual.A;

/**
 *
 * @author Profesor
 */
public class Conexion {

    public static Connection openConnection() throws SQLException {
        return DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/prueba",
                "root", "");

    }

}
