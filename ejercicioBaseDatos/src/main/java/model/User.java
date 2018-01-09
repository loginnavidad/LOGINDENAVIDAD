/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author Miguel Angel Diaz
 */
public class User {
    private long id;
    private String user;
    private String password;
    private boolean activo;
    private String codigo_activacion;
    private String email;
    private long id_permiso;

    public User() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean getActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public String getCodigo_activacion() {
        return codigo_activacion;
    }

    public void setCodigo_activacion(String codigo_activacion) {
        this.codigo_activacion = codigo_activacion;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getId_permiso() {
        return id_permiso;
    }

    public void setId_permiso(long id_permiso) {
        this.id_permiso = id_permiso;
    }
    
}
