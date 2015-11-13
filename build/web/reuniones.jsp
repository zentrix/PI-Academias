<%-- 
    Document   : reuniones
    Created on : 27/10/2015, 06:11:10 PM
    Author     : carlos
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SCA - Convocar Reuniones</title>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap-datetime/css/bootstrap-datetimepicker.css" rel="stylesheet" type="text/css"/>
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
                    <li class="navbar-link active"><a href="#">Reuniones</a></li>
                    <li class="navbar-link"><a href="listas">Nombrar Lista</a></li>
                    <li class="navbar-link"><a href="minutas.jsp">Generar Minuta</a></li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
                </ul>
            </div>
            
        </nav>
        
        <div class="container">
            <div class="panel panel-default"> 
                <div class="panel-heading"> Canvocar a reuniones</div>
                <div class="panel-body">
                    <form name="reuniones" action="reuniones" method="POST">
                        <div class="form-group">
                            <label for="dtp_input1" class="control-label">DateTime Picking</label>
                            <div class="input-group date" id="form_datetime" data-date="2000-09-16T05:25:07Z" data-date-format="dd MM yyyy - HH:ii p" data-link-field="dtp_input1">
                                <input class="form-control" size="16" type="text" value="" readonly>
                                <span class="input-group-addon"><span class="glyphicon glyphicon-time"></span></span>
                            </div>
                            <input type="hidden" id="dtp_input1" value="" /><br/>
                        </div>                        
                        <div class="form-group">
                            <label for="motivo" class="control-label">Propocito de la reunion</label><br>
                            <input name="motivo" class="form-control" type="text" id="motivo" >
                        </div>                        
                        <div class="form-group">
                            <label for="puntos" class="control-label">puntos de la reunion</label><br>
                            <textarea name="puntos" class="form-control" id="puntos" required></textarea>                           
                        </div>

                        <input type="submit" class="btn btn-primary" value="Crear Reunion" onclick="listo()">
                    </form>
                </div>
            </div>
        </div>
        <script src="js/jquery-2.1.4.min.js" type="text/javascript"></script>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
        <script src="css/bootstrap-datetime/js/bootstrap-datetimepicker.js" type="text/javascript"></script>
        <script src="css/bootstrap-datetime/js/locales/bootstrap-datetimepicker.es.js" type="text/javascript"></script>
        <script type="text/javascript">
            $('#form_datetime').datetimepicker({
                language:  'es',
                daysOfWeekDisabled: '0,6',
                weekStart: 0,
                startDate: "2014-01-01 0:00",
                todayBtn:  1,
                autoclose: 1,
                todayHighlight: 1,
                startView: 2,
                forceParse: 0,
                showMeridian: true
            });
        </script>
    </body>
</html>
