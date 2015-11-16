/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import bean.Conversacion;
import interfaces.IComentario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author carlos
 */
public class DaoConversacion implements IComentario{

    @Override
    public boolean insert(Conversacion comentario, Connection conexion) throws Exception {
        Statement statement;
        statement = (Statement) conexion.createStatement();
        String query = "INSERT INTO comentarios values('"+comentario.getComentario()+"','"+comentario.getFecha()+"','"+comentario.getIdUsuario()+"')";
        statement.execute(query);
        statement.close();
        return true;
    }

    @Override
    public List<Conversacion> getAll(Connection conexion) throws Exception {
        List<Conversacion> listConversacion =new ArrayList<>();
       
        Statement statement;
        ResultSet resultSet;
        
        String query="SELECT c.idComentario,c.comentario,c.fecha,u.nombre FROM conversaciones c "
                + "INNER JOIN conversacion_miembro cm ON c.idComentario=cm.idConversacion "
                + "INNER JOIN user u ON cm.idUsuario=u.id_profesor ORDER BY c.fecha";
        
        statement=(Statement) conexion.createStatement();
        resultSet=statement.executeQuery(query);
        
        Conversacion conversacion;
        while(resultSet.next())
        {
            conversacion=new Conversacion();
            
            conversacion.setIdConversacion(resultSet.getInt("idComentario"));
            conversacion.setComentario(resultSet.getString("comentario"));
            conversacion.setFecha(resultSet.getString("fecha"));
            conversacion.setNombre(resultSet.getString("nombre"));
            
            listConversacion.add(conversacion);
        }
        
        resultSet.close();
        statement.close();
        
        return listConversacion;
    }

    @Override
    public boolean delete(int idComentario, Connection conexion) throws Exception {
        Statement statement;
        String query = "delete from user where id_profesor='"+idComentario+"'";
        statement=(Statement) conexion.createStatement();
        statement.execute(query);
        statement.close();
        return true;
    }
    
}
