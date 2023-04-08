package com.egg.biblioteca.repositorios;

import com.egg.biblioteca.entidades.Libro;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
/**
 * @author Luca Monteleone
 */
@Repository
public interface LibroRepositorio extends JpaRepository<Libro, Long> { 
    
    /*JpaRepository es una interfaz genérica proporcionada por Spring Data JPA 
    que extiende la interfaz CrudRepository. Esta interfaz proporciona una 
    serie de métodos para realizar operaciones CRUD (crear, leer, actualizar y eliminar) en una entidad JPA.
    Donde: JpaRepository<T, ID>

        T es el tipo de la entidad JPA que se va a gestionar.
        ID es el tipo de datos del identificador de la entidad.
    
    Al ser una interface los metodos no tienen ni cuerpo ni retorno
    
    */
    
    @Query("SELECT l FROM Libro l WHERE l.titulo = :titulo") //@Query es una anotación utilizada en Java para indicar que un método es una consulta (query) que se ejecutará en una base de datos.
    public Libro buscarPorTitulo (@Param("titulo") String titulo); //@Param es una anotación que se utiliza en Java para especificar el nombre de un parámetro en un método o en una consulta
                                //@Param("titulo") hace referencia al atributo a buscar [l.titulo], y String titulo a lo que recibe la query para buscar [:titulo]
    
    @Query("SELECT l FROM Libro l WHERE l.autor.nombre = :nombre")
    public List<Libro> buscarPorAutor(@Param("nombre") String nombre);
}