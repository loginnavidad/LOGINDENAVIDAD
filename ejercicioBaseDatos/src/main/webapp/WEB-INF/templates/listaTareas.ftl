<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Listado de tareas">
<#assign no_tareas="No hay tareas asignadas">
<#assign subir_tarea_ok="Todo correcto. Acabas de subir tu tarea">
<#assign subir_tarea_ko="La tarea no se ha podido sunir. Vuelve a intentarlo">
<#assign return_asignaturas="Volver a mis asignaturas">
<#assign cerrar_sesion="Cerrar sesion">
<#assign nombre_tarea="Nombre de la tarea">
<#assign fecha_tarea="Fecha tarea">
<#assign tarea_hecha="Tarea hecha">
<#assign subir_tarea="Subir tarea">
<#assign volver_tarea="Volver a subir tarea">
<#assign titulo_tabla="Tus tareas">
<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <script>
            function addpaginas(){
                document.getElementById("paginar").value = document.getElementById("paginar").value + 10;
                pagination.submit();
            }
            function substracpaginas(){
                document.getElementById("paginar").value = document.getElementById("paginar").value -10;
                pagination.submit();
            }
        </script>
        </head>
    <body>
        <#include "cabecera.ftl">
        <div class="container">
            <h2>${titulo_tabla}</h2>
            <table class="table table-striped">
                <tr>
                    <th>${nombre_tarea}</th>
                    <th>${fecha_tarea}</th>
                    <th>${tarea_hecha}</th>
                    <th>${subir_tarea}</th>
                    </tr>

                <#if tareas??>
                    <#list tareas as tarea>
                <tr>
                    <td>${tarea.nombre}</td>
                    <td>${tarea.fecha_entrega?date}</td>
                    <td>
                        <#if tarea.hecho == 1>
                            <span class="glyphicon glyphicon-ok"></span>
                        <#else>
                            <span class="glyphicon glyphicon-remove"></span>
                        </#if>
                    </td>
                    <#if tarea.hecho == 0>
                    <td>
                        <a href="tareas?op=UPD_TAREA&id_tarea=${tarea.id_tarea}&id=${id_asig}" class="btn btn-primary">${subir_tarea}</a>    
                    </td>
                    <#else>
                    <td>
                        <a href="tareas?op=UPD_TAREA&id_tarea=${tarea.id_tarea}&id=${id_asig}" class="btn btn-warning">${volver_tarea}</a>    
                    </td>
                    </#if>
                </tr>
                    <#else>
                <tr>
                    <td colspan="3">${no_tareas}</td>
                    </tr>
                    </#list>
                </#if>
                </table>
                <#if ok??>
                    <#if ok == 1>
                        <div class="alert alert-success">
                           ${subir_tarea_ok}
                        </div>
                        <#else>
                        <div class="alert alert-danger">
                            ${subir_tarea_ko}
                        </div>
                    </#if>
                </#if>   
            <form action="alumnos" method="get" name="pagination">
                <input type="hidden" id="paginar" value="${numAsig}" name="paginacion">
                <button onclick="substracpaginas();" class="btn btn-primary col-xs-offset-5"><-</button>
                <button onclick="addpaginas();" class="btn btn-primary col-xs-offset-5">-></button>
            </form>
            <a href="alumnos" class="btn btn-info">${return_asignaturas}</a>
            
            <a href="Users?accion=loginout" class="btn btn-success">${cerrar_sesion}</a>  
        </body>
    </html>
