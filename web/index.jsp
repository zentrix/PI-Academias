<%-- 
    Document   : index
    Created on : 27/10/2015, 05:47:12 PM
    Author     : carlos
--%>

<%@page import="Ejb.EjbConversacion"%>
<%@page import="bean.Conversacion"%>
<%@page import="bean.Usuario"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema De Control De Academias</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <jsp:useBean id="ejbUsuario" scope="session" class="Ejb.EjbUsuario" />
        <jsp:useBean id="ejbComunicacion" scope="session" class="Ejb.EjbConversacion" />
        <% Ejb.EjbConversacion ejbConversacion = (EjbConversacion) session.getAttribute("ejbComunicacion"); %>
        <% if(ejbUsuario.getUsuario().getUsuario()==null){ response.sendRedirect("login.jsp");} %>
        <!-- Bara de de navegacion-->
            <nav role="navigation" class="navbar navbar-default">
                <div class="navbar-header">
                    <button type="button" data-target="#navbarCollapse" data-toggle="collapse" class="navbar-toggle">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a href="#" class="navbar-brand">RancholoSoftware</a>
                </div>
                <div id="navbarCollapse" class="collapse navbar-collapse">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="#"> Home</a></li>
                        <li class="navbar-link"><a href="reuniones.jsp">Reuniones</a></li>
                        <li class="navbar-link"><a href="listas">Nombrar Lista</a></li>
                        <li class="navbar-link"><a href="minutas.jsp">Generar Minuta</a></li>
                        </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <li><p class="navbar-text">ingreso como: <c:out value="${ejbUsuario.usuario.nombre}" default="existe la variable"/></p></li>
                    </ul>
                </div>        
            </nav>
        <!-- END Barra de Navegacion-->       
       
            <div class="container">
                <div class="panel panel-default">
                    <form name="chat" action="" method="POST">
                        <div class="form-group">
                           <textarea class="form-control" name="mensaje" rows="3" placeholder="ingresa un comentario" required="true" ></textarea>
                           <input type="hidden" name="idMaestro" id="idMaestro" value="${ejbUsuario.usuario.idMaestro}"/>
                           <input type="submit" class="btn btn-block" name="send" value="Publicar">
                        </div>                        
                    </form>
                </div>
            </div>
            <% if(ejbComunicacion.getListConversacion()==null){} 
            else {
            %>
            
                <% for(int i=0;i<ejbComunicacion.getListConversacion().size();i++) { %>
                    <div class="container">
                        <div class="panel panel-default">
                            <% Conversacion conversacio = new Conversacion();
                                conversacio = ejbComunicacion.getListConversacion().get(i);
                            %>
                            <label><%=conversacio.getNombre() %></label>
                            <label><%=conversacio.getFecha() %></label>
                            <label><%=conversacio.getComentario() %></label>
                        </div>
                    </div>
                <% } 
            } %>
            
            
        <script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
