package com.egg.biblioteca.entidades;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
/**
 * @author Luca Monteleone
 */
@Entity //Con esto le decimos a Java que esta clase es una entidad que queremos persistir de manera permanente sus datos en algun repositorio en nuestro caso la base de datos de MySQL
public class Libro {

    @Id //es una anotación utilizada en JPA para indicar que un campo de una entidad representa la clave primaria de la tabla correspondiente en la base de datos.
    private Long isbn;
    
    private String titulo;
    
    private Integer ejemplares;
    
    @Temporal(TemporalType.DATE) //es una anotación que se utiliza para indicar que un campo de fecha en una entidad JPA debe ser mapeado a una columna de base de datos que contenga solo la parte de fecha.
    private Date fechaAlta;
    
    @ManyToOne //Le decimos que muchos libros van a tener un solo autor
    //es una anotación de JPA que se utiliza para establecer una relación de muchos a uno entre dos entidades, lo que permite que varias instancias de la primera entidad se relacionen con una sola instancia de la segunda entidad.
    private Autor autor;
    
    @ManyToOne //Le decimos que muchos libros van a tener una sola editorial 
    private Editorial editorial;
    
    @OneToOne
    private Imagen imagen;

    public Libro() { }

    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Editorial getEditorial() {
        return editorial;
    }

    public void setEditorial(Editorial editorial) {
        this.editorial = editorial;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

}