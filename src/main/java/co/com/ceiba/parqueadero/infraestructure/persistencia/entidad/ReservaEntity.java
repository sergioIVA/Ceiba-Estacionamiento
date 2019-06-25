package co.com.ceiba.parqueadero.infraestructure.persistencia.entidad;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "reserva")
public class ReservaEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reserva_id")
	private Long idReserva;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_ingreso", nullable = false)
	private Date fechaIngreso;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "fecha_retiro", nullable = true)
	private Date fechaRetiro;
	
	@Column(name = "valor_total", nullable = true)
	private float valorTotal;
	
	@ManyToOne
	@JoinColumn(name = "vehiculo_id", nullable = false)
	private VehiculoEntity vehiculo;
	
	@ManyToOne
	@JoinColumn(name = "puesto_id", nullable = false)
	private PuestoEntity puesto;

	

	public Long getIdReserva() {
		return idReserva;
	}

	public void setIdReserva(Long idReserva) {
		this.idReserva = idReserva;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaRetiro() {
		return fechaRetiro;
	}

	public void setFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
	}

	public float getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(float valorTotal) {
		this.valorTotal = valorTotal;
	}

	public VehiculoEntity getVehiculo() {
		return vehiculo;
	}

	public void setVehiculo(VehiculoEntity vehiculo) {
		this.vehiculo = vehiculo;
	}

	public PuestoEntity getPuesto() {
		return puesto;
	}

	public void setPuesto(PuestoEntity puesto) {
		this.puesto = puesto;
	}

			
	
	
	
	


}
