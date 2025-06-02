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
	 * Metodo que inserta la orden
	 * @param ordenRequest
	 * @return
	 */
	OrdenEntity insertaOrden(OrdenRequest ordenRequest);
	
	/**
	 * Metodo que inserta la orden
	 * @param ordenRequest
	 * @return
	 */
	OrdenEntity actualizaOrden(Long ordenId, OrdenRequest ordenRequest);
	
	
}
