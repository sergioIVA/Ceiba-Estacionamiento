package co.com.ceiba.parqueadero.infraestructure.persistencia.entidad;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "vehiculo")
public class VehiculoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vehiculo_id")
	private Long idVehiculo;
	
	@Column(name = "placa", nullable = false)
	private String placa;
	
	@Column(name = "cilindraje", nullable = true)
	private short cilindraje;
	
	@ManyToOne
	@JoinColumn(name = "tipo_vehiculo_id", nullable = false)
	private TipoVehiculoEntity tipoVehiculo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "vehiculo")
	private Set<ReservaEntity> Reserva;

	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public short getCilindraje() {
		return cilindraje;
	}

	public void setCilindraje(short cilindraje) {
		this.cilindraje = cilindraje;
	}

	public TipoVehiculoEntity getTipoVehiculo() {
		return tipoVehiculo;
	}

	public void setTipoVehiculo(TipoVehiculoEntity tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
	}

	public Set<ReservaEntity> getReserva() {
		return Reserva;
	}

	public void setReserva(Set<ReservaEntity> reserva) {
		Reserva = reserva;
	}

	
	
	
	

}
