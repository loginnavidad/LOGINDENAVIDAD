<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <script src="assets/js/verpassword.js"></script>
        </head>
    <body>
    <div class="container">
        <div class="row col-xs-offset-5">
            <h3>Clase DWES</h3>
        </div>
        <div class="row">
            <div class="col-xs-4 col-xs-offset-4">
                <form action="users" method="get">
                   <input type="text" name="correoLogin" placeholder="Introduzca el correo electrónico" class="form-control"/>
                   <input type="password" name="passLogin" placeholder="Introduzca la contraseña" id="inputPass" class="form-control">

                   <input type="submit" name="accion" value="login" class="btn btn-primary col-xs-5 col-xs-offset-3"/>
                </form>
            </div>
        </div><br><br>
        <a href="cambiopassword" class="col-xs-offset-5">Cambia la contraseña</a><br>
        <a href="recuperarpassword" class="col-xs-offset-5">¿Has olvidado la contraseña?</a>
        <a href="registro" class="col-xs-offset-5">¿No tienes una cuenta?</a>
        <#if mensaje??>
            <p class="col-xs-offset-5">${mensaje}</p>
        <#else>
            <p></p>
        </#if>
    </div>
    </body>
    </html>
