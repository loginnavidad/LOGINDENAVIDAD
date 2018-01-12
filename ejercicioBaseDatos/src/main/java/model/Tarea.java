package model;

import java.util.Date;

/**
 *
 * @author miguel palomares
 */
public class Tarea {
    private int id_tarea;
    private int id_asignatura;
    private String nombre;
    private Date fecha_entrega;
    private int hecho;
    private int idAlumno;

    public Tarea() {
    }

    public int getId_tarea() {
        return id_tarea;
    }

    public void setId_tarea(int id_tarea) {
        this.id_tarea = id_tarea;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(Date fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public int getHecho() {
        return hecho;
    }

    public void setHecho(int hecho) {
        this.hecho = hecho;
    }

    public int getIdAlumno() {
        return idAlumno;
    }

    public void setIdAlumno(int idAlumno) {
        this.idAlumno = idAlumno;
    } 
}
