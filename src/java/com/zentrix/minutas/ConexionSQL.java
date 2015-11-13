package com.zentrix.minutas;

import java.sql.*;

public class ConexionSQL {
    private static final String controlador = "com.mysql.jdbc.Driver";
    private String direccion="jdbc:mysql://localhost/usuario";
    private String usuario;
    private String clave;
    private Connection conexion;
    private Statement consulta;
    private String sql;
    
    public ConexionSQL( String usuario, String clave) {
//        this.direccion = direccion;
        this.usuario = usuario;
        this.clave = clave;
    }
    
    public int conecta() {
        try {
            Class.forName(controlador);
            conexion = DriverManager.getConnection(direccion, usuario, clave);
            consulta = conexion.createStatement();
            return 0;
        }
        catch(Exception e) {
            System.out.println("ConexionSQL: Error al conectar: " + e.toString());
            return 1;
        }
    }
    
    public ResultSet consulta(String sql) {
        if(conexion == null) {
            System.out.println("ConexionSQL: No está conectado a la base de datos");
            return null;
        }
        else {
            try {
                ResultSet resultado = consulta.executeQuery(sql);
                return resultado;
            }
            catch(Exception e) {
                System.out.println("ConexionSQL: Error al consultar " + e.toString());
                return null;
            }
        }
    }
    
    public int ejecuta(String sql) {
        if(conexion == null) {
            System.out.println("ConexionSQL: No está conectado a la base de datos");
            return 1;
        }
        else {
            try {
                consulta.executeUpdate(sql);
                return 0;
            }
            catch(Exception e) {
                System.out.println("ConexionSQL: Error al ejecutar sentencia " + e.toString());
                return 1;
            }
        }            
    }
    
    public int cerrar() {
        try {
            if(consulta != null)
                consulta.close();
            if(conexion != null)
                conexion.close();
            return 0;
        }
        catch(Exception e) {
            System.out.println("ConexionSQL: Error al cerrar sesión " + e.toString());
            return 1;
        }
    }    
}
