package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @author Luca Monteleone
 */
@Service
public class EditorialServicio {

    @Autowired
    private EditorialRepositorio editorialRepo;
    
    @Transactional
    public void crearEditorial(String nombre) throws MiException {
        
        validar(nombre);
        
        Editorial editorial = new Editorial();
        
        editorial.setNombre(nombre);
        
        editorialRepo.save(editorial);
        
    }
    
    public List<Editorial> listarEditoriales () {
        
        List<Editorial> editoriales = new ArrayList();
        
        editoriales = editorialRepo.findAll();
        
        return editoriales;
        
    }
    
    public void modificarEditorial(String nombre, Long id) {
        
        Optional<Editorial> respuesta = editorialRepo.findById(id);
        
        if ( respuesta.isPresent() ) {
            
            Editorial editorial = respuesta.get();
            
            editorial.setNombre(nombre);
            
            editorialRepo.save(editorial);
            
        }
        
    }
    
    public void validar( String nombre ) throws MiException {
        
        if (nombre.isEmpty() || nombre == null) {
            throw new MiException("El nombre de la editorial no puede ser nulo o estar vacio");
        }
        
    }
    
}