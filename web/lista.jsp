<%-- 
    Document   : lista
    Created on : 26/10/2015, 08:03:39 PM
    Author     : carlos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="com.zentrix.minutas.Consulta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SCA - Nombrar Lista</title>
        <!--<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>-->
        <!--<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>-->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
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
                <li class="navbar-link"><a href="index.jsp"> Home</a></li>
                <li class="navbar-link"><a href="reuniones.jsp">Reuniones</a></li>
                <li class="navbar-link active"><a href="#">Nombrar Lista</a></li>
                <li class="navbar-link"><a href="minutas.jsp">Generar Minuta</a></li>
                
            </ul>
            
        </div>
            
        </nav>

        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title"> Lista de Asistencias</h3>
                </div>
                <div class="panel-body">
                    <form name="listaAsistente" action="ServletListas" method="POST"> 
                        <jsp:useBean id="bean" scope="request" class="bean.listasUser" />
                        
                    <%  String[] nombre = bean.getNombre();
                        String[] id = bean.getIdProfesor(); 
                        int i=0;
                        if(nombre.length<0){ %>
                        <div class="input-group checkbox">
                            <label for="1" class="label"><c:out value="no hay datos que mostrar"/></label>
                        </div>
                    <% } else{ for(String e : nombre) {%>
                        
                        <div class="input-group checkbox">
                            <input type="checkbox" name="lista" id="<%= id[i] %>"  value="true">
                            <label for="<%= id[i] %>" class="label"><%= e %></label>
                        </div> 
                    <% i++;}} %>
                        
                
                <input type="submit" value="Enviar Lista" class="btn btn-primary btn-lg btn-block" name="btnList" />
                    </form>
                </div>
            </div>
        </div>

        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
