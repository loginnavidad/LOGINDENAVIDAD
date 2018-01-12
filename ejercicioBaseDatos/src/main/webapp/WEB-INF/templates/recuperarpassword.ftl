<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>
            <div class="row">
                <div>
                    <form action="recuperarpassword" method="get">
                        <input type="text" name="correo" placeholder="Introduzca el correo electronico" class="form-control"/>
                        <input type="submit" name="accion" value="recuperarpassword" class="btn btn-primary">
                    </form>
                <div>
            </div>
        </body>
    </html>
