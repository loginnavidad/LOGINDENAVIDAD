<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">
<#assign content>
form-control
</#assign>
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <link rel="stylesheet" href="/assets/bootstrap/css/bootstrap.min.css">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>
                <form action="users" method="get">
                    <input type="text" name="nombreUser" placeholder="Introduzca el nombre del administrador" class="form-control"/>
                    <input type="text" name="passUser" placeholder="Introduzca la contraseña" class="content"/>
                    <input type="email" name="emailUser" placeholder="Introduzca un email" class="form-control"/>
                    <button name="accion" value="addUser" class="btn btn-primary">Registrar</button>
                </form>
        <a href="p.html">Pincha aquí</a>
    </body>
    </html>
