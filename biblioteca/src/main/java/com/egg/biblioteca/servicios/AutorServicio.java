package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * 
 * @author Luca Monteleone
 */
@Service
public class AutorServicio {

    @Autowired
    private AutorRepositorio autorRepo;
    
    @Transactional
    public void crearAutor(String nombre) throws MiException {
        
        validar(nombre);
        
        Autor autor = new Autor();
        
        autor.setNombre(nombre);
        
        autorRepo.save(autor);
        
    }
    
    public List<Autor> listarAutores() {
        
        List<Autor> autores = new ArrayList();
        
        autores = autorRepo.findAll();
        
        return autores;
        
    }
    
    public void modificarAutor(String nombre, Long id) {
        
        Optional<Autor> respuesta = autorRepo.findById(id);
        
        if ( respuesta.isPresent() ) {
            
            Autor autor = respuesta.get();
            
            autor.setNombre(nombre);
            
            autorRepo.save(autor);
            
        }
        
    }
    
    public void validar( String nombre ) throws MiException {
            
        if ( nombre.isEmpty() || nombre == null ) {
            throw new MiException("El nombre no puede ser nulo o estar vacio");
        }
        
    }
    
}