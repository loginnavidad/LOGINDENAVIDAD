<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Listado de tareas">
<#assign subir_tarea_ok="Todo correcto. Acabas de subir tu tarea">
<#assign subir_tarea_ko="La tarea no se ha podido sunir. Vuelve a intentarlo">

<!DOCTYPE html>
<html>
    <head>
        <title>${title}</title>
        <meta charset="${charset}">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    </head>
    <body>
        <#include "cabecera.ftl">
        <div class="container">
            <h2>Crear una Tarea</h2>
            <form action="tareas" method="get" name="pagination">
                <input type="text" name="nombreTarea" placeholder="Descripcion de la tarea" class="form-control"/>
                <input type="text" name="fechaEntrega" placeholder="Fecha" class="form-control">
                <input type="submit" name="op" value="CREAR_TAREA" class="btn btn-primary"/>
            </form>
            <#if ok??>
                <#if ok == 1>
                    <div class="alert alert-success">
                        ${crear_tarea_ok}
                    </div>
                <#else>
                    <div class="alert alert-danger">
                        ${crear_tarea_ko}
                    </div>
                </#if>
            </#if>   
        </body>
    </html>
