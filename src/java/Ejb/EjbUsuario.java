/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import DAO.DaoUsuario;
import DBConexion.Conexion;
import bean.Usuario;
import java.sql.Connection;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author carlos
 */
@Stateless
public class EjbUsuario {
    private Usuario usuario;
    private List<Usuario> listaUsuario;
    private Connection conexion;
    private final DaoUsuario daoUsuario;
    public EjbUsuario()
    {
        usuario=new Usuario();
        daoUsuario=new DaoUsuario();
    } 
    public boolean insert()
    {
        boolean valorRetorno;
        try
        {
            conexion=Conexion.conexion();
            valorRetorno=daoUsuario.insert(usuario, conexion);
            conexion.close();
            valorRetorno = true;
        }
        catch(Exception ex)
        {
            valorRetorno=false;
        }
        return valorRetorno;
    }
    
    public boolean listarUsuario()
    {
        boolean valorRetorno;
        try
        {
            conexion=Conexion.conexion();
            listaUsuario=daoUsuario.getAll(conexion);
            conexion.close();
            valorRetorno=true;
        }
        catch(Exception ex)
        {
            valorRetorno=false;
        }
        return valorRetorno;
    }
    
    public boolean leerPorIdProfesor(String idProducto)
    {
        boolean valorRetorno;
        try
        {
            conexion=Conexion.conexion();
            usuario=daoUsuario.getByIdProfesor(idProducto, conexion);
            conexion.close();
            valorRetorno=true;
        }
        catch(Exception ex)
        {
            valorRetorno=false;
        }
        return valorRetorno;
    }
    public boolean isExistUsuario(String usename, String contrasena){
        boolean valorRetorno;
        try{
            conexion=Conexion.conexion();
            usuario=daoUsuario.usuarioIsExist(usename, contrasena, conexion);
            if(usuario==null)
                return false;
            else{
                conexion.close();
                valorRetorno=true;
            }
        }catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
        return valorRetorno;
    }
    
    public boolean actualizarUsuario()
    {
        boolean valorRetorno;
        try
        {
            conexion=Conexion.conexion();
            daoUsuario.update(usuario, conexion);
            conexion.close();
            valorRetorno=true;
        }
        catch(Exception ex)
        {
            valorRetorno=false;
        }
        return valorRetorno;
    }
    

    
    public boolean borrarUsuario(String idProducto)
    {
        boolean valorRetorno;
        try
        {
            conexion=Conexion.conexion();
            daoUsuario.delete(idProducto, conexion);
            conexion.close();
            valorRetorno=true;
        }
        catch(Exception ex)
        {
            valorRetorno=false;
        }
        return valorRetorno;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario tProducto) {
        this.usuario = tProducto;
    }

    public List<Usuario> getListaTProducto() {
        return listaUsuario;
    }

    public void setListaTProducto(List<Usuario> listaTProducto) {
        this.listaUsuario = listaTProducto;
    }
}
