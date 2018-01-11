<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Listado de tareas">

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
            <h2>Listado de tareas del alumno</h2>
            <table class="table table-striped">
                <tr>
                    <th>Nombre de la tarea</th>
                    <th>Fecha tarea</th>
                    <th>Tarea hecha</th>
                </tr>

                <#if tareas??>
                    <#list tareas as tarea>
                <tr>
                    <td>${tarea.nombre}</td>
                    <td>${tarea.fecha_entrega?date}</td>
                    <td>${tarea.hecho}</td>
                    </tr>
                    <#else>
                <tr>
                    <td colspan="3">No hay tareas asignadas</td>
                    </tr>
                    </#list>
                </#if>
                </table>
           
        </body>
    </html>
