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
        </head>
    <body>
            <div class="row">
                <div class="col-xs-4">
                    <form action="recuperarpassword" method="get">
                        <input type="text" name="correo" placeholder="Introduzca el correo electronico" class="form-control"/>
                        <input type="submit" name="accion" value="recuperarpassword" class="btn btn-primary col-xs-offset-3">
                    </form>
                <div>
            </div>
        </body>
    </html>
