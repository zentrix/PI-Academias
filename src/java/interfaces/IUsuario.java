/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import bean.Usuario;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author carlos
 */
public interface IUsuario {
    public boolean insert(Usuario usuario, Connection conexion)throws Exception;
    public Usuario getByIdProfesor(String idProfesor, Connection conexion)throws Exception;
    public Usuario usuarioIsExist(String usuario,String contrasena, Connection conexion)throws Exception;
    public List<Usuario> getAll(Connection conexion)throws Exception;
    public boolean update(Usuario usuario, Connection conexion)throws Exception;
    public boolean delete(String idProfesor, Connection conexion)throws Exception;
}
