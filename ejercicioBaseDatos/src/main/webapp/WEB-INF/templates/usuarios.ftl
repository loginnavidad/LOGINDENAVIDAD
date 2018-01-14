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
        <link rel="stylesheet" href="assets/css/modales.css">
        <style>
            nav{
                width:150px;
            }
        </style>
        <script src="assets/js/modales.js"></script>
        <script src="assets/js/envioformularios.js"></script>
    </head>
    <body onload="cargar();">
        
        <#include "cabecera.ftl">
        
        <div class="container">
                <div class="col-xs-offset-5">
                    <nav class="row">
                        <nav id="profesor" class="btn btn-primary">Añadir Profesor</nav>
                    </nav>

                    <nav class="row">
                        <nav id="alumno" class="btn btn-primary">Añadir Alumno</nav>
                    </nav>

                    <nav class="row">
                        <nav id="asignatura" class="btn btn-primary">Añadir Asignatura</nav>
                    </nav>

                    <nav class="row">
                        <nav id="curso" class="btn btn-primary">Añadir Curso</nav>
                    </nav>

                    <nav class="row">
                        <nav id="asignarProfe" class="btn btn-primary">Asignar Profesor</nav>
                    </nav>
                </div>
        </div>
        
        
        
        <div id="profe" class="formularioProfesor">

            <div class="modal-content">
                <span class="close" id="closep">&times;</span>
                <form action="users" method="get" name="envioprofesor">
                    <input type="text" name="nombreProfesor" placeholder="Introduzca el nombre del profesor" class="form-control"/>
                    <input type="text" name="nombreUser" placeholder="Introduzca el nombre del usuario" class="form-control"/>
                    <input type="text" name="passUser" placeholder="Introduzca la contraseña" class="form-control"/>
                    <input type="email" name="emailUser" placeholder="Introduzca un email" class="form-control"/>
                    <button name="accion" value="addProfesor" class="btn btn-primary">Crear Profesor</button>
                </form>
            </div>

        </div>
        
        
        <div id="alum" class="formularioAlumno">

            <div class="modal-content">
                <span class="close" id="closea">&times;</span>
                <form action="users" method="get" name="envioalumno">
                    <input type="text" name="nombreAlumno" placeholder="Introduzca el nombre del alumno" class="form-control"/>
                    <input type="text" name="nombreUser" placeholder="Introduzca el nombre del usuario" class="form-control"/>
                    <input type="text" name="passUser" placeholder="Introduzca la contraseña" class="form-control"/>
                    <input type="email" name="emailUser" placeholder="Introduzca un email" class="form-control"/>
                    <button value="addAlumno" name="accion" class="btn btn-primary">Enviar</button>
                </form>
            </div>

        </div>
        
        
        <div id="asig" class="formularioAsignatura">

            <div class="modal-content">
                <span class="close" id="closeas">&times;</span>
                <form action="asignaturas" method="get" name="envioasignatura">
                    <input type="text" name="nombreAsignatura" placeholder="Introduzca el nombre de la asignatura" class="form-control"/>
                    <select name="id_curso" class="form-control">
                        <#list cursos as curso>
                            <option value="${curso.id}">${curso.descripcion}</option>
                        </#list>
                    </select>
                    <button value="addAsignatura" name="accion" class="btn btn-primary">Enviar</button>
                </form>
            </div>

        </div>
        
        
        <div id="curs" class="formularioCurso">

            <div class="modal-content">
                <span class="close" id="closec">&times;</span>
                <form action="cursos" method="get" name="enviocurso">
                    <textarea name="descripcion" placeholder="Introduzca una breve descripcion del curso" rows="5" class="form-control">Escriba aqui la descripcion del curso</textarea>
                    <button value="addCurso" name="accion" class="btn btn-primary">Enviar</button>
                </form>
            </div>

        </div>
      
        
        <div id="asigprofe" class="formularioProfeAsig">

            <div class="modal-content">
                <span class="close" id="closeap">&times;</span>
                <form action="administrador" method="get" name="asignarProfe">
                    <label for="asignaturaSelect">Asignaturas</label>
                    <select name="id_asignatura" id="asignaturaSelect" class="form-control">
                        <#list asignaturas as asignatura>
                            <option value="${asignatura.id}">${asignatura.nombre}</option>
                        </#list>
                    </select>
                    <label for="profesorSelect">Profesores</label>
                    <select name="id_profesor" id="profesorSelect" class="form-control">
                        <#list profesores as profesor>
                            <option value="${profesor.id_user}">${profesor.nombre}</option>
                        </#list>
                    </select>
                    <button value="asignarProfesor" name="accion" class="btn btn-primary">Enviar</button>
                </form>
            </div>

        </div>
      
        <script type="text/javascript" src="assets/js/modales.js"></script>
        </body>
    </html>
