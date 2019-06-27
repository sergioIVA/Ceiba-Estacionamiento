package co.com.ceiba.parqueadero.infraestructure.persistencia.mapeador;
import co.com.ceiba.parqueadero.domain.model.Reserva;
import co.com.ceiba.parqueadero.infraestructure.persistencia.entidad.ReservaEntity;



public final class ReservaMapper {
	
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
		entidad.setFechaIngreso(dominio.getFechaIngreso());
		entidad.setFechaRetiro(dominio.getFechaRetiro());
		entidad.setValorTotal(dominio.getValorTotal());
		
		entidad.setPuesto(PuestoMapper.toEntity(dominio.getPuesto()));
		entidad.setVehiculo(VehiculoMapper.toEntity(dominio.getVehiculo()));
		
		
		return entidad;
	}

}
