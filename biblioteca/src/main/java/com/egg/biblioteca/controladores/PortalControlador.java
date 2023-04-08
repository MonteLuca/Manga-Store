package com.egg.biblioteca.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * @author Luca Monteleone
 */
@Controller //Es responsable de procesar las solicitudes HTTP y enviar una respuesta adecuada al cliente.
@RequestMapping("/") //es una anotación en el framework Spring que se utiliza para mapear las solicitudes web a los métodos de controlador correspondientes. Esta anotación permite asociar una ruta de solicitud con un método específico en un controlador de Spring
public class PortalControlador {

    @GetMapping("/") //es una anotación en Spring que se utiliza para manejar solicitudes HTTP GET en una aplicación web. Permite asociar una ruta de solicitud con un método de controlador específico que se encarga de procesar la solicitud y devolver una respuesta adecuada.
    public String index() {
        return "index.html";
    }

    @GetMapping("/login")
    public String login() {
        return "login.html";
    }
    
    @GetMapping("/registrar")
    public String registrar() {
        return "registrar.html";
    }
    
}