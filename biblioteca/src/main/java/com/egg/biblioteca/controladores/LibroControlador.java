package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.servicios.AutorServicio;
import com.egg.biblioteca.servicios.EditorialServicio;
import com.egg.biblioteca.servicios.LibroServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * @author Luca Monteleone
 */
@Controller
@RequestMapping("/libro")
public class LibroControlador {
    
    @Autowired
    private LibroServicio libroService;
    
    @Autowired
    private AutorServicio autorService;
    
    @Autowired
    private EditorialServicio editorialService;
    
    @GetMapping("/registrar")
    public String registrarLibro (ModelMap model) {
        
        List<Autor> autores = autorService.listarAutores();
        
        List<Editorial> editoriales = editorialService.listarEditoriales();
        
        model.addAttribute("autores", autores);
        
        model.addAttribute("editoriales", editoriales);
        
        return "libroForm.html";
        
    }
    
    @PostMapping("/guardar")
    public String guardarLibro(@RequestParam(required=false) Long isbn, 
                               @RequestParam String titulo, 
                               @RequestParam(required = false) Integer ejemplares,
                               @RequestParam Long idAutor,
                               @RequestParam Long idEditorial,
                               ModelMap model) {
        
        try {
           
            libroService.crearLibro(isbn, titulo, ejemplares, idAutor, idEditorial);
            
            model.put("exito", "El libro se guardo correctamente en la base de datos");
            
        } catch (MiException ex) {
             
            model.put("error", "Algun campo no fue validado");
            
            return "libroForm.html";
            
        }
        
        return "libroForm.html";
        
    }
            
}