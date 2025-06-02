package mx.com.trupper.prueba.dto;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Modelo de request para generar la orden de compra
 */
@Getter
@Setter
@ToString
public class ProdcutoDto {

	private String codigo;
	private String descripcion;
	private Long ordenId;
	private BigDecimal precio;
	
}
