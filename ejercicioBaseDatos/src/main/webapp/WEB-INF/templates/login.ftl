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
        <form action="users" method="get">
           <input type="text" name="correoLogin" placeholder="Introduzca el correo electrónico" class="form-control"/>
           <input type="pass" name="passLogin" placeholder="Introduzca la contraseña" id="inputPass" class="form-control">
           <img src="assets/Imagenes/ojo.jpg" alt="Ojo ver pass" title="aaa" id="ver">
           <input type="submit" name="accion" value="login" class="btn btn-primary"/>
        </form>
    <a href="cambiopassword">Cambia la contraseña</a>
    <a href="recuperarpassword">¿Has olvidado la contraseña?</a>
    </body>
    </html>
