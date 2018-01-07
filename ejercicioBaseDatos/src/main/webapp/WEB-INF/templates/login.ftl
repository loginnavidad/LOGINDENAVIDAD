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
           <input type="text" name="nombreLogin" placeholder="Introduzca el usuario" class="form-control"/>
           <input type="text" name="passLogin" placeholder="Introduzca la contraseña" class="form-control"/>
           <img src="assets/Imagenes/ojo.png">
           <input type="submit" value="Enviar" class="btn btn-primary"/>
        </form>

    </body>
    </html>
