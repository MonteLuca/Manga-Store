package com.egg.biblioteca.controladores;

import com.egg.biblioteca.entidades.Imagen;
import com.egg.biblioteca.repositorios.ImagenRepositorio;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author monte
 */
@Controller
@RequestMapping("/imagen")
public class ImagenControlador {

    @Autowired
    private ImagenRepositorio imagenRepo;

    /* @GetMapping("/imagen/{id}")
    public ResponseEntity<byte[]> mostrarImagen(@PathVariable Long id) {
        Optional<Imagen> imagenOptional = (Optional<Imagen>) imagenRepo.findById(id);
        if (imagenOptional.isPresent()) {
            Imagen imagen = imagenOptional.get();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.valueOf(imagen.getMime()));
            headers.setContentLength(imagen.getContenido().length);
            return new ResponseEntity<>(imagen.getContenido(), headers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    } */

}
