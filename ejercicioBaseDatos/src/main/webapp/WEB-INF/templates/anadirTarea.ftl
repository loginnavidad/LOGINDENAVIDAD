<#ftl strip_whitespace = true>

<#assign charset="UTF-8">
<#assign title="Listado de tareas">

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
            <h2>Crear una Tarea</h2>
            <form action="tareas" method="get">
           <input type="text" name="nombreTarea" placeholder="Descripcion de la tarea" class="form-control"/>
           <input type="pass" name="fechaEntrega" placeholder="Fecha" id="inputPass" class="form-control">
           <input type="submit" name="accion" value="Crear" class="btn btn-primary"/>
        </form>
           <p>${mensajeTarea}</p>
        </body>
    </html>
