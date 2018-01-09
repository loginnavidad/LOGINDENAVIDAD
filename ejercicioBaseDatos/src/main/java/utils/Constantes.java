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
    public static final String LINK_EMAIL = "http://localhost:8080/users?accion=validarUsuario&codigo=";
    public static final String ASUNTO_EMAIL = "Activa tu cuenta";
    public static final String REGISTRO_CORRECTO_ADMINISTRADOR = "Administrador registrado con éxito.";
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
    
    //QUERIES DIVERSAS
    public static final String INSERTAR_USERS = "INSERT INTO USERS (USER,PASSWORD,CODIGO_ACTIVACION,EMAIL,ACTIVO) VALUES(?,?,?,?,?)";
    public static final String DAR_PERMISO = "INSERT INTO PERMISOS_USUARIOS (ID_PERMISO,ID_USER) VALUES (?,?)";
    public static final String HACER_ADMIN = "INSERT INTO PERMISOS_USUARIOS (ID_PERMISO,ID_USER) VALUES (?,?)";
    public static final String DESHACER_ADMIN = "DELETE FROM PERMISOS_USUARIOS WHERE ID_USER = ?";
    public static final String INSERTAR_EN_PROFESOR = "INSERT INTO PROFESORES (ID_USER,NOMBRE) VALUES (?,?)";
    public static final String INSERTAR_EN_ALUMNOS = "INSERT INTO ALUMNOS (ID,NOMBRE) VALUES (?,?)";
    public static final String ACTIVACION_MANUAL = "UPDATE USERS SET ACTIVO = ? WHERE ID = ?";
    public static final String ADD_CURSO = "INSERT INTO CURSOS(DESCRIPCION) VALUES (?)";
    public static final String ADD_ASIGNATURA = "INSERT INTO ASIGNATURAS (NOMBRE) VALUES (?)";
    
    
    //MENSAJES DE CAMBIO DE PERMISOS DE ADMINISTRADOR
    public static final String ADMIN_CAMBIADO_OK = "Cambio a administrador correcto";
    public static final String ADMIN_CAMBIADO_ERROR = "Se produjo un error al dar el permiso";
    //MENSAJE QUE VA CON EL CORREO CUANDO SE CREA UN PROFESOR O ALUMNO
    public static final String USUARIO = "Su usuario es: ";
    public static final String PASSWORD = "Su contraseña es: ";
    //MENSAJES DE SI SE HAN CREADO BIEN DIVERSAS COSAS
    public static final String MENSAJE_ALUMNO_CREADO_BIEN = "El alumno se creo correctamente";
    public static final String MENSAJE_ALUMNO_CREADO_MAL = "Se produjo un error al crear el usuario";
    public static final String MENSAJE_PROFESOR_CREADO_BIEN = "El profesor se creo correctamente";
    public static final String MENSAJE_PROFESOR_CREADO_MAL = "Se produjo un error al crear el profesor";
    public static final String MENSAJE_ASIGNATURA_CREADA_BIEN = "La asignatura se ha creaod correctamente";
    public static final String MENSAJE_ASIGNATURA_CREADA_MAL = "Se produjo un error al crear la asignatura";
    public static final String MENSAJE_CURSO_CREADO_BIEN = "El curso se ha creado correctamente";
    public static final String MENSAJE_CURSO_CREADO_MAL = "Se produjo un error al crear el curso";
    //MENSAJE DE SI SE HA ACTIVADO EL USUARIO
    public static final String MENSAJE_USUARIO_ACTIVADO = "El usuario ha sido activado correctamente";
    public static final String MENSAJE_USUARIO_NO_ACTIVADO = "Se produjo un error al activar el usuarios";
    
}
