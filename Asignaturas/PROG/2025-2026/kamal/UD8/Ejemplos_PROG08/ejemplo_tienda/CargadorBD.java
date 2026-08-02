package ejemplo_tienda_mio;

import java.sql.SQLException;
import java.util.List;

public class CargadorBD {

    public static void cargarDesdeMariaDB(Tienda tienda) {
        ProductoDAO dao = new ProductoDAO();

        try {
            List<Producto> productos = dao.obtenerTodos();
            for (Producto p : productos) {
                tienda.agregarProductoCatalogo(p);
            }
            System.out.println("Productos cargados desde MariaDB.");
        } catch (SQLException e) {
            System.out.println("Error al cargar productos desde MariaDB: " + e.getMessage());
        }
    }
}