package com.egg.biblioteca.entidades;

import com.egg.biblioteca.enumeraciones.Rol;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 *
 * @author monte
 */
@Entity
public class Usuario {
 
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Le decimos que la el id sea autoincremental por cada dato
    private Long id;
    
    private String nombre;
    
    private String email;
    
    private String password;
    
    @Enumerated //Se utiliza para decir que la variable es un enum
    private Rol rol;

    public Usuario() {      
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
   
}