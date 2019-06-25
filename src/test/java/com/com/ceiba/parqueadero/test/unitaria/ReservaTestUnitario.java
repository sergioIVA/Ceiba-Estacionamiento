package com.com.ceiba.parqueadero.test.unitaria;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.com.ceiba.parqueadero.test.databuilder.PuestoTestBuilder;
import com.com.ceiba.parqueadero.test.databuilder.ReservaTestBuilder;
import com.com.ceiba.parqueadero.test.databuilder.VehiculoTestBuilder;

import co.com.ceiba.parqueadero.domain.model.Puesto;
import co.com.ceiba.parqueadero.domain.model.Reserva;
import co.com.ceiba.parqueadero.domain.model.Vehiculo;


public class ReservaTestUnitario {

	private static final long ID_FACTURA = 1;
	private static final Puesto PUESTO = new PuestoTestBuilder().build();
	private static final Vehiculo VEHICULO = new VehiculoTestBuilder().build();
	private static final Date FECHA_INGRESO = Calendar.getInstance().getTime();
	private static final Date FECHA_RETIRO = null;
	private static final float VALOR = 0;

	private Reserva reserva;

	@Test
	public void crearFactura() {
		// arrange
		ReservaTestBuilder facturaTestBuilder = new ReservaTestBuilder().obtenerFacturaPorId(ID_FACTURA)
				.obtenerFacturaPorBahia(PUESTO).obtenerFacturaPorVehiculo(VEHICULO)
				.obetnerFacturaPorFechaIngreso(FECHA_INGRESO).obtenerFacturaPorFechaRetiro(FECHA_RETIRO)
				.obtenerFacturaPorValor(VALOR);
		// act
		reserva = facturaTestBuilder.build();
		// assert
		long valor=reserva.getIdReserva();
		assertEquals(ID_FACTURA, valor);
		assertEquals(PUESTO,reserva.getPuesto());
		assertEquals(VEHICULO, reserva.getVehiculo());
		assertEquals(FECHA_INGRESO, reserva.getFechaIngreso());
		assertEquals(FECHA_RETIRO, reserva.getFechaRetiro());
		assertEquals(VALOR, reserva.getValorTotal(), 0);
	}

	
}
