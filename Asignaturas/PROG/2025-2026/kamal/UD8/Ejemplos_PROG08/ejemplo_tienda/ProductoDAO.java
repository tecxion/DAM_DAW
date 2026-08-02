package ejemplo_tienda_mio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoDAO {

    public void insertarProducto(Producto p) throws SQLException {
        String sqlProducto = "INSERT INTO producto(nombre, precio, tipo) VALUES (?, ?, ?)";
        String sqlAlimentacion = "INSERT INTO producto_alimentacion(id_producto, caducidad) VALUES (?, ?)";
        String sqlHigiene = "INSERT INTO producto_higiene(id_producto, uso_profesional) VALUES (?, ?)";

        try (Connection con = ConexionMariaDB.getConnection()) {
            con.setAutoCommit(false);

            try (
                PreparedStatement psProducto = con.prepareStatement(sqlProducto, Statement.RETURN_GENERATED_KEYS);
                PreparedStatement psAlimentacion = con.prepareStatement(sqlAlimentacion);
                PreparedStatement psHigiene = con.prepareStatement(sqlHigiene)
            ) {
                psProducto.setString(1, p.getNombre());
                psProducto.setDouble(2, p.getPrecio());

                if (p instanceof ProductoAlimentacion) {
                    psProducto.setString(3, "ALIMENTACION");
                } else if (p instanceof ProductoHigiene) {
                    psProducto.setString(3, "HIGIENE");
                } else {
                    throw new SQLException("Tipo de producto no soportado");
                }

                psProducto.executeUpdate();

                int idGenerado;
                try (ResultSet rs = psProducto.getGeneratedKeys()) {
                    if (!rs.next()) {
                        throw new SQLException("No se pudo obtener el ID generado");
                    }
                    idGenerado = rs.getInt(1);
                }

                if (p instanceof ProductoAlimentacion pa) {
                    psAlimentacion.setInt(1, idGenerado);
                    psAlimentacion.setInt(2, pa.getCaducidad());
                    psAlimentacion.executeUpdate();
                } else if (p instanceof ProductoHigiene ph) {
                    psHigiene.setInt(1, idGenerado);
                    psHigiene.setBoolean(2, ph.isUsoProfesional());
                    psHigiene.executeUpdate();
                }

                con.commit();
            } catch (SQLException e) {
                con.rollback();
                throw e;
            } finally {
                con.setAutoCommit(true);
            }
        }
    }

    public List<Producto> obtenerTodos() throws SQLException {
        List<Producto> productos = new ArrayList<>();

        String sql = """
            SELECT p.id, p.nombre, p.precio, p.tipo,
                   pa.caducidad,
                   ph.uso_profesional
            FROM producto p
            LEFT JOIN producto_alimentacion pa ON p.id = pa.id_producto
            LEFT JOIN producto_higiene ph ON p.id = ph.id_producto
            ORDER BY p.nombre
            """;

        try (
            Connection con = ConexionMariaDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                double precio = rs.getDouble("precio");
                String tipo = rs.getString("tipo");

                Producto p;
                if ("ALIMENTACION".equals(tipo)) {
                    int caducidad = rs.getInt("caducidad");
                    p = new ProductoAlimentacion(nombre, precio, caducidad);
                } else if ("HIGIENE".equals(tipo)) {
                    boolean usoProfesional = rs.getBoolean("uso_profesional");
                    p = new ProductoHigiene(nombre, precio, usoProfesional);
                } else {
                    continue;
                }

                productos.add(p);
            }
        }

        return productos;
    }

    public Producto buscarPorNombre(String nombreBuscado) throws SQLException {
        String sql = """
            SELECT p.id, p.nombre, p.precio, p.tipo,
                   pa.caducidad,
                   ph.uso_profesional
            FROM producto p
            LEFT JOIN producto_alimentacion pa ON p.id = pa.id_producto
            LEFT JOIN producto_higiene ph ON p.id = ph.id_producto
            WHERE LOWER(p.nombre) = LOWER(?)
           """;

        try (
            Connection con = ConexionMariaDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, nombreBuscado);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nombre = rs.getString("nombre");
                    double precio = rs.getDouble("precio");
                    String tipo = rs.getString("tipo");

                    if ("ALIMENTACION".equals(tipo)) {
                        return new ProductoAlimentacion(nombre, precio, rs.getInt("caducidad"));
                    } else if ("HIGIENE".equals(tipo)) {
                        return new ProductoHigiene(nombre, precio, rs.getBoolean("uso_profesional"));
                    }
                }
            }
        }

        return null;
    }

    public boolean eliminarPorNombre(String nombre) throws SQLException {
        String sql = "DELETE FROM producto WHERE LOWER(nombre) = LOWER(?)";

        try (
            Connection con = ConexionMariaDB.getConnection();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, nombre);
            return ps.executeUpdate() > 0;
        }
    }
}