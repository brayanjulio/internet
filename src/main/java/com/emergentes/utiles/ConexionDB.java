package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionDB {

    static public String url = "jdbc:mysql://localhost:3306/bd_internet";
    static public String usuario = "root";
    static public String password = "admin";

    protected Connection conn = null;

    public ConexionDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");//versio 5 de mysql
            //Class.forName("com.mysql.jc.jdbc.Driver");//versio 8 de mysql
            conn = DriverManager.getConnection(url, usuario, password);
            if (conn != null) {
                //si es nullo entonces hay un error
                System.out.println("Error de SQL" + conn);
            }
        } catch (SQLException ex) {
            System.out.println("Error al conectar " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en Driver" + ex.getMessage());
        }
    }

    public Connection conectar() {
        return conn;
    }

    public void desconectar() {
        System.out.println("Cerrando la BD" + conn);
        try {
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
