package com.com.ceiba.parqueadero.test.databuilder;

import co.com.ceiba.parqueadero.domain.model.TipoVehiculo;
import co.com.ceiba.parqueadero.domain.model.Vehiculo;

public class VehiculoTestBuilder {

	private static final long ID_VEHICULO = 3;
	private static final short CILINDRAJE = 110;
	private static final String PLACA = "RWW111";
	
	private static final long EXISTE_ID_VEHICULO = 3;
	private static final String EXISTE_PLACA="BBC312";
	private static final short EXISTE_CILINDRAJE = 120;
	
	
	private static final TipoVehiculo TIPO_VEHICULO = new TipoVehiculoTestBuilder().build();
	
	private long idVehiculo;
	private String placaVehiculo;
	private short cilindrajeVehiculo;
	private TipoVehiculo tipoVehiculo;

	public VehiculoTestBuilder() {
		this.idVehiculo = ID_VEHICULO;
		this.placaVehiculo = PLACA;
		this.cilindrajeVehiculo = CILINDRAJE;
		this.tipoVehiculo = TIPO_VEHICULO;
	}

	public VehiculoTestBuilder obtenerVehiculoPorId(long idVehiculo) {
		this.idVehiculo = idVehiculo;
		return this;
	}
	
	public VehiculoTestBuilder obtenerVehiculoPorPlaca(String placaVehiculo) {
		this.placaVehiculo = placaVehiculo;
		return this;
	}
	
	public VehiculoTestBuilder obtenerVehiculoPorCilindraje(short cilindrajeVehiculo) {
		this.cilindrajeVehiculo = cilindrajeVehiculo;
		return this;
	}

	public VehiculoTestBuilder obtenerVehiculoPorTipo(TipoVehiculo tipoVehiculo) {
		this.tipoVehiculo = tipoVehiculo;
		return this;
	}

	
	public Vehiculo vehiculoExistente() {
		
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setIdVehiculo(EXISTE_ID_VEHICULO);
		vehiculo.setPlaca(EXISTE_PLACA);
		vehiculo.setCilindraje(EXISTE_CILINDRAJE);
		vehiculo.setTipoVehiculo(this.tipoVehiculo);
		
		return vehiculo;
		
	}
	
	public Vehiculo build() {
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setIdVehiculo(this.idVehiculo);
		vehiculo.setPlaca(this.placaVehiculo);
		vehiculo.setCilindraje(this.cilindrajeVehiculo);
		vehiculo.setTipoVehiculo(this.tipoVehiculo);		
		return vehiculo;
	}

	
}
