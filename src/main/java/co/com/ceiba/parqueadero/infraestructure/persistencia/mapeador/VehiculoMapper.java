package co.com.ceiba.parqueadero.infraestructure.persistencia.mapeador;

import co.com.ceiba.parqueadero.domain.model.Vehiculo;
import co.com.ceiba.parqueadero.infraestructure.persistencia.entidad.TipoVehiculoEntity;
import co.com.ceiba.parqueadero.infraestructure.persistencia.entidad.VehiculoEntity;

public class VehiculoMapper {
	

	public static Vehiculo toDomain(VehiculoEntity entidad) {
		Vehiculo dominio = new Vehiculo();
		
		dominio.setIdVehiculo(entidad.getIdVehiculo());
		dominio.setPlaca(entidad.getPlaca());
		dominio.setCilindraje(entidad.getCilindraje());
		dominio.setTipoVehiculo(TipoVehiculoMapper.toDomain(entidad.getTipoVehiculo()));
		
		return dominio;
	}
	
	public static VehiculoEntity toEntity(Vehiculo dominio) {
		
		VehiculoEntity entidad = new VehiculoEntity();
		
		entidad.setIdVehiculo(dominio.getIdVehiculo());
		entidad.setPlaca(dominio.getPlaca());
		entidad.setCilindraje(dominio.getCilindraje());
		
		TipoVehiculoEntity tipoVehiculoEntidad = new TipoVehiculoEntity();
		tipoVehiculoEntidad.setIdTipoVehiculo(dominio.getTipoVehiculo().getIdTipoVehiculo());
		tipoVehiculoEntidad.setTipoVehiculo(dominio.getTipoVehiculo().getNombre());
		
		entidad.setTipoVehiculo(tipoVehiculoEntidad);
				
		return entidad;
	}
	

}
