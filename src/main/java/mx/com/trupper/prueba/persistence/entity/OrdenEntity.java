package mx.com.trupper.prueba.persistence.entity;

import java.math.BigDecimal;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Modelo para la entidad sucursales
 */
@Getter
@Setter
@ToString
@Entity
@Table(name="ordenes")
public class OrdenEntity {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@NotNull
	private Long id;
	
	@NotNull
	@Column(name="fecha")
	private Date fecha;
	
	@NotNull
	@Column(name="total")
	private BigDecimal total;
	
	@ManyToOne
	@JoinColumn(name = "sucursal_id")
	private SucursalEntity sucursal;

}
