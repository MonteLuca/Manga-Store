package com.egg.biblioteca.controladores;

import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.servicios.AutorServicio;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@RequestMapping("/autor") //Es decir localhost:8080/autor 
public class AutorControlador {
    
    @Autowired
    private AutorServicio autorService;
    
    @GetMapping("/registrar") //Es decir localhost:8080/autor/registrar
    public String registrarAutor() {
        return "autorForm.html";
    }
    
    @PostMapping("/guardar")
    public String guardarAutor(@RequestParam String nombre, ModelMap model) { 
        //Este parametro esta conectado con el atributo name del input que se encuentra en autorForm por lo tanto tiene que coincidir con el mismo
        //Con @RequestParam le decimos que es un parametro requerido y que va a llegar cuando se ejecute el formulario
        try {
            
            autorService.crearAutor(nombre);
        
            model.put("exito", "El autor fue cargado correctamente");
            
        } catch (MiException ex) {
            
            model.put("error", ex.getMessage());
            
            return "autorForm.html";
        }                       
        
        return "autorForm.html";
    }
    
}