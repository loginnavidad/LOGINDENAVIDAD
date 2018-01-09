<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">

<!DOCTYPE html>
<html>
    <head>
        <title>Asignaturas</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        </head>
    <body>
        <table>
            <tr>
                <th>Ver datos</th>
                <th>Nombre</th>
            </tr>
            <#if content??>
                <#list asignaturas as asignatura>
                <tr>
                    <td>
                        <input type="button" value="Ver">
                    </td>
                    <td>${asignatura.nombre}</td>
                </tr>
                </#list>
            <#else>
                <div>No estas impartiendo ninguna asignatura</div>
            </#if>
            </table>	
        </body>
    </html>
