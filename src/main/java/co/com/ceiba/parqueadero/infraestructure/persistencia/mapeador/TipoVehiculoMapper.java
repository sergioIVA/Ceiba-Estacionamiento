package co.com.ceiba.parqueadero.infraestructure.persistencia.mapeador;

import co.com.ceiba.parqueadero.domain.model.TipoVehiculo;
import co.com.ceiba.parqueadero.infraestructure.persistencia.entidad.TipoVehiculoEntity;

public final class TipoVehiculoMapper {
	
  
	public static TipoVehiculo toDomain(TipoVehiculoEntity entidad) {	
		TipoVehiculo dominio = new TipoVehiculo();
		
		dominio.setIdTipoVehiculo(entidad.getIdTipoVehiculo());
		dominio.setNombre(entidad.getTipoVehiculo());
		
		return dominio;
	}
	
	  private TipoVehiculoMapper() {
	    	
	    }
		
	
	public static TipoVehiculoEntity toEntity(TipoVehiculo dominio) {
		TipoVehiculoEntity entidad = new TipoVehiculoEntity();
		
		entidad.setIdTipoVehiculo(dominio.getIdTipoVehiculo());
		entidad.setTipoVehiculo(dominio.getNombre());
		
		return entidad;
	}
	

}
