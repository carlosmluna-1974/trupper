package mx.com.trupper.prueba.service.impl;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.Column;
import lombok.extern.log4j.Log4j2;
import mx.com.trupper.prueba.dto.OrdenRequest;
import mx.com.trupper.prueba.dto.ProdcutoDto;
import mx.com.trupper.prueba.persistence.entity.OrdenEntity;
import mx.com.trupper.prueba.persistence.entity.ProdcutoEntity;
import mx.com.trupper.prueba.persistence.entity.SucursalEntity;
import mx.com.trupper.prueba.persistence.repository.OrdenRepository;
import mx.com.trupper.prueba.persistence.repository.ProdcutoRespository;
import mx.com.trupper.prueba.persistence.repository.SucursalRepository;
import mx.com.trupper.prueba.service.OrdenService;

/**
 * Implementacion de los metodos de transacciones y validaciones
 */
@Service
@Log4j2
public class OrdenServiceImpl implements OrdenService {

	@Autowired
	private OrdenRepository ordenRepository;
	@Autowired
	private SucursalRepository sucursalRepository;
	@Autowired
	private ProdcutoRespository prodcutoRespository;
	
	
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

	@Override
	public OrdenEntity guardaOrden(Long ordenId, OrdenRequest ordenRequest) {
		log.info("guardaOrden(): {}", ordenRequest);
		
		// tomo los datos de la sucursal o envio una excepcion si no se encuentra.
		SucursalEntity sucursalEntity = sucursalRepository.findById(ordenRequest.getSucursalId())
				.orElseThrow(() -> new RuntimeException("Sucursal con el identificador " + ordenRequest.getSucursalId() 
				+ " no se encuentra ne la BD."));
						
		// Genero los datos para guardar el registro.
		Long idOrden = null;
		if ( Objects.nonNull(ordenId) ) 
			idOrden = ordenId;
		log.info("idOrden: {}", idOrden);
		
		OrdenEntity ordenEntity = OrdenEntity.builder().id(idOrden).fecha(ordenRequest.getFecha())
				.total(ordenRequest.getTotal()).sucursal(sucursalEntity).build();
		
		OrdenEntity ordensave = ordenRepository.save(ordenEntity);
		log.info("ordensave: {}", ordensave);
		
		for (ProdcutoDto productoEnt : ordenRequest.getProdcutos()) {
			ProdcutoEntity prodcutoEntity = ProdcutoEntity.builder().codigo(productoEnt.getCodigo()).descripcion(productoEnt.getDescripcion())
					.precio(productoEnt.getPrecio()).orden(ordensave).build();
			log.info("prodcutoEntity: {}", prodcutoEntity);
			
			ProdcutoEntity prodcutoSave = prodcutoRespository.save(prodcutoEntity);
			log.info("prodcutoSave: {}", prodcutoSave);
		}
		
		return ordenRepository.save(ordenEntity);
	}

}
