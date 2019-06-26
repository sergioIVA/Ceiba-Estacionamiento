package com.com.ceiba.parqueadero.test.unitaria;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.com.ceiba.parqueadero.test.databuilder.TipoVehiculoTestBuilder;

import co.com.ceiba.parqueadero.domain.model.TipoVehiculo;

public class TipoVehiculoTestUnitario {

	private static final long ID_TIPO_VEHICULO = 2;
	private static final String NOMBRE = "MOTO";
    private TipoVehiculo tipoVehiculo;

	@Test
	public void crearTipoVehiculo() {
		// arrange
		TipoVehiculoTestBuilder tipoVehiculoTestBuilder = new TipoVehiculoTestBuilder()
				.obtenerTipoPorId(ID_TIPO_VEHICULO).obtenerTipoPorClase(NOMBRE);
		// act
		tipoVehiculo = tipoVehiculoTestBuilder.build();
		// assert
		assertEquals(ID_TIPO_VEHICULO, tipoVehiculo.getIdTipoVehiculo());
		assertEquals(NOMBRE, tipoVehiculo.getNombre());
	}

	
	
}
