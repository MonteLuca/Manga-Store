package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.enumeraciones.Rol;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.repositorios.UsuarioRepositorio;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
/**
 * @author monte
 */
@Service
public class UsuarioServicio implements UserDetailsService {
    
    @Autowired
    private UsuarioRepositorio usuarioRepo;
    
    @Transactional
    public void registrar(String nombre, String email, String password, String password2) throws MiException {
        
        validar(nombre, email, password, password2);
        
        Usuario usuario = new Usuario();
        
        usuario.setNombre(nombre);
        
        usuario.setEmail(email);
 
        usuario.setPassword(new BCryptPasswordEncoder().encode(password));
        
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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepo.buscarPorEmail(email);
        
        if (usuario != null) {
            
            List<GrantedAuthority> permisos = new ArrayList();
            
            GrantedAuthority p = new SimpleGrantedAuthority("ROLE_" + usuario.getRol().toString()); //ROLE_USER
            
            permisos.add(p);
            
            return new User(usuario.getEmail(), usuario.getPassword(), permisos);
            
        } else {
            
            return null;
            
        }
    } 
    
}