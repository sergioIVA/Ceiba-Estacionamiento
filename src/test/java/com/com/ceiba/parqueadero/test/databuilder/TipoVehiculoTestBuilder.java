package com.com.ceiba.parqueadero.test.databuilder;

import co.com.ceiba.parqueadero.domain.model.TipoVehiculo;

public class TipoVehiculoTestBuilder {

	private static final long ID_TIPO_VEHICULO = 1;
	private static final String NOMBRE = "CARRO";
	
	private long idTipoVehiculo;
	private String nombre;
	
	public TipoVehiculoTestBuilder() {
		this.idTipoVehiculo = ID_TIPO_VEHICULO;
		this.nombre = NOMBRE;
	}
	
	public TipoVehiculoTestBuilder obtenerTipoPorId(long idTipoVehiculo) {
		this.idTipoVehiculo = idTipoVehiculo;
		return this;
	}
	
	public TipoVehiculoTestBuilder obtenerTipoPorClase(String claseVehiculo) {
		this.nombre = claseVehiculo;
		return this;
	}
	
	public TipoVehiculo build() {
		TipoVehiculo tipoVehiculo = new TipoVehiculo();
		tipoVehiculo.setIdTipoVehiculo(idTipoVehiculo);
		tipoVehiculo.setNombre(nombre);
		return tipoVehiculo;
	}
	
}
