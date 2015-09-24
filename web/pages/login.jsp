<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Login</title>

    <!-- Bootstrap Core CSS -->
    <link href="../bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="../bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div id="titulo" class="panel-heading">
                        <h3 class="panel-title">Por favor, inicie sesión</h3>
                    <!--<h3 class="panel-title" style="color: red">Usuario o contraseña incorrectos</h3>   
                    -->
                    </div>
                    <div  class="panel-body">
                        <form id="formulario" role="form" method="POST" action="Usuarios?action=iniciar_sesion">
                            <fieldset>
                                 <div class="form-group">
                                           
                                     <select name="tipo" id="tipo" class="form-control">
                                                <option value="admin">Administrador</option>
                                                <option value="cliente">Cliente</option>
                                            </select>
                                        </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Usuario" name="usuario" id="usuario" type="text" autofocus>
                                </div>
                                <div  class="form-group">
                                    <input class="form-control" placeholder="Contraseña" name="password" id="password" type="password" value="">
                                </div>
                            
                                <!-- Change this to a button or input when using this as a form -->
                                <button type="submit" class="btn btn-lg btn-success btn-block">Iniciar Sesion</button>
                                 
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- jQuery -->
    <script src="../bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="../bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="../dist/js/sb-admin-2.js"></script>
    
    <script>
      //  $("#contenedor").hide();
      
      
      $("#formulario").submit(function (){
          var datosForm =$(this).serialize();
          $.post("../Usuarios?action=iniciar_sesion",datosForm,procesar).error(falla);
          return false;
      });
      
     function procesar(datos){
         console.log(datos);
        if(datos=="valido"){
            
            window.location="Admin/";
        }else if(datos="invalido"){
       $('fieldset div').removeClass("form-group");
       $('fieldset div').addClass("form-group has-error");
       $("div h3").html("<h3 class='panel-title' style='color: red'>Usuario, tipo o contraseña incorrectos</h3>");
        }else{
            $("div h3").html("<h3 class='panel-title' style='color: red'>Upps !! error inesperado por favor, intentalo mas tarde</h3>");
        }
     }
     function falla(){
         $("div h3").html("<h3 class='panel-title' style='color: red'>Upps !! error inesperado por favor, intentalo mas tarde</h3>");
     }
       
    </script>
</body>

</html>
