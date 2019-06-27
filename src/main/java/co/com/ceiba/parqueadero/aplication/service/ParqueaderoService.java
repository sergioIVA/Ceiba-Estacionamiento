package co.com.ceiba.parqueadero.aplication.service;

import java.util.Calendar;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.domain.model.Parqueadero;
import co.com.ceiba.parqueadero.domain.model.Puesto;
import co.com.ceiba.parqueadero.domain.model.Reserva;
import co.com.ceiba.parqueadero.domain.model.TipoVehiculo;
import co.com.ceiba.parqueadero.domain.model.Vehiculo;

@Service
public class ParqueaderoService {
	
    private Parqueadero parqueadero;
	
	public ParqueaderoService(Parqueadero parqueadero) {
		this.parqueadero = parqueadero;
	}

	public Reserva registrarEntrada(Puesto puesto, Vehiculo vehiculo) {
		return parqueadero.registrarEntrada(puesto, vehiculo);
	}
	
	public boolean permitirIngreso(String placa, Calendar fechaIngreso) {
		return parqueadero.permitirEntrada(placa,fechaIngreso);
	}
	
	public Reserva registrarSalida(Reserva reserva, Vehiculo vehiculo) {
		return parqueadero.registrarSalida(reserva, vehiculo);
	}
	
	public float calcularValor(TipoVehiculo tipoVehiculo, short cilindraje,Calendar fechaIngreso,Calendar fechaRetiro) {
		return parqueadero.calcularValor(tipoVehiculo, cilindraje, fechaIngreso, fechaRetiro);
	}
	
	
	

}
