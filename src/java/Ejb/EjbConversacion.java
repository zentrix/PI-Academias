/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejb;

import DAO.DaoConversacion;
import DBConexion.Conexion;
import bean.Conversacion;
import java.sql.Connection;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author carlos
 */
@Stateless
public class EjbConversacion {
    private Conversacion conversacion;
    private List<Conversacion> listConversacion;
    private DaoConversacion daoConversacion;
    private Connection conexion;
    
    public EjbConversacion() {
        conversacion = new Conversacion();
        daoConversacion = new DaoConversacion();
    }
    
    public boolean insert() {
        boolean valorRetorno;
        try {
            conexion=Conexion.conexion();
            valorRetorno=daoConversacion.insert(conversacion, conexion);
            conexion.close();
            valorRetorno = true;
        }
        catch(Exception ex) {
            valorRetorno=false;
        }
        return valorRetorno;
    }
    
    public boolean listarConversaciones()
    {
        boolean valorRetorno;
        try {
            conexion=Conexion.conexion();
            listConversacion=daoConversacion.getAll(conexion);
            conexion.close();
            valorRetorno=true;
        }
        catch(Exception ex) {
            valorRetorno=false;
        }
        return valorRetorno;
    }
    
    public boolean borrarConversaciones(int idConversacion) {
        boolean valorRetorno;
        try {
            conexion=Conexion.conexion();
            daoConversacion.delete(idConversacion, conexion);
            conexion.close();
            valorRetorno=true;
        }
        catch(Exception ex) {
            valorRetorno=false;
        }
        return valorRetorno;
    }
    
    public Conversacion getConversacion() {
        return conversacion;
    }

    public void setConversacion(Conversacion conversacion) {
        this.conversacion = conversacion;
    }

    public List<Conversacion> getListConversacion() {
        return listConversacion;
    }

    public void setListConversacion(List<Conversacion> listConversacion) {
        this.listConversacion = listConversacion;
    }
}
