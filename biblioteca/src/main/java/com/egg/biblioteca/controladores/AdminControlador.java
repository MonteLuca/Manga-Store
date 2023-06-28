package com.egg.biblioteca.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author monte
 */
@Controller
@RequestMapping("/admin")
public class AdminControlador {
    
    @GetMapping("/dashboard")
    public String panelAdmin() {
        return "panel.html";
    }
    
}