/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;
import java.sql.*;

/**
 *
 * @author arcangelmarinp
 */
public class Conexion {
  public Conexion() {
    }

    public Connection getConexion(){
        Connection con=null;
        try{
            /* Carga|Registra el driver JDBC */
            Class.forName("org.apache.derby.jdbc.ClientDriver").newInstance();
            /* Obtener la conexion */
	    con = DriverManager.getConnection("jdbc:derby://localhost:1527/bd_prueba");
        }catch(SQLException ex){
        }catch(Exception e){   
        }
        return con;
    } 
}