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
            <h2>Listado de alumnos</h2>
            <table class="table table-striped">
                <tr>
                    <th>Datos del alumno</th>
                    <th>ID</th>
                    <th>Nombre</th>
                </tr>
            <#if action==0>
                <#if alumnos??>
                    <#list alumnos as alumno>
                <tr>
                    <td>
                        <a href="tareas?id=${alumno.id}" class="btn btn-info">Info</a>
                    </td>
                    <td>${alumno.id}</td>
                    <td>${alumno.nombre}</td>
                    </tr>
                    <#else>
                <tr>
                    <td colspan="3">No existen alumnos</td>
                    </tr>
                    </#list>
                </#if>
                <#else>
                <tr>
                    <td>
                       <a href="tareas?id=${alumno.id}" class="btn btn-info">Info</a>
                    </td>
                    <td>${alumno.id}</td>
                    <td>${alumno.nombre}</td>
                    </tr>
            </#if>
                </table>
            <div>
                <h3>Buscar el alumno</h3>
            </div>
            <form method="POST" action="alumnos?op=GETALUM">
                <input type="text" placeholder="Nombre" name="nombre">
                <input type="submit" class="btn btn-primary" value="Buscar">
            </form>
            <a href="alumnos">Listar todos los alumnos</a>
        </body>
    </html>
