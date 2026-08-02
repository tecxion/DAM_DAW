import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionDB {
	
	private static final String URL="jdbc:mariadb://localhost:3306/peliculas";
	private static final String USER="user";
	private static final String PASSWORD="P1234";
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_GREEN = "\u001B[32m";

	public static Connection openConnection() {
		Connection conexion = null;
		try {
			conexion = DriverManager.getConnection(URL, USER, PASSWORD);
			System.out.printf(ANSI_GREEN + "\nConectado a la BBDD: %s\n" + ANSI_RESET, URL );
			
		} catch (Exception e) {
			System.out.printf(ANSI_RED + "\nError al connectar a BBDD: %s \n"+ANSI_PURPLE+"Traza de errores:\n"+ANSI_RESET, URL + ANSI_RESET);
			e.printStackTrace();
			Utilidades.pausarInteracion();
			System.out.println("Saliendo del programa, no se puede conectar a BBDD.");
			System.exit(1);
		}
		return conexion;
	};

	public static void closeConnection(Connection conexion) {
		try {
			if (conexion != null && !(conexion.isClosed())) {
				conexion.close();
			}
		} catch (Exception e) {
			System.out.println("Error al cerrar la conexion de BBDD.");
			e.printStackTrace();
			Utilidades.pausarInteracion();
			System.out.println("Saliendo del programa, no se puede cerrar la conexion de BBDD.");
			System.exit(1);
		}
		
		
	};

}
