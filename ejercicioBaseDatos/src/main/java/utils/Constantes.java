/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

/**
 *
 * @author Miguel Angel Diaz
 */
public class Constantes {
    //DE LA APP ANTERIOR
    public static final String INDEX_SUPERUSUARIO = "usuarios.ftl";
    public static final String ERROR_REGISTRO = "No se ha podido registrar al usuario";
    public static final String LINK_EMAIL = "http://localhost:8080/LOGINDENAVIDAD/ejercicioBaseDatos/users?accion=validarUsuario&codigo=";
    public static final String ASUNTO_EMAIL = "Activa tu cuenta";
    public static final String REGISTRO_CORRECTO_ADMINISTRADOR = "Usuario creado con exito.";
    public static final String REGISTRO_CORRECTO_PROFESOR = "Profesor registrado con éxito";
    public static final String REGISTRO_CORRECTO_ALUMNO = "Alumno registrado con éxito";
    public static final String ERROR_NOMBRE = "El nombre de usuario ya existe.";
    public static final String ERROR_TIEMPO = "Se ha superado el tiempo de activación.";
    public static final String ERROR_TIEMPO_2 = "Regístrate otra vez.";
    public static final String CUENTA_ACTIVADA = "Tu cuenta ha sido activada.";
    public static final String CUENTA_ACTIVADA_2 = "Ahora puedes iniciar sesión.";
    public static final String YA_ACTIVADA = "Tu cuenta ya ha sido activada.";
    public static final String ERROR_ACTIVAR = "Ha ocurrido un error al activar tu cuenta.";
    public static final String ERROR_ACTIVAR_2 = "Inténtalo de nuevo más tarde.";
    public static final String ERROR_LOGIN = "Tu cuenta no está activada.";
    public static final String ERROR_LOGIN_2 = "Te hemos enviado un correo para activar tu cuenta. Comprueba tu bandeja de entrada.";
    public static final String ERROR_LOGIN_3 = "Usuario y contraseña incorrectos.";
    public static final String LOGIN = "login.ftl";
    public static final String USUARIO_EXISTE = "No se ha podido registrar ese nombre";
    public static final String VARIABLE_MENSAJE = "mensaje";
    public static final String VARIABLE_MENSAJE2 = "mensaje2";
    public static final String PANTALLASUPERADMIN = "pantallasuperadmin.ftl";
    public static final String PAGINA_INSERTADO_OK = "insertado.ftl";
    public static final String NUEVO_USER_REGISTRADO = "nuevouser.ftl";
    public static final String REGISTRO_PANTALLA = "registro.ftl";
    public static final String ACTIVADO_PANTALLA = "activado.ftl";
    public static final String ASIGNAR_PROFESOR = "asignarprofe.ftl";
    public static final String PANTALLA_ADMIN = "usuarios.ftl";
    public static final String MENSAJE_LOGIN_FAIL = "Usuario o contraseña erroneos";
    public static final String MENSAJE_PERMISOS = "No tiene permiso para acceder aqui";
    public static final String MENSAJE_LOGIN_NO_HECHO = "Por favor haga login";
    //QUERIES DIVERSAS
    public static final String INSERTAR_USERS = "INSERT INTO USERS (USER,PASSWORD,CODIGO_ACTIVACION,EMAIL,ACTIVO) VALUES(?,?,?,?,?)";
    public static final String DAR_PERMISO = "INSERT INTO PERMISOS_USUARIOS (ID_PERMISO,ID_USER) VALUES (?,?)";
    public static final String HACER_ADMIN = "UPDATE PERMISOS_USUARIOS SET ID_PERMISO = ?, ID_USER = ? WHERE ID_USER = ?";
    public static final String DESHACER_ADMIN = "UPDATE PERMISOS_USUARIOS SET ID_PERMISO = ?, ID_USER = ? WHERE ID_USER = ?";
    public static final String INSERTAR_EN_PROFESOR = "INSERT INTO PROFESORES (ID_USER,NOMBRE) VALUES (?,?)";
    public static final String INSERTAR_EN_ALUMNOS = "INSERT INTO ALUMNOS (ID,NOMBRE) VALUES (?,?)";
    public static final String ACTIVACION_MANUAL = "UPDATE USERS SET ACTIVO = ? WHERE ID = ?";
    public static final String ADD_CURSO = "INSERT INTO CURSOS(DESCRIPCION) VALUES (?)";
    public static final String LISTAR_CURSOS = "SELECT * FROM CURSOS";
    public static final String ADD_ASIGNATURA = "INSERT INTO ASIGNATURAS (NOMBRE,ID_CURSO) VALUES (?,?)";
    public static final String SELECT_USERS_PERMISOS = "SELECT * FROM USERS LEFT JOIN PERMISOS_USUARIOS ON USERS.ID = PERMISOS_USUARIOS.ID_USER LIMIT 10 OFFSET ?";
    public static final String SELECT_USER_BY_CORREO = "SELECT * FROM USERS WHERE EMAIL = ?";
    public static final String UPDATE_NEW_PASSWORD = "UPDATE USERS SET PASSWORD = ? WHERE EMAIL = ?";
    public static final String SACAR_PERMISO = "SELECT * from USERS INNER JOIN PERMISOS_USUARIOS ON USERS.ID = PERMISOS_USUARIOS.ID_USER WHERE USERS.EMAIL = ?";
    public static final String COGER_TODOS_PROFESORES = "SELECT * FROM PROFESORES";
    public static final String ASIGNAR_PROFESOR_ASIGNATURA = "INSERT INTO PROFE_ASIGNATURA (ID_PROFE, ID_ASIGNATURA) VALUES (?,?)";
    
    
    
