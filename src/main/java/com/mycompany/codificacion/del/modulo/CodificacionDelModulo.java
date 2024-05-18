

package com.mycompany.codificacion.del.modulo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CodificacionDelModulo {

    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/actividad-codificación";
        String usuario = "root";
        String password = "";
        String driver = "com.mysql.cj.jdbc.Driver";
        Connection conexion = null;
        Statement statement = null;
        ResultSet rs = null;
        
         try {
            Class.forName(driver);
            conexion = DriverManager.getConnection(url, usuario, password);
            statement = conexion.createStatement();
            rs = statement.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
            /*
            //Insertar datos
            statement.execute("INSERT INTO usuario (id, nombre) VALUES (NULL, 'Oscar');");
             rs = statement.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
            
            //Atualizar datos
            statement.execute("UPDATE usuario SET nombre = 'Denis' WHERE usuario.id = 2;");
             rs = statement.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            */
            
            //Eliminar datos
            statement.execute("DELETE FROM usuario WHERE usuario.id = 3;");
             rs = statement.executeQuery("SELECT * FROM usuario");
            while (rs.next()) {
                System.out.println(rs.getString("nombre"));
            }
            
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(CodificacionDelModulo.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            // Cerrar los recursos en un bloque finally
            try {
                if (rs != null) {
                    rs.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(CodificacionDelModulo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
