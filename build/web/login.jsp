<%-- 
    Document   : login
    Created on : 8/11/2015, 11:00:58 PM
    Author     : carlos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SCA -Login</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <!-- css -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-datepicker.css" rel="stylesheet" type="text/css"/>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%%>
        <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Login</h3>
                </div>
                <div class="panel-body">
                    <form name="login" action="SLogin" method="POST"> 
                        <%  if(session.getAttribute("error")==null){}
                            else if(session.getAttribute("error").equals("ERROR")){
                                
                                 %>
                        <div class="alert alert-danger" role="alert">
                            <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
                            <span class="sr-only">Error:</span>
                            Usuario y Contraseña Erroneos
                        </div>
                                 <%  session.setAttribute("error", "");
                            }
                            
                        %>
                        <div class="form-group">
                            <label for="user" class="control-label">Usuario</label>
                            <div class="controls">
                                <input type="text" name="usuario" class="form-control" id="user" required/>
                                <p class="help-bock"></p>
                            </div>
                            
                        </div>
                        <div class="form-group">
                            <label for="pass">Contraseña</label>
                            <input type="password" name="contrasena" class="form-control" id="pass" required/>
                            <p class="help-block"></p>
                        </div>
                        
                        <input type="submit" value="Enviar" name="send" class="btn btn-primary btn-block"/>
                    </form>
                </div>
        </div>
                        
        <!-- javascript -->
        <script src="js/jquery.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="js/bootstrap-datetimepicker.js" type="text/javascript"></script>
    </body>
</html>