    //MENSAJES DE CAMBIO DE PERMISOS DE ADMINISTRADOR
    public static final String ADMIN_CAMBIADO_OK = "Cambio a administrador correcto";
    public static final String ADMIN_CAMBIADO_ERROR = "Se produjo un error al dar el permiso";
    public static final String MENSAJE_ASIGNAR_PROFE = "Profesor asignado correctamente";
    public static final String MENSAJE_ASIGNAR_PROFE_ERROR = "Error al asignar el profesor";
    //MENSAJE QUE VA CON EL CORREO CUANDO SE CREA UN PROFESOR O ALUMNO
    public static final String USUARIO = "Su usuario es: ";
    public static final String PASSWORD = "Su contraseña es: ";
    //MENSAJES DE SI SE HAN CREADO BIEN DIVERSAS COSAS
    public static final String MENSAJE_ALUMNO_CREADO_BIEN = "El alumno se creo correctamente";
    public static final String MENSAJE_ALUMNO_CREADO_MAL = "Se produjo un error al crear el usuario";
    public static final String MENSAJE_PROFESOR_CREADO_BIEN = "El profesor se creo correctamente";
    public static final String MENSAJE_PROFESOR_CREADO_MAL = "Se produjo un error al crear el profesor";
    public static final String MENSAJE_ASIGNATURA_CREADA_BIEN = "La asignatura se ha creado correctamente";
    public static final String MENSAJE_ASIGNATURA_CREADA_MAL = "Se produjo un error al crear la asignatura";
    public static final String MENSAJE_CURSO_CREADO_BIEN = "El curso se ha creado correctamente";
    public static final String MENSAJE_CURSO_CREADO_MAL = "Se produjo un error al crear el curso";
    //MENSAJE DE SI SE HA ACTIVADO EL USUARIO
    public static final String MENSAJE_USUARIO_ACTIVADO = "El usuario ha sido activado correctamente";
    public static final String MENSAJE_USUARIO_NO_ACTIVADO = "Se produjo un error al activar el usuarios";
    //MESNAJES TAREAS
    public static final String TAREA_EXITO = "Tarea modificada correctamente";
    public static final String TAREA_ERROR = "No se ha podido modificar la tarea";
    
    //ALUMNOS
    public static final String LISTAR_ALUMNOS_ASIGNATURAS = "SELECT alum.ID, alum.NOMBRE, alumASig.NOTA FROM ALUMNOS alum JOIN ALUMNO_ASIGNATURA alumAsig ON alum.ID = alumAsig.ID_ALUMNO WHERE alumAsig.ID_ASIGNATURA = ?";
    public static final String LISTAR_ASIGNATURAS_ALUMNO="select asi.* , aa.nota from ALUMNO_ASIGNATURA aa join ASIGNATURAS asi on aa.id_asignatura=asi.id where aa.id_alumno=? LIMIT 10 OFFSET ?";
    //TAREAS
    public static final String LISTAR_TAREAS_ALUMNO = "SELECT t.ID_TAREA, t.ID_ASIGNATURA,t.NOMBRE,t.FECHA_ENTREGA,ta.HECHO,ta.idAlumno from TAREAS t join TAREAS_ALUMNOS ta on t.ID_TAREA=ta.idTarea where ta.idAlumno=? and t.ID_ASIGNATURA=? LIMIT 10 OFFSET ?";
    public static final String SUBIR_TAREA_ALUMNO = "update TAREAS_ALUMNOS set HECHO = 1 where idTarea=?";
    //FTL
    public static final String LISTA_TAREAS = "listaTareas.ftl";
    public static final String AÑADIR_TAREA = "anadirTarea.ftl";
    public static final String LISTA_ALUMNOS = "profesoresAlumnos.ftl";
    public static final String PROFESORES = "profesores.ftl";
    public static final String LISTA_ASIGNATURA_ALUMNO = "listaAsignaturaAlum.ftl";
}
