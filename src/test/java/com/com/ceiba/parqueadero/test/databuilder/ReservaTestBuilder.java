package com.com.ceiba.parqueadero.test.databuilder;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import co.com.ceiba.parqueadero.domain.model.Puesto;
import co.com.ceiba.parqueadero.domain.model.Reserva;
import co.com.ceiba.parqueadero.domain.model.Vehiculo;


public class ReservaTestBuilder {

	
	private static final long ID_RESERVA = 3;
	private static final Puesto PUESTO = new PuestoTestBuilder().build();
	private static final Vehiculo VEHICULO = new VehiculoTestBuilder().vehiculoExistente();
	private static final Date FECHA_INGRESO = Calendar.getInstance().getTime();
	private static final Date FECHA_RETIRO = null;
	private static final float VALOR = 0;
	
	

	private static final long ID_RESERVA2 = 4;
	private static final Puesto PUESTO2 = new PuestoTestBuilder().build();
	private static final Vehiculo VEHICULO2 = new VehiculoTestBuilder().vehiculoExistente();
	private static final Date FECHA_INGRESO2 = Calendar.getInstance().getTime();
	private static final Date FECHA_RETIRO2 = null;
	private static final float VALOR2 = 0;
	

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
	
	
	public List<Reserva> listaReservas(){
	   
		List<Reserva> reservas=new ArrayList<>();
		
	    Reserva reserva1=new Reserva();
	    reserva1.setIdReserva(ID_RESERVA);
	    reserva1.setFechaIngreso(FECHA_INGRESO);
	    reserva1.setFechaRetiro(FECHA_RETIRO);
	    reserva1.setPuesto(PUESTO);
	    reserva1.setValorTotal(VALOR);
	    reserva1.setVehiculo(VEHICULO);
	    
	    
	    Reserva reserva2=new Reserva();
	    reserva2.setFechaIngreso(FECHA_INGRESO2);
	    reserva2.setFechaRetiro(FECHA_RETIRO2);
	    reserva2.setIdReserva(ID_RESERVA2);
	    reserva2.setPuesto(PUESTO2);
	    reserva2.setValorTotal(VALOR2);
	    reserva2.setVehiculo(VEHICULO2);
	    
	    reservas.add(reserva1);
	    reservas.add(reserva2);
	    
	    return reservas;
	    
	   
	}
	
	public List<Reserva> listaReservasPendientes(){
		
     List<Reserva> reservas=new ArrayList<>();
		
	    Reserva reserva1=new Reserva();
	    reserva1.setIdReserva(ID_RESERVA);
	    reserva1.setFechaIngreso(FECHA_INGRESO);
	    reserva1.setFechaRetiro(null);
	    reserva1.setPuesto(PUESTO);
	    reserva1.setValorTotal(VALOR);
	    reserva1.setVehiculo(VEHICULO);
	    
	    
	    Reserva reserva2=new Reserva();
	    reserva2.setFechaIngreso(FECHA_INGRESO2);
	    reserva2.setFechaRetiro(null);
	    reserva2.setIdReserva(ID_RESERVA2);
	    reserva2.setPuesto(PUESTO2);
	    reserva2.setValorTotal(VALOR2);
	    reserva2.setVehiculo(VEHICULO2);
	    
	    reservas.add(reserva1);
	    reservas.add(reserva2);
	    
	    return reservas;
	    
		
	}
	


}
