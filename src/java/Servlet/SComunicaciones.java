/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import Ejb.EjbConversacion;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carlos
 */
@WebServlet(name = "SComunicaciones", urlPatterns = {"/SComunicaciones"})
public class SComunicaciones extends HttpServlet {

    @EJB
    private EjbConversacion ejbConversacion;
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        if(request.getMethod().equals("GET")){
            if(ejbConversacion.listarConversaciones()){
                request.setAttribute("ejbComunicacion", ejbConversacion);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }else{
                request.setAttribute("mensajeError", "No hay datos que mostrar");
                response.sendRedirect("index.jsp");
            }
        }
        if(request.getMethod().equals("POST")){
            ejbConversacion = new EjbConversacion();
            PrintWriter out = response.getWriter();

            if(request.getAttribute("idmaestro")!=null){
                ejbConversacion.getConversacion().setIdUsuario((int) request.getAttribute("idMaestro"));
                out.println(request.getAttribute("id"));
            }else{out.println("id es nulo");}
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    public String hoy (){
        java.util.Date hoy = new java.util.Date();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"); 
        try { 
            return df.format(hoy); 
        } catch (Exception pe) { 
            return "ParseException " + pe; 
        }
    }
}
