package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.servicios.LibroServicio;
import java.util.List;
import org.apache.tomcat.util.codec.binary.Base64;
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

//        byte[] bytes = libros.get(0).getImagen().getContenido();

//        String base64 = Base64.encodeBase64String(bytes);

//        model.addAttribute("base64", base64);
        
        return "tienda.html";

    }

}