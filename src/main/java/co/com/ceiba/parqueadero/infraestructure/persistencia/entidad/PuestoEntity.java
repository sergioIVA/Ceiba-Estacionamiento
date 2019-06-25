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
@Table(name="puesto")
public class PuestoEntity {
	
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name = "puesto_id")
		private Long idPuesto;
		
		@Column(name = "estado_puesto", nullable = false)
		private boolean estado;
		
		@Column(name = "tipo_puesto_vehiculo", nullable = false)
		private String tipoPuestoVehiculo;
			
		@JsonIgnore
		@OneToMany(mappedBy = "puesto")
		private Set<ReservaEntity> reservas;

		public Long getIdPuesto() {
			return idPuesto;
		}

		public void setIdPuesto(Long idPuesto) {
			this.idPuesto = idPuesto;
		}

		public boolean isEstado() {
			return estado;
		}

		public void setEstado(boolean estado) {
			this.estado = estado;
		}

		public String getTipoPuestoVehiculo() {
			return tipoPuestoVehiculo;
		}

		public void setTipoPuestoVehiculo(String tipoPuestoVehiculo) {
			this.tipoPuestoVehiculo = tipoPuestoVehiculo;
		}

		public Set<ReservaEntity> getReservas() {
			return reservas;
		}

		public void setReservas(Set<ReservaEntity> reservas) {
			this.reservas = reservas;
		}
		
		
		

		

}
