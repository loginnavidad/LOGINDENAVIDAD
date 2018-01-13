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
            function activar(){
                activar.submit();
            }
            function desactivar(){
                desactivar.submit();
            }
            function enviar2(){
                formulario2.submit();
            }
            function addpaginas(){
                var numerodeusuarios = document.getElementById("paginar").value;
                numerodeusuarios = numerodeusuarios + 10;
                paginar.submit();
            }
            function substracpaginas(){
                var numerodeusuarios = document.getElementById("paginar").value;
                numerodeusuarios = numerodeusuarios - 10;
                paginar.submit();
            }
        </script>
        </head>
    <body>
        <table class="table table-striped">
            <tr>
                <td class="bg-primary">Nombre</td>
                <td class="bg-primary">Cuenta Activada</td>
                <td class="bg-primary">Correo Electrónico</td>
                <td class="bg-primary">Permiso</td>
            <tr>
            <#list usuarios as usuario>
                <tr>
                    <td>${usuario.user}</td>
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
                    <td>
                       <#if usuario.id_permiso??>
                            <#if usuario.id_permiso == 2>
                                <p>Profesor</p>
                            <#elseif usuario.id_permiso == 1>
                                <form action="users" method="get" name="desactivar">
                                    <input type="hidden" name="id" value="${usuario.id}"/>
                                    <input type="checkbox" name="admin" checked="checked">
                                    <button name="accion" value="DesactivarAdmin" onclick="desactivar();" class="btn btn-primary">Enviar</button>
                                </form>
                            <#elseif usuario.id_permiso == 3>
                                <p>Alumno</p>
                            <#elseif usuario.id_permiso == 4>
                                <p>Superadmin</p>
                            <#elseif usuario.id_permiso == 6>
                                <form action="users" method="get" name="activar">
                                   <input type="hidden" name="id" value="${usuario.id}"/>
                                   <input type="checkbox" name="admin">
                                   <button name="accion" value="ActivarAdmin" onclick="activar();" class="btn btn-primary">Enviar</button>
                               </form>
                            </#if>
                        <#else>
                                <p>Operacion no disponible</p>
                        </#if>
                        
                    </td>
                    
                </tr>
            </#list>
        <table>
            <form action="superadministrador" method="get" name="pagination">
                <input type="hidden" id="paginar" value="${numUsers}" name="paginacion">
                <button onclick="substracpaginas();" class="btn btn-primary"><-</button>
                <button onclick="addpaginas();" class="btn btn-primary col-xs-offset-11">-></button>
            </form>
    </body>
    </html>
