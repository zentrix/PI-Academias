/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zentrix.minutas;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletOutputStream;

/**
 *
 * @author carlos
 */
public class SMinuta extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet minutaservlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet minutaservlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>El titulo es  " + request.getAttribute("titulo") + "</h1>");
            out.println("<h1>Servlet minutaservlet at " + request.getAttribute("cuerpominuta") + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
        
        //obtenemos los datos de la forma
        String titulo = request.getParameter("titulo");
        String cuerpo = request.getParameter("cuerpominuta");
        
        ServletOutputStream sos = response.getOutputStream();
        response.setContentType("application/pdf");
        //creamos un nuevo documento
        Document doc = new Document();
        
        
        //creamos los estilos y las fuentes
        Font bfBold20 = new Font(FontFamily.TIMES_ROMAN, 20, Font.BOLD, new BaseColor(0, 0, 0)); 
        Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLDITALIC, new BaseColor(0, 0, 0)); 
        Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);
        try {
            //creamos  un instancio de PdfWriter usando el OutputStream
            PdfWriter.getInstance(doc, sos);
            
            doc.addAuthor("Sistema Gestor de Academias");
            doc.addCreationDate();
            doc.addProducer();
            doc.addCreator("Sistema de Academias");
            doc.addTitle(titulo);
            doc.setPageSize(PageSize.LETTER);
            doc.open();
            doc.add(new Paragraph(titulo , bfBold20));
            doc.add(new Paragraph(cuerpo, bf12));
            doc.close();
            
//        PrintWriter out = response.getWriter();
//        out.println("titulo "+ titulo);
//        out.println("cuerpo "+ cuerpo);
        } catch (DocumentException ex ) { ex.printStackTrace(); } 
          catch (Exception e){ e.printStackTrace(); }
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

}
