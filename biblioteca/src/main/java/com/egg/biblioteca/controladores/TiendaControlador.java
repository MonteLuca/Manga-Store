package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.servicios.LibroServicio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author monte
 */
@Controller
@RequestMapping("/tienda")
public class TiendaControlador {
    
    @Autowired
    private LibroServicio libroService;

    @GetMapping("/vista")
    public String tienda(ModelMap model) {

        List<Libro> libros = libroService.listarLibros();
        
        model.addAttribute("libros", libros);
        
        return "tienda.html";

    }

}