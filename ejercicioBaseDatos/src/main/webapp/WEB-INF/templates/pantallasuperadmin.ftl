<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Example">
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
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
        <table class="table table-striped">
            <tr>
                <td>Nombre</td>
                <td>Cuenta Activada</td>
                <td>Correo Electrónico</td>
                <td>Permiso</td>
                <td>Otros</td>
            <tr>
            <#list usuarios as usuario>
                <tr>
                    <td>${usuario.nombre}</td>
                    <#if usuario.activo == false>
                    <td>No activo
                        <form action="users" method="get" name="formulario2">
                            <input type="hidden" name="id" value="${usuario.id}"/>
                            <button name="accion" value="activacionManual" class="btn btn-primary">Activar</button>
                        </form>
                    </td>
                    <#elseif usuario.activo == true>
                    <td>Activo</td>
                    </#if>
                    <td>${usuario.email}</td>
                    <td>Blablabla</td>
                    <td>
                        <form action="users" method="get" name="formulario2">
                            <input type="hidden" name="id" value="${usuario.id}"/>
                            <button name="accion" value="borrar" class="btn btn-primary">Borrar</button>
                        </form>
                    </td>
                </tr>
            </#list>
        <table>
    </body>
    </html>
