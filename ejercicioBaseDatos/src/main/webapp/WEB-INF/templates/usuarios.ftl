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
        <script src="assets/js/modales.js"></script>
    </head>
    <body onload="cargar();">
        <button id="administrador" class="btn btn-primary">Añadir Administrador</button>
        <button id="profesor" class="btn btn-primary">Añadir Profesor</button>
        <button id="alumno" class="btn btn-primary">Añadir Alumno</button>
        <button id="asignatura" class="btn btn-primary">Añadir Asignatura</button>
        <button id="listado" class="btn btn-primary">Listar Usuarios</button>
        
        
        
        
        <div id="profe" class="formularioProfesor">

            <div class="modal-content">
                <span class="close">&times;</span>
                <form action="users" method="get">
                    <input type="text" name="nombreProfesor" placeholder="Introduzca el nombre del profesor" class="form-control"/>
                    <input type="text" name="nombreUser" placeholder="Introduzca el nombre del usuario" class="form-control"/>
                    <input type="text" name="passUser" placeholder="Introduzca la contraseña" class="form-control"/>
                    <input type="email" name="emailUser" placeholder="Introduzca un email" class="form-control"/>
                    <input name="accion" value="addProfesor" class="btn btn-primary">
                </form>
            </div>

        </div>
        
        
        <div id="alum" class="formularioAlumno">

            <div class="modal-content">
                <span class="close">&times;</span>
                <form action="users" method="get">
                    <input type="text" name="nombreProfesor" placeholder="Introduzca el nombre del alumno" class="form-control"/>
                    <input type="text" name="nombreUser" placeholder="Introduzca el nombre del usuario" class="form-control"/>
                    <input type="text" name="passUser" placeholder="Introduzca la contraseña" class="form-control"/>
                    <input type="email" name="emailUser" placeholder="Introduzca un email" class="form-control"/>
                    <button value="addAlumno" name="accion" class="btn btn-primary">Enviar</button>
                </form>
            </div>

        </div>
        
        
        <div id="asig" class="formularioAsignatura">

            <div class="modal-content">
                <span class="close">&times;</span>
                <form action="asignaturas" method="get">
                    <input type="text" name="nombreAsignatura" placeholder="Introduzca el nombre del alumno" class="form-control"/>
                    <textarea name="descripcion" placeholder="Introduzca una breve descripcion del curso" rows="5" class="form-control"/>
                    <button value="addAsignatura" name="accion" class="btn btn-primary">Enviar</button>
                </form>
            </div>

        </div>
        
        
        
    <#if insertado == 1>
        <script>
            alert("${mensaje}");
        </script>
    <#else>
        <script>
            alert("${mensaje}");
        </script>
    </#if>

        <script type="text/javascript" src="/assets/js/modales.js"></script>
        </body>
    </html>
