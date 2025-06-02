package mx.com.trupper.prueba.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import mx.com.trupper.prueba.persistence.entity.OrdenEntity;

/**
 * Interface Repository de la entidad Orden
 */
public interface OrdenRepository extends JpaRepository<OrdenEntity, Long> {

}
