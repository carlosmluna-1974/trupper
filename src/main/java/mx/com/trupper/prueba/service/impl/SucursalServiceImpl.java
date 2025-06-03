package mx.com.trupper.prueba.service.impl;

import org.springframework.stereotype.Service;

import mx.com.trupper.prueba.persistence.entity.SucursalEntity;
import mx.com.trupper.prueba.service.SucursalService;

@Service
public class SucursalServiceImpl implements SucursalService {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SucursalEntity consultaSucursal(Long sucursalId) {
		return SucursalEntity.builder().id(1).nombre("CDMX").build();
	}

}
