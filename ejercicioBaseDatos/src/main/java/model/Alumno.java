package model;

/**
 *
 * @author miguel palomares
 */
public class Alumno {

    private long id;
    private String nombre;
    private int nota;
    
    public Alumno() {
    }

    public Alumno(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
