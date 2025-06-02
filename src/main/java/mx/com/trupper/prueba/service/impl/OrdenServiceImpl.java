package mx.com.trupper.prueba.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import mx.com.trupper.prueba.dto.OrdenRequest;
import mx.com.trupper.prueba.persistence.entity.OrdenEntity;
import mx.com.trupper.prueba.persistence.entity.SucursalEntity;
import mx.com.trupper.prueba.persistence.repository.OrdenRepository;
import mx.com.trupper.prueba.service.OrdenService;

/**
 * Implementacion de los metodos de transacciones y validaciones
 */
@Service
@Log4j2
public class OrdenServiceImpl implements OrdenService {

	private OrdenRepository ordenRepository;
	
	public OrdenServiceImpl(OrdenRepository ordenRepository) {
		this.ordenRepository = ordenRepository;
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrdenEntity consultaOrdenPorOrderId(Long ordenId) {
		log.info("consultaOrdenPorOrderId(): {}", ordenId);	
		// Consulto la orden de compra
		Optional<OrdenEntity> ordenCompra = ordenRepository.findById(ordenId);
		log.debug("ordenCompra: {}", ordenCompra);				
		return ordenCompra.get();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrdenEntity insertaOrden(OrdenRequest ordenRequest) {
		log.info("insertaOrden(): {}", ordenRequest);	
		
		OrdenEntity ordenEntity = new OrdenEntity();
		ordenEntity.setFecha(ordenRequest.getFecha());
		
		SucursalEntity sucursalEntity = new SucursalEntity();
		sucursalEntity.setId(ordenRequest.getSucursalId());
		ordenEntity.setSucursal(sucursalEntity);
		ordenEntity.setTotal(ordenRequest.getTotal());
		
		return ordenRepository.save(ordenEntity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public OrdenEntity actualizaOrden(Long ordenId, OrdenRequest ordenRequest) {
		log.info("actualizaOrden(): {}", ordenRequest);
		
		OrdenEntity ordenEntity = new OrdenEntity();
		ordenEntity.setId(ordenId);
		ordenEntity.setFecha(ordenRequest.getFecha());
		
		SucursalEntity sucursalEntity = new SucursalEntity();
		sucursalEntity.setId(ordenRequest.getSucursalId());
		ordenEntity.setSucursal(sucursalEntity);
		ordenEntity.setTotal(ordenRequest.getTotal());
		
		return ordenRepository.save(ordenEntity);
	}

}
