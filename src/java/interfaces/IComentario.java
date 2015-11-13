/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.Conversacion;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface IComentario {
    public boolean insert(Conversacion comentario, Connection conexion) throws Exception;
    public List<Conversacion> getAll(Connection conexion) throws Exception;
    public boolean delete(int idComentario, Connection conexion) throws Exception;
}
