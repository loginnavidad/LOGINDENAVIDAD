<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <script>
            function enviar1(){
                formulario1.submit();
            }
            function enviar2(){
                formulario2.submit();
            }
        </script>
        </head>
    <body>
        <table>
            <tr>
                <td>Nombre</td>
                <td>Activo</td>
                <td>Permiso</td>
                <td>Otros</td>
            <tr>
            <#list usuarios as usuario>
                <tr>
                    <td>${usuario.user}</td>
                    <#if usuario.activo == false>
                    <td>No activo
                        <form action="users" method="get" name="formulario2">
                            <input type="hidden" name="id" value="${usuario.id}"/>
                            <button name="accion">Activar</button>
                        </form>
                    </td>
                    <#elseif usuario.activo == true>
                    <td>Activo</td>
                    </#if>
                    <td>${usuario.codigo_activacion}</td>
                    <td>${usuario.email}</td>
                </tr>
            </#list>
        <table>
    </body>
    </html>