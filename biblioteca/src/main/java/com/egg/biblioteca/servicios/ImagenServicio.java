package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Imagen;
import com.egg.biblioteca.repositorios.ImagenRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Base64;
import org.springframework.web.multipart.MultipartFile;
/**
 *
 * @author monte
 */
@Service
public class ImagenServicio {

    @Autowired
    private ImagenRepositorio imagenRepo;

    public Imagen guardar(MultipartFile archivo) {

        if (archivo != null) {

            try {

                Imagen imagen = new Imagen();

                imagen.setMime(archivo.getContentType());

                imagen.setNombre(archivo.getOriginalFilename());

                //imagen.setContenido(archivo.getBytes());

                byte[] imagenBytes = archivo.getBytes();

                String imagenBase64 = Base64.getEncoder().encodeToString(imagenBytes);

                imagen.setContenido(imagenBase64);

                System.out.println("imagenBase64 = " + imagenBase64);

                return imagenRepo.save(imagen);

            } catch (Exception e) {

                System.err.println(e.getMessage());

            }

        }

        return null;

    }

}