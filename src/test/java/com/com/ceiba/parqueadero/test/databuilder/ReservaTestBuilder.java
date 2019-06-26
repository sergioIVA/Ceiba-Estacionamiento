package com.com.ceiba.parqueadero.test.databuilder;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.parqueadero.domain.model.Puesto;
import co.com.ceiba.parqueadero.domain.model.Reserva;
import co.com.ceiba.parqueadero.domain.model.Vehiculo;


public class ReservaTestBuilder {

  /** 
	private static final long ID_RESERVA = 1;
	private static final Puesto PUESTO = new PuestoTestBuilder().build();
	private static final Vehiculo VEHICULO = new VehiculoTestBuilder().build();
	private static final Date FECHA_INGRESO = Calendar.getInstance().getTime();
	private static final Date FECHA_RETIRO = null;
	private static final float VALOR = 0;
 **/
	
	
	private static final long ID_RESERVA = 3;
	private static final Puesto PUESTO = new PuestoTestBuilder().build();
	private static final Vehiculo VEHICULO = new VehiculoTestBuilder().build();
	private static final Date FECHA_INGRESO = Calendar.getInstance().getTime();
	private static final Date FECHA_RETIRO = null;
	private static final float VALOR = 0;
	

	private long idReserva;
	private Puesto puesto;
	private Vehiculo vehiculo;
	private Date fechaIngreso;
	private Date fechaRetiro;
	private float valor;

	public ReservaTestBuilder() {
		this.idReserva = ID_RESERVA;
		this.puesto = PUESTO;
		this.vehiculo = VEHICULO;
		this.fechaIngreso = FECHA_INGRESO;
		this.fechaRetiro = FECHA_RETIRO;
		this.valor = VALOR;
	}
	
	public ReservaTestBuilder obtenerReservaPorId(long idReserva) {
		this.idReserva = idReserva;
		return this;
	}

	public ReservaTestBuilder obtenerReservaPorPuesto(Puesto puesto) {
		this.puesto = puesto;
		return this;
	}

	public  ReservaTestBuilder obtenerReservaPorVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}

	public ReservaTestBuilder obetnerReservaPorFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}

	public ReservaTestBuilder obtenerReservaPorFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
		return this;
	}

	public ReservaTestBuilder obtenerReservaPorValor(float valor) {
		this.valor = valor;
		return this;
	}

	public Reserva build() {
		Reserva reserva = new Reserva();
		reserva.setIdReserva(this.idReserva);
		reserva.setPuesto(this.puesto);
		reserva.setVehiculo(this.vehiculo);
		reserva.setFechaIngreso(this.fechaIngreso);
		reserva.setFechaRetiro(this.fechaRetiro);
		reserva.setValorTotal(this.valor);
		return reserva;
	}
	
	


}
