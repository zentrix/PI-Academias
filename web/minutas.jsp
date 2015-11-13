<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>SCA - Creacion De Minutas</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
                        <li class="navbar-link"><a href="listas">Nombrar Lista</a></li>
                        <li class="navbar-link active"><a href="#">Generar Minuta</a></li>
                
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Action</a></li>
                        <li><a href="#">Another action</a></li>
                        <li><a href="#">Something else here</a></li>
                        <li role="separator" class="divider"></li>
                        <li><a href="#">Separated link</a></li>
                    </ul>
                </li>
            </ul>
        </div>
            
        </nav>
        <div class="container">
            <div class="panel panel-default">
                <div class="panel-heading"> Creacion de Minutas </div>
                <div class="panel-body">
                    <form name="minuta" action="minutaservlet" method="POST" >
                        <div class="form-group">
                            <input name="titulo" class="form-control" id="titulo" type="text" placeholder="Titulos"/>
                        </div>
                        <div class="form-group">
                            <label for="cuerpo">Puntos de la reunion</label>
                            <textarea name="cuerpominuta" class="form-control" rows="3" id="cuerpo"> </textarea>
                        </div>
                        <div>
                            <input type="submit" name="generar" value="Generar" class="btn btn-primary btn-lg btn-block"/>
                        </div>
                    </form>
                    <a href="lista.jsp">Listas</a>
                </div>
            </div>
        </div>
        <script src="js/bootstrap.min.js" type="text/javascript"></script>
    </body>
</html>
