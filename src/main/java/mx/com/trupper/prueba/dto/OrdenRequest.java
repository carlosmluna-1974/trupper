package mx.com.trupper.prueba.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Modelo de request para generar la orden de compra
 */
@Getter
@Setter
@ToString
public class OrdenRequest {

	private Integer sucursalId;
	private Date fecha;
	private BigDecimal total;
	private List<ProdcutoDto> prodcutos;
	
}
