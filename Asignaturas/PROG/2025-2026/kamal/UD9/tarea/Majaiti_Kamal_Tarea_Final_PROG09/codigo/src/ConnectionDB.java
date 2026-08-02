import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class ConnectionDB {
	
	// Fichero donde se almacena la persistencia del programa.
	public static final String obd="peliculas.odb";
	// Colores de la consola para mensajes informativos y de errores.
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_GREEN = "\u001B[32m";

	// Metodo para abrir la conexion contra el fichero peliculas.odb y bloquearlo.
	public static EntityManagerFactory  openConnection() {
		EntityManagerFactory emf = null;
		try {
			// Abrirmos el fichero al que hace referencia el atributo estatico de tipo String obd.
			emf = Persistence.createEntityManagerFactory(ConnectionDB.obd);
	        System.out.printf(ANSI_GREEN + "\nConectado a la BBDD: %s\n" + ANSI_RESET, ConnectionDB.obd );
			
		} catch (Exception e) {
			// Si da error pintamos el error en pantalla, solo daria error si existe una carpeta con el nombre.
			System.out.printf(ANSI_RED + "\nError al connectar a BBDD: %s \n"+ANSI_PURPLE+"Traza de errores:\n"+ANSI_RESET, ConnectionDB.obd + ANSI_RESET);
			e.printStackTrace();
			Utilidades.pausarInteracion();
			System.out.println("Saliendo del programa, no se puede conectar a BBDD.");
			System.exit(1);
		}
		return emf;
	};
	// Metodo para cerrar la conexion contra el fichero peliculas.odb y desbloquearlo.
	public static void closeConnection(EntityManagerFactory conexion) {
		try {
			// Si esta abierto el fichero lo cerramos.
			if (conexion != null && conexion.isOpen()) {
				conexion.close();
			}
		} catch (Exception e) {
			// Si no logramos cerrar el fichero damos error indicando la causa y la pila de llamadas.
			System.out.println("Error al cerrar la conexion de BBDD.");
			e.printStackTrace();
			Utilidades.pausarInteracion();
			System.out.println("Saliendo del programa, no se puede cerrar la conexion de BBDD.");
			System.exit(1);
		}
		
		
	};

}
