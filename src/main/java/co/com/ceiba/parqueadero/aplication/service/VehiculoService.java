package co.com.ceiba.parqueadero.aplication.service;

import java.util.List;
import org.springframework.stereotype.Service;

import co.com.ceiba.parqueadero.domain.model.Vehiculo;
import co.com.ceiba.parqueadero.domain.repositorio.VehiculoRepositorio;

@Service
public class VehiculoService {
	
	private VehiculoRepositorio vehiculoRepositorio;

	public VehiculoService(VehiculoRepositorio vehiculoRepositorio) {
		this.vehiculoRepositorio = vehiculoRepositorio;
	}
	
	public List<Vehiculo> listarVehiculos(){
		return vehiculoRepositorio.listarVehiculos();
	}
	
	public Vehiculo obtenerVehiculoPorPlaca(String placaVehiculo){
		return vehiculoRepositorio.obtenerVehiculoPorPlaca(placaVehiculo);
	}
		
	public Vehiculo registrarVehiculo(Vehiculo vehiculo) {
		return vehiculoRepositorio.registrarVehiculo(vehiculo);
	}

}
