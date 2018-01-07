<#ftl strip_whitespace = true>

<#setting boolean_format=computer>
<#import "/libs/mylib.ftl" as my>

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
                    <td>${usuario.nombre}</td>
                    <#if usuario.activo == 0>
                        <td>No activo 
                            <form action="users" method="get" name="formulario1">
                                <input type="hidden" name="id" value="${usuario.id}"/>
                                <button name="action" value="activacionManual" class="btn btn-primary"  onclick="enviar1();">Activar</button>
                            </form>
                        </td>
                    <#elseif usuario.activo == 1>
                        <td>Activado</td>
                    </#if>
                    <#if usuario.permiso == 1>
                        <td>
                            <form action="users" method="get" name="formulario2">
                                <input type="hidden" name="id" value="${usuario.id}"/>
                                <input type="checkbox" name="administrador" checked="checked"/>
                                <button name="accion" value="DesactivarAdmin" class="btn btn-primary"  onclick="enviar2();">Desactivar</button>
                            </form>
                        </td>
                    <#else>
                        <td>
                            <form action="users" method="get" name="formulario2">
                                <input type="hidden" name="id" value="${usuario.id}"/>
                                <input type="checkbox" name="administrador"/>
                                <button name="accion" value="activarConSuper" class="btn btn-primary" onclick="enviar2();">Activar</button>
                            </form>
                        </td>
                    </#if>
                </tr>
            </#list>
        <table>
    </body>
    </html>
