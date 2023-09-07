/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_transversal.AccesoDatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author pablo
 */
public class Conexion {
    //todos los nombres van con mayus proque son constantes
    private static final String URL= "jdbc:mariadb://localhost:3307/";
    private static final String DB= "proyecto_transversal";
    private static final String USUARIO= "root";
    private static final String PASSWORD= "";
    private static Connection connection;
    
    private Conexion(){}
    
    public static Connection getConexion(){
    if(connection==null){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            connection= DriverManager.getConnection(URL+DB, USUARIO, PASSWORD);
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Error al cargar los drivers " + ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al conectarse a la base de datos " + ex.getMessage());
        }

    }
    return connection;
    
    }
    
}
