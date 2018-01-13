<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Listado alumnos">

<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        </head>
    <body>
        <div class="container">
            <h2>Listado de tus alumnos</h2>
            <table class="table table-striped">
                <tr>
                    <th>Nombre</th>
                    <th>Nota</th>
                    <th></th>
                </tr>
                <#if asignaturas??>
                    <#list alumnos as alumno>
                <tr>
                    <td>
                        ${alumno.nombre}
                    </td>
                    <td></td>
                    <td><form action="users" method="get" class="form-margin">
                        <input type="text" name="nota" placeholder="nota" value=${alumno.nota} class="input-margin form-control input-height"/></td>
                    </tr>
                    <#else>
                <tr>
                    <td colspan="3">No existen asignaturas</td>
                    </tr>
                    </#list>
                </#if>
                </table>
        </body>
    </html>
