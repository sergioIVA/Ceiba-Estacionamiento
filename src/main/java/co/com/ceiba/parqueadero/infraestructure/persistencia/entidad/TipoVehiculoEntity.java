package co.com.ceiba.parqueadero.infraestructure.persistencia.entidad;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tipoVehiculo")
public class TipoVehiculoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipo_vehiculo_id")
	private Long idTipoVehiculo;
	
	@Column(name = "tipo_vehiculo", nullable = false)
	private String tipoVehiculo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "tipoVehiculo")
	private Set<VehiculoEntity> vehiculos;

	public Long getIdTipoVehiculo() {
		return idTipoVehiculo;
	}

	public void setIdTipoVehiculo(Long idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
	}


	public String getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(String tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Set<VehiculoEntity> getVehiculos() {
		return vehiculos;
	}

	public void setVehiculos(Set<VehiculoEntity> vehiculos) {
		this.vehiculos = vehiculos;
	}

}
