package com.com.ceiba.parqueadero.test.databuilder;

import java.util.ArrayList;
import java.util.List;

import co.com.ceiba.parqueadero.domain.model.TipoVehiculo;
import co.com.ceiba.parqueadero.domain.model.Vehiculo;

public class VehiculoTestBuilder {

	private static final long ID_VEHICULO = 3;
	private static final short CILINDRAJE = 110;
	private static final String PLACA = "RWW111";
	
	private static final long EXISTE_ID_VEHICULO = 1;
	private static final String EXISTE_PLACA="BBC312";
	private static final short EXISTE_CILINDRAJE = 120;
	
	private static final long ID_NUEVO=4;
	private static final String PLACA_NUEVA="BBC212";
	private static final short CILINDRAJE_NUEVO = 120;
	
	
	
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
	
	public List<Vehiculo> listadoVehiculos(){
		
		List<Vehiculo> vehiculos=new ArrayList<>();
		
		Vehiculo vehiculo1=new Vehiculo();
		vehiculo1.setIdVehiculo(ID_VEHICULO);
		vehiculo1.setCilindraje(CILINDRAJE);
		vehiculo1.setPlaca(PLACA);
		vehiculo1.setTipoVehiculo(TIPO_VEHICULO);
		
		Vehiculo vehiculo2=new Vehiculo();
		vehiculo2.setIdVehiculo(EXISTE_ID_VEHICULO);
		vehiculo2.setCilindraje(EXISTE_CILINDRAJE);
		vehiculo2.setPlaca(EXISTE_PLACA);
		vehiculo2.setTipoVehiculo(TIPO_VEHICULO);
		
		vehiculos.add(vehiculo1);
		vehiculos.add(vehiculo2);
		
		return vehiculos;
		
	}
	
	public Vehiculo buildNuevo() {
		
		Vehiculo vehiculo = new Vehiculo();
		vehiculo.setIdVehiculo(ID_NUEVO);
		vehiculo.setPlaca(PLACA_NUEVA);
		vehiculo.setCilindraje(CILINDRAJE_NUEVO);
		vehiculo.setTipoVehiculo(TIPO_VEHICULO);		
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
