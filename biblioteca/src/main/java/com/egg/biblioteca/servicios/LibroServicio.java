package com.egg.biblioteca.servicios;

import com.egg.biblioteca.entidades.Autor;
import com.egg.biblioteca.entidades.Editorial;
import com.egg.biblioteca.entidades.Libro;
import com.egg.biblioteca.exceptions.MiException;
import com.egg.biblioteca.repositorios.AutorRepositorio;
import com.egg.biblioteca.repositorios.EditorialRepositorio;
import com.egg.biblioteca.repositorios.LibroRepositorio;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Luca Monteleone
 */
@Service
public class LibroServicio {

    @Autowired //Indicamos al servidor de aplicaciones que esta variable va a ser inicializada por el, entonces no hace falta inicializarla para operar con ella
    private LibroRepositorio libroRepo;

    @Autowired
    private AutorRepositorio autorRepo;

    @Autowired
    private EditorialRepositorio editorialRepo;

    @Transactional //Establecemos que si el metodo se ejecuta sin lanzar exceptions se persiste y se guarda en la base de datos, en cambio, si lanza exceptions no se persiste nada
    public void crearLibro(Long isbn, String titulo, Integer ejemplares, Long idAutor, Long idEditorial) throws MiException {

        validar(isbn,titulo,ejemplares,idAutor,idEditorial);
        
        Libro libro = new Libro();

        Autor autor = autorRepo.findById(idAutor).get(); //Le decimos que el autor que guarde en Autor autor, lo busque por id [.findById(isbn)] y que me lo traiga [.findById(isbn).get()]

        Editorial editorial = editorialRepo.findById(idEditorial).get();

        libro.setIsbn(isbn);

        libro.setTitulo(titulo);

        libro.setEjemplares(ejemplares);

        libro.setFechaAlta(new Date());

        libro.setAutor(autor);

        libro.setEditorial(editorial);

        libroRepo.save(libro); //.save recibe una entidad como parametro y la persiste en la base de datos

    }

    public List<Libro> listarLibros() {

        List<Libro> libros = new ArrayList();

        libros = libroRepo.findAll(); //Le decimos que traiga todos los libros de la base de datos

        return libros;

    }

    @Transactional
    public void modificarLibro(Long isbn, String titulo, Integer ejemplares, Long idAutor, Long idEditorial) throws MiException {

        validar(isbn, titulo, ejemplares, idAutor, idEditorial);
        
        Optional<Libro> libroResp = libroRepo.findById(isbn); //Optional es una estructura de datos que indica que un valor puede o no estar presente

        Optional<Autor> autorResp = autorRepo.findById(idAutor);

        Optional<Editorial> editorialResp = editorialRepo.findById(idEditorial);

        /* --------------------------------------------------------------------------- */
        Autor autor = new Autor();

        Editorial editorial = new Editorial();

        /* --------------------------------------------------------------------------- */
        if (autorResp.isPresent()) { //Se puede llamar al método "isPresent()" para determinar si el valor está presente o no, y se puede obtener el valor utilizando el método "get()".

            autor = autorResp.get();

        }

        if (editorialResp.isPresent()) {

            editorial = editorialResp.get();

        }

        if (libroResp.isPresent()) {

            Libro libro = libroResp.get();

            libro.setTitulo(titulo);

            libro.setEjemplares(ejemplares);

            libro.setAutor(autor);

            libro.setEditorial(editorial);

        }

    }
    
    private void validar( Long isbn, String titulo, Integer ejemplares, Long idAutor, Long idEditorial ) throws MiException {
        
        if (isbn == null) {
            throw new MiException("El isbn no puede ser nulo");
        }

        if (titulo.isEmpty() || titulo == null) {
            throw new MiException("El titulo no puede estar vacio o ser nulo");
        }

        if (ejemplares == null) {
            throw new MiException("Los ejemplares no pueden estar nulos");
        }

        if (idAutor == null) {
            throw new MiException("El idAutor no puede ser nulo");
        }

        if (idEditorial == null) {
            throw new MiException("El idEditorial no puede ser nulo");
        }
        
    }
    
    private String guardarImagen(MultipartFile imagen) throws IOException {
        
        byte[] bytesImagen = imagen.getBytes();
        
        String imagen64 = Base64.getEncoder().encodeToString(bytesImagen);
        
        return imagen64;
        
    }

}