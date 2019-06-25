package com.com.ceiba.parqueadero.test.unitaria;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Calendar;
import org.junit.Assert;
import org.junit.Test;
import com.com.ceiba.parqueadero.test.databuilder.PuestoTestBuilder;
import com.com.ceiba.parqueadero.test.databuilder.ReservaTestBuilder;
import com.com.ceiba.parqueadero.test.databuilder.TipoVehiculoTestBuilder;
import com.com.ceiba.parqueadero.test.databuilder.VehiculoTestBuilder;
import co.com.ceiba.parqueadero.domain.model.Parqueadero;
import co.com.ceiba.parqueadero.domain.model.Puesto;
import co.com.ceiba.parqueadero.domain.model.Reserva;
import co.com.ceiba.parqueadero.domain.model.TipoVehiculo;
import co.com.ceiba.parqueadero.domain.model.Vehiculo;


public class parqueaderoTestUnitario {
	
	private static final String PLACA = "RWW111"; 

	@Test
	public void permitirAccesoPorTipoVehiculo() {
		// arrange
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder();
		Vehiculo vehiculo = vehiculoTestBuilder.build();
		Parqueadero parking = mock(Parqueadero.class);
		when(parking.estaPermitido(vehiculo)).thenReturn(true);
		// act
		boolean esPermitido = parking.estaPermitido(vehiculo);
		// assert
		assertTrue(esPermitido);
	}

	@Test
	public void NoPermitirAccesoPorTipoVehiculo() {
		// arrange
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder();
		Vehiculo vehiculo = vehiculoTestBuilder.build();
		Parqueadero parking = mock(Parqueadero.class);
		when(parking.estaPermitido(vehiculo)).thenReturn(false);
		// act
		boolean esPermitido = parking.estaPermitido(vehiculo);

		// assert
		assertFalse(esPermitido);
	}

	@Test
	public void noPermitirAccesoVehiculoIncompatiblePuesto() {
		// arrange
		PuestoTestBuilder bahiaTestBuilder = new PuestoTestBuilder();
		Puesto bahia = bahiaTestBuilder.build();

		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder();
		Vehiculo vehiculo = vehiculoTestBuilder.build();

		Parqueadero parking = mock(Parqueadero.class);

		when(parking.esCompatible(vehiculo, bahia)).thenReturn(false);
		// act
		boolean esCompatible = parking.esCompatible(vehiculo, bahia);
		// assert
		assertFalse(esCompatible);
	}

	@Test
	public void permitirAccesoVehiculoCompatibleBahia() {
		// arrange
		PuestoTestBuilder puestoTestBuilder = new PuestoTestBuilder();
		Puesto puesto = puestoTestBuilder.build();

		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder();
		Vehiculo vehiculo = vehiculoTestBuilder.build();

		Parqueadero parking = mock(Parqueadero.class);

		when(parking.esCompatible(vehiculo, puesto)).thenReturn(true);
		// act
		boolean esCompatible = parking.esCompatible(vehiculo, puesto);
		// assert
		assertTrue(esCompatible);
	}

	@Test
	public void PermitirAccesoPuestoLibre() {
		// arrange
		PuestoTestBuilder puestoTestBuilder = new PuestoTestBuilder();
		Puesto puesto = puestoTestBuilder.build();

		Parqueadero parking = mock(Parqueadero.class);

		when(parking.estaLibre(puesto)).thenReturn(true);
		// act
		boolean esLibre = parking.estaLibre(puesto);
		// assert
		assertTrue(esLibre);
	}

	@Test
	public void noPermitirAccesoBahiaOcupada() {
		// arrange
		PuestoTestBuilder bahiaTestBuilder = new PuestoTestBuilder();
		Puesto puesto = bahiaTestBuilder.build();

		Parqueadero parking = mock(Parqueadero.class);

		when(parking.estaLibre(puesto)).thenReturn(false);
		// act
		boolean esLibre = parking.estaLibre(puesto);
		// assert
		assertFalse(esLibre);
	}

