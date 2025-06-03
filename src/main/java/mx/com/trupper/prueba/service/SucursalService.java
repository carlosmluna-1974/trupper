package mx.com.trupper.prueba.service;

import mx.com.trupper.prueba.persistence.entity.SucursalEntity;

/**
 * Interface de los metodos de sucursales.
 */
public interface SucursalService {

	/**
	 * Metodo que manda un mock de sucursales en caso de que no cargue el insert de la base de datos.
	 * @param sucursalId Id de la sucurzal.
	 * @return Registro de la sucursal.
	 */
	SucursalEntity consultaSucursal(Long sucursalId);
	
}
