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
        </head>
    <body>
        <div class="col-12 navbar navbar-toggleable-md bg-info">
            <div>
                <div>
                    <h2>Proyecto Navidad</h2>
                </div>
            <a href="users?accion=logout" class="col-xs-offset-10 btn btn-primary" style="margin-top:-60px;">Cerrar Sesion</a>
            </div>
        </div>
    </body>
</html>
