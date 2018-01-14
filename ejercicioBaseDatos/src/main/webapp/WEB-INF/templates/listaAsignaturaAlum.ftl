<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Listado de tus asignaturas">
<#assign cerrar_sesion="Cerrar sesion">
<#assign title_table="Listado de tus asignaturas">
<#assign no_asignaturas="No tienes asignaturas asignadas">
<#assign tareas="Tareas">
<#assign nombre_asignatura="Nombre asignatura">
<#assign nota="Nota">
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
            <h2>${title_table}</h2>
            <table class="table table-striped">
                <tr>
                    <th>${tareas}</th>
                    <th>${nombre_asignatura}</th>
                    <th>${nota}</th>
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
                    <td colspan="3">${no_asignaturas}</td>
                    </tr>
                    </#list>
                </#if>
                </table>
            
            <a href="Users?accion=loginout" class="btn btn-success">${cerrar_sesion}</a>  
        </body>
    </html>
