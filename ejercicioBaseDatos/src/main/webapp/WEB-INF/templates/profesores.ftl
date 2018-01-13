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
                    <th>Nombre de Asignatura</th>
                    <th>Curso</th>
                    <th>id</th>
                </tr>
                <#if asignaturas??>
                    <#list asignaturas as asignatura>
                <tr>
                    <td>
                        <a href="profesores?id_asignatura=${asignatura.id}" class="btn btn-info">${asignatura.nombre}</a>
                    </td>
                    <td></td>
                    <td>${asignatura.id}</td>
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
