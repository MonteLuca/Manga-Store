package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Usuario;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.servicios.UsuarioServicio;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 * @author Luca Monteleone
 */
@Controller //Es responsable de procesar las solicitudes HTTP y enviar una respuesta adecuada al cliente.
@RequestMapping("/") //es una anotación en el framework Spring que se utiliza para mapear las solicitudes web a los métodos de controlador correspondientes. Esta anotación permite asociar una ruta de solicitud con un método específico en un controlador de Spring
public class PortalControlador {

    @Autowired
    private UsuarioServicio usuarioService;
    
    @GetMapping("/") //es una anotación en Spring que se utiliza para manejar solicitudes HTTP GET en una aplicación web. Permite asociar una ruta de solicitud con un método de controlador específico que se encarga de procesar la solicitud y devolver una respuesta adecuada.
    public String inicio() {
        return "login-register_Form.html";
    }
    
    @PreAuthorize("hasAnyRole('ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/inicio")
    public String index(HttpSession session){
        
        Usuario logueado = (Usuario) session.getAttribute("usuariosession");
        
        if (logueado.getRol().toString().equals("ADMIN")) {
            return "redirect:/admin/dashboard";
        }
        
        return "index.html";
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, ModelMap model) {
        
        if (error != null) {
            model.put("error", "Usuario o contraseña invalido");
        }
        
        return "login.html";
    }
    
    @GetMapping("/registrar")
    public String registrar() {
        return "registrar.html";
    }
    
    @PostMapping("/registro")
    public String registro(@RequestParam String nombre, @RequestParam String email, @RequestParam String password, @RequestParam String password2, ModelMap model) {
        
        try {
            usuarioService.registrar(nombre, email, password, password2);
            
            model.put("exito", "Usuario registrado correctamente");
            
            return "index.html"; 
            
        } catch (MiException ex) {

            model.put("error", ex.getMessage());
            
            model.put("nombre",nombre);
            
            model.put("email",email);
            
            return "registrar.html";
            
        }
        
    }
}