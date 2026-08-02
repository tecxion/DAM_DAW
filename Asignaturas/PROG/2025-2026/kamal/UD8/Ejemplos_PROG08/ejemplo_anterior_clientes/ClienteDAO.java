package ejemplo_anterior_clientes;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author CIPFPD
 */
public class ClienteDAO {

    private String nif, nombre, apellido;

    public ClienteDAO(String nif, String nombre, String apellido) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nif=" + nif + ", nombre=" + nombre + ", apellido=" + apellido + '}';
    }

    public static String[] cargarClientesNombre(String nombre, Connection c) {
        String[] clientes = null;
        try {
            Statement s = c.createStatement();

            ResultSet rs = s.executeQuery("SELECT NIF, NOMBRE, APELLIDOS "
                    + "FROM CLIENTES WHERE NOMBRE = '" + nombre + "'");

            rs.last();
            clientes = new String[rs.getRow()];
            rs.beforeFirst();
            int indice = 0;
            // Iteramos sobre los registros del resultado
            while (rs.next()) {
                clientes[indice] = rs.getString("NIF") + " "
                        + rs.getString("Nombre") + " "
                        + rs.getString("Apellidos");
                indice++;
            }
            rs.close();
            s.close();
        } catch (SQLException ex) {
//            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

    public static int insertarCliente(String nombre, String apellido, String nif, Connection c) {
        try {
            // Preparamos la consulta
            Statement s = c.createStatement();

            return s.executeUpdate(
                    "INSERT INTO clientes (NIF, Nombre, Apellidos) VALUES "
                    + "('" + nif + "', '" + nombre + "', '" + apellido + "');");
        } catch (SQLException ex) {
//            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
}
