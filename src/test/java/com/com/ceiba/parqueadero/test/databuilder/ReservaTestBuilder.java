package com.com.ceiba.parqueadero.test.databuilder;

import java.util.Calendar;
import java.util.Date;

import co.com.ceiba.parqueadero.domain.model.Puesto;
import co.com.ceiba.parqueadero.domain.model.Reserva;
import co.com.ceiba.parqueadero.domain.model.Vehiculo;


public class ReservaTestBuilder {
	
	private static final long ID_RESERVA = 1;
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
	
	public ReservaTestBuilder obtenerFacturaPorId(long idReserva) {
		this.idReserva = idReserva;
		return this;
	}

	public ReservaTestBuilder obtenerFacturaPorBahia(Puesto puesto) {
		this.puesto = puesto;
		return this;
	}

	public  ReservaTestBuilder obtenerFacturaPorVehiculo(Vehiculo vehiculo) {
		this.vehiculo = vehiculo;
		return this;
	}

	public ReservaTestBuilder obetnerFacturaPorFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
		return this;
	}

	public ReservaTestBuilder obtenerFacturaPorFechaRetiro(Date fechaRetiro) {
		this.fechaRetiro = fechaRetiro;
		return this;
	}

	public ReservaTestBuilder obtenerFacturaPorValor(float valor) {
		this.valor = valor;
		return this;
	}

	public Reserva build() {
		Reserva factura = new Reserva();
		factura.setIdReserva(this.idReserva);
		factura.setPuesto(this.puesto);
		factura.setVehiculo(this.vehiculo);
		factura.setFechaIngreso(this.fechaIngreso);
		factura.setFechaRetiro(this.fechaRetiro);
		factura.setValorTotal(this.valor);
		return factura;
	}


}
