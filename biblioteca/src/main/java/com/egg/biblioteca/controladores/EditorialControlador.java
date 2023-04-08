package com.egg.biblioteca.controladores;

import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.servicios.EditorialServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * @author Luca Monteleone
 */
@Controller
@RequestMapping("/editorial")
public class EditorialControlador {
    
    @Autowired
    private EditorialServicio editorialService;

    @GetMapping("registrar")
    public String registrarEditorial() {
        
        return "editorialForm.html";
        
    }
    
    @PostMapping("/guardar")
    public String guardarEditorial(@RequestParam String nombre) {
        
        try {
            editorialService.crearEditorial(nombre);
        } catch (MiException ex) {
            Logger.getLogger(EditorialControlador.class.getName()).log(Level.SEVERE, null, ex);
            return "editorialForm.html";
        }
        
        return "index.html";
        
    }
    
}