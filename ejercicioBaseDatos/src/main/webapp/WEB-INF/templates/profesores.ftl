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
            <h2>Listado de tus asignaturas</h2>
            <table class="table table-striped">
                <tr>
                    <th>Tareas</th>
                    <th>Nombre asignatura</th>
                    <th>Nota</th>
                </tr>
                <#if asignaturas??>
                    <#list asignaturas as asignatura>
                <tr>
                    <td>
                        <a href="tareas?id=${asignatura.id}" class="btn btn-info">Tareas</a>
                    </td>
                    <td>${asignatura.nombre}</td>
                    <td>${asignatura.nota}</td>
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
