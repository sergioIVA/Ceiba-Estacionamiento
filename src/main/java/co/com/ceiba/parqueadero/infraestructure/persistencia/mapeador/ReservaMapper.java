package co.com.ceiba.parqueadero.infraestructure.persistencia.mapeador;
import co.com.ceiba.parqueadero.domain.model.Reserva;
import co.com.ceiba.parqueadero.infraestructure.persistencia.entidad.PuestoEntity;
import co.com.ceiba.parqueadero.infraestructure.persistencia.entidad.ReservaEntity;
import co.com.ceiba.parqueadero.infraestructure.persistencia.entidad.VehiculoEntity;

public class ReservaMapper {
	
	
	
	private ReservaMapper() {
	}
	
	public static Reserva toDomain(ReservaEntity entidad) {
		Reserva dominio = new Reserva();
		dominio.setIdReserva(entidad.getIdReserva());
		dominio.setFechaIngreso(entidad.getFechaIngreso());
		dominio.setFechaRetiro(entidad.getFechaRetiro());
		dominio.setValorTotal(entidad.getValorTotal());
		dominio.setPuesto(PuestoMapper.toDomain(entidad.getPuesto()));
		dominio.setVehiculo(VehiculoMapper.toDomain(entidad.getVehiculo()));
		return dominio;		
	}
	
	public static ReservaEntity toEntity(Reserva dominio) {
		ReservaEntity entidad = new ReservaEntity();
		entidad.setIdReserva(dominio.getIdReserva());
		
		PuestoEntity puestoEntidad = new PuestoEntity();
		puestoEntidad.setIdPuesto(dominio.getPuesto().getIdPuesto());
		entidad.setPuesto(puestoEntidad);
		
		VehiculoEntity vehiculoEntidad = new VehiculoEntity();
		vehiculoEntidad.setIdVehiculo(dominio.getVehiculo().getIdVehiculo());
		entidad.setVehiculo(vehiculoEntidad);
		
		entidad.setFechaIngreso(dominio.getFechaIngreso());
		entidad.setFechaRetiro(dominio.getFechaRetiro());	
		entidad.setValorTotal(dominio.getValorTotal());
		
		return entidad;
	}

}
