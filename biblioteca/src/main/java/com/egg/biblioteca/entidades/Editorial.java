package com.egg.biblioteca.entidades;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
/**
 * @author Luca Monteleone
 */
@Entity
public class Editorial {

//    Si el Id fuera de tipo String      
//    @Id 
//    @GeneratedValue(generator = "uuid") //JPA generará automáticamente un valor UUID único para el campo de la clave primaria cada vez que se cree una nueva instancia de la entidad. Este valor se utilizará como clave primaria para el registro correspondiente en la base de datos.
//    @GenericGenerator(name = "uuid", strategy = "uuid2") //Es una anotación que se utiliza en JPA para definir un generador personalizado de valores únicos para un campo de la entidad que representa la clave primaria, utilizando la estrategia de generación "uuid2" de Hibernate y el estándar UUID para generar valores únicos.
//    private String id;
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY) //Le decimos que la el id sea autoincremental por cada dato
    private Long id;

    private String nombre;

    public Editorial() { }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}