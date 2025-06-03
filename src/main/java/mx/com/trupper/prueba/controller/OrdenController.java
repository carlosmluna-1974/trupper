package mx.com.trupper.prueba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;
import mx.com.trupper.prueba.constants.Constants;
import mx.com.trupper.prueba.dto.OrdenRequest;
import mx.com.trupper.prueba.persistence.entity.OrdenEntity;
import mx.com.trupper.prueba.service.OrdenService;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Log4j2
@RestController
@RequestMapping(Constants.API_BASE_PATH)
public class OrdenController {
	
	// Variables de inyeccion de dependencia
	@Autowired
	private OrdenService ordenService;


	/**
	 * Metodo que consulta una orden de compra por medio de su ID.
	 * @param ordenId
	 * @return Orden de Compra
	 */
	@GetMapping(Constants.API_ORDER_ID)
	public ResponseEntity<OrdenEntity> consultaOrdenConpra(@PathVariable Long ordenId) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); // viene del token
	    log.info("Usuario autenticado: " + username);
	    
		return new ResponseEntity<>(ordenService.consultaOrdenPorOrderId(ordenId), HttpStatus.OK);
	}
	
	/**
	 * Metodo que genera una orden de compra.
	 * @param request Datos de entrada para generar la orden..
	 * @return Orden de Compra creada
	 */
	@PostMapping
	public ResponseEntity<OrdenEntity> insertaOrdenCompra(@RequestBody OrdenRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); // viene del token
	    log.info("Usuario autenticado: " + username);
	    
		return new ResponseEntity<>(ordenService.guardaOrden(null, request), HttpStatus.OK);
	}
	
	/**
	 * Metodo que actualiza una orden de compra
	 * @param ordenId ID de la orden.
	 * @param request Datos de entrada para ctualizar.
	 * @return Orden de Compra actualizada
	 */
	@PutMapping(Constants.API_ORDER_ID)
	public ResponseEntity<OrdenEntity> actualizaOrdenCompra(@PathVariable Long ordenId, @RequestBody OrdenRequest request) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    String username = auth.getName(); // viene del token
	    log.info("Usuario autenticado: " + username);
	    
		return new ResponseEntity<>(ordenService.guardaOrden(ordenId, request), HttpStatus.OK);
	}
	
}
