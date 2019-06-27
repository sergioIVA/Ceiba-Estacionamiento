package co.com.ceiba.parqueadero.infraestructure.persistencia.mapeador;

import co.com.ceiba.parqueadero.domain.model.Puesto;
import co.com.ceiba.parqueadero.infraestructure.persistencia.entidad.PuestoEntity;

public final class PuestoMapper {

	private PuestoMapper() {
		 throw new IllegalStateException("Utility class");
	}
	
	public static Puesto toDomain(PuestoEntity entidad) {
		
		Puesto dominio = new Puesto();
		dominio.setIdPuesto(entidad.getIdPuesto());
		dominio.setEstado(entidad.isEstado());
		dominio.setTipoPuestoVehiculo(entidad.getTipoPuestoVehiculo());
		return dominio;
	}	
	
	public static PuestoEntity toEntity(Puesto dominio) {
		
		PuestoEntity entidad = new PuestoEntity();
		entidad.setIdPuesto(dominio.getIdPuesto());
		entidad.setEstado(dominio.isEstado());
		entidad.setTipoPuestoVehiculo(dominio.getTipoPuestoVehiculo());
		return entidad;
	}
	
	
}
