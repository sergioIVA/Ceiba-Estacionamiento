package com.com.ceiba.parqueadero.test.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


import org.junit.Test;

import com.com.ceiba.parqueadero.test.databuilder.PuestoTestBuilder;
import co.com.ceiba.parqueadero.domain.model.Puesto;


public class PuestoTestUnitario {

	private static final long ID_BAHIA = 1;
	private static final boolean ESTADO_BAHIA = true;
	private static final String TIPO_BAHIA = "CARRO";

	private Puesto puesto;

	@Test
	public void crearBahia() {
		// arrange
		PuestoTestBuilder puestoTestBuilder = new PuestoTestBuilder().puestoPorId
				(ID_BAHIA).puestoPorEstado(ESTADO_BAHIA)
				.puestoPorTipo(TIPO_BAHIA);
		// act
		puesto = puestoTestBuilder.build();
		long valor= puesto.getIdPuesto();
		
		// assert
		assertEquals(ID_BAHIA,valor);
		assertTrue(puesto.isEstado()); 
		assertEquals(TIPO_BAHIA, puesto.getTipoPuestoVehiculo());		
	}

	
}
