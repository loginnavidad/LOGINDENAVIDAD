<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.css">
        <script>
            function pantallaLogin(){
                window.location.href = "login";
            }
        </script>
        </head>
        <body>
            <div class="container">
                <div class="col-xs-offset-5">
                    <h3>Registro</h3>
                </div>
                <div class="row">
                    <div  class="col-sm-4 col-sm-offset-4 row-height back-dark margin-general">
                        <form action="users" method="get" class="form-margin">
                            <input type="text" name="nombreUser" placeholder="Introduzca el nombre del usuario" class="input-margin form-control input-height"/>
                            <input type="text" name="passUser" placeholder="Introduzca la contraseña" class="input-margin form-control input-height"/>
                            <input type="email" name="emailUser" placeholder="Introduzca un email" class="input-margin form-control input-height"/>
                            <button name="accion" value="addUser" class="btn btn-primary btn-margin col-sm-offset-2 col-sm-7 input-height">Registrar</button>
                        </form>
                            <button class="btn btn-primary btn-margin col-sm-offset-2 col-sm-7 input-height" id="enlaceLogin" onclick="pantallaLogin();">Inicia sesión</button>
                    <div>
                </div>
            </div>
        </body>
    </html>
