package mx.com.trupper.prueba.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.trupper.prueba.dto.OrdenRequest;
import mx.com.trupper.prueba.persistence.entity.OrdenEntity;
import mx.com.trupper.prueba.service.OrdenService;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {
	
	private OrdenService ordenService;
	
	public OrdenController(OrdenService ordenService) {
		this.ordenService = ordenService;
	}


	@GetMapping("/{ordenId}")
	public ResponseEntity<OrdenEntity> consultaOrdenConpra(@PathVariable Long ordenId) {
		return new ResponseEntity<>(ordenService.consultaOrdenPorOrderId(ordenId), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<OrdenEntity> insertaOrdenCompra(@RequestBody OrdenRequest request) {
		return new ResponseEntity<>(ordenService.insertaOrden(request), HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<OrdenEntity> actualizaOrdenCompra(@PathVariable Long ordenId, @RequestBody OrdenRequest request) {
		return new ResponseEntity<>(ordenService.actualizaOrden(ordenId, request), HttpStatus.OK);
	}
	
}
