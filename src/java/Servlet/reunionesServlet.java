/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.zentrix.minutas;

import com.sun.mail.util.MailConnectException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


/**
 *
 * @author zentr
 */
public class reunionesServlet extends HttpServlet {

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
            out.println("hola");
            /* TODO output your page here. You may use following sample code. */
//            String to = request.getParameter("");
//            crearMail("","","","","");
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
        try(PrintWriter out =  response.getWriter()) {
            String fecha = request.getParameter("fecha");
            String motivo = request.getParameter("motivo");
            String puntos = request.getParameter("puntos");
            String to ="zentrix.24@gmail.com";
            String from ="villalvazo_rodriguez@ucol.mx";
            String host = "smtp.gmail.com";
            String header = "this mail from java servlet";
            
            Properties pro = System.getProperties();
            pro.put("mail.smtp.host", "aspmx.l.google.com");
            pro.put("mail.smtp.port", "25");
            pro.put("mail.smtp.auth", "true");
            pro.put("mail.user", from);
            pro.put("mail.password", "carlos24");
            
            Session session = Session.getDefaultInstance(pro);
            MimeMessage mensaje = new MimeMessage(session);
            mensaje.setFrom(new InternetAddress(from));
            mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mensaje.setSubject(header);
            mensaje.setContent("<h1>"+header+"</h1><p>"+fecha+"</p><br><p>"+motivo+"</p><br><p>"+puntos+"</p>", "text/html");
            out.println("el email se envio Coretamente");
            Transport.send(mensaje);
        } catch (AddressException ex) {
            PrintWriter out2 = response.getWriter();
            out2.println("AddressException");
        } catch (MessagingException ex) {
            PrintWriter out2 = response.getWriter();
            out2.println("MessaginException");
        }
        
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
    /*private boolean crearMail(String to, String from,String host,String header,String mns){
        boolean re = false;
        if(to!=null && from != null){
            if(host!=null){
                Properties pro = System.getProperties();
                pro.getProperty("mail.smtp.host", host);
                Session session = Session.getDefaultInstance(pro);
                try{
                    MimeMessage mensaje = new MimeMessage(session);
                    mensaje.setFrom(new InternetAddress(from));
                    mensaje.setRecipient(Message.RecipientType.TO, new InternetAddress(to));
                    mensaje.setSubject(header);
                    mensaje.setContent("<h1>"+header+"</h1><p>"+mns+"</p>", "text/html");
                    Transport.send(mensaje);
                    re=true;
                    return re;
                }catch(MailConnectException e){
                    
                    Logger.getLogger(reunionesServlet.class.getName()).log(Level.SEVERE, null, e);
                    return re;
                } catch (AddressException ex) {
                    
                    Logger.getLogger(reunionesServlet.class.getName()).log(Level.SEVERE, null, ex);
                    return re;
                } catch (MessagingException ex) {
                    
                    Logger.getLogger(reunionesServlet.class.getName()).log(Level.SEVERE, null, ex);
                    return re;
                }
                
            }else{return re;}
        }else {
            return re;
        }
    } */
}
