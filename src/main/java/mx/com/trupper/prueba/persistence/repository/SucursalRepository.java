package mx.com.trupper.prueba.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mx.com.trupper.prueba.persistence.entity.SucursalEntity;

/**
 * Interface de repositorio de la entidad Sucursales.
 */
@Repository
public interface SucursalRepository extends JpaRepository<SucursalEntity, Integer> {
	
}
