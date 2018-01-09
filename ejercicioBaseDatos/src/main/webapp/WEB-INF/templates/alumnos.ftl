<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">

<!DOCTYPE html>
<html>
    <head>
        <title>Listado alumnos</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>
        <table>
            <tr>
                <th>Ver datos</th>
                <th>ID</th>
                <th>Nombre</th>
            </tr>
            <#if content??>
                <#list alumnos as alumno>
                <tr>
                    <td>
                        <input type="button" value="Ver">
                    </td>
                    <td>${alumno.id}</td>
                    <td>${alumno.nombre}</td>
                </tr>
                </#list>
            <#else>
                <div>No existen alumnos</div>
            </#if>
            </table>	
        </body>
    </html>
