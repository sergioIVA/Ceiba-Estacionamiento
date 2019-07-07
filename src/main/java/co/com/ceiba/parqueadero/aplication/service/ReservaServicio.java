package co.com.ceiba.parqueadero.aplication.service;

import java.util.List;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.domain.exception.AccesoDenegadoException;
import co.com.ceiba.parqueadero.domain.model.Puesto;
import co.com.ceiba.parqueadero.domain.model.Reserva;
import co.com.ceiba.parqueadero.domain.model.Vehiculo;
import co.com.ceiba.parqueadero.domain.repositorio.PuestoRepositorio;
import co.com.ceiba.parqueadero.domain.repositorio.ReservaRepositorio;
import co.com.ceiba.parqueadero.domain.repositorio.VehiculoRepositorio;
import co.com.ceiba.parqueadero.infraestructure.persistencia.mapeador.VehiculoMapper;

@Service
public class ReservaServicio {
	
	private ParqueaderoService parqueaderoService;
	private ReservaRepositorio reservaRepositorio;
	private PuestoRepositorio puestoRepositorio;
	private VehiculoRepositorio vehiculoRepositorio;
	private static final String VEHICULO_CON_RESERVA="Este vehiculo ya tiene asignado un puesto";
	
	
	public ReservaServicio(ParqueaderoService parqueaderoService, ReservaRepositorio reservaRepositorio,
			PuestoRepositorio puestoRepositorio, VehiculoRepositorio vehiculoRepositorio) {
		this.parqueaderoService = parqueaderoService;
		this.reservaRepositorio = reservaRepositorio;
		this.puestoRepositorio = puestoRepositorio;
		this.vehiculoRepositorio = vehiculoRepositorio;
	}
	
	public List<Reserva> listarReservas(){
		return reservaRepositorio.listarReserva();
	}
	
	public List<Reserva> listarReservasPendientes(){
		return reservaRepositorio.listarReservaPendiente();
	}
	
	public Reserva registrarEntrada(long idPuesto, long idVehiculo) {
		
		Vehiculo vehiculo = vehiculoRepositorio.obtenerVehiculoPorId(idVehiculo);
		
		List<Reserva> listaReservaVehiculos=reservaRepositorio.reservasVehiculo(VehiculoMapper.toEntity(vehiculo));
		
		               for(Reserva r:listaReservaVehiculos) {
		            	   
		            	        if(r.getFechaRetiro()==null) {
		            	        	throw new AccesoDenegadoException(VEHICULO_CON_RESERVA);
		            	        }
		               }
		       
		
		Puesto puesto = puestoRepositorio.obtenerPuestoPorId(idPuesto);
		
		Reserva reserva = parqueaderoService.registrarEntrada(puesto, vehiculo);  
	    puestoRepositorio.cambiarEstadoPuesto(idPuesto);
	    
	    return reservaRepositorio.registrarEntrada(reserva);
	
	}
	
	public Reserva registrarSalida(long idReserva) {
		
		Reserva reserva = reservaRepositorio.obtenerReservaPorId(idReserva);
		Vehiculo vehiculo = vehiculoRepositorio.obtenerVehiculoPorId(reserva.getVehiculo().
				            getIdVehiculo());
		reserva = parqueaderoService.registrarSalida(reserva, vehiculo);
		puestoRepositorio.cambiarEstadoPuesto(reserva.getPuesto().getIdPuesto());
		return reservaRepositorio.registrarSalida(reserva);
	}
	
	
	
	
	
	
	

}
