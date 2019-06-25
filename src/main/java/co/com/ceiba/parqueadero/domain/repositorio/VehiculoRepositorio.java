package co.com.ceiba.parqueadero.domain.repositorio;

import java.util.List;

import co.com.ceiba.parqueadero.domain.model.Vehiculo;

public interface VehiculoRepositorio {
	
    public List<Vehiculo> listarVehiculos();
	
	public Vehiculo obtenerVehiculoPorPlaca(String placaVehiculo);

	public Vehiculo registrarVehiculo(Vehiculo vehiculo);
	
	public Vehiculo obtenerVehiculoPorId(long idVehiculo);


}
