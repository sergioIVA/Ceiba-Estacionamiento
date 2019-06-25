package com.com.ceiba.parqueadero.test.unitaria;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.com.ceiba.parqueadero.test.databuilder.TipoVehiculoTestBuilder;
import com.com.ceiba.parqueadero.test.databuilder.VehiculoTestBuilder;

import co.com.ceiba.parqueadero.domain.model.TipoVehiculo;
import co.com.ceiba.parqueadero.domain.model.Vehiculo;

public class VehiculoTestUnitario {
	
	private static final long ID_VEHICULO = 2;
	private static final String PLACA= "RWW111";
	private static final short CILINDRAJE = 110;
	private static final TipoVehiculo TIPO_VEHICULO = new TipoVehiculoTestBuilder().build();

	private Vehiculo vehiculo;

	@Test
	public void crearVehiculo() {
		// arrange
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder().obtenerVehiculoPorId(ID_VEHICULO)
				                                       .obtenerVehiculoPorPlaca(PLACA)
				                                       .obtenerVehiculoPorCilindraje(CILINDRAJE)
				                                       .obtenerVehiculoPorTipo(TIPO_VEHICULO);
		// act
		vehiculo = vehiculoTestBuilder.build();

		// assert
		assertEquals(ID_VEHICULO, vehiculo.getIdVehiculo());
		assertEquals(PLACA, vehiculo.getPlaca());
		assertEquals(CILINDRAJE, vehiculo.getCilindraje());
		assertEquals(TIPO_VEHICULO, vehiculo.getTipoVehiculo());		
	}

}
