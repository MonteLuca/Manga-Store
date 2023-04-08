package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.enumeraciones.Rol;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.repositorios.UsuarioRepositorio;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * @author monte
 */
public class UsuarioServicio {
    
    @Autowired
    private UsuarioRepositorio usuarioRepo;
    
    @Transactional
    public void registrar(String nombre, String email, String password, String password2) throws MiException {
        
        validar(nombre, email, password, password2);
        
        Usuario usuario = new Usuario();
        
        usuario.setNombre(nombre);
        
        usuario.setEmail(email);
 
        usuario.setPassword(password);
        
        usuario.setRol(Rol.USER);
        
        usuarioRepo.save(usuario);
        
    }
    
    private void validar(String nombre, String email, String password, String password2) throws MiException {
        
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre no puede ser nulo o estar vacio");
        }
        
        if (email.isEmpty() || email == null) {
            throw new MiException("El email no puede ser nulo o estar vacio");
        }
        
        if (password.isEmpty() || password == null || password.length() <= 5) {
            throw new MiException("La contraseña no puede estar vacia, y debe tener mas de 5 digitos");
        }
        
        if (!password.equals(password2)) {
            throw new MiException("Las contraseñas ingresadas deben ser iguales");
        }
        
    }
    
}