	@Test
	public void permitirAccesoPorPlaca() {
		// arrange
		Calendar fechaIngreso = Calendar.getInstance();
		fechaIngreso.set(2019, 5, 17, 5, 0);

		Parqueadero parking = mock(Parqueadero.class);

		when(parking.permitirEntrada("BBC123", fechaIngreso)).thenReturn(true);
		// act
		boolean perimitido = parking.permitirEntrada("BBC123", fechaIngreso);
		// assert
		assertTrue(perimitido);
	}

	@Test
	public void negarAccesoPorPlaca() {
		// arrange
		Calendar fechaIngreso = Calendar.getInstance();
		fechaIngreso.set(2019, 5, 18, 5, 0);

		Parqueadero parking = mock(Parqueadero.class);

		when(parking.permitirEntrada("AAA123", fechaIngreso)).thenReturn(false);
		// act
		boolean perimitido = parking.permitirEntrada("AAA123", fechaIngreso);
		// assert
		assertFalse(perimitido);
	}

	@Test
	public void permitirAccesoPorPlacaInicioLetraA() {
		// arrange
		Calendar fechaIngreso = Calendar.getInstance();
		fechaIngreso.set(2019, 5, 17, 5, 0);

		Parqueadero parking = mock(Parqueadero.class);

		when(parking.permitirEntrada("AAA111", fechaIngreso)).thenReturn(true);
		// act
		boolean perimitido = parking.permitirEntrada("AAA111", fechaIngreso);
		// assert
		assertTrue(perimitido);
	}

