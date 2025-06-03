package mx.com.trupper.prueba.service;

import mx.com.trupper.prueba.dto.OrdenRequest;
import mx.com.trupper.prueba.persistence.entity.OrdenEntity;

/**
 * Interface@ de los metodos de transacciones y validaciones
 */
public interface OrdenService {

	/**
	 * Metodo que consl¿ulta de la orden
	 * @param ordenId
	 * @return
	 */
	OrdenEntity consultaOrdenPorOrderId(Long ordenId);
	
	/**
	 * Metodo que guarda la orden en la base de datos.
	 * @param ordenId Orden ID. (Puede o no existir.
	 * @param ordenRequest Datos de entrada
	 * @return Registro de la orden creada o actualizada.
	 */
	OrdenEntity guardaOrden(Long ordenId, OrdenRequest ordenRequest);
	
	
}
