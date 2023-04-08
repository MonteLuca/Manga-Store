
package com.egg.biblioteca.repositorios;

import com.egg.biblioteca.entidades.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Luca Monteleone
 */
@Repository
public interface EditorialRepositorio extends JpaRepository<Editorial, Long>{
                                        
}
