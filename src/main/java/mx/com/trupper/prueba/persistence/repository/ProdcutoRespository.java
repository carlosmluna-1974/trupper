package mx.com.trupper.prueba.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.trupper.prueba.persistence.entity.ProdcutoEntity;


/**
 * Interface de repositorio de la entidad Prodcutos
 */
public interface ProdcutoRespository  extends JpaRepository<ProdcutoEntity, Long> {

}
