package mx.com.trupper.prueba.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
@Table(name="sucursales")
public class SucursalEntity {
	
	@Id
	@Column(name="id")
	private Integer id;
	
	@Column(name="nombre")
	private String nombre;

}
