/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_transversal;

import java.sql.Connection;
import proyecto_transversal.AccesoDatos.Conexion;

/**
 *
 * @author pablo
 */
public class Proyecto_transversal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Connection con= Conexion.getConexion();
    }
    
}