	@Test
	public void calcularValorHoraCarro() {
		// act
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder();
		Vehiculo vehiculo = vehiculoTestBuilder.build();
		Calendar fechaIngreso = Calendar.getInstance();
		fechaIngreso.set(2019, 5, 17, 5, 0);
		Calendar fechaRetiro = Calendar.getInstance();
		fechaRetiro.set(2019, 5, 17, 10, 0);
		Parqueadero parking = mock(Parqueadero.class);
		when(parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(), 
				fechaIngreso,fechaRetiro)).thenReturn(5000F);
		// assert
		assertEquals(5000F, parking.calcularValor(vehiculo.getTipoVehiculo(), 
				vehiculo.getCilindraje(),fechaIngreso, fechaRetiro), 0);
	}

	@Test
	public void calcularValorDiaCarro() {
		// act
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder();
		Vehiculo vehiculo = vehiculoTestBuilder.build();
		Calendar fechaIngreso = Calendar.getInstance();
		fechaIngreso.set(2019, 5, 17, 7, 0);
		Calendar fechaRetiro = Calendar.getInstance();
		fechaRetiro.set(2019, 5, 17, 16, 0);
		Parqueadero parking = mock(Parqueadero.class);
		when(parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(),
				fechaIngreso,fechaRetiro)).thenReturn(8000F);
		// assert
		assertEquals(8000F, parking.calcularValor(vehiculo.getTipoVehiculo(),
				vehiculo.getCilindraje(),fechaIngreso, fechaRetiro), 0);
	}

	@Test
	public void calcularValorMasDeUnDiaCarro() {
		// act
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder();
		Vehiculo vehiculo = vehiculoTestBuilder.build();
		Calendar fechaIngreso = Calendar.getInstance();
		fechaIngreso.set(2019, 5, 17, 7, 0);
		Calendar fechaRetiro = Calendar.getInstance();
		fechaRetiro.set(2019, 5, 18, 10, 0);
		Parqueadero parking = mock(Parqueadero.class);
		when(parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(), fechaIngreso,
				fechaRetiro)).thenReturn(11000F);
		// assert
		assertEquals(11000F, parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(),
				fechaIngreso, fechaRetiro), 0);
	}
	
	@Test
	public void calcularValorHoraMoto() {
		// act
		TipoVehiculoTestBuilder tipoVehiculoTestBuilder = new TipoVehiculoTestBuilder();
		TipoVehiculo tipoVehiculo = tipoVehiculoTestBuilder.build();
		tipoVehiculo.setNombre("MOTO");
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder();
		Vehiculo vehiculo = vehiculoTestBuilder.obtenerVehiculoPorTipo(tipoVehiculo)
				.obtenerVehiculoPorCilindraje((short) 1200).build();
		Calendar fechaIngreso = Calendar.getInstance();
		fechaIngreso.set(2019, 5, 17, 7, 0);
		Calendar fechaRetiro = Calendar.getInstance();
		fechaRetiro.set(2019, 5, 17, 10, 0);
		Parqueadero parking = mock(Parqueadero.class);
		when(parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(), fechaIngreso,
				fechaRetiro)).thenReturn(1500F);
		// assert
		assertEquals(1500F, parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(),
				fechaIngreso, fechaRetiro), 0);
	}
	
	@Test
	public void calcularValorDiaMoto() {
		// act
		TipoVehiculoTestBuilder tipoVehiculoTestBuilder = new TipoVehiculoTestBuilder();
		TipoVehiculo tipoVehiculo = tipoVehiculoTestBuilder.build();
		tipoVehiculo.setNombre("MOTO");
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder();
		Vehiculo vehiculo = vehiculoTestBuilder.obtenerVehiculoPorTipo(tipoVehiculo)
				.obtenerVehiculoPorCilindraje((short) 1200).build();
		Calendar fechaIngreso = Calendar.getInstance();
		fechaIngreso.set(2019, 5, 17, 7, 0);
		Calendar fechaRetiro = Calendar.getInstance();
		fechaRetiro.set(2019, 5, 17, 16, 0);
		Parqueadero parking = mock(Parqueadero.class);
		when(parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(), 
				fechaIngreso,fechaRetiro)).thenReturn(4000F);
		// assert
		assertEquals(4000F, parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(),
				fechaIngreso, fechaRetiro), 0);
	}
	
	@Test
	public void calcularValorMasDeUnDiaMoto() {
		// act
		TipoVehiculoTestBuilder tipoVehiculoTestBuilder = new TipoVehiculoTestBuilder();
		TipoVehiculo tipoVehiculo = tipoVehiculoTestBuilder.build();
		tipoVehiculo.setNombre("MOTO");
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder();
		Vehiculo vehiculo = vehiculoTestBuilder.obtenerVehiculoPorTipo(tipoVehiculo)
				.obtenerVehiculoPorCilindraje((short) 1200).build();
		Calendar fechaIngreso = Calendar.getInstance();
		fechaIngreso.set(2019, 5, 17, 7, 0);
		Calendar fechaRetiro = Calendar.getInstance();
		fechaRetiro.set(2019, 5, 18, 10, 0);
		Parqueadero parking = mock(Parqueadero.class);
		when(parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(), fechaIngreso,
				fechaRetiro)).thenReturn(5500F);
		// assert
		assertEquals(5500F, parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(),
				fechaIngreso, fechaRetiro), 0);
	}
	
	@Test
	public void calcularValorHoraMotoCilindrajeMayor() {
		// act
		TipoVehiculoTestBuilder tipoVehiculoTestBuilder = new TipoVehiculoTestBuilder();
		TipoVehiculo tipoVehiculo = tipoVehiculoTestBuilder.build();
		tipoVehiculo.setNombre("MOTO");
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder();
		Vehiculo vehiculo = vehiculoTestBuilder.obtenerVehiculoPorTipo(tipoVehiculo)
				.obtenerVehiculoPorCilindraje((short) 1200).build();
		Calendar fechaIngreso = Calendar.getInstance();
		fechaIngreso.set(2019, 5, 17, 7, 0);
		Calendar fechaRetiro = Calendar.getInstance();
		fechaRetiro.set(2019, 5, 18, 10, 0);
		Parqueadero parking = mock(Parqueadero.class);
		when(parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(), fechaIngreso,
				fechaRetiro)).thenReturn(3500F);
		// assert
		assertEquals(3500F, parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(),
				fechaIngreso, fechaRetiro), 0);
	}

	@Test
	public void calcularValorDiaMotoCilindrajeMayor() {
		// act
		TipoVehiculoTestBuilder tipoVehiculoTestBuilder = new TipoVehiculoTestBuilder();
		TipoVehiculo tipoVehiculo = tipoVehiculoTestBuilder.build();
		tipoVehiculo.setNombre("MOTO");
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder();
		Vehiculo vehiculo = vehiculoTestBuilder.obtenerVehiculoPorTipo(tipoVehiculo)
				.obtenerVehiculoPorCilindraje((short) 1200).build();
		Calendar fechaIngreso = Calendar.getInstance();
		fechaIngreso.set(2019, 5, 17, 7, 0);
		Calendar fechaRetiro = Calendar.getInstance();
		fechaRetiro.set(2019, 5, 18, 10, 0);
		Parqueadero parking = mock(Parqueadero.class);
		when(parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(),fechaIngreso,
				fechaRetiro)).thenReturn(3500F);
		// assert
		assertEquals(3500F, parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(),
				fechaIngreso, fechaRetiro), 0);
	}
	
	@Test
	public void calcularValorMasDeUnDiaMotoCilindrajeMayor() {
		// act
		TipoVehiculoTestBuilder tipoVehiculoTestBuilder = new TipoVehiculoTestBuilder();
		TipoVehiculo tipoVehiculo = tipoVehiculoTestBuilder.build();
		tipoVehiculo.setNombre("MOTO");
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder();
		Vehiculo vehiculo = vehiculoTestBuilder.obtenerVehiculoPorTipo(tipoVehiculo)
				.obtenerVehiculoPorCilindraje((short) 1200).build();
		Calendar fechaIngreso = Calendar.getInstance();
		fechaIngreso.set(2019, 5, 17, 7, 0);
		Calendar fechaRetiro = Calendar.getInstance();
		fechaRetiro.set(2019, 5, 18, 17, 0);
		Parqueadero parking = mock(Parqueadero.class);
		when(parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(),fechaIngreso,
				fechaRetiro)).thenReturn(10000F);
		// assert
		assertEquals(10000F, parking.calcularValor(vehiculo.getTipoVehiculo(), vehiculo.getCilindraje(),
				fechaIngreso, fechaRetiro), 0);
	}	

	@Test
	public void registrarEntradaVehiculo() {
		//arrange
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder();
		Vehiculo vehiculo = vehiculoTestBuilder.obtenerVehiculoPorPlaca(PLACA).build();
		PuestoTestBuilder puestoTestBuilder = new PuestoTestBuilder();
		Puesto puesto = puestoTestBuilder.build();
		ReservaTestBuilder reservaTestBuilder = new ReservaTestBuilder();
		Reserva reserva = reservaTestBuilder.build();
		Parqueadero parqueadero = mock(Parqueadero.class);
		//act
		parqueadero.registrarEntrada(puesto, vehiculo);
		//assert
		Assert.assertNotNull(reserva.getVehiculo());
	}
	
	@Test
	public void registrarSalidaVehiculo() {
		//arrange
		VehiculoTestBuilder vehiculoTestBuilder = new VehiculoTestBuilder();
		Vehiculo vehiculo = vehiculoTestBuilder.obtenerVehiculoPorPlaca(PLACA).build();
		ReservaTestBuilder reservaTestBuilder = new ReservaTestBuilder();
		Reserva reserva = reservaTestBuilder.build();
		Parqueadero parqueadero = mock(Parqueadero.class);
		//act
		parqueadero.registrarSalida(reserva, vehiculo);
		//assert
		Assert.assertNotNull(reserva.getVehiculo());
	}
	

}
