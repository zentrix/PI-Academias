/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bean.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */

public class DaoUsuario implements interfaces.IUsuario{

    @Override
    public boolean insert(Usuario usuario, Connection conexion) throws Exception {
        Statement statement;
        statement=(Statement) conexion.createStatement();
        String query="insert into user values('"+usuario.getIdMaestro()+"'"+"'"+usuario.getNombre()+"','"+usuario.getUsuario()+
                "','"+usuario.getContrasena()+"',"+usuario.getCorreo()+"','"+usuario.getNombreCargo()+");";
        statement.execute(query);
        statement.close();
        return true;
    }

    @Override
    public Usuario getByIdProfesor(String idProfesor, Connection conexion) throws Exception {
       Usuario usuario=null;
        
        Statement statement;
        ResultSet resultSet;
        
        String query="select * from user where id_profesor='"+idProfesor+"'";
        
        statement=(Statement) conexion.createStatement();
        resultSet=statement.executeQuery(query);
        
        
        if(resultSet.next())
        {
            usuario=new Usuario();
            
            usuario.setIdMaestro(resultSet.getInt("id_profesor"));
            usuario.setNombre(resultSet.getString("nombre"));
            usuario.setUsuario(resultSet.getString("usuario"));
            usuario.setContrasena(resultSet.getString("contrasena"));
            usuario.setCorreo(resultSet.getString("correo"));
            usuario.setNombreCargo(resultSet.getString("nombre_cargo"));
        }
        
        resultSet.close();
        statement.close();
        
        return usuario;
    }

    @Override
    public List<Usuario> getAll(Connection conexion) throws Exception {
        List<Usuario> listUsuario =new ArrayList<>();
       
        Statement statement;
        ResultSet resultSet;
        
        String query="select * from user";
        
        statement=(Statement) conexion.createStatement();
        resultSet=statement.executeQuery(query);
        
        Usuario usuario;
        while(resultSet.next())
        {
            usuario=new Usuario();
            
            usuario.setIdMaestro(resultSet.getInt("id_profesor"));
            usuario.setNombre(resultSet.getString("nombre"));
            usuario.setUsuario(resultSet.getString("usuario"));
            usuario.setContrasena(resultSet.getString("contrasena"));
            usuario.setCorreo(resultSet.getString("correo"));
            usuario.setNombreCargo(resultSet.getString("nombre_cargo"));
            
            listUsuario.add(usuario);
        }
        
        resultSet.close();
        statement.close();
        
        return listUsuario;
    }

    @Override
    public boolean update(Usuario usuario, Connection conexion) throws Exception {
        Statement statement;
        
        String query="update user set nombre='"+usuario.getNombre()+"', usuario='"+usuario.getUsuario()+"', contrasena='"+usuario.getContrasena()+"', correo='"+usuario.getCorreo()+"',nombre_cargo='"+usuario.getNombreCargo()+"'  where id_profesor='"+usuario.getIdMaestro()+"'";
        statement=(Statement) conexion.createStatement();
        statement.execute(query);
        statement.close();
        return true;
    }

    @Override
    public boolean delete(String idProfesor, Connection conexion) throws Exception {
        Statement statement;
        String query = "delete from user where id_profesor='"+idProfesor+"'";
        statement=(Statement) conexion.createStatement();
        statement.execute(query);
        statement.close();
        return true;
    }

    @Override
    public Usuario usuarioIsExist(String usuario,String contrasena, Connection conexion) throws Exception {
        Usuario usuario1=null;
        
        Statement statement;
        ResultSet resultSet;
        
        String query="select * from user where usuario='"+usuario+"' AND contrasena='"+contrasena+"'";
        
        statement=(Statement) conexion.createStatement();
        resultSet=statement.executeQuery(query);
        
        if(resultSet!=null){
            if(resultSet.next())
            {
                usuario1=new Usuario();

                usuario1.setIdMaestro(resultSet.getInt("id_profesor"));
                usuario1.setNombre(resultSet.getString("nombre"));
                usuario1.setUsuario(resultSet.getString("usuario"));
                usuario1.setContrasena(resultSet.getString("contrasena"));
                usuario1.setCorreo(resultSet.getString("correo"));
                usuario1.setNombreCargo(resultSet.getString("nombre_cargo"));
            }
            resultSet.close();
        }

        statement.close();
        
        return usuario1;
    }


}
