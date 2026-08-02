package ejemplo_anterior_clientes;


import java.sql.Connection;
import java.sql.SQLException;
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
public class Principal {

    public static void main(String[] args) {
        try {
            Connection c = Conexion.openConnection();
            
            System.out.println(ClienteDAO.insertarCliente("Nuevo", "Cliente", "15555555S", c));
            
            for (String string : ClienteDAO.cargarClientesNombre("Juan", c)) {
                System.out.println(string);
            }
            
            c.close();
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
