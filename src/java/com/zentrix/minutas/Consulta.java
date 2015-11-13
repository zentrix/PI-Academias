/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zentrix.minutas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author carlos
 */
public class Consulta {
    static final String controlador = "com.mysql.jdbc.Driver";
    private static final String direccion = "jdbc:mysql://localhost/usuario";
    private static final String usuario = "root";
    private static final String clave = "Carlos24@";    
    
       /**
    * 
    * @return String
    */  
    public static String[] consulta() {
       Connection conexion = null;
       Statement consulta = null;
       String sql;
       
       int id;
       ArrayList<String> nombre = new ArrayList<>(); 
       
       
       try {
           Class.forName(controlador);
           conexion = DriverManager.getConnection(direccion, usuario, clave);
           consulta = conexion.createStatement();
           sql = "select id_profesor,nombre from user";
           ResultSet resultado = consulta.executeQuery(sql);
           
           while(resultado.next()) {
               nombre.add(resultado.getString("id_profesor")+resultado.getString("nombre"));
           }
           
           resultado.close();
           consulta.close();
           conexion.close();
           return nombre.toArray(new String[nombre.size()]);
       }
       catch(Exception e) {
           System.out.println("Error: " + e.toString());
           return null;
       }
       finally {
           try {
               if(consulta != null)
                   consulta.close();
               if(conexion != null)
                   conexion.close();
           }
           catch(Exception e) {
               System.out.println("Error: " + e.toString());
           }
       }
   }
    
    /**
     *
     * @param Nombre1
     * @return String
     */
    public  String re(String Nombre1){
        int c= Nombre1.length();
        String replace="";
        System.out.println ("Nombre Original:  "+Nombre1);
          for (int contador =0; contador<c; contador++){
            if (Nombre1.charAt(0)=='n'){
                replace = Nombre1.replaceFirst("null","");
                System.out.println(replace);
            }
            else{
                System.out.print(Nombre1.charAt(contador)+ "");
            }
        }
        return replace;
    }

}